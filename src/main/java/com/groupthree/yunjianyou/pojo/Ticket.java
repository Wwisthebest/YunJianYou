package com.groupthree.yunjianyou.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="ticket")
public class Ticket {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "phone")
    private String phone;
    @Column(name = "card_no")
    private String cardNo;
    @Column(name = "udate")
    private String udate;
    private int own;
}
