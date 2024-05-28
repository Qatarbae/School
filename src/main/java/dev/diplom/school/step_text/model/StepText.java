package dev.diplom.school.step_text.model;

import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.StepContentType;
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
public class StepText implements StepContentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "step_id")
    private Step step;

//    @Column(name = "name")
//    private String name;

    @Column(name = "text")
    private String text;

//    @Column(name = "position")
//    private Integer position;
}
