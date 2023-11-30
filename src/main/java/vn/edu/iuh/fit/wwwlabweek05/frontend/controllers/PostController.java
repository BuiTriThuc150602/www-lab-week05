package vn.edu.iuh.fit.wwwlabweek05.frontend.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.SkillLevel;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Job;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.JobSkill;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Post;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.JobRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.PostRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.CompanyServices;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.PostServices;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.SkillServices;

@Controller

public class PostController {

  @Autowired
  private PostServices postServices;
  @Autowired
  private CompanyServices companyServices;
  @Autowired
  private SkillServices skillServices;
  @Autowired
  private JobRepository jobRepository;
  @Autowired
  private JobSkillRepository jobSkillRepository;
  @Autowired
  private PostRepository postRepository;

  @GetMapping("/getPosts")
  public String getAllPost(Model model) {
    return "";
  }

  @GetMapping("/post")
  public String showPostPage(Model model, @RequestParam("com_id") Optional<Long> com_id) {
    com_id.ifPresent(aLong -> {
          Optional<Company> company = companyServices.getById(aLong);
          if (company.isPresent()) {
            model.addAttribute("company", company);
          }
        }
    );

    List<SkillLevel> skillLevels = List.of(SkillLevel.values());
    List<Skill> skills = skillServices.getSkills();
    model.addAttribute("skillList", skills);
    model.addAttribute("levels", skillLevels);

    return "companyPost/CompanyPosting";
  }

  @PostMapping("/post")
  public String posting(RedirectAttributes redirectAttributes, @RequestParam("skills") Long[] skills,
      @RequestParam("title") String title, @RequestParam("content") String content,
      @RequestParam("jobName") String jobName, @RequestParam("jobName") String description,
      @RequestParam("companyId") Long companyId, @RequestParam Map<String, String> skillLevels) {
    List<JobSkill> jobSkills = new ArrayList<>();

    Optional<Company> company = companyServices.getById(companyId);
    Job job = new Job(jobName, description, company.get());
    jobRepository.save(job);

    Arrays.stream(skills).toList().forEach(aLong -> {
      String level = skillLevels.get(aLong.toString());
      Skill skill = skillServices.getSkill(aLong).get();
      JobSkill jobSkill = new JobSkill(skill,job,SkillLevel.valueOf(level),"");
      jobSkills.add(jobSkill);
      jobSkillRepository.save(jobSkill);
    });
    job.setJobSkills(jobSkills);
    jobRepository.save(job);

    Post post = new Post(title, LocalDate.now(), content, job, company.get());
    postRepository.save(post);

    redirectAttributes.addFlashAttribute("companyLogin", company);
    redirectAttributes.addFlashAttribute("candidateLogin", null);
    return "redirect:/home-page";
  }
  @DeleteMapping("/delete")
  public String deletePost(@RequestParam Optional<Long> id){
    id.ifPresent(aLong -> postRepository.deleteById(aLong));
    return "redirect:/home-page";
  }
}
