package com.amo.amo.file;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductFile {
    @Id
    @SequenceGenerator(name = "p_gen",sequenceName = "p_gen")
    @GeneratedValue(generator ="p_gen" ,strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String type;
    private byte[] data;
}
