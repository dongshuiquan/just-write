package com.dsq.spring.customtag;

/**
 * Created by DELL on 2018/7/14.
 */
public class User {
    String id;
    String userName;
    String eamil;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;

    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", eamil='" + eamil + '\'' +
                '}';
    }
}

