package com.amo.amo.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private Long contact;

    public Employee(String name, String email, Long contact) {
        this.name = name;
        this.email = email;
        this.contact = contact;
    }
}
