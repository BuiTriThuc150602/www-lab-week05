package vn.edu.iuh.fit.wwwlabweek05.frontend.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;
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

  @GetMapping("/getPosts")
  public String getAllPost(Model model) {
    return "";
  }

  @GetMapping("/posting")
  public String showPostPage(Model model, @RequestParam("com_id") Optional<Long> com_id) {
    com_id.ifPresent(aLong -> {
          Optional<Company> company = companyServices.getById(aLong);
      if (company.isPresent()) {
        model.addAttribute("company", company);
      }
        }
    );

    model.addAttribute("jobSkillList", skillServices.getSkills());
    return "companyPost/CompanyPosting";
  }

  @PostMapping("/post")
  public String posting() {
    return "";
  }

}
