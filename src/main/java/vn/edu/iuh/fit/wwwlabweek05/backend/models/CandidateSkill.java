package vn.edu.iuh.fit.wwwlabweek05.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.SkillLevel;
import vn.edu.iuh.fit.wwwlabweek05.backend.ids.CandidateSkillID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "candidate_skill")
@IdClass(CandidateSkillID.class)
public class CandidateSkill {
  @Id
  @JoinColumn(name = "can_id")
  @ManyToOne
  private Candidate candidate;
  @Id
  @JoinColumn(name = "skill_id")
  @ManyToOne
  private Skill skill;
  @Column(name = "skill_level",length = 4)
  private SkillLevel skillLevel;
  @Column(name = "more_infos",length = 1000)
  private String moreInfo;

}
