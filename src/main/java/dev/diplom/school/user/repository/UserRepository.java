package dev.diplom.school.user.repository;


import dev.diplom.school.user.model.entity.Role;
import dev.diplom.school.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    Optional<User> findByRole(Role role);
    boolean existsByFullName(String fullName);
    boolean existsByLogin(String login);
}