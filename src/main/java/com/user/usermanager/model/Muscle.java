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
public class Muscle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;

    private String body_part;

    private String image;

    @OneToMany
    @JoinColumn(name = "muscle_id")
    @ToString.Exclude
    private List<RelationExerciceMuscle> relationsExercices;
}
