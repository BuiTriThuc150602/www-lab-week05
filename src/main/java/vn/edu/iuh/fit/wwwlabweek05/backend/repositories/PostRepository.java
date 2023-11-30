package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Post;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;

public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findPostsByJob_JobSkills_Skill(Skill skill);

  Optional<Post> findByJob_JobSkills_Skill(Skill skill);


  List<Post> findByCompany_Id(long id);


}