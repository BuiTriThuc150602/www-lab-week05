package vn.edu.iuh.fit.wwwlabweek05.backend.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Account;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.AccountRepository;

@Service
public class AccountServices {
@Autowired
  private AccountRepository accountRepository;

  public boolean login(String email, String pwd) {
    return accountRepository.existsByEmailAndPassword(email, pwd);
  }

  public Optional<Account> getAccountByEmail(String email) {
    return accountRepository.findByEmail(email);
  }

  public void save(Account account) {
    accountRepository.save(account);
  }

  public int update(long id, String pwd) {
    return accountRepository.updatePasswordById(pwd, id);
  }



}
