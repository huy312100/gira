package cybersoft.javabackend.gira.role.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.gira.role.model.GiraRole;

@SpringBootTest
public class GiraRoleRepositoryTest {
	@Autowired
	private GiraRoleRepository repository;
	
	@Test
	public void shouldNotInsertRole() {
		GiraRole role = GiraRole.builder()
						.code("FOUR")
						.description(null)
						.build();
		
		assertThrows(Exception.class, () -> repository.save(role));
	}
}
