package MobileContactsInterfaceSOA.service.exception;

import MobileContactsInterfaceSOA.dto.MobileContactDTO;

public class ContactAlreadyExistsException extends Exception{
    private final long serialVersionUID = 1L;

    public ContactAlreadyExistsException(MobileContactDTO dto) {
        super("Contact with number " + dto.getPhonenumber() + " already exits");
    }
}
