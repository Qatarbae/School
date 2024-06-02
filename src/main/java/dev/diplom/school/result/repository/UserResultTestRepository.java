package dev.diplom.school.result.repository;

import dev.diplom.school.result.model.UserResultTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT urt FROM UserResultTest urt WHERE urt.user.fullName LIKE %:name%")
    List<UserResultTest> findAllByUserName(@Param("name") String name);

    @Query("SELECT urt FROM UserResultTest urt WHERE urt.stepTest.name LIKE %:name%")
    List<UserResultTest> findAllByTestName(@Param("name") String name);
}
