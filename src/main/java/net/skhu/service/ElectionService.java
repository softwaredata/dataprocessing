/*
minsub
 */
package net.skhu.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.api.ElectionController;
import net.skhu.api.MainController;
import net.skhu.domain.Election;

import net.skhu.domain.Team;
import net.skhu.domain.UserToElection;
import net.skhu.dto.ElectionRequest;
import net.skhu.dto.ElectionVoteDate;
import net.skhu.exception.ElectionException;
import net.skhu.mapper.ElectionMapper;
import net.skhu.mapper.TeamMapper;
import net.skhu.mapper.UserToElectionMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Slf4j
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

    public ElectionRequest getElection(String type, HttpServletResponse response) throws IOException {
        if(StringUtils.isEmpty(type)) {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('투표 타입이 잘못되었습니다'); history.go(-1);</script>");
            out.flush();
            throw new ElectionException("request parameter 없음");
        }

        int realType = Integer.parseInt(type);
        final Election election = electionMapper.findByType(realType);

        StringBuffer sb = new StringBuffer();
        if(realType == 1) {
            sb.append("총학생회");
        } else if(realType == 2) {
            sb.append("학부 대표");
        } else {
            sb.append("전공 대표");
        }

        sb.append(" 선거");

        ElectionRequest request = ElectionRequest.builder()
                .title(sb.toString())
                .regStartDate(election.getRegStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .regEndDate(election.getRegEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .department(election.getDepartment())
                .voteStartDate(election.getVoteStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .voteEndDate(election.getVoteEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .name(election.getName())
                .build();

        return request;
   }

   public void setElection(ElectionRequest electionReq, HttpServletResponse response) throws IOException {
       response.setContentType("text/html; charset=utf-8");
       PrintWriter out = response.getWriter();

       if(electionReq.getName() == 0) {
            out.println("<script>alert('횟수가 올바른 형식이 아닙니다 확인하세요.'); history.go(-1);</script>");
            out.flush();
            throw new ElectionException("name이 없어요");
        }

       int type = 0;
       if(electionReq.getTitle().charAt(0) == '총') {
           type = 1;
       } else if(electionReq.getTitle().charAt(0) == '학') {
           type = 2;
       } else {
           type = 3;
       }

        Election election = Election.builder()
                .name(electionReq.getName())
                .regStartDate(LocalDateTime.parse(electionReq.getRegStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .regEndDate(LocalDateTime.parse(electionReq.getRegEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .voteStartDate(LocalDateTime.parse(electionReq.getVoteStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .voteEndDate(LocalDateTime.parse(electionReq.getVoteEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .type(type)
                .department(electionReq.getDepartment())
                .build();

       int num = electionMapper.update(election);

       if(num != 0) {
           out.println("선거 정보가 저장되었습니다.");
           out.close();
       }
//       return election;
   }

}
