/*
minsub
 */
package net.skhu.service;

import net.skhu.api.ElectionController;
import net.skhu.api.MainController;
import net.skhu.domain.Team;
import net.skhu.domain.UserToElection;
import net.skhu.dto.ElectionVoteDate;
import net.skhu.mapper.ElectionMapper;
import net.skhu.mapper.TeamMapper;
import net.skhu.mapper.UserToElectionMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Service
public class ElectionService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ElectionService.class);

    private final CheckVoteDayPossibleService checkVoteDayPossibleService;
    private final ElectionMapper electionMapper;
    private final TeamMapper teamMapper;
    private final UserToElectionMapper userToElectionMapper;

    public ElectionService(final ElectionMapper electionMapper, final CheckVoteDayPossibleService checkVoteDayPossibleService,
                           final TeamMapper teamMapper, final UserToElectionMapper userToElectionMapper) {
        this.electionMapper=electionMapper;
        this.checkVoteDayPossibleService = checkVoteDayPossibleService;
        this.teamMapper = teamMapper;
        this.userToElectionMapper = userToElectionMapper;
    }

    public boolean isPossibleVote(ElectionVoteDate electionVoteDate){

        return checkVoteDayPossibleService.isPossibleVoteDay(electionVoteDate);

    }

    public boolean electionCheck(Model model,int electionType, HttpServletResponse response) throws IOException{
        ElectionVoteDate electionVoteDate=ElectionVoteDate.builder()
                .type(electionType)
                .build();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if(isPossibleVote(electionVoteDate)){
            model.addAttribute("election",electionMapper.findByVoteDate(electionVoteDate.getType()));
            List<Team> teamList = teamMapper.findTeams(electionType);
            model.addAttribute("teamList", teamList);
            return true;
        }
        else {
            out.println("<script>alert('투표가 개설되지 않았습니다'); history.go(-1);</script>");
            out.flush();
            return false;
        }
    }

    public void studentGoVote(UserToElection userToElection,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if(userToElectionMapper.findMemberPossibleVote(userToElection) > 0){
            out.println("이미 투표 하셨습니다");
            out.flush();

        }
        else if( userToElectionMapper.findMemberPossibleVote(userToElection) == 0){
            userToElectionMapper.goToVote(userToElection);
            if(userToElection.getAbandonment() == 1) {
                out.println("기권 하셨습니다");
            }
            else{
                out.println("소중한 한표 감사합니다");
            }
            out.flush();

        }
    }

    public void endElection(){

    }

}
