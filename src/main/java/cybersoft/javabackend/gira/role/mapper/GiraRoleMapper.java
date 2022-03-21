package cybersoft.javabackend.gira.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.gira.role.dto.GiraRoleDTO;
import cybersoft.javabackend.gira.role.model.GiraRole;

@Mapper
public interface GiraRoleMapper {
GiraRoleMapper INSTANCE = Mappers.getMapper(GiraRoleMapper.class);
	
	GiraRole mapToEntity(GiraRoleDTO dto);
}
