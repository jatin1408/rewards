package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date updatedDate;
    private String password;
    private String userCategory;
}
