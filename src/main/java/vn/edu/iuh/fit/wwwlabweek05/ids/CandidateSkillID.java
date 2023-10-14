package vn.edu.iuh.fit.wwwlabweek05.ids;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.wwwlabweek05.models.Candidate;
import vn.edu.iuh.fit.wwwlabweek05.models.Skill;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSkillID implements Serializable {
  private Candidate candidate;
  private Skill skill;

}
