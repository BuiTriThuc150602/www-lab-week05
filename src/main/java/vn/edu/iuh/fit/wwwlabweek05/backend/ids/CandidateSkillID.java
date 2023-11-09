package vn.edu.iuh.fit.wwwlabweek05.backend.ids;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Candidate;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSkillID implements Serializable {
  private Candidate candidate;
  private Skill skill;

}
