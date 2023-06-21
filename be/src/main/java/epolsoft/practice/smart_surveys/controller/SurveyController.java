package epolsoft.practice.smart_surveys.controller;

import epolsoft.practice.smart_surveys.dto.AccessSurveyResponseDto;
import epolsoft.practice.smart_surveys.dto.SurveyRequestDto;
import epolsoft.practice.smart_surveys.dto.SurveyResponseDto;
import epolsoft.practice.smart_surveys.entity.AccessSurvey;
import epolsoft.practice.smart_surveys.entity.Survey;
import epolsoft.practice.smart_surveys.mapper.AccessSurveyMapper;
import epolsoft.practice.smart_surveys.mapper.SurveyMapper;
import epolsoft.practice.smart_surveys.services.SurveyService;
import epolsoft.practice.smart_surveys.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/survey")
@Tag(name = "Опросник", description = "Все методы для работы с опросником")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private UserService userService;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private AccessSurveyMapper accessSurveyMapper;

    @Operation(summary = "Создать новый опрос")
    @PostMapping()
    public SurveyResponseDto createSurvey(@Valid @RequestBody SurveyRequestDto surveyDto) {
        Survey survey = surveyService.createSurvey(surveyDto);
        return surveyMapper.toResponseDto(survey);
    }

    @Operation(summary = "Получить опрос по id")
    @GetMapping("/{id}")
    public SurveyResponseDto getById(@PathVariable Long id) {
        Survey survey = surveyService.getSurveyById(id);
        return surveyMapper.toResponseDto(survey);
    }

    @Operation(summary = "Получить список опросов по id автора")
    @GetMapping("/author/{id}")
    public List<SurveyResponseDto> getSurveys(@PathVariable Long id) {
        List<Survey> surveys = surveyService.getAllSurveysByUserId(id);
        return surveyMapper.toResponseDtos(surveys);
    }

    @Operation(summary = "Получить список доступных опросов автору по его id")
    @GetMapping("/available/{id}")
    public List<AccessSurveyResponseDto> getAccessSurveys(@PathVariable Long id){
        List<AccessSurvey> accessSurveys = surveyService.getAllAccessSurveysByUserId(id);
        return accessSurveyMapper.toResponseDtos(accessSurveys);
    }
}
