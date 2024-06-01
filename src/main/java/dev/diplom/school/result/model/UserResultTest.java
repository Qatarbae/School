package dev.diplom.school.result.model;

import dev.diplom.school.step_test.model.StepTest;
import dev.diplom.school.user.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_result_test")
public class UserResultTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "step_test_id", nullable = false)
    private StepTest stepTest;

    @Column(name = "questions_passed", nullable = false)
    private int questionsPassed;

    @Enumerated(EnumType.STRING)
    @Column(name = "result_type", nullable = false)
    private ResultType resultType;

}
