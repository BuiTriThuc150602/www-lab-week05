package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

  @Transactional
  @Modifying
  @Query("update Account a set a.password = ?1 where a.id = ?2")
  int updatePasswordById(String password, long id);

  boolean existsByEmailAndPassword(
      String email, String password);

  Optional<Account> findByEmail(@NonNull String email);
}