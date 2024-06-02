package dev.diplom.school.result.service;


import dev.diplom.school.result.model.ResultType;
import dev.diplom.school.result.model.UserResultTest;
import dev.diplom.school.result.model.dto.UserResultTestCheckDto;
import dev.diplom.school.result.model.dto.UserResultTestDto;
import dev.diplom.school.result.repository.UserResultTestRepository;
import dev.diplom.school.step_test.model.StepOption;
import dev.diplom.school.step_test.model.StepQuestion;
import dev.diplom.school.step_test.model.StepTest;
import dev.diplom.school.step_test.repository.StepQuestionRepository;
import dev.diplom.school.step_test.repository.StepTestRepository;
import dev.diplom.school.user.model.entity.User;
import dev.diplom.school.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserResultTestCheckServiceImpl implements UserResultTestCheckService {

    private final UserResultTestRepository userResultTestRepository;
    private final UserRepository userRepository;
    private final StepTestRepository stepTestRepository;
    private final StepQuestionRepository stepQuestionRepository;


    @Override
    public UserResultTestDto saveUserResultTest(UserResultTestCheckDto userResultTestDto, String name) {
        User user = userRepository.findByLogin(name)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Login"));
        StepTest stepTest = stepTestRepository.findById(userResultTestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid step test ID"));

        int correctAnswersCount = 0;
        int totalQuestions = userResultTestDto.getQuestions().size();

        for (UserResultTestCheckDto.QuestionCheckDto questionDto : userResultTestDto.getQuestions()) {
            StepQuestion question = stepQuestionRepository.findByStepTestIdAndQuestion(userResultTestDto.getId(), questionDto.getQuestion())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));

            // Получаем правильные ответы из базы данных
            Map<String, Boolean> correctOptions = question.getOptions().stream()
                    .collect(Collectors.toMap(StepOption::getOption, StepOption::isValid));

            // Получаем выбранные пользователем ответы из DTO
            Map<String, Boolean> selectedOptions = questionDto.getOptions();

            // Проверяем правильность ответа
            boolean isCorrect;
            if (questionDto.isOneCorrect()) {
                isCorrect = correctOptions.equals(selectedOptions);
            } else {
                isCorrect = correctOptions.entrySet().stream()
                        .filter(Map.Entry::getValue) // Берем только правильные ответы
                        .allMatch(entry -> selectedOptions.getOrDefault(entry.getKey(), false)); // Проверяем, что все правильные ответы выбраны
            }

            if (isCorrect) {
                correctAnswersCount++;
            }
        }

        double percentage = ((double) correctAnswersCount / totalQuestions) * 100;
        ResultType resultType;

        if (percentage < 50) {
            resultType = ResultType.NOT_PASSED;
        } else if (percentage < 70) {
            resultType = ResultType.SATISFACTORY;
        } else if (percentage < 90) {
            resultType = ResultType.GOOD;
        } else {
            resultType = ResultType.EXCELLENT;
        }

        UserResultTest userResultTest = UserResultTest.builder()
                .user(user)
                .stepTest(stepTest)
                .questionsPassed(correctAnswersCount)
                .resultType(resultType)
                .build();

        userResultTest = userResultTestRepository.save(userResultTest);
        String questionPassed = userResultTest.getQuestionsPassed() + "/" + stepTest.getQuestions().stream().count();
        return new UserResultTestDto(
                userResultTest.getId(),
                userResultTest.getUser().getLogin(),
                userResultTest.getStepTest().getStep().getLesson().getModules().getCourse().getName(),
                userResultTest.getStepTest().getName(),
                questionPassed,
                userResultTest.getResultType().name()
        );
    }
}