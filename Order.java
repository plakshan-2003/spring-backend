package com.communication.project_backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ordername", length = 45)
    private String ordername;

    @Column(name = "quantity")
    private Integer quantity;

    @Lob
    @Column(name = "orderdetails")
    private String orderdetails;

}