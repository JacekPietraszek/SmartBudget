package com.smartbudget.smartbudget.user;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String nick;

    public UserDto(Long id, String firstName, String lastName, String nick) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}
