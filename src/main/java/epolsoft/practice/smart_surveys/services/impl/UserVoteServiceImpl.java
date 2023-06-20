package epolsoft.practice.smart_surveys.services.impl;

import epolsoft.practice.smart_surveys.entity.AnswerOption;
import epolsoft.practice.smart_surveys.entity.User;
import epolsoft.practice.smart_surveys.entity.UserVote;
import epolsoft.practice.smart_surveys.repository.AnswerOptionRepository;
import epolsoft.practice.smart_surveys.repository.UserRepository;
import epolsoft.practice.smart_surveys.repository.UserVoteRepository;
import epolsoft.practice.smart_surveys.services.UserService;
import epolsoft.practice.smart_surveys.services.UserVoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import epolsoft.practice.smart_surveys.exceptions.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserVoteServiceImpl implements UserVoteService {
    @Autowired
    private UserService userService;
    @Autowired
    private AnswerOptionRepository answerOptionRepository;
    @Autowired
    private UserVoteRepository userVoteRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserVote> createUserVotes(List<UserVote> userVotes) {
        for (UserVote userVote : userVotes) {
            if (!answerOptionRepository.existsById(userVote.getAnswerOptionId()))
                throw new NotFoundException("Варианта ответа с таким ID не существует");

            userService.checkById(userVote.getUserId());

            userVoteRepository.incrementVoteCount(userVote.getAnswerOptionId());
            this.userVoteRepository.save(userVote);
        }
        return null;
    }
}
