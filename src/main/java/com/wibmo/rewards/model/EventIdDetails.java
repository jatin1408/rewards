package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "EventID_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventIdDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

    private String eventDesc;
    private String eventType;
    @CreationTimestamp
    private Date insertDate;
}
