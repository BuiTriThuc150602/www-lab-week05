package vn.edu.iuh.fit.wwwlabweek05.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}