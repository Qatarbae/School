package dev.diplom.school.step_text.model;

import dev.diplom.school.step.model.Step;
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
@Table(name = "step_text")
public class StepText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "position")
    private Integer position;
}
