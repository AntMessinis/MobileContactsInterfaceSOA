package MobileContactsInterfaceSOA.service.exception;

public class EmptyContactListException extends Exception{
    private static long serialVersionUID = 1L;
    public EmptyContactListException() {
        super("Your Contacts List is empty");
    }
}
