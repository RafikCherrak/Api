package com.user.usermanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Exercice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;

    private String description;

    private String difficuly;

    @OneToMany
    @JoinColumn(name = "exercice_id")
    @ToString.Exclude
    private List<RelationExerciceMuscle> relationsMuscles;


}
