package com.codeup.foodtruckfinder.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    private User truck_owner;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true, unique = true)
    private String phone;

    @Column(nullable = true)
    private String profile_picture;

    @Column(nullable = true)
    private Double longitude;

    @Column(nullable = true)
    private Double latitude;

    @ManyToMany(mappedBy = "favoriteTrucks")
    private List<User> usersFavorited;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truck")
    private List<Menu> menu;

    @ManyToMany(mappedBy = "confirmed_trucks")
    private List<User> confirmed_users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truck")
    private List<TruckPicture> truckPictures;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "trucks_cuisines", joinColumns = {@JoinColumn(name = "truck_id")}, inverseJoinColumns = {@JoinColumn(name = "cuisine_id")})
    private List<Cuisine> cuisines;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truck")
    private List<Review> reviews;

    public Truck() {
    }

    public Truck(long id, User truck_owner, String name, String description, String phone, String profile_picture, double longitude, double latitude, List<User> usersFavorited, List<Menu> menu, List<User> confirmed_users, List<TruckPicture> truckPictures, List<Cuisine> cuisines, List<Review> reviews) {
        this.id = id;
        this.truck_owner = truck_owner;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.profile_picture = profile_picture;
        this.longitude = longitude;
        this.latitude = latitude;
        this.usersFavorited = usersFavorited;
        this.menu = menu;
        this.confirmed_users = confirmed_users;
        this.truckPictures = truckPictures;
        this.cuisines = cuisines;
        this.reviews = reviews;
    }

    public Truck(String name, String description, String phone, String profile_picture) {
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.profile_picture = profile_picture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getTruck_owner() {
        return truck_owner;
    }

    public void setTruck_owner(User truck_owner) {
        this.truck_owner = truck_owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public List<User> getUsersFavorited() {
        return usersFavorited;
    }

    public void setUsersFavorited(List<User> usersFavorited) {
        this.usersFavorited = usersFavorited;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<User> getConfirmed_users() {
        return confirmed_users;
    }

    public void setConfirmed_users(List<User> confirmed_users) {
        this.confirmed_users = confirmed_users;
    }

    public List<TruckPicture> getTruckPictures() {
        return truckPictures;
    }

    public void setTruckPictures(List<TruckPicture> truckPictures) {
        this.truckPictures = truckPictures;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public double averageRatingPercent() {
        double total = 0;
        double reviewCount = reviews.size();
        if (reviewCount == 0) {
            return 0;
        }
        for (Review review : reviews) {
            total += review.getRating();
        }
        return total * 20 / reviewCount;
    }
}