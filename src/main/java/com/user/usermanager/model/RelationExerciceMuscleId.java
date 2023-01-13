package com.user.usermanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationExerciceMuscleId implements Serializable {

    @Id
    @Column(name = "exercice_id")
    private Long exerciceId;

    @Id
    @Column(name = "muscle_id")
    private Long muscleId;
}
