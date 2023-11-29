package vn.edu.iuh.fit.wwwlabweek05;

import com.neovisionaries.i18n.CountryCode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.AccountType;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.SkillLevel;
import vn.edu.iuh.fit.wwwlabweek05.backend.enums.SkillType;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Account;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Address;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Candidate;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Job;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.JobSkill;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Skill;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.AccountRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.JobRepository;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.JobSkillRepository;
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
  @Autowired
  private JobRepository jobRepository;
  @Autowired
  private JobSkillRepository jobSkillRepository;

//  @Bean
  CommandLineRunner initData() {
    return args -> {

      //Skill Insert
      Skill sk1 = new Skill("Java", "Java mobile app", SkillType.SOFT_SKILL);
      skillRepository.save(sk1);
      Skill sk2 = new Skill("C#", "C# Winform", SkillType.TECHNICAL_sKILL);
      skillRepository.save(sk2);
      Skill sk3 = new Skill("Security", "Java Spring Security", SkillType.TECHNICAL_sKILL);
      skillRepository.save(sk3);
      Skill sk4 = new Skill("JWT", "JWT", SkillType.SOFT_SKILL);
      skillRepository.save(sk4);
      Skill sk5 = new Skill("Python", "AI python", SkillType.SOFT_SKILL);
      skillRepository.save(sk5);
      Skill sk6 = new Skill("MongoDb", "Mongodb design", SkillType.UNSPECIFIC);
      skillRepository.save(sk6);
      Skill sk7 = new Skill("Ruby", "Ruby programmer", SkillType.SOFT_SKILL);
      skillRepository.save(sk7);

      //Account
      Account accCandidate = new Account("trithucbuittb@gmail.com", "thuc123",
          AccountType.CANDIDATE);
      Account accCompany = new Account("company@company.com", "com123", AccountType.COMPANY);
      accountRepository.save(accCandidate);
      accountRepository.save(accCompany);

      //address
      Address addCandidate = new Address("102/28", "Phan Huy ich", "Tp.HCM",
          "77998", CountryCode.VN);
      Address addCompany = new Address("28/10", "Nguyen Hue", "Tp.HCM",
          "717374", CountryCode.VN);
      addressRepository.save(addCandidate);
      addressRepository.save(addCompany);

      //candidate, company
      candidateRepository.save(
          new Candidate("Bui Tri Thuc", LocalDate.of(2002, 6, 15), addCandidate, "0963015348",
              accCandidate.getEmail(), accCandidate));
      companyRepository.save(
          new Company("AWS Software Engineer", "028998823", accCompany.getEmail(), "www.aws.vn",
              addCompany, accCompany));
      Random rnd = new Random();

      // candidate
      for (int i = 1; i < 20; i++) {
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

      //Company
      for (int i = 0; i < 10; i++) {
        Address add = new Address(rnd.nextInt(1, 1000) + "", "Quang Trung", "HCM",
            rnd.nextInt(70000, 80000) + "", CountryCode.VN);
        addressRepository.save(add);
        Account acc = new Account("email_company" + i + "@gmail.com", "passCompany" + i,
            AccountType.COMPANY);
        accountRepository.save(acc);
        Company com = new Company("Software ASW Company " + rnd.nextInt(1, 100),
            rnd.nextLong(1111111111L, 9999999999L) + "", "email_" + i * i + 1 + "@gmail.com",
            "www/" + (i * i) + "software.com", add, acc);
        companyRepository.save(com);
        Job jb = new Job("Job name " + i, " Job name " + i + " description", com);
        jobRepository.save(jb);
        List<Skill> skillList = List.of(sk1, sk2, sk3, sk4, sk5, sk6, sk7);
        JobSkill jobSkill = new JobSkill(skillList.get(rnd.nextInt(1, 7)), jb,
            Arrays.stream(SkillLevel.values()).toList().get(rnd.nextInt(0, 4)),
            "No more information for job");
        jobSkillRepository.save(jobSkill);

      }


    };
  }


}
