package com.user.usermanager.service;

import com.user.usermanager.exception.ExerciceNotFoundException;
import com.user.usermanager.model.Exercice;
import com.user.usermanager.repo.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExerciceService {

    private final ExerciceRepository exerciceRepository;

    @Autowired
    public ExerciceService(ExerciceRepository exerciceRepository) {

        this.exerciceRepository = exerciceRepository;
    }


    public List<Exercice> findAllExercices() {
        return exerciceRepository.findAll();
    }

    public Exercice updateExercice(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }

    public Exercice findExerciceById(Long id) {
        return (Exercice) exerciceRepository.findExerciceById(id)
                .orElseThrow(() -> new ExerciceNotFoundException("Exercice by id " + id + " was not found")); }

    }


