package org.nuptpig.fundbackend.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class UserBinding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "fund_code")
    Fund fund;

    @Column(name = "amount_held")
    private float amountHeld;  //持有金额

    @CreationTimestamp
    @Column(name = "created_time")
    private Timestamp createdTime;   //关注时间

    @Column(name = "held_time", nullable = true)
    private Timestamp heldTime;  //持有时间
}
