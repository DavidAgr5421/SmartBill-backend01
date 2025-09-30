package sena.facturacion;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sena.facturacion.application.service.UserRolService;
import sena.facturacion.application.service.UserService;
import sena.facturacion.domain.model.User;
import sena.facturacion.infrastructure.adapters.input.rest.BillDetailRestAdapter;
import sena.facturacion.infrastructure.adapters.input.rest.BillRestAdapter;
import sena.facturacion.infrastructure.adapters.input.rest.UserRolRestAdapter;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.Bill.BillDetailCreateRequest;
import sena.facturacion.infrastructure.adapters.input.rest.model.request.User.UserRolRequest;
import sena.facturacion.infrastructure.adapters.output.persistence.entity.*;
import sena.facturacion.infrastructure.adapters.output.persistence.repository.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class GeneralApplication implements CommandLineRunner {

	private final UserService userService;
	private final UserRolRestAdapter rolRestAdapter;
	private final UserRolService userRolService;
	private final ClientRepository clientRepository;
	private final ProductRepository productRepository;
	private final BillRestAdapter billRest;
	private final BillDetailRestAdapter billDetailRest;

	public static void main(String[] args) {
		SpringApplication.run(GeneralApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		// ============================================
		// ROLES
		// ============================================
		System.out.println("🔐 Creando roles...");
		rolRestAdapter.save(new UserRolRequest("ADMIN"));
		rolRestAdapter.save(new UserRolRequest("EMPLEADO"));
		rolRestAdapter.save(new UserRolRequest("VENDEDOR"));
		rolRestAdapter.save(new UserRolRequest("GERENTE"));
		rolRestAdapter.save(new UserRolRequest("CONTADOR"));

		// ============================================
		// USUARIOS - Guardar primero y obtener IDs
		// ============================================
		System.out.println("👤 Creando usuarios...");
		User user1 = userService.save(new User(null, "Admin Principal", "admin@gmail.com", "5421", null, userRolService.findByRolId(1L), true));
		User user2 = userService.save(new User(null, "Julio Gómez", "gamin@gmail.com", "344345", null, userRolService.findByRolId(2L), true));
		User user3 = userService.save(new User(null, "Román Castro", "papito@gmail.com", "45456aa", null, userRolService.findByRolId(3L), true));
		User user4 = userService.save(new User(null, "Andrea Seller", "andrea.seller@company.com", "pass123", null, userRolService.findByRolId(3L), true));
		User user5 = userService.save(new User(null, "Miguel Manager", "miguel.manager@company.com", "manager456", null, userRolService.findByRolId(4L), true));
		User user6 = userService.save(new User(null, "Clara Contador", "clara.contador@company.com", "count789", null, userRolService.findByRolId(5L), true));
		User user7 = userService.save(new User(null, "Roberto Vendedor", "roberto.v@company.com", "vende321", null, userRolService.findByRolId(3L), true));
		User user8 = userService.save(new User(null, "Lucia Admin", "lucia.admin@company.com", "admin999", null, userRolService.findByRolId(1L), true));

		// Obtener IDs de usuarios para usar en facturas
		Long adminId = user1.getId();
		Long empleadoId = user2.getId();
		Long vendedorId = user3.getId();

		// ============================================
		// CLIENTES
		// ============================================
		System.out.println("👥 Creando clientes...");
		List<ClientEntity> clients = Arrays.asList(
				new ClientEntity(null, "Juan Pérez", "juan@gmail.com", "Calle 99 32-34", "+57 311 355 35500", LocalDateTime.now(), true),
				new ClientEntity(null, "Cristo Rey", "cristo@rey.com", "Calle 100 777", "+00 777 77 77", LocalDateTime.now(), true),
				new ClientEntity(null, "Pablo Pablito", "bot.ia@gmail.com", "Carrera 100 56-57", "+45 100 3456", LocalDateTime.now(), true),
				new ClientEntity(null, "María González", "maria.gonzalez@email.com", "Avenida 68 45-23", "+57 312 456 7890", LocalDateTime.now(), true),
				new ClientEntity(null, "Carlos Rodríguez", "carlos.r@company.com", "Calle 72 12-89", "+57 315 789 4561", LocalDateTime.now(), true),
				new ClientEntity(null, "Ana López", "ana.lopez@hotmail.com", "Carrera 15 34-56", "+57 320 123 4567", LocalDateTime.now(), true),
				new ClientEntity(null, "Pedro Sánchez", "pedro.sanchez@outlook.com", "Diagonal 80 23-45", "+57 301 987 6543", LocalDateTime.now(), true),
				new ClientEntity(null, "Laura Martínez", "laura.m@gmail.com", "Transversal 45 67-89", "+57 318 456 1234", LocalDateTime.now(), true),
				new ClientEntity(null, "Diego Torres", "diego.torres@email.com", "Calle 85 90-12", "+57 319 753 8642", LocalDateTime.now(), true),
				new ClientEntity(null, "Sofia Ramírez", "sofia.ramirez@company.com", "Avenida 30 56-78", "+57 314 852 9630", LocalDateTime.now(), true),
				new ClientEntity(null, "Empresas XYZ S.A.S", "contacto@empresasxyz.com", "Calle 100 14-35", "+57 601 234 5678", LocalDateTime.now(), true),
				new ClientEntity(null, "Distribuidora Central", "ventas@distribuidoracentral.com", "Carrera 50 78-90", "+57 604 567 8901", LocalDateTime.now(), true),
				new ClientEntity(null, "Comercial Norte", "info@comercialnorte.co", "Avenida 15 23-45", "+57 605 890 1234", LocalDateTime.now(), true),
				new ClientEntity(null, "Tech Solutions", "contact@techsolutions.com", "Calle 26 45-67", "+57 601 345 6789", LocalDateTime.now(), true),
				new ClientEntity(null, "Inversiones Sur", "admin@inversionessur.com", "Diagonal 70 89-01", "+57 602 678 9012", LocalDateTime.now(), true)
		);
		clientRepository.saveAll(clients);

		// ============================================
		// PRODUCTOS
		// ============================================
		System.out.println("📦 Creando productos...");
		List<ProductEntity> products = Arrays.asList(
				// Herramientas manuales
				new ProductEntity(null, "Martillo", "HER-001", BigInteger.valueOf(2359), null, null, null, true),
				new ProductEntity(null, "Tuerca 1/2", "TUE-002", BigInteger.valueOf(45), null, null, null, true),
				new ProductEntity(null, "Tornillo 3/8", "TOR-003", BigInteger.valueOf(120), null, null, null, true),
				new ProductEntity(null, "Taladro Eléctrico", "HER-004", BigInteger.valueOf(5000), null, null, null, true),
				new ProductEntity(null, "Llave Inglesa 12\"", "HER-005", BigInteger.valueOf(800), null, null, null, true),
				new ProductEntity(null, "Destornillador Plano", "HER-006", BigInteger.valueOf(350), null, null, null, true),
				new ProductEntity(null, "Destornillador Estrella", "HER-007", BigInteger.valueOf(380), null, null, null, true),
				new ProductEntity(null, "Alicate Universal", "HER-008", BigInteger.valueOf(1200), null, null, null, true),
				new ProductEntity(null, "Sierra Manual", "HER-009", BigInteger.valueOf(2800), null, null, null, true),
				new ProductEntity(null, "Nivel de Burbuja", "HER-010", BigInteger.valueOf(1500), null, null, null, true),

				// Materiales de construcción
				new ProductEntity(null, "Cemento Gris 50kg", "MAT-011", BigInteger.valueOf(18500), null, null, null, true),
				new ProductEntity(null, "Arena Lavada m³", "MAT-012", BigInteger.valueOf(45000), null, null, null, true),
				new ProductEntity(null, "Ladrillo Común", "MAT-013", BigInteger.valueOf(850), null, null, null, true),
				new ProductEntity(null, "Varilla 3/8 6m", "MAT-014", BigInteger.valueOf(12000), null, null, null, true),
				new ProductEntity(null, "Cable Eléctrico 12AWG", "ELE-015", BigInteger.valueOf(2500), null, null, null, true),

				// Pinturas
				new ProductEntity(null, "Pintura Blanca Galón", "PIN-016", BigInteger.valueOf(35000), null, null, null, true),
				new ProductEntity(null, "Pintura Azul Galón", "PIN-017", BigInteger.valueOf(38000), null, null, null, true),
				new ProductEntity(null, "Pintura Roja Galón", "PIN-018", BigInteger.valueOf(38000), null, null, null, true),
				new ProductEntity(null, "Brocha 3 pulgadas", "PIN-019", BigInteger.valueOf(4500), null, null, null, true),
				new ProductEntity(null, "Rodillo con Mango", "PIN-020", BigInteger.valueOf(8900), null, null, null, true),

				// Plomería
				new ProductEntity(null, "Tubería PVC 1/2\" 6m", "PLO-021", BigInteger.valueOf(15000), null, null, null, true),
				new ProductEntity(null, "Codo PVC 1/2\"", "PLO-022", BigInteger.valueOf(850), null, null, null, true),
				new ProductEntity(null, "Llave de Paso 1/2\"", "PLO-023", BigInteger.valueOf(12500), null, null, null, true),
				new ProductEntity(null, "Sifón Lavamanos", "PLO-024", BigInteger.valueOf(8900), null, null, null, true),
				new ProductEntity(null, "Teflón Rollo", "PLO-025", BigInteger.valueOf(3500), null, null, null, true),

				// Eléctricos
				new ProductEntity(null, "Interruptor Simple", "ELE-026", BigInteger.valueOf(4500), null, null, null, true),
				new ProductEntity(null, "Toma Corriente Doble", "ELE-027", BigInteger.valueOf(6800), null, null, null, true),
				new ProductEntity(null, "Bombillo LED 9W", "ELE-028", BigInteger.valueOf(12000), null, null, null, true),
				new ProductEntity(null, "Cinta Aislante", "ELE-029", BigInteger.valueOf(2800), null, null, null, true),
				new ProductEntity(null, "Breaker 20A", "ELE-030", BigInteger.valueOf(18500), null, null, null, true),

				// Herramientas eléctricas
				new ProductEntity(null, "Pulidora Angular 4.5\"", "POW-031", BigInteger.valueOf(125000), null, null, null, true),
				new ProductEntity(null, "Taladro Percutor", "POW-032", BigInteger.valueOf(180000), null, null, null, true),
				new ProductEntity(null, "Sierra Circular 7.25\"", "POW-033", BigInteger.valueOf(225000), null, null, null, true),
				new ProductEntity(null, "Lijadora Orbital", "POW-034", BigInteger.valueOf(95000), null, null, null, true),
				new ProductEntity(null, "Compresor 2.5HP", "POW-035", BigInteger.valueOf(450000), null, null, null, true),

				// Seguridad
				new ProductEntity(null, "Casco de Seguridad", "SEG-036", BigInteger.valueOf(18500), null, null, null, true),
				new ProductEntity(null, "Guantes Carnaza", "SEG-037", BigInteger.valueOf(12000), null, null, null, true),
				new ProductEntity(null, "Gafas Protección", "SEG-038", BigInteger.valueOf(8500), null, null, null, true),
				new ProductEntity(null, "Tapones Auditivos", "SEG-039", BigInteger.valueOf(3500), null, null, null, true),
				new ProductEntity(null, "Chaleco Reflectivo", "SEG-040", BigInteger.valueOf(15000), null, null, null, true)
		);
		productRepository.saveAll(products);

		// ============================================
		// FACTURAS Y DETALLES - Usando IDs reales
		// ============================================
		System.out.println("🧾 Creando facturas y detalles...");

		// Factura 1 - Cliente 1, Usuario Admin
		billRest.save(new BillCreateRequest(1L, adminId, 200L, "CREDIT_CARD"));
		billDetailRest.save(new BillDetailCreateRequest(1L, 1L, BigInteger.valueOf(2), 2359L, 4718L, "2 Martillos"));
		billDetailRest.save(new BillDetailCreateRequest(1L, 6L, BigInteger.valueOf(3), 350L, 1050L, "3 Destornilladores"));

		// Factura 2 - Cliente 2, Usuario Empleado
		billRest.save(new BillCreateRequest(2L, empleadoId, 500L, "CASH"));
		billDetailRest.save(new BillDetailCreateRequest(2L, 2L, BigInteger.valueOf(10), 45L, 450L, "10 Tuercas"));
		billDetailRest.save(new BillDetailCreateRequest(2L, 3L, BigInteger.valueOf(5), 120L, 600L, "5 Tornillos"));

		// Factura 3 - Cliente 3, Usuario Vendedor
		billRest.save(new BillCreateRequest(3L, vendedorId, 6000L, "CREDIT_CARD"));
		billDetailRest.save(new BillDetailCreateRequest(3L, 4L, BigInteger.valueOf(1), 5000L, 5000L, "Taladro Eléctrico"));
		billDetailRest.save(new BillDetailCreateRequest(3L, 8L, BigInteger.valueOf(1), 1200L, 1200L, "Alicate Universal"));

		// Factura 4 - Cliente 4, Usuario Admin
		billRest.save(new BillCreateRequest(4L, adminId, 1500L, "CASH"));
		billDetailRest.save(new BillDetailCreateRequest(4L, 16L, BigInteger.valueOf(2), 35000L, 70000L, "2 Galones Pintura Blanca"));
		billDetailRest.save(new BillDetailCreateRequest(4L, 19L, BigInteger.valueOf(3), 4500L, 13500L, "3 Brochas"));

		// Factura 5 - Cliente 5, Usuario Empleado
		billRest.save(new BillCreateRequest(5L, empleadoId, 2500L, "TRANSFER"));
		billDetailRest.save(new BillDetailCreateRequest(5L, 11L, BigInteger.valueOf(5), 18500L, 92500L, "5 Bultos Cemento"));
		billDetailRest.save(new BillDetailCreateRequest(5L, 13L, BigInteger.valueOf(100), 850L, 85000L, "100 Ladrillos"));

		// Factura 6 - Cliente 6, Usuario Vendedor
		billRest.save(new BillCreateRequest(6L, vendedorId, 800L, "CREDIT_CARD"));
		billDetailRest.save(new BillDetailCreateRequest(6L, 21L, BigInteger.valueOf(3), 15000L, 45000L, "3 Tuberías PVC"));
		billDetailRest.save(new BillDetailCreateRequest(6L, 22L, BigInteger.valueOf(10), 850L, 8500L, "10 Codos PVC"));

		// Factura 7 - Cliente 7, Usuario Admin
		billRest.save(new BillCreateRequest(7L, adminId, 3000L, "CASH"));
		billDetailRest.save(new BillDetailCreateRequest(7L, 28L, BigInteger.valueOf(10), 12000L, 120000L, "10 Bombillos LED"));
		billDetailRest.save(new BillDetailCreateRequest(7L, 26L, BigInteger.valueOf(15), 4500L, 67500L, "15 Interruptores"));

		// Factura 8 - Cliente 8, Usuario Empleado
		billRest.save(new BillCreateRequest(8L, empleadoId, 4500L, "CREDIT_CARD"));
		billDetailRest.save(new BillDetailCreateRequest(8L, 31L, BigInteger.valueOf(1), 125000L, 125000L, "Pulidora Angular"));
		billDetailRest.save(new BillDetailCreateRequest(8L, 36L, BigInteger.valueOf(2), 18500L, 37000L, "2 Cascos Seguridad"));

		// Factura 9 - Cliente 9, Usuario Vendedor
		billRest.save(new BillCreateRequest(2L, vendedorId, 1200L, "TRANSFER"));
		billDetailRest.save(new BillDetailCreateRequest(2L, 37L, BigInteger.valueOf(5), 12000L, 60000L, "5 Pares Guantes"));
		billDetailRest.save(new BillDetailCreateRequest(2L, 38L, BigInteger.valueOf(10), 8500L, 85000L, "10 Gafas Protección"));

		// Factura 10 - Cliente 10, Usuario Admin
		billRest.save(new BillCreateRequest(6L, adminId, 5000L, "CASH"));
		billDetailRest.save(new BillDetailCreateRequest(6L, 33L, BigInteger.valueOf(1), 225000L, 225000L, "Sierra Circular"));
		billDetailRest.save(new BillDetailCreateRequest(6L, 34L, BigInteger.valueOf(1), 95000L, 95000L, "Lijadora Orbital"));

		// Factura 11 - Cliente 11 (Empresa), Usuario Empleado
		billRest.save(new BillCreateRequest(1L, empleadoId, 10000L, "TRANSFER"));
		billDetailRest.save(new BillDetailCreateRequest(1L, 35L, BigInteger.valueOf(1), 450000L, 450000L, "Compresor Industrial"));
		billDetailRest.save(new BillDetailCreateRequest(1L, 32L, BigInteger.valueOf(2), 180000L, 360000L, "2 Taladros Percutor"));
		billDetailRest.save(new BillDetailCreateRequest(1L, 30L, BigInteger.valueOf(5), 18500L, 92500L, "5 Breakers"));

		// Factura 12 - Cliente 12, Usuario Vendedor
		billRest.save(new BillCreateRequest(2L, vendedorId, 7500L, "CREDIT_CARD"));
		billDetailRest.save(new BillDetailCreateRequest(2L, 11L, BigInteger.valueOf(20), 18500L, 370000L, "20 Bultos Cemento"));
		billDetailRest.save(new BillDetailCreateRequest(2L, 14L, BigInteger.valueOf(10), 12000L, 120000L, "10 Varillas"));

		// Factura 13 - Cliente 13, Usuario Admin
		billRest.save(new BillCreateRequest(3L, adminId, 3500L, "CASH"));
		billDetailRest.save(new BillDetailCreateRequest(3L, 16L, BigInteger.valueOf(5), 35000L, 175000L, "5 Galones Pintura"));
		billDetailRest.save(new BillDetailCreateRequest(3L, 17L, BigInteger.valueOf(3), 38000L, 114000L, "3 Galones Azul"));
		billDetailRest.save(new BillDetailCreateRequest(3L, 20L, BigInteger.valueOf(5), 8900L, 44500L, "5 Rodillos"));

		// Factura 14 - Cliente 14, Usuario Empleado
		billRest.save(new BillCreateRequest(1L, empleadoId, 2000L, "TRANSFER"));
		billDetailRest.save(new BillDetailCreateRequest(1L, 15L, BigInteger.valueOf(50), 2500L, 125000L, "50m Cable Eléctrico"));
		billDetailRest.save(new BillDetailCreateRequest(1L, 29L, BigInteger.valueOf(20), 2800L, 56000L, "20 Cintas Aislantes"));

		// Factura 15 - Cliente 15, Usuario Vendedor
		billRest.save(new BillCreateRequest(8L, vendedorId, 8000L, "CREDIT_CARD"));
		billDetailRest.save(new BillDetailCreateRequest(8L, 40L, BigInteger.valueOf(20), 15000L, 300000L, "20 Chalecos Reflectivos"));
		billDetailRest.save(new BillDetailCreateRequest(8L, 39L, BigInteger.valueOf(50), 3500L, 175000L, "50 Tapones Auditivos"));
		billDetailRest.save(new BillDetailCreateRequest(8L, 36L, BigInteger.valueOf(10), 18500L, 185000L, "10 Cascos"));

		System.out.println("✅ Datos de prueba cargados exitosamente!");
		System.out.println("📊 Resumen:");
		System.out.println("   - Roles: 5");
		System.out.println("   - Clientes: 15");
		System.out.println("   - Productos: 40");
		System.out.println("   - Usuarios: 8");
		System.out.println("   - Facturas: 15");
		System.out.println("   - Detalles de factura: ~45");
		System.out.println("");
		System.out.println("👤 Usuarios creados con IDs:");
		System.out.println("   - Admin: ID " + adminId);
		System.out.println("   - Empleado: ID " + empleadoId);
		System.out.println("   - Vendedor: ID " + vendedorId);
	}
}