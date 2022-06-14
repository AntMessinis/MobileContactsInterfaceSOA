package MobileContactsInterfaceSOA.controller;

import MobileContactsInterfaceSOA.dto.MobileContactDTO;
import MobileContactsInterfaceSOA.model.MobileContact;
import MobileContactsInterfaceSOA.service.IMobileContactService;
import MobileContactsInterfaceSOA.service.MobileContactServiceImpl;
import MobileContactsInterfaceSOA.service.exception.ContactAlreadyExistsException;
import MobileContactsInterfaceSOA.service.exception.ContactNotFoundException;
import MobileContactsInterfaceSOA.service.exception.EmptyContactListException;

public class MobileContactsController {
    private IMobileContactService service = new MobileContactServiceImpl();

    public MobileContactsController(){}

    public boolean insertController(String... fields) throws ContactAlreadyExistsException {
        MobileContactDTO dto = contactDTOFromInput(fields);
        return service.insertContact(dto);
    }

    public MobileContact getContactController(String phonenumber) throws EmptyContactListException {
        MobileContactDTO dto = new MobileContactDTO();
        dto.setPhonenumber(phonenumber);
        return service.getMobileContact(dto);
    }

    public boolean updateController(String phonenumber, String... fields) throws ContactNotFoundException {
        MobileContactDTO dto = contactDTOFromInput(fields);
        return service.updateContact(phonenumber, dto);
    }

    public boolean deleteController(String phonenumber) throws ContactNotFoundException {
        MobileContactDTO dto = new MobileContactDTO();
        dto.setPhonenumber(phonenumber);
        return service.deleteContact(dto);
    }

    private MobileContactDTO contactDTOFromInput(String... fields){
        MobileContactDTO dto = new MobileContactDTO();

        dto.getUser().setName(fields[0]);
        dto.getUser().setSurname(fields[1]);
        dto.setPhonenumber(fields[2]);

        return dto;
    }
}
