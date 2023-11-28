package vn.edu.iuh.fit.wwwlabweek05.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_id")
  private long id;
  @Column(name = "title", nullable = false)
  private String title;
  @Column(name = "publish_at", nullable = false)
  private LocalDate publishAt;
  @Column(name = "content", nullable = false)
  private String content;
  @OneToMany
  private List<JobSkill> jobSkills;
  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;
  @Column(name = "start_date")
  private LocalDate startDate;
  @Column(name = "end_date")
  private LocalDate endDate;
  @Column(name = "start_salary")
  private double startSalary;


}
