package dev.diplom.school.step_test.model;

import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.StepContentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "step_test")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StepTest implements StepContentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "step_id")
    private Step step;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "stepTest")
    private Set<StepQuestion> questions;
}
