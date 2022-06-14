package MobileContactsInterfaceSOA.dto;

public class MobileContactDTO {
    private UserDTO user = new UserDTO();
    private String phonenumber;

    public MobileContactDTO() {}

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
