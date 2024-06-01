package dev.diplom.school.step_test.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "step_question")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StepQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "step_test_id", nullable = false)
    private StepTest stepTest;

    @Column(name = "question")
    private String question;

    @Column(name = "one_correct")
    private boolean oneCorrect;

    @OneToMany(mappedBy = "stepQuestion")
    private Set<StepOption> options;

}
