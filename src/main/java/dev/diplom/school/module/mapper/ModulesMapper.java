package dev.diplom.school.module.mapper;

import dev.diplom.school.module.model.Modules;
import dev.diplom.school.module.model.dto.ModulesRequest;
import dev.diplom.school.module.model.dto.ModulesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModulesMapper {
    ModulesMapper INSTANCE = Mappers.getMapper(ModulesMapper.class);

    @Mapping(source = "course.id", target = "courseId")
    ModulesResponse mapToModulesResponse(Modules modules);

    List<ModulesResponse> mapToModulesResponseList(List<Modules> modulesList);

    Modules mapToModules(ModulesRequest modulesRequest);

    List<Modules> mapToModulesList(List<ModulesRequest> modulesRequestList);
}