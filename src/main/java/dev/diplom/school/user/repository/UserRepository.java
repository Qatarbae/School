package dev.diplom.school.user.repository;


import java.util.Optional;

import dev.diplom.school.user.model.entity.Role;
import dev.diplom.school.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);

    Optional<User> findByRole(Role role);
    boolean existsByFullName(String fullName);
    boolean existsByLogin(String login);
}