package com.unifil.pontolimpo.entites;

import java.io.Serializable;

//@Entity
//@Table(name = "TB_USER")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idUser;
    private String userName;
    private String email;
    private String password;

    //Constructor
    public User() {
    }

    public User(Long idUser, String userName, String email, String password) {
        this.idUser = idUser;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    //GETTER SETTER
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
    //To String
    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", userName=" + userName + ", email=" + email + ", password=" + password
                + "]";
    }
    //hashcode and equal
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (idUser == null) {
            if (other.idUser != null)
                return false;
        } else if (!idUser.equals(other.idUser))
            return false;
        return true;
    }


}
