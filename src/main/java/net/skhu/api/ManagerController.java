package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.mapper.TeamsMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ManagerController {

    private final TeamsMapper teamsMapper;

    //TODO (6월 16일) 뷰 만들기, 후보자 목록 가져오기
    @GetMapping("/list")
    public String findCandidate(Model model, Member member){
        model.addAttribute("selectCandidate", teamsMapper.findByTeams());
        return "manager/listCandidate";
    }

    //TODO (6월 16일) 후보자 승인 시키기
    @PostMapping("")
    public String candidateMemberAssign() {
        return "";
    }


    @GetMapping("/update")
    public String updateTeam(@RequestParam("idx") int idx, Member member){
        teamsMapper.updateTeams(idx);
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String deleteTeam(@RequestParam("idx") int idx, Member member) {
        teamsMapper.deleteTeams(idx);
        return "redirect:list";
    }
}
