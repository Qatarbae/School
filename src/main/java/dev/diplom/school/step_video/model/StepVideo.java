package dev.diplom.school.step_video.model;

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
@Table(name = "step_video")
public class StepVideo implements StepContentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "step_id")
    private Step step;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "position")
    private Integer position;
}
