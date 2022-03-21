package cybersoft.javabackend.gira.role.service;

import java.util.List;

import cybersoft.javabackend.gira.role.dto.GiraRoleDTO;
import cybersoft.javabackend.gira.role.model.GiraRole;

public interface GiraRoleService {
	List<GiraRole> findAllEntity();
	GiraRole save(GiraRoleDTO dto);
}
