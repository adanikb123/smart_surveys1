package epolsoft.practice.smart_surveys.repository;

import epolsoft.practice.smart_surveys.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findAllByAuthorId(Long id);
}
