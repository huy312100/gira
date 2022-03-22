package cybersoft.javabackend.gira.role.dto;

import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiraGroupWithRolesDTO {
	private UUID id;
	
	private String code;
	
	private String description;
	
	Set<GiraRoleDTO> roles;
}
