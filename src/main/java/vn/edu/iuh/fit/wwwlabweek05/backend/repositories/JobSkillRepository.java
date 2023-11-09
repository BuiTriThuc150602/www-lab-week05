package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.ids.JobSkillID;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.JobSkill;

public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillID> {

}