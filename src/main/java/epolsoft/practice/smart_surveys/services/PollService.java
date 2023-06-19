package epolsoft.practice.smart_surveys.services;

import epolsoft.practice.smart_surveys.entity.Poll;
import epolsoft.practice.smart_surveys.exceptions.NotFoundException;

import java.util.List;

public interface PollService {
    List<Poll> getPollsBySurveyId(Long id);
    void checkById(Long id) throws NotFoundException;
}
