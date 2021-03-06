package com.codeup.foodtruckfinder.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private boolean truckOwner;
    @Column(nullable = false)
    private boolean admin;
    @Column
    private String profilePicture;

    @OneToOne(cascade=CascadeType.ALL)
    private Truck truck;

    @ManyToMany
    @JoinTable(name = "user_favorites", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "truck_id")})
    private List<Truck> favoriteTrucks;
    @ManyToMany
    @JoinTable(name = "user_confirmations", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "truck_id")})
    private List<Truck> confirmed_trucks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Review> reviews;

    public User() {
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
        profilePicture = copy.profilePicture;
        favoriteTrucks = copy.favoriteTrucks;
        confirmed_trucks = copy.confirmed_trucks;
        reviews = copy.reviews;
        truckOwner = copy.truckOwner;
        admin = copy.admin;
        truck = copy.truck;
    }

    public User(String username, String email, String profilePicture) {
        this.username = username;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public User(String username, String password, String email, boolean truckOwner, String profilePicture) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.truckOwner = truckOwner;
        this.admin = false;
        this.profilePicture = profilePicture;
    }

    public User(long id, String username, String password, String email, boolean truckOwner, boolean admin, String profilePicture, List<Truck> favoriteTrucks, List<Truck> confirmed_trucks, List<Review> reviews) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.truckOwner = truckOwner;
        this.admin = admin;
        this.profilePicture = profilePicture;
        this.favoriteTrucks = favoriteTrucks;
        this.confirmed_trucks = confirmed_trucks;
        this.reviews = reviews;
    }

    public User(long id, String username, String password, String email, boolean truckOwner, boolean admin, String profilePicture, Truck truck, List<Truck> favoriteTrucks, List<Truck> confirmed_trucks, List<Review> reviews) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.truckOwner = truckOwner;
        this.admin = admin;
        this.profilePicture = profilePicture;
        this.truck = truck;
        this.favoriteTrucks = favoriteTrucks;
        this.confirmed_trucks = confirmed_trucks;
        this.reviews = reviews;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTruckOwner() {
        return truckOwner;
    }

    public void setTruckOwner(boolean truckOwner) {
        this.truckOwner = truckOwner;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Truck> getFavoriteTrucks() {
        return favoriteTrucks;
    }

    public void setFavoriteTrucks(List<Truck> favoriteTrucks) {
        this.favoriteTrucks = favoriteTrucks;
    }

    public List<Truck> getConfirmed_trucks() {
        return confirmed_trucks;
    }

    public void setConfirmed_trucks(List<Truck> confirmed_trucks) {
        this.confirmed_trucks = confirmed_trucks;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

}