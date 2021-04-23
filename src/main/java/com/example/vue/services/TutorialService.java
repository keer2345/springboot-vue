package com.example.vue.services;

import com.example.vue.entity.Tutorial;
import com.example.vue.repo.TutorialRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialService {
  @Autowired private TutorialRepo tutorialRepo;

  public List<Tutorial> findAll() {
    return tutorialRepo.findAll();
  }

  public List<Tutorial> findByTitle(String title) {
    return tutorialRepo.findByTitleContaining(title);
  }

  public Optional<Tutorial> findById(Long id) {
    return tutorialRepo.findById(id);
  }

  public Tutorial createTutorial(Tutorial tutorial) {
    return tutorialRepo.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
  }
}
