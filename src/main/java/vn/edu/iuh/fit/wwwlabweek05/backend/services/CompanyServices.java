package vn.edu.iuh.fit.wwwlabweek05.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Account;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Company;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.CompanyRepository;

@Service
public class CompanyServices {
  @Autowired
  private CompanyRepository companyRepository;
  public List<Company> getAllCompany(){
    return companyRepository.findAll();
  }
  public Optional<Company> getById(long id){
    return companyRepository.findById(id);
  }
  public Optional<Company> getByName(String name){
    return companyRepository.findByName(name);
  }
  public Optional<Company> getByAccount(Account account){
    return companyRepository.findByAccount_Id(account.getId());
  }



}
