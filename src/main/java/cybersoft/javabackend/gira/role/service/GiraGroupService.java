package cybersoft.javabackend.gira.role.service;

import java.util.List;

import cybersoft.javabackend.gira.role.dto.GiraGroupDTO;
import cybersoft.javabackend.gira.role.dto.GiraGroupWithRolesDTO;

public interface GiraGroupService {
	List<GiraGroupDTO> findAllDto();
	GiraGroupDTO createNewGroup(GiraGroupDTO dto);
	GiraGroupWithRolesDTO addRole(String groupId, String roleId);
}
