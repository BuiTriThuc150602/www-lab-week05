package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  Optional<Company> findByAccount_Id(long id);

  Optional<Company> findByName(String name);
}