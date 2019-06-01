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
@AllArgsConstructor
@Controller
public class AdminController {
    final ElectionService electionService;

    @Secured("ROLE_ADMIN")
    @GetMapping("admin/electionManagement")
    public String electionManagement(Model model) {
        final List<Election> list = electionService.getNowElections();
        StringBuilder sb = new StringBuilder();

        for(Election election : list) {
            sb.append("election")
                    .append(election.getType());

            model.addAttribute(sb.toString(), election);
        }

        return  "admin/electionManagement";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("admin/electionManagement")
    public String electionManagement(@RequestBody(required = false) final Optional<ElectionRequest> electionRequest) {
        if(electionRequest.isPresent()) {
            final ElectionRequest election = electionRequest.get();
            electionService.setElection(election);
        }
        return "admin/electionManagement";
    }
}
