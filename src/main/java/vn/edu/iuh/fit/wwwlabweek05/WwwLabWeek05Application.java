package vn.edu.iuh.fit.wwwlabweek05;

import com.neovisionaries.i18n.CountryCode;
import java.time.LocalDate;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.AccountType;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.SkillType;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Account;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Address;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Candidate;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.AccountRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.SkillRepository;

@SpringBootApplication
public class WwwLabWeek05Application {

  public static void main(String[] args) {
    SpringApplication.run(WwwLabWeek05Application.class, args);
  }

  @Autowired
  private CandidateRepository candidateRepository;
  @Autowired
  private AddressRepository addressRepository;
  @Autowired
  private SkillRepository skillRepository;
  @Autowired
  private CompanyRepository companyRepository;
  @Autowired
  private AccountRepository accountRepository;

//  @Bean
  CommandLineRunner initData() {
    return args -> {
      Random rnd = new Random();
      for (int i = 1; i < 100; i++) {
        Address add = new Address(rnd.nextInt(1, 1000) + "", "Quang Trung", "HCM",
            rnd.nextInt(70000, 80000) + "", CountryCode.VN);
        addressRepository.save(add);

        Account acc = new Account("email_" + i + "@gmail.com", "password" + i,
            AccountType.CANDIDATE);
        accountRepository.save(acc);

        Candidate can = new Candidate("Name #" + i,
            LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
            add,
            rnd.nextLong(1111111111L, 9999999999L) + "",
            "email_" + i + "@gmail.com", acc);
        candidateRepository.save(can);
      }
      for (int i = 0; i < 10; i++) {
        Address add = new Address(rnd.nextInt(1, 1000) + "", "Quang Trung", "HCM",
            rnd.nextInt(70000, 80000) + "", CountryCode.VN);
        addressRepository.save(add);
        Account acc = new Account("email_" + i + "@gmail.com", "password" + i, AccountType.COMPANY);
        accountRepository.save(acc);
        Company com = new Company("Software " + rnd.nextInt(1, 100),
            rnd.nextLong(1111111111L, 9999999999L) + "", "email_" + i + "@gmail.com",
            "www/" + (i * i) + "software.com", add, acc);
        companyRepository.save(com);
      }
      skillRepository.save(new Skill("Java", "Java mobile app", SkillType.SOFT_SKILL));
      skillRepository.save(new Skill("C#", "C# Winform", SkillType.TECHNICAL_sKILL));
      skillRepository.save(
          new Skill("Security", "Java Spring Security", SkillType.TECHNICAL_sKILL));
      skillRepository.save(new Skill("JWT", "JWT", SkillType.SOFT_SKILL));
      skillRepository.save(new Skill("Python", "AI python", SkillType.SOFT_SKILL));
      skillRepository.save(new Skill("MongoDb", "Mongodb design", SkillType.UNSPECIFIC));
      skillRepository.save(new Skill("Ruby", "Ruby programmer", SkillType.SOFT_SKILL));


    };
  }


}
