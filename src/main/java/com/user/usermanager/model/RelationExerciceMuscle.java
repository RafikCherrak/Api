package com.user.usermanager.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Data
@IdClass(RelationExerciceMuscleId.class)
@Entity
public class RelationExerciceMuscle implements Serializable {

    @Id
    @Column(name = "exercice_id")
    private Long exerciceId;

    @Id
    @Column(name = "muscle_id")
    private Long muscleId;

    @ManyToOne
    @JoinColumn(name = "exercice_id", insertable = false, updatable = false)
    private Exercice exercice;

    @ManyToOne
    @JoinColumn(name = "muscle_id", insertable = false, updatable = false)
    private Muscle muscle;

    private Double pourcentageParticipation;

    public RelationExerciceMuscle(Long exerciceId, Long muscleId, Double pourcentageParticipation) {
        this.exerciceId = exerciceId;
        this.muscleId = muscleId;
        this.pourcentageParticipation = pourcentageParticipation;
    }
}
