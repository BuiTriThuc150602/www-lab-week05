package vn.edu.iuh.fit.wwwlabweek05.backend.ids;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Job;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobSkillID implements Serializable {
  private Job job;
  private Skill skill;

}
