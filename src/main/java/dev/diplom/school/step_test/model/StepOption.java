package dev.diplom.school.step_test.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "step_option")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StepOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "test_question_id", nullable = false)
    private StepQuestion stepQuestion;

    @Column(name = "option", nullable = false)
    private String option;

    @Column(name = "valid", nullable = false)
    private boolean valid;
}
