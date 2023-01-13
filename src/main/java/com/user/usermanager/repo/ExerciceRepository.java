package com.user.usermanager.repo;

import com.user.usermanager.model.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExerciceRepository extends JpaRepository<Exercice, Long> {

    Optional<Exercice> findExerciceById(Long id);

    @Query("" +
            "select e " +
            " from Exercice e " +
            " left join fetch e.relationsMuscles rm " +
            " left join fetch rm.muscle m" +
            ""
    )
    List<Exercice> findAllWithMuscles();
}
