package dev.diplom.school.module.repository;

import dev.diplom.school.module.model.Modules;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesRepository extends CrudRepository<Modules, Long> {
}
