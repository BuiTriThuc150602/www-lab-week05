package vn.edu.iuh.fit.wwwlabweek05.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.AccountType;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Account;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Candidate;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.CandidateSkill;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Post;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.AccountServices;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.CandidateServices;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.CompanyServices;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.PostServices;

@Controller
public class AccountController {

  @Autowired
  private AccountServices accountServices;
  @Autowired
  private CandidateServices candidateServices;
  @Autowired
  private CompanyServices companyServices;
  @Autowired
  private PostServices postServices;

  @GetMapping("/login")
  public String goToLogin() {
    return "index";
  }

  @PostMapping("/login")
  public String login(Model model, HttpSession session,
      @RequestParam("email") String email,
      @RequestParam("password") String pwd) {
    boolean loginStatus = accountServices.login(email, pwd);
    session.setAttribute("isLogin", loginStatus);
    if (loginStatus) {
      Optional<Account> acc = accountServices.getAccountByEmail(email);
      Optional<Candidate> can;
      Optional<Company> com;
      model.addAttribute("accLogin", acc);

      if (acc.isPresent() && (acc.get().getType() == AccountType.CANDIDATE)) {
        can = candidateServices.getCandidateByAccount(acc.get());
        session.setAttribute("candidateLogin", can.get());
      } else if (acc.isPresent() && (acc.get().getType() == AccountType.COMPANY)) {
        com = companyServices.getByAccount(acc.get());
        session.setAttribute("companyLogin", com.get());
      }
      return "redirect:/home-page";
    } else {
      model.addAttribute("loginStatus", false);
    }

    return "index";
  }

  @GetMapping("/home-page")
  public String home(Model model, HttpSession session) {
    Boolean isLogin = (Boolean) session.getAttribute("isLogin");
    isLogin = isLogin != null && isLogin;

    if (isLogin) {
      Candidate candidate = (Candidate) session.getAttribute("candidateLogin");
      Company company = (Company) session.getAttribute("companyLogin");
      List<Post> postList;
      if (candidate != null) {
        model.addAttribute("candidateLogin", candidate);
        model.addAttribute("companyLogin", null);
        List<CandidateSkill> candidateSkills = candidate.getCandidateSkills();
        postList = new ArrayList<>();
        if (candidateSkills != null) {
          for (CandidateSkill candidateSkill : candidateSkills) {
            System.out.println(candidateSkill);
            postList.addAll(postServices.getPostsBySkill(candidateSkill.getSkill()));
          }

        }
        model.addAttribute("postList", postList);
      } else if (company != null) {
        model.addAttribute("candidateLogin", null);
        model.addAttribute("companyLogin", company);
        postList = new ArrayList<>(postServices.getPostsByCompany(company));
        session.setAttribute("postList", postList);
      }
      return "home";
    } else {
      return "redirect:/login";
    }
  }
}
