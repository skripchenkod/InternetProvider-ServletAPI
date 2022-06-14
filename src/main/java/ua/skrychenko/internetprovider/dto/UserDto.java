package ua.skrychenko.internetprovider.dto;

public class UserDto {
    private String userName;
    private String password;

    public UserDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  userName
                 +password ;
    }
}
