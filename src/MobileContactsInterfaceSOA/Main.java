package MobileContactsInterfaceSOA;

import MobileContactsInterfaceSOA.controller.MobileContactsController;
import MobileContactsInterfaceSOA.model.MobileContact;
import MobileContactsInterfaceSOA.service.exception.ContactAlreadyExistsException;
import MobileContactsInterfaceSOA.service.exception.ContactNotFoundException;
import MobileContactsInterfaceSOA.service.exception.EmptyContactListException;
import MobileContactsInterfaceSOA.service.exception.NotPhoneNumberException;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {
    public static final MobileContactsController controller = new MobileContactsController();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws NotPhoneNumberException, ContactAlreadyExistsException, EmptyContactListException, ContactNotFoundException {
        int inputChoice = 0;
        do {
            showMenu();
            inputChoice = getMenuChoice();
            switch (inputChoice){
                case 1:
                    insertHandler();
                    break;
                case 2:
                    getContactHandler();
                    break;
                case 3:
                    updateHandler();
                    break;
                case 4:
                    deleteHandler();
                    break;
                case 5:
                    System.out.println("Exiting Application");
                    break;
            }
        } while (inputChoice != 5);
    }

    public static void showMenu(){
        System.out.println("Please select from the following options");
        System.out.println("1) Insert New Contact");
        System.out.println("2) Show Contact");
        System.out.println("3) Update Contact");
        System.out.println("4) Delete Contact");
        System.out.println("5) Exit Application");
        System.out.println();
        System.out.print("Please Enter Choice: ");
    }

    public static int getMenuChoice(){
        try{
            int inputChoice = in.nextInt();
            return inputChoice;
        } catch (NumberFormatException e){
            System.out.println("Please enter a number that corresponds to a menu choice");
            throw e;
        }
    }

    public static String getName(){
        System.out.print("Please type the name of the contact: ");
        String contactName = in.next();
        return contactName;
    }

    public static String getSurname(){
        System.out.print("Please type the surname of the contact: ");
        String contactSurname = in.next();
        return contactSurname;
    }

    public static String getPhoneNumber() throws NotPhoneNumberException {
        System.out.print("Please type the phone number of the contact: ");
        String contactNumber = in.next();

        if (!isPhoneNumber(contactNumber)){
            throw new NotPhoneNumberException();
        }
        return contactNumber;
    }

    public static void insertHandler() throws NotPhoneNumberException, ContactAlreadyExistsException {
        String contactName = getName();
        String contactSurname= getSurname();
        String contactPhoneNumber = getPhoneNumber();

        if (controller.insertController(contactName, contactSurname, contactPhoneNumber)){
            System.out.println();
            System.out.println("New Contact Inserted Successfully");
            System.out.println();
        }
    }

    public static void updateHandler() throws NotPhoneNumberException, ContactNotFoundException {
        String currentPhoneNumber = getPhoneNumber();

        String contactName = getName();
        String contactSurname= getSurname();
        String contactPhoneNumber = getPhoneNumber();

        if (controller.updateController(currentPhoneNumber, contactName, contactSurname, contactPhoneNumber)){
            System.out.println();
            System.out.println("Contact Updated Successfully");
            System.out.println();
        }
    }

    public static void getContactHandler() throws NotPhoneNumberException, EmptyContactListException {
        String contactPhoneNumber = getPhoneNumber();
        MobileContact contact = controller.getContactController(contactPhoneNumber);
        System.out.println(contact);
    }

    public static void deleteHandler() throws NotPhoneNumberException, ContactNotFoundException {
        String contactPhoneNumber = getPhoneNumber();
        if (controller.deleteController(contactPhoneNumber)){
            System.out.println();
            System.out.println("Contact Deleted Successfully");
            System.out.println();
        }
    }



    //Helper Functions

   // Checks if the user's input is a number
    private static boolean isLong(String phoneNumber){
        try {
            Long.parseLong(phoneNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Checks if the number provided by the user is long enough to be a phone number and is in correct format
    private static boolean isPhoneNumber(String phoneNumber){
        if ((isLong(phoneNumber) && phoneNumber.startsWith("21")) || (isLong(phoneNumber) && phoneNumber.startsWith("69"))){
            return (phoneNumber.length() == 10);
        }
        return false;
    }


}
