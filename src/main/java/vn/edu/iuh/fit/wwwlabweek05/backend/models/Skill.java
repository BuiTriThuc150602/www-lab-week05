package vn.edu.iuh.fit.wwwlabweek05.backend.models;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.SkillType;

@Entity
@Table(name = "skill")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Skill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "skill_id", length = 20)
  private long id;
  @Column(name = "skill_name", length = 150, nullable = false)
  @NonNull
  private String skillName;
  @Column(name = "skill_desc", length = 300)
  @NonNull
  private String skillDescription;
  @Column(name = "skill_type", length = 4, nullable = false)
  @NonNull
  private SkillType type;
  @OneToMany(mappedBy = "skill")
  private List<JobSkill> jobSkills;

}
