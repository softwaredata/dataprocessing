package net.skhu.service;

import net.skhu.api.MainController;
import net.skhu.domain.Team;
import net.skhu.dto.ElectionVoteDate;
import net.skhu.mapper.ElectionMapper;
import net.skhu.mapper.TeamMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Service
public class ElectionService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

    private final CheckVoteDayPossibleService checkVoteDayPossibleService;
    private final ElectionMapper electionMapper;
    private final TeamMapper teamMapper;

    public ElectionService(final ElectionMapper electionMapper,
                           final CheckVoteDayPossibleService checkVoteDayPossibleService,final TeamMapper teamMapper) {
        this.electionMapper=electionMapper;
        this.checkVoteDayPossibleService = checkVoteDayPossibleService;
        this.teamMapper = teamMapper;
    }

    public boolean isPossibleVote(ElectionVoteDate electionVoteDate){

        logger.info(electionVoteDate.getVoteStartDate()+" "+electionVoteDate.getVoteEndDate());
        return checkVoteDayPossibleService.isPossibleVoteDay(electionVoteDate);

    }

    public String electionCheck(Model model,int type, HttpServletResponse response) throws IOException{
//        ElectionVoteDate electionVoteDate =electionMapper.findByVoteDate1(type);
        ElectionVoteDate electionVoteDate=ElectionVoteDate.builder()
                .type(type)
                .build();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if(isPossibleVote(electionVoteDate)){
            List<Team> teamList = teamMapper.findTeams(type);
            model.addAttribute("teamList", teamList);
            return "election/election1";
        }
        else {
            model.addAttribute("error",-1);
            model.addAttribute("msg", "not open election");

            return "redirect:/main";
        }
    }



}
