package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}