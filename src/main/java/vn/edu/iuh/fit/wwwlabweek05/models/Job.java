package vn.edu.iuh.fit.wwwlabweek05.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "job_id")
  private long id;
  @Column(name = "job_name")
  private String name;
  @Column(name = "job_desc")

  private String description;
  @ManyToOne
  @JoinColumn(name = "company", nullable = false)
  private Company company;
  @OneToMany(mappedBy = "job")
  private List<JobSkill> jobSkills;

}
