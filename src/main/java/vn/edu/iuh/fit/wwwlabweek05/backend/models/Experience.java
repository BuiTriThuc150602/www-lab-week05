package vn.edu.iuh.fit.wwwlabweek05.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "experience")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Experience {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "exp_id")
  private long id;
  @Column(name = "from_date")
  private LocalDate fromDate;
  @Column(name = "to_date")

  private LocalDate toDate;
  @Column(name = "company", length = 120)
  private String companyName;
  @Column(name = "role",length = 100)
  private String role;
  @Column(name = "work_desc",length = 400)

  private String workDescription;
  @ManyToOne
  private Candidate candidate;


}
