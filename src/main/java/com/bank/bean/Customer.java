package com.bank.bean;

import lombok.Data;
import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private String cusID;
    private String cusName;
    private String phone;
    private String type;
    private String money;
    private String state;
}
