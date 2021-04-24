package com.example.vue.controller;

import com.example.vue.entity.Tutorial;
import com.example.vue.services.TutorialService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(path = "/api")
public class TutorialController {
  @Autowired private TutorialService tutorialService;

  @GetMapping("/tutorial")
  public ResponseEntity<List<Tutorial>> retrieveAllTutorials(
      @RequestParam(required = false) String title) {

    try {
      List<Tutorial> tutorials = new ArrayList<Tutorial>();

      if (title == null) {
        tutorialService.findAll().forEach(tutorials::add);
      } else {
        tutorialService.findByTitle(title).forEach(tutorials::add);
      }

      if (tutorials.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/tutorial/{id}")
  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") Long id) {
    Optional<Tutorial> tutorial = tutorialService.findById(id);
    if (tutorial.isPresent()) {
      return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/tutorial")
  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
    try {
      Tutorial tutorialAdded = tutorialService.save(tutorial);
      return new ResponseEntity<>(tutorialAdded, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/tutorial/{id}")
  public ResponseEntity<Tutorial> updateTutorial(
      @PathVariable("id") Long id, @RequestBody Tutorial tutorial) {
    Optional<Tutorial> tutorialUpdate = tutorialService.findById(id);
    if (tutorialUpdate.isPresent()) {
      Tutorial tutorialUpdated = tutorialUpdate.get();
      tutorialUpdated.setTitle(tutorial.getTitle());
      tutorialUpdated.setDescription(tutorial.getDescription());
      tutorialUpdated.setPublished(tutorial.isPublished());

      return new ResponseEntity<>(tutorialService.save(tutorialUpdated), HttpStatus.OK);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/tutorial/{id}")
  public ResponseEntity<Tutorial> deleteTutorial(@PathVariable("id") Long id) {
    try {
      tutorialService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/tutorial")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    try {
      tutorialService.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/tutorial/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
    try {
      List<Tutorial> tutorials = tutorialService.findByPublished(true);
      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
