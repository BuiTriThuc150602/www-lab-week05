package vn.edu.iuh.fit.wwwlabweek05.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Candidate")

public class Candidate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "can_id", length = 20)
  private long id;
  @Column(name = "full_name",length = 255,nullable = false)
  private String fullName;
  @Column(name = "dob",nullable = false)
  private LocalDate dob;
  @Column(name = "phone",length = 15,nullable = false,unique = true)
  private String phone;
  @Column(name = "email",length = 255,nullable = false,unique = true)

  private String email;
  @JoinColumn(name = "address",nullable = false)
  @OneToOne
  private Address address;
  @OneToMany(mappedBy = "candidate")
  private List<CandidateSkill> candidateSkills;
  @OneToMany(mappedBy = "candidate")

  private List<Experience> experiences;

}
