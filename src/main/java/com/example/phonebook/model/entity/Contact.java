package com.example.phonebook.model.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name="contacts")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="contact_id")
    private Integer id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    private String company;
    private String job;
    @Column(nullable = false)
    private String email;
    private String phone;
    private String avatar;
    private String country;
    private String street;
    private String postal_code;
    private String city;
    @Temporal(TemporalType.DATE)
    private LocalDate birthday;
    private String notes;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Contact(){

    }

    public Contact(String firstname, String lastname, String company, String job, String email, String phone, String avatar, String country, String street, String postal_code, String city, LocalDate birthday, String notes, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.country = country;
        this.street = street;
        this.postal_code = postal_code;
        this.city = city;
        this.birthday = birthday;
        this.notes = notes;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
