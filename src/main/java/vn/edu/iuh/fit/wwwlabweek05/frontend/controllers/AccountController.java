package vn.edu.iuh.fit.wwwlabweek05.frontend.controllers;

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
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.AccountServices;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.CandidateServices;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.CompanyServices;

@Controller
public class AccountController {

  @Autowired
  private AccountServices accountServices;
  @Autowired
  private CandidateServices candidateServices;
  @Autowired
  private CompanyServices companyServices;

  @PostMapping("/login")
  public String login(Model model, RedirectAttributes redirectAttributes,
      @RequestParam("email") String email,
      @RequestParam("password") String pwd) {
    boolean loginStatus = accountServices.login(email, pwd);
    if (loginStatus) {
      Optional<Account> acc = accountServices.getAccountByEmail(email);
      Optional<Candidate> can;
      Optional<Company> com;
      model.addAttribute("accLogin", acc);

      if (acc.isPresent() && (acc.get().getType() == AccountType.CANDIDATE)) {
        can = candidateServices.getCandidateByAccount(acc.get());
        com = Optional.empty();
        can.ifPresent(candidate -> {
          redirectAttributes.addFlashAttribute("candidateLogin", candidate);
          redirectAttributes.addFlashAttribute("companyLogin", com);
        });
      } else if (acc.isPresent() && (acc.get().getType() == AccountType.COMPANY)) {
        can = Optional.empty();
        com = companyServices.getByAccount(acc.get());
        com.ifPresent(company -> {
          System.out.println("company in login : " + company);
          redirectAttributes.addFlashAttribute("companyLogin", company);
          redirectAttributes.addFlashAttribute("candidateLogin", can);
        });

      }
      return "redirect:/home-page";
    } else {
      model.addAttribute("loginStatus", false);
    }
    return "index";
  }

  @GetMapping("/home-page")
  public String home(Model model, @ModelAttribute("candidateLogin") Optional<Candidate> candidate,
      @ModelAttribute("companyLogin") Optional<Company> company) {
    System.out.println("candidate:" + candidate);
    System.out.println("company:" + company);
    if (candidate.isPresent()) {
      model.addAttribute("candidateLogin", candidate.get());
    } else
      company.ifPresent(value -> model.addAttribute("companyLogin", value));

    return "home";

  }


}
