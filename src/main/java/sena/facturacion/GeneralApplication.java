package sena.facturacion;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sena.facturacion.infrastructure.adapters.input.rest.BillDetailRestAdapter;
import sena.facturacion.infrastructure.adapters.input.rest.BillRestAdapter;
import sena.facturacion.infrastructure.adapters.input.rest.UserRolRestAdapter;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.BillDetailCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.UserRolRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.*;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class GeneralApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final UserRolRestAdapter rolRestAdapter;
	private final UserRolRepository userRolRepository;
	private final ClientRepository clientRepository;
	private final ProductRepository productRepository;
	private final BillRestAdapter billRest;
	private final BillDetailRestAdapter billDetailRest;

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

		 List<ClientEntity> clients = Arrays.asList(
				 new ClientEntity(null,"Juan Perez","Calle 99 32-34","+57 311 355 35500", LocalDateTime.now()),
				 new ClientEntity(null,"Cristo Rey","Calle 100 777","+00 777 77 77",LocalDateTime.now()),
				 new ClientEntity(null, "Pablo Pablito", "Carrera 100 56-57","+45 100 3456", LocalDateTime.now())
		 );

		 List<ProductEntity> products = Arrays.asList(
				 new ProductEntity(null, "Martillo", "NO12356", BigInteger.valueOf(2359),null, null, null),
				 new ProductEntity(null, "Tuerca", "NO12356", BigInteger.valueOf(45), null, null,null),
				 new ProductEntity(null, "Tornillo", "NO56789", BigInteger.valueOf(120), null, null,null),
				 new ProductEntity(null, "Taladro", "NO77777", BigInteger.valueOf(5000), null, null,null),
				 new ProductEntity(null, "Llave Inglesa", "NO88888", BigInteger.valueOf(800), null, null,null)
		 );

		 userRepository.saveAll(entities);
		 clientRepository.saveAll(clients);
		 productRepository.saveAll(products);

		 billRest.save(new BillCreateRequest(1L,1L,200L,"CREDIT_CARD"));
		 billRest.save(new BillCreateRequest(2L,1L,500L,"CASH"));
		 billRest.save(new BillCreateRequest(3L,1L,6000L,"CREDIT_CARD"));

		 billDetailRest.save(new BillDetailCreateRequest(
				 1L, 2L, BigInteger.valueOf(3), 300L,
				 "3 items of product 2"
		 ));

		 billDetailRest.save(new BillDetailCreateRequest(
				 2L, 1L, BigInteger.valueOf(2),
				 10L,
				 null
		 ));

		 billDetailRest.save(new BillDetailCreateRequest(
				 3L, 2L, BigInteger.valueOf(1),
				 4L,
				 "single item"
		 ));
	}
 }
