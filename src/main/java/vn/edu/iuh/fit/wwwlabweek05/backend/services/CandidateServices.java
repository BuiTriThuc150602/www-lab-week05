package vn.edu.iuh.fit.wwwlabweek05.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Account;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Candidate;
import vn.edu.iuh.fit.wwwlabweek05.backend.repositories.CandidateRepository;

@Service

public class CandidateServices {
  @Autowired
  private CandidateRepository candidateRepository;
  public Page<Candidate> findAll(int pageNo,int pageSize,String sortBy,String sortDirection){
    Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
    Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
    return candidateRepository.findAll(pageable);
  }
  public List<Candidate> findAllNoPaging(){
    return candidateRepository.findAll();
  }

  public Optional<Candidate> getCandidateByAccount(Account account){
    return candidateRepository.findByAccount_Id(account.getId());
  }


}
