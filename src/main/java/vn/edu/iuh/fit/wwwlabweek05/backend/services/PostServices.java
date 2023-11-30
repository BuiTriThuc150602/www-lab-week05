package vn.edu.iuh.fit.wwwlabweek05.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Post;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.PostRepository;

@Service

public class PostServices {
  @Autowired
  private PostRepository postRepository;
  public List<Post> getAllPost(){
    return postRepository.findAll();
  }
  public Optional<Post> getById(long id){
    return postRepository.findById(id);
  }
  public Optional<Post> getPostBySkill(Skill skill){
    return postRepository.findByJob_JobSkills_Skill(skill);
  }
  public List<Post> getPostsBySkill(Skill skill){
    return postRepository.findPostsByJob_JobSkills_Skill(skill);
  }

  public List<Post> getPostsByCompany(Company company){
    return postRepository.findByCompany_Id(company.getId());
  }


}
