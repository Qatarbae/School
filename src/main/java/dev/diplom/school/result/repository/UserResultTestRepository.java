package dev.diplom.school.result.repository;

import dev.diplom.school.result.model.UserResultTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserResultTestRepository extends JpaRepository<UserResultTest, Long> {

    Optional<UserResultTest> findByUserId(Long userId);

    Optional<UserResultTest> findByStepTestId(Long testId);

    List<UserResultTest> findAllByUserId(Long userId);

    List<UserResultTest> findAllByStepTestId(Long testId);

    List<UserResultTest> findAllByResultType(String resultType);


}
