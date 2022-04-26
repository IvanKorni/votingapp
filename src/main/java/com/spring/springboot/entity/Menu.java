package com.spring.springboot.entity;


import javax.persistence.*;

@Entity
@Table(name="menu")
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

    public Menu() {
    }

    public Menu(String restaurantName, String menu) {
        RestaurantName = restaurantName;
        Menu = menu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getMenu() {
        return Menu;
    }

    public void setMenu(String menu) {
        Menu = menu;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public void vote() {
        vote++;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "RestaurantName='" + RestaurantName + '\'' +
                ", Menu='" + Menu + '\'' +
                '}';
    }
}
