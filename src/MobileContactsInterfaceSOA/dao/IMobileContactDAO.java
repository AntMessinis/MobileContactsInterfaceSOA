package MobileContactsInterfaceSOA.dao;

import MobileContactsInterfaceSOA.model.MobileContact;

public interface IMobileContactDAO {
    boolean insert(MobileContact contact);

    boolean update(String phoneNumber, MobileContact contact);

    boolean delete(String phoneNumber);

    MobileContact read(String phoneNumber);
}
