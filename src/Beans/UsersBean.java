package Beans;

import java.util.ArrayList;
import java.util.List;

public class UsersBean {
    private String username;
    private String surname;
    private String email;
    private String login;
    private String password;
    private String role;

//    private List<String> role;

    public UsersBean(){}

    public UsersBean(String username, String surname, String email, String login, String password, String role){
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;

//        this.role = new ArrayList<String>();
//        if (role!= null) {
//            for (String role: role) {
//                this.role.add(role);
//            }
//        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<String> getRole() {
//        return role;
//    }
//
//    public void setRole(List<String> role) {
//        this.role = role;
//    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
