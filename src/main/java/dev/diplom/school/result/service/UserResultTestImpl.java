package dev.diplom.school.result.service;

import dev.diplom.school.course.model.Course;
import dev.diplom.school.result.model.UserResultTest;
import dev.diplom.school.result.model.dto.UserResultTestDto;
import dev.diplom.school.result.repository.UserResultTestRepository;
import dev.diplom.school.step_test.model.StepTest;
import dev.diplom.school.step_test.repository.StepTestRepository;
import dev.diplom.school.user.model.entity.User;
import dev.diplom.school.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserResultTestImpl implements UserResultTestService {

    private final UserResultTestRepository userResultTestRepository;
    private final UserRepository userRepository;  // Assuming you have this repository
    private final StepTestRepository stepTestRepository;  // Assuming you have this repository

    @Override
    public UserResultTestDto getByUserId(Long userId) {
        Optional<UserResultTest> userResultTest = userResultTestRepository.findByUserId(userId);
        return userResultTest.map(this::toDto).orElse(null);
    }

    @Override
    public UserResultTestDto getByStepTestId(Long testId) {
        Optional<UserResultTest> userResultTest = userResultTestRepository.findByStepTestId(testId);
        return userResultTest.map(this::toDto).orElse(null);
    }

    @Override
    public List<UserResultTestDto> getAllByUserId(Long userId) {
        return userResultTestRepository.findAllByUserId(userId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResultTestDto> getAllByStepTestId(Long testId) {
        return userResultTestRepository.findAllByStepTestId(testId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResultTestDto> getAllByResultType(String resultType) {
        return userResultTestRepository.findAllByResultType(resultType)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private UserResultTestDto toDto(UserResultTest userResultTest) {
        User user = userRepository.findById(userResultTest.getUser().getId()).orElseThrow();
        StepTest stepTest = stepTestRepository.findById(userResultTest.getStepTest().getId()).orElseThrow();
        Course course = stepTest.getStep().getLesson().getModules().getCourse();

        String questionPassed = userResultTest.getQuestionsPassed() + "/" + stepTest.getQuestions().stream().count();

        return new UserResultTestDto(
                userResultTest.getId(),
                user.getLogin(),
                course.getName(),
                stepTest.getName(),
                questionPassed,
                userResultTest.getResultType().name()
        );
    }

    @Override
    public List<UserResultTestDto> findAllByUserName(String name) {
        return userResultTestRepository.findAllByUserName(name)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResultTestDto> findAllByTestName(String name) {
        return userResultTestRepository.findAllByTestName(name)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
