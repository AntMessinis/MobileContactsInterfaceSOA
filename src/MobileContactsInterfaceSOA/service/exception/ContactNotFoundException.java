package MobileContactsInterfaceSOA.service.exception;

import MobileContactsInterfaceSOA.dto.MobileContactDTO;

public class ContactNotFoundException extends Exception{
    private static long serialVersionUID = 1L;
    public ContactNotFoundException(MobileContactDTO dto) {
        super("Contact with number " + dto.getPhonenumber() + " not found");
    }

    public ContactNotFoundException(String message) {
        super(message);
    }
}
