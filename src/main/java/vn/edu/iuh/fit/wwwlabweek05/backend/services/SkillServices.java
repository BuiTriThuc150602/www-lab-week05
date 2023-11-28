package vn.edu.iuh.fit.wwwlabweek05.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.SkillRepository;

@Service
public class SkillServices {
  @Autowired
  private SkillRepository skillRepository;
  public List<Skill> getSkills(){
    return skillRepository.findAll();
  }

  public Optional<Skill> getSkill(long id){
    return skillRepository.findById(id);
  }

  public Optional<Skill> getSkill(String skillName){
    return skillRepository.findBySkillNameIgnoreCase(skillName);
  }
}
