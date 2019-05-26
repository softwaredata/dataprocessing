package net.skhu.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Election;
import net.skhu.dto.ElectionRequest;
import net.skhu.mapper.ElectionMapper;
import org.springframework.stereotype.Service;

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

    public void createElection(final ElectionRequest election) {
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

    public void updateElection(final ElectionRequest electionRequest) {
        Election election = electionMapper.findByName(electionRequest.getName(), electionRequest.getType());
        if(election == null) return;

        election = Election.builder()
                .name(electionRequest.getName())
                .regStartDate(LocalDateTime.parse(electionRequest.getRegStartDate()))
                .regEndDate(LocalDateTime.parse(electionRequest.getRegEndDate()))
                .type(electionRequest.getType())
                .voteStartDate(LocalDateTime.parse(electionRequest.getVoteStartDate()))
                .voteEndDate(LocalDateTime.parse(electionRequest.getVoteEndDate()))
                .build();

        try {
            electionMapper.update(election);
        } catch(Exception e) {
            log.error(e.getMessage());
        }
    }



}
