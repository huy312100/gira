package cybersoft.javabackend.gira.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.gira.role.dto.GiraGroupDTO;
import cybersoft.javabackend.gira.role.dto.GiraGroupWithRolesDTO;
import cybersoft.javabackend.gira.role.dto.GiraRoleDTO;
import cybersoft.javabackend.gira.role.model.GiraGroup;

@Mapper
public interface GiraGroupMapper {

	GiraGroupMapper INSTANCE=Mappers.getMapper(GiraGroupMapper.class);
	
	GiraGroupDTO toDTO(GiraGroup model);
	GiraGroup toModel(GiraGroupDTO dto);
	GiraGroupWithRolesDTO toDtoWithRoles(GiraGroup modifiedGroup);
}
