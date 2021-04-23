package com.example.vue.controller;

import com.example.vue.entity.Tutorial;
import com.example.vue.services.TutorialService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
