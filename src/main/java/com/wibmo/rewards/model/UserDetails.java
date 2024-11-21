package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "User_Details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNumber;
    private Date creationDate;
    private Date updatedDate;
    private String password;
    private String userCategory;
}
