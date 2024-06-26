package dev.diplom.school.step.model;


import dev.diplom.school.lesson.model.Lesson;
import dev.diplom.school.step_test.model.StepTest;
import dev.diplom.school.step_text.model.StepText;
import dev.diplom.school.step_video.model.StepVideo;
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

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private StepType stepType;

    @Column(name = "position")
    private Integer position;

    @OneToOne(mappedBy = "step", cascade = CascadeType.ALL)
    private StepText stepText;

    @OneToOne(mappedBy = "step", cascade = CascadeType.ALL)
    private StepVideo stepVideo;

    @OneToOne(mappedBy = "step", cascade = CascadeType.ALL)
    private StepTest stepTest;
}
