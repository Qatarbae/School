package dev.diplom.school.step_test.repository;

import dev.diplom.school.step_test.model.StepQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StepQuestionRepository extends JpaRepository<StepQuestion, Long> {

    Optional<StepQuestion> findByQuestion(String question);
}
