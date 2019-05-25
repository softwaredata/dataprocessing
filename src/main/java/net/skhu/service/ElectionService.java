package net.skhu.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Election;
import net.skhu.dto.ElectionRequest;
import net.skhu.mapper.ElectionMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    public List<Election> getElection() {
        final LocalDateTime now = LocalDateTime.now();
        List<Election> resultList = electionMapper.findElections(now);
        return resultList;
    }

//    public void setElection(List<ElectionRequest> list) {
//        for(int i=0; i<electionList.size(); i++) {
//            Election election = electionList.get(i);
//            String name;
//            if(election.getType() == 1) {
//                name = electionList.get(i).getName() + "대 총학";
//            } else if(election.getType() == 2) {
//                name = election.getName() + "대 학부";
//            } else {
//                name = election.getName() + "대 전공";
//            }
//             Election newElection = election.builder()
//                     .name(name)
//
//        }
//    }
//
//    public void createElection(final ElectionRequest electionRequest) {
//        final Election election = Election.builder()
//                .voteStartDate(dateTime);
//
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                LocalDateTime dateTime = LocalDateTime.parse(electionRequest.getVoteStartDate(), format);
//    }



}
