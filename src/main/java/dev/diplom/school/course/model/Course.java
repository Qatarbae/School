package dev.diplom.school.course.model;

import dev.diplom.school.module.model.Modules;
import dev.diplom.school.user.model.entity.UserCourse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @OneToMany
    @JoinColumn(name = "course_id")
    private List<Modules> modules = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<UserCourse> userCourses;
}
