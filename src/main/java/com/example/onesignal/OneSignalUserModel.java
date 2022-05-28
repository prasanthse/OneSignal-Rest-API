package com.example.onesignal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OneSignalUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String idOneSignal;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdOneSignal() {
        return idOneSignal;
    }

    public void setIdOneSignal(String idOneSignal) {
        this.idOneSignal = idOneSignal;
    }
}
