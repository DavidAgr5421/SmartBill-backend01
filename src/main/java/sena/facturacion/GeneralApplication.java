package sena.facturacion;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sena.facturacion.infrastructure.adapters.input.rest.UserRolRestAdapter;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.UserRolRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.UserRolEntity;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.UserRepository;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.UserRolRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class GeneralApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final UserRolRestAdapter rolRestAdapter;
	private final UserRolRepository userRolRepository;

	public static void main(String[] args) {
		SpringApplication.run(GeneralApplication.class, args);
	}


	 @Override
	 public void run(String... args) throws Exception {

		 rolRestAdapter.save(new UserRolRequest("ADMIN"));
		 rolRestAdapter.save(new UserRolRequest("EMPLEADO"));

		 Optional<UserRolEntity> rolAdmin = userRolRepository.findByRolName("ADMIN");
		 Optional<UserRolEntity> rolEmpleado = userRolRepository.findByRolName("EMPLEADO");

		 List<UserEntity> entities = Arrays.asList(
				 new UserEntity(null, "Juan", "juan@gmail.com", "34135",null, rolAdmin.get()),
				 new UserEntity(null, "Carlos", "Rodriguez@gmail.com", "45690",null, rolAdmin.get()),
				 new UserEntity(null, "Julio", "Perez@gmail.com", "34545",null, rolEmpleado.get()),
				 new UserEntity(null, "Roman", "Ramirez@gmail.com", "45456aa",null, rolEmpleado.get())
		 );
		 userRepository.saveAll(entities);
	 }
 }
