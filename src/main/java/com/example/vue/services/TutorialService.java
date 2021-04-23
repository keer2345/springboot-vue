package com.example.vue.services;

import com.example.vue.entity.Tutorial;
import com.example.vue.repo.TutorialRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialService {
  @Autowired private TutorialRepo tutorialRepo;

  public List<Tutorial> findAll() {
    return tutorialRepo.findAll();
  }
  public List<Tutorial> findByTitle(String title){
    return tutorialRepo.findByTitleContaining(title);
  }
}
