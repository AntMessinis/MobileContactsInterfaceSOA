package MobileContactsInterfaceSOA.service;

import MobileContactsInterfaceSOA.dto.MobileContactDTO;
import MobileContactsInterfaceSOA.model.MobileContact;
import MobileContactsInterfaceSOA.service.exception.ContactAlreadyExistsException;
import MobileContactsInterfaceSOA.service.exception.ContactNotFoundException;
import MobileContactsInterfaceSOA.service.exception.EmptyContactListException;

public interface IMobileContactService {
    boolean insertContact(MobileContactDTO dto) throws ContactAlreadyExistsException;
    boolean updateContact(String phoneNumber, MobileContactDTO dto) throws ContactNotFoundException;
    MobileContact getMobileContact(MobileContactDTO dto) throws EmptyContactListException;
    boolean deleteContact(MobileContactDTO dto) throws ContactNotFoundException;
}
