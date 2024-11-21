package com.wibmo.rewards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime insertDate;
}
