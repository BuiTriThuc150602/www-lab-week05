package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.ids.CandidateSkillID;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.CandidateSkill;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillID> {

}