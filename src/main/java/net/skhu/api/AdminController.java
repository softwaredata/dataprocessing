package net.skhu.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Election;
import net.skhu.dto.ElectionRequest;
import net.skhu.service.ElectionService;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


/**
 * Created by bomi on 2019-05-25.
 */

@Slf4j
@Controller
public class AdminController {
    private final ElectionService electionService;

    public AdminController(final ElectionService electionService) {
        this.electionService = electionService;
    }

    //@Secured("ROLE_ADMIN")
    @GetMapping("admin/electionManagement")
    public String electionManagement(Model model) {
        final List<Election> list = electionService.getNowElections();

        String type = "";
        for(Election election : list) {
            if(election.getType() == 1) {
                type = "general";
            } else if(election.getType() == 2) {
                type = "department";
            } else if(election.getType() == 3) {
                type = "major";
            }
            model.addAttribute(type, election);
//            log.error(election.toString());
        }

        return  "admin/electionManagement";
    }

    //@Secured("ROLE_ADMIN")
    @PostMapping("admin/electionManagement")
    public String electionManagement(final Optional<ElectionRequest> electionRequest) {
        log.error("enter the method");
        if(electionRequest.isPresent()) {
            log.error("electionRequest is Present!!", electionRequest);
            log.error(electionRequest.get().getRegStartDate());
            log.error(electionRequest.get().getRegEndDate());
            log.error(electionRequest.get().getVoteStartDate());
            log.error(electionRequest.get().getVoteEndDate());

            final ElectionRequest election = electionRequest.get();
            log.error("여기까지");
            electionService.setElection(election);
        }
        return "redirect:/main";
    }
}
