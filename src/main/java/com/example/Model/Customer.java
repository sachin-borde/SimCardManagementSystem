package com.example.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Customer_name")
    private String name;
    private int age;
    private String gender;
    private String address;
    private long adhar_no;
    @Column(length = 10, unique = true)
    private String contact;
    @Email(message = "please provide valid email id")
    private String email;
    private long sim_no;
    private String status;

}