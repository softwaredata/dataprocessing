<<<<<<< HEAD
package net.skhu.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Election;
import net.skhu.dto.ElectionRequest;
import net.skhu.mapper.ElectionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by bomi on 2019-05-16.
 */

@Slf4j
@AllArgsConstructor
@Service
public class ElectionService {
    private final ElectionMapper electionMapper;

    @Transactional(readOnly = true)
    public List<Election> getNowElections() {
        return electionMapper.findElections();
    }

    @Transactional
    public void addElection(final ElectionRequest election) {
        Election newElection = Election.builder()
                .name(election.getName())
                .regStartDate(LocalDateTime.parse(election.getRegStartDate()))
                .regEndDate(LocalDateTime.parse(election.getRegEndDate()))
                .type(election.getType())
                .voteStartDate(LocalDateTime.parse(election.getVoteStartDate()))
                .voteEndDate(LocalDateTime.parse(election.getVoteEndDate()))
                .build();

        try {
            electionMapper.create(newElection);
        } catch(Exception e) {
            log.error(e.getMessage());
        }
    }

    @Transactional
    public void setElection(final ElectionRequest electionRequest) {
        log.error("service");
        Election election = electionMapper.findByName(electionRequest.getType());
        if(election == null) return;
        log.error(election.toString());
        log.error("election is not null");

        election = Election.builder()
                .name(electionRequest.getName())
                .regStartDate(LocalDateTime.parse(electionRequest.getRegStartDate()))
                .regEndDate(LocalDateTime.parse(electionRequest.getRegEndDate()))
                .type(electionRequest.getType())
                .voteStartDate(LocalDateTime.parse(electionRequest.getVoteStartDate()))
                .voteEndDate(LocalDateTime.parse(electionRequest.getVoteEndDate()))
                .build();

        log.error("election", election);

        try {
            electionMapper.update(election);
            log.error("election Update success", election);
        } catch(Exception e) {
            log.error(e.getMessage());
        }
    }


=======
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

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ElectionController.class);

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
>>>>>>> develop

}
