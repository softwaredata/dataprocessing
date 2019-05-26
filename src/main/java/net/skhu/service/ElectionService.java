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

    public List<Election> getNowElections() {
        final LocalDateTime now = LocalDateTime.now();
        return electionMapper.findElections(now);
    }

//    public void saveElection(List<ElectionRequest> list) {
//        for(int i=0; i<list.size(); i++) {
//            ElectionRequest election = list.get(i);
//            Election newElection = Election.builder()
//                    .ganeration(election.getGeneration())
//                    .regStartDate(election.getRegStartDate())
//                    .regEndDate(election.getRegEndDate())
//                    .type(election.getType())
//                    .voteStartDate(election.getVoteStartDate())
//                    .voteEndDate(election.getVoteEndDate())
//                    .build();
//
//        }
//    }

//    public void createElection(final ElectionRequest electionRequest) {
//        final Election election = Election.builder()
//                .voteStartDate(dateTime);
//
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                LocalDateTime dateTime = LocalDateTime.parse(electionRequest.getVoteStartDate(), format);
//    }



}
