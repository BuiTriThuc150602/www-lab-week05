package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

  Optional<Candidate> findByAccount_Id(long id);
}