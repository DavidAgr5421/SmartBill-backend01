package sena.facturacion;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserRolEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.UserRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.UserRolRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class GeneralApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final UserRolRepository userRolRepository;

	public static void main(String[] args) {
		SpringApplication.run(GeneralApplication.class, args);
	}


	 @Override
	 public void run(String... args) throws Exception {

		 UserRolEntity rolInvitado = new UserRolEntity(null,"INVITADO");
		 UserRolEntity rolAdmin = new UserRolEntity(null,"ADMIN");
		 UserRolEntity rolEmpleado = new UserRolEntity(null,"EMPLEADO");

		userRolRepository.save(rolInvitado);
		userRolRepository.save(rolAdmin);
		userRolRepository.save(rolEmpleado);

		 List<UserEntity> entities = Arrays.asList(
				 new UserEntity(null, "Juan", "juan@gmail.com", "34135",null, rolAdmin),
				 new UserEntity(null, "Carlos", "Rodriguez@gmail.com", "45690",null, rolAdmin),
				 new UserEntity(null, "Julio", "Perez@gmail.com", "34545",null, rolEmpleado),
				 new UserEntity(null, "Roman", "Ramirez@gmail.com", "45456aa",null, rolEmpleado)
		 );
		 userRepository.saveAll(entities);
	 }
 }
