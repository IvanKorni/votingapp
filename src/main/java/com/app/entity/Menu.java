package com.app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="menu")
@Setter
@Getter
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="restaurant_name")
    private String RestaurantName;

    @Column(name = "menu")
    private String Menu;

    @Column(name ="vote")
    private int vote;
}
