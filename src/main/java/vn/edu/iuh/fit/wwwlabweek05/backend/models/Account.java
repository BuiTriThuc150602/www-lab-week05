package vn.edu.iuh.fit.wwwlabweek05.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.AccountType;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "email", nullable = false)
  @NonNull
  private String email;
  @Column(name = "password", nullable = false)
  @NonNull
  private String password;
  @Column(name = "type")
  @NonNull
  private AccountType type;

}
