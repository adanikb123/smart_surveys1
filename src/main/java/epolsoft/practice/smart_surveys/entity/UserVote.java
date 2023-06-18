package epolsoft.practice.smart_surveys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import epolsoft.practice.smart_surveys.entity.enums.RoleType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_vote")
@Data
public class UserVote {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "answer_option_id", referencedColumnName = "id")
    private AnswerOption answerOption;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "text", nullable = false, columnDefinition = "text")
    private String text;

    public UserVote() {super();}
}


