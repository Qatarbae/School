package dev.diplom.school.lesson.model;

import dev.diplom.school.module.model.Modules;
import dev.diplom.school.step.model.Step;
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
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "modules_id")
    private Modules modules;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_exam")
    private boolean isExam;

    @OneToMany
    @JoinColumn(name = "lesson_id")
    private List<Step> steps = new ArrayList<>();
}
