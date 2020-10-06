package com.ravi.firebase.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {
    private String name;
    private int age;
    private String city;
}
