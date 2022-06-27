package ua.skrychenko.internetprovider.dto;

public class UserDto {
    private String userName;
    private String password;
    private String status;

    public UserDto(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public UserDto(String userName, String password, String status) {
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public UserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return userName + password;
    }
}
