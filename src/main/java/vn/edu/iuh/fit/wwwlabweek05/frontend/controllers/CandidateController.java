package vn.edu.iuh.fit.wwwlabweek05.frontend.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.wwwlabweek05.backend.models.Candidate;
import vn.edu.iuh.fit.wwwlabweek05.backend.services.CandidateServices;

@Controller
public class CandidateController {
  @Autowired
  private CandidateServices candidateServices;

  @GetMapping("/list")
  public String showCandidateListNoPaging(Model model){
    model.addAttribute("candidates",candidateServices.findAllNoPaging());
    return "candidates/candidates";
  }
  @GetMapping("/candidates")
  public String showCandidateListWithPaging(Model model,@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
    int currentPage = page.orElse(1);
    int pageSize = size.orElse(15);
    Page<Candidate> candidatePage = candidateServices.findAll(currentPage-1,pageSize,"id","asc");
    model.addAttribute("candidatePage",candidatePage);
    int totalPages = candidatePage.getTotalPages();
    if (totalPages > 0) {
      List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
          .boxed()
          .collect(Collectors.toList());
      model.addAttribute("pageNumbers", pageNumbers);
    }

    return "candidates/candidatePage";
  }




}
