package net.skhu.service;

import lombok.RequiredArgsConstructor;
import net.skhu.domain.Election;
import net.skhu.dto.ElectionVoteDate;
import net.skhu.mapper.ElectionMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CheckVoteDayPossibleService {

    private final ElectionMapper electionMapper;

     public boolean isPossibleVoteDay(ElectionVoteDate electionVoteDate) {
        Election compareVoteDate = getVoteDate(electionVoteDate);
        return isCheckIntermediatePeriod(compareVoteDate) || isCheckStartDuration(compareVoteDate.getVoteStartDate()) || isCheckEndDuration(compareVoteDate.getVoteEndDate());
    }

    private Election getVoteDate(ElectionVoteDate electionVoteDate) {
         return electionMapper.findByVoteDate(electionVoteDate);
    }

    private boolean isCheckIntermediatePeriod(Election electionVoteDate) {
         return (electionVoteDate.getVoteEndDate().isAfter(LocalDate.now()) && electionVoteDate.getVoteStartDate().isBefore(LocalDate.now()));
    }

    private boolean isCheckStartDuration(LocalDate startDate){
         return startDate.equals(LocalDate.now());
    }

    private boolean isCheckEndDuration(LocalDate endDate) {
         return endDate.equals(LocalDate.now());
    }

}
