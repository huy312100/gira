package cybersoft.javabackend.gira.role.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cybersoft.javabackend.gira.role.model.GiraRole;

public interface GiraRoleRepository extends JpaRepository<GiraRole, UUID> {

}
