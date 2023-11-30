package vn.edu.iuh.fit.wwwlabweek05.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_id")
  private long id;
  @NonNull
  @Column(name = "title", nullable = false)
  private String title;
  @NonNull
  @Column(name = "publish_at", nullable = false)
  private LocalDate publishAt;
  @NonNull
  @Column(name = "content", nullable = false)
  private String content;
  @NonNull
  @OneToOne
  @JoinColumn(name = "job_id")
  private Job job;
  @NonNull
  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

}
