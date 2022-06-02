package ua.skrychenko.internetprovider.entity;

public class UserEntity {
    private int id;
    private String userName;
    private String password;
    private BalanceEntity balance;

    public UserEntity(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
