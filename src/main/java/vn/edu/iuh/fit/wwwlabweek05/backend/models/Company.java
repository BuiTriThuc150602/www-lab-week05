package vn.edu.iuh.fit.wwwlabweek05.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "com_id")
  private long id;
  @Column(name = "comp_name",nullable = false)
  private String name;
  @Column(name = "about", length = 2000)
  private String about;
  @Column(name = "phone", unique = true)
  private String phone;
  @Column(name = "email", unique = true)

  private String email;
  @Column(name = "web_url", unique = true)

  private String webURL;
  @OneToOne
  @JoinColumn(name = "address")
  private Address address;
  @OneToMany(mappedBy = "company")
  private List<Job> jobs;


}
