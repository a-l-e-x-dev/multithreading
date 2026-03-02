package com.example.task3.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "counter")
@Data
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long counter;
//    @Version
//    private Long version;
}
