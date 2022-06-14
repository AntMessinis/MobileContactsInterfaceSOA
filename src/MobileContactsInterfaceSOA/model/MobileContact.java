package MobileContactsInterfaceSOA.model;

public class MobileContact {
    private User user;
    private String phoneNumber;

    public MobileContact() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MobileContact{" +
                "user=" + user +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
