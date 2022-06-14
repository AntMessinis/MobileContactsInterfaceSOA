package MobileContactsInterfaceSOA.service;

import MobileContactsInterfaceSOA.dao.IMobileContactDAO;
import MobileContactsInterfaceSOA.dao.MobileContactDAOImpl;
import MobileContactsInterfaceSOA.dto.MobileContactDTO;
import MobileContactsInterfaceSOA.model.MobileContact;
import MobileContactsInterfaceSOA.model.User;
import MobileContactsInterfaceSOA.service.exception.ContactAlreadyExistsException;
import MobileContactsInterfaceSOA.service.exception.ContactNotFoundException;
import MobileContactsInterfaceSOA.service.exception.EmptyContactListException;

public class MobileContactServiceImpl implements IMobileContactService{

    public MobileContactServiceImpl(){}

    //Composition and Forwarding pattern
    private IMobileContactDAO dao = MobileContactDAOImpl.getInstance();

    @Override
    public boolean insertContact(MobileContactDTO dto) throws ContactAlreadyExistsException {
        MobileContact contact = new MobileContact();
        extractFieldsFromDTO(dto, contact);
        try {
            if (!dao.insert(contact)){
                throw new ContactAlreadyExistsException(dto);
            } else {
                return true;
            }
        } catch (ContactAlreadyExistsException e){
            throw e;
        }
    }

    @Override
    public boolean updateContact(String phoneNumber, MobileContactDTO dto) throws ContactNotFoundException {
        MobileContact contact = new MobileContact();
        extractFieldsFromDTO(dto, contact);
        try {
            if (!dao.update(phoneNumber, contact)){
                throw new ContactNotFoundException(dto);
            } else {
                return true;
            }
        } catch (ContactNotFoundException e){
            throw e;
        }
    }

    @Override
    public MobileContact getMobileContact(MobileContactDTO dto) throws EmptyContactListException {
        try{
            return dao.read(dto.getPhonenumber());
        } catch (ArrayIndexOutOfBoundsException e){
            throw new EmptyContactListException();
        }
    }

    @Override
    public boolean deleteContact(MobileContactDTO dto) throws ContactNotFoundException {
        try{
            if (!dao.delete(dto.getPhonenumber())){
                throw new ContactNotFoundException("Contact not found");
            } else {
                return true;
            }
        } catch (ContactNotFoundException e){
            throw e;
        }
    }

    private void extractFieldsFromDTO(MobileContactDTO dto, MobileContact contact){
        // Instantiate a new user to pass the user related fields
        User user = new User();

        user.setName(dto.getUser().getName());
        user.setSurname(dto.getUser().getSurname());

        // Pass the user to MobileContact object and set contacts phonenumber to dto phonenumber
        contact.setUser(user);
        contact.setPhoneNumber(dto.getPhonenumber());
    }
}
