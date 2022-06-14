package MobileContactsInterfaceSOA.service.exception;

public class NotPhoneNumberException extends Exception{
    private static long serialVersionUID = 1L;
    public NotPhoneNumberException() {
        super("Your input does not correspond to a phone number");
    }
}
