package com.user.usermanager;

import com.user.usermanager.model.Exercice;
import com.user.usermanager.model.Muscle;
import com.user.usermanager.model.RelationExerciceMuscle;
import com.user.usermanager.repo.ExerciceRepository;
import com.user.usermanager.repo.MuscleRepository;
import com.user.usermanager.repo.RelationExerciceMuscleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
public class ExploratoryTest {

    @Autowired
    private ExerciceRepository exerciceRepository;
    @Autowired
    private MuscleRepository muscleRepository;
    @Autowired
    private RelationExerciceMuscleRepository relationExerciceMuscleRepository;

    @Test
    @Transactional
    @Sql(scripts = {"/sql/schema.sql", "/sql/data.sql"})
    void name() {
        // ======= INIT MODEL
        // initDatabase();

        // ======== SERVICE =======
        // List<Muscle> allMuscles = exerciceRepository.findAll();

//        List<Muscle> allMusclesFound = muscleRepository.findAll();
//        System.out.println("Muscles ==");
//        System.out.println(allMusclesFound);
//        System.out.println("==========");

        List<Exercice> allExercices = exerciceRepository.findAll();
        List<Exercice> allExercicesWithMuscles = exerciceRepository.findAllWithMuscles();
        List<Muscle> muscleList = muscleRepository.findAll();
        List<RelationExerciceMuscle> allRelations = relationExerciceMuscleRepository.findAll();

        // ==================== VUE ================

        System.out.println("== EXERCICES ==");
        System.out.println(allExercices);

        System.out.println("== MUSCLES ==");
        System.out.println(muscleList);

        System.out.println("== REL ==");
        System.out.println(allRelations);

        for (Exercice exercice : allExercicesWithMuscles) {
            afficherExercice(exercice);
        }

    }

    private void initDatabase() {
        Exercice exercice1 = new Exercice(null, "devcouché", "", "", new ArrayList<>());
        Exercice exercice2 = new Exercice(null, "pompes", "", "", new ArrayList<>());
        Exercice exercice3 = new Exercice(null, "devincliné", "", "", new ArrayList<>());
        Exercice exercice4 = new Exercice(null, "soulevéterre", "", "", new ArrayList<>());
        exerciceRepository.saveAll(Arrays.asList(exercice1, exercice2, exercice3, exercice4));

        Muscle muscle1 = new Muscle(null, "Triceps", "", "", new ArrayList<>());
        Muscle muscle2 = new Muscle(null, "Biceps", "", "", new ArrayList<>());
        Muscle muscle3 = new Muscle(null, "Pectoraux", "", "", new ArrayList<>());
        muscleRepository.saveAll(Arrays.asList(muscle1, muscle2, muscle3));

        RelationExerciceMuscle relEx1toMus3 = new RelationExerciceMuscle(exercice1.getId(), muscle3.getId(), .8);
        RelationExerciceMuscle relEx1toMus1 = new RelationExerciceMuscle(exercice1.getId(), muscle1.getId(), .2);
        relationExerciceMuscleRepository.saveAll(Arrays.asList(relEx1toMus3, relEx1toMus1));

        RelationExerciceMuscle relEx2toMus3 = new RelationExerciceMuscle(exercice2.getId(), muscle3.getId(), .8);
        RelationExerciceMuscle relEx2toMus1 = new RelationExerciceMuscle(exercice2.getId(), muscle1.getId(), .2);
        relationExerciceMuscleRepository.saveAll(Arrays.asList(relEx2toMus3, relEx2toMus1));

        RelationExerciceMuscle relEx4toMus2 = new RelationExerciceMuscle(exercice4.getId(), muscle2.getId(), .1);
        relationExerciceMuscleRepository.saveAll(Arrays.asList(relEx4toMus2));
    }

    private void afficherExercice(Exercice exercice1) {
        System.out.println("== Exercice ==");
        System.out.println("nom : " + exercice1.getName());
        System.out.println("description : " + exercice1.getDescription());
        System.out.println("difficulty : " + exercice1.getDifficuly());
        System.out.println("muscles : ");
        for (RelationExerciceMuscle relationExerciceMuscle : exercice1.getRelationsMuscles()) {
            System.out.println(" - " + relationExerciceMuscle.getMuscle().getName() + " (" + (relationExerciceMuscle.getPourcentageParticipation() * 100) + "%)");
        }
        System.out.println("");
    }
}
