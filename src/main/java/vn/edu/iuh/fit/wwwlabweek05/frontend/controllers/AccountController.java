package vn.edu.iuh.fit.wwwlabweek05.frontend.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public String login(Model model, @RequestParam("email") String email,
      @RequestParam("password") String pwd) {
    boolean loginStatus = accountServices.login(email, pwd);
    if (loginStatus) {
      Optional<Account> acc = accountServices.getAccountByEmail(email);
      Optional<Candidate> can = Optional.empty();
      Optional<Company> company = Optional.empty();
      if (acc.isPresent() && (acc.get().getType() == AccountType.CANDIDATE)) {
        can = candidateServices.getCandidateByAccount(acc.get());
        model.addAttribute("candidateLogin", can);
      } else if (acc.isPresent() && (acc.get().getType() == AccountType.COMPANY)) {
        company = companyServices.getByAccount(acc.get());
        model.addAttribute("companyLogin", company);

      }
      model.addAttribute("accLogin", acc);
      return "/home";
    }else {
      model.addAttribute("loginStatus", false);
    }
    return "index";
  }

  @GetMapping("/home")
  public String home(Model model){
    return "home";

  }


}
