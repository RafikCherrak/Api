package com.user.usermanager.controller;

import com.user.usermanager.model.Exercice;
import com.user.usermanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.user.usermanager.service.ExerciceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/exercice")
@RestController
public class ExerciceController {
    private final ExerciceService exerciceService;

    @Autowired
    private ExerciceController exerciceController;

    public ExerciceController(ExerciceService exerciceService) {
        this.exerciceService = exerciceService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Exercice>> getAllExercice() {
        List<Exercice> exercices = exerciceService.findAllExercices();
        return new ResponseEntity<>(exercices, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Exercice> getAllUsers (@PathVariable("id") Long id) throws Throwable {
        Exercice exercices = exerciceService.findExerciceById(id);
        return new ResponseEntity<>(exercices, HttpStatus.OK);
    }

}
