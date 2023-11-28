package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

  Optional<Skill> findBySkillNameIgnoreCase(String skillName);

}