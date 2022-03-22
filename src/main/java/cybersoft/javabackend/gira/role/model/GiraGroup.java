package cybersoft.javabackend.gira.role.model;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import cybersoft.javabackend.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="gira_group")
public class GiraGroup extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(min = 5,max=5)
	private String code;
	@NotBlank
	private String description;
	

	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(
			name="gira_group_role",
			joinColumns =@JoinColumn(name="group_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
			)
	private Set<GiraRole> roles=new LinkedHashSet<>();
	
	public void addRole(GiraRole role) {
		roles.add(role);
		role.getGroups().add(this);
		
	}
	
	public void removeRole(GiraRole role) {
		roles.remove(role);
		role.getGroups().remove(this);
	}
	
	public void clearRole() {
		this.roles.clear();
	}
	
}
