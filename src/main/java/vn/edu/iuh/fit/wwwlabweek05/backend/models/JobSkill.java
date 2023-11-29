package vn.edu.iuh.fit.wwwlabweek05.backend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.SkillLevel;
import vn.edu.iuh.fit.wwwlabweek05.backend.ids.JobSkillID;

@Entity
@Table(name = "job_skill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(JobSkillID.class)
public class JobSkill {
  @Id
  @JoinColumn(name = "skill_id",nullable = false)
  @ManyToOne(cascade = CascadeType.MERGE)
  private Skill skill;
  @Id
  @JoinColumn(name = "job_id",nullable = false)
  @ManyToOne(cascade = CascadeType.MERGE)
  private Job job;
  @JoinColumn(name = "skill_level",nullable = false)
  private SkillLevel skillLevel;
  @Column(name = "more_infos",length = 1000)
  private String moreInfo;

}
