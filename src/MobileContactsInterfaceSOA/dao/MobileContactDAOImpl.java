package MobileContactsInterfaceSOA.dao;

import MobileContactsInterfaceSOA.model.MobileContact;

public class MobileContactDAOImpl implements IMobileContactDAO{

    // This class implements the singleton pattern
    private static final IMobileContactDAO DAO = new MobileContactDAOImpl();

    private static final int DATABASE_SIZE = 500;
    private final MobileContact[] CONTACTS = new MobileContact[DATABASE_SIZE];

    private int lastContactPosition = -1;

    // This is private so the class can not be directly instatiated
    private MobileContactDAOImpl(){}


    // Returns the singleton instance
    public static IMobileContactDAO getInstance(){
        return DAO;
    }


    @Override
    public boolean insert(MobileContact contact) {
        if (contact == null) return false;
        if (getContactPosition(contact.getPhoneNumber()) != -1) return false;
        CONTACTS[++lastContactPosition] = contact;
        return true;
    }

    @Override
    public boolean update(String phoneNumber, MobileContact contact) {
        if (phoneNumber == null || contact == null) return false;

        int contactPosition = getContactPosition(phoneNumber);
        if (contactPosition != -1){
            CONTACTS[contactPosition] = contact;
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String phoneNumber) {
        if (phoneNumber == null) return false;
        int contactPosition = getContactPosition(phoneNumber);

        if (contactPosition != -1){
            System.arraycopy(CONTACTS, contactPosition + 1, CONTACTS, contactPosition, lastContactPosition - contactPosition);
            lastContactPosition--;
            return true;
        }
        return false;
    }

    @Override
    public MobileContact read(String phoneNumber) {
        int contactPosition = getContactPosition(phoneNumber);
        if (CONTACTS[contactPosition] == null){
            return null;
        }
        return CONTACTS[contactPosition];
    }

    private int getContactPosition(String phoneNumber){
        if (phoneNumber == null) return -1;
        for (int i = 0; i <= lastContactPosition; i++){
            if (CONTACTS[i].getPhoneNumber().equals(phoneNumber)){
                return i;
            }
        }
        return -1;
    }
}
