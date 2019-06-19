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



}
