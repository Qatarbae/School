package dev.diplom.school.step_text.repository;

import dev.diplom.school.step_text.model.StepText;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepTextRepository extends CrudRepository<StepText, Long> {
}
