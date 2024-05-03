package dev.diplom.school.step.model;


import dev.diplom.school.lesson.model.Lesson;
import dev.diplom.school.step_text.model.StepText;
import dev.diplom.school.step_video.model.StepVideo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "step")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany
    @JoinColumn(name = "step_id")
    private List<StepText> stepTexts = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "step_id")
    private List<StepVideo> stepVideos = new ArrayList<>();
}
