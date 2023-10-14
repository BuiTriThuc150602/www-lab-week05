package vn.edu.iuh.fit.wwwlabweek05.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.edu.iuh.fit.wwwlabweek05.enums.SkillType;

@Entity
@Table(name = "skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Skill {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "skill_id",length = 20)
  private long id;
  @Column(name = "skill_name",length = 150,nullable = false)
  private String skillName;
  @Column(name = "skill_desc",length = 300)

  private String skillDescription;
  @Column(name = "skill_type",length = 4,nullable = false)

  private SkillType type;
  @OneToMany(mappedBy = "skill")
  private List<JobSkill> jobSkills;

}
