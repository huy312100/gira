package cybersoft.javabackend.gira.role.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.gira.role.dto.GiraGroupDTO;
import cybersoft.javabackend.gira.role.dto.GiraGroupWithRolesDTO;
import cybersoft.javabackend.gira.role.mapper.GiraGroupMapper;
import cybersoft.javabackend.gira.role.model.GiraGroup;
import cybersoft.javabackend.gira.role.model.GiraRole;
import cybersoft.javabackend.gira.role.repository.GiraGroupRepository;
import cybersoft.javabackend.gira.role.repository.GiraRoleRepository;

@Service
public class GiraGroupServiceImpl implements GiraGroupService {
	@Autowired
	private GiraGroupRepository repository;
	@Autowired
	private GiraRoleRepository roleRepository;
	
	@Override
	public List<GiraGroupDTO> findAllDto() {
		List<GiraGroup> groups=repository.findAll();
		List<GiraGroupDTO> dtos=groups.stream()
								.map(t->GiraGroupMapper.INSTANCE.toDTO(t))
								.collect(Collectors.toList());
		
		return dtos; 
	}

	@Override
	public GiraGroupDTO createNewGroup(GiraGroupDTO dto) {
		GiraGroup group=GiraGroupMapper.INSTANCE.toModel(dto);
		GiraGroup newGroup=repository.save(group);
		return GiraGroupMapper.INSTANCE.toDTO(newGroup);
	}

	@Override
	public GiraGroupWithRolesDTO addRole(String groupId, String roleId) {
		GiraGroup group;
		GiraRole role;
		try {
			group=repository.getById(UUID.fromString(groupId));
			role=roleRepository.getById(UUID.fromString(roleId));
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		group.addRole(role);
		GiraGroup modifiedGroup=repository.save(group);
		GiraGroupWithRolesDTO dto=GiraGroupMapper.INSTANCE.toDtoWithRoles(modifiedGroup);
		return dto;
	}

}
