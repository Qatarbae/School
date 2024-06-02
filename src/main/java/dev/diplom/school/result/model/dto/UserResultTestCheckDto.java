package dev.diplom.school.result.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResultTestCheckDto {
    private Long id;
    private Long stepId;
    private Set<QuestionCheckDto> questions;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class QuestionCheckDto {
        private String question;
        private boolean oneCorrect;
        private Map<String, Boolean> options;

    }
}