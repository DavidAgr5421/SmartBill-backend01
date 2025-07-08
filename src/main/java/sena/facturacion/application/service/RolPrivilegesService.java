package sena.facturacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sena.facturacion.application.ports.input.RolPrivilegesServicePort;
import sena.facturacion.application.ports.output.RolPrivilegesPersistencePort;
import sena.facturacion.domain.exception.RolPrivilegesNotFound;
import sena.facturacion.domain.model.RolPrivileges;

@Service
@RequiredArgsConstructor
public class RolPrivilegesService implements RolPrivilegesServicePort {

    private final RolPrivilegesPersistencePort persistencePort;

    @Override
    public RolPrivileges findById(Long id) {
        return persistencePort.findById(id).orElseThrow(RolPrivilegesNotFound::new);
    }

    @Override
    public RolPrivileges save(RolPrivileges rolPrivileges) {
        return persistencePort.save(rolPrivileges);
    }

    @Override
    public RolPrivileges update(Long id, RolPrivileges rolPrivileges) {
        return persistencePort.findById(id).map(privileges -> {
                privileges.setRol(rolPrivileges.getRol());
                privileges.setRolId(rolPrivileges.getRolId());
                privileges.setCreateBill(rolPrivileges.getCreateBill());
                privileges.setDeleteBill(rolPrivileges.getDeleteBill());
                privileges.setViewHistory(rolPrivileges.getViewHistory());
                privileges.setPrintBill(rolPrivileges.getPrintBill());
                privileges.setCreateProduct(rolPrivileges.getCreateProduct());
                privileges.setDeleteProduct(rolPrivileges.getDeleteProduct());
                privileges.setCreateUser(rolPrivileges.getCreateUser());
                privileges.setDeleteUser(rolPrivileges.getDeleteUser());
                privileges.setGenerateReports(rolPrivileges.getGenerateReports());
                privileges.setEditConfig(rolPrivileges.getEditConfig());
                privileges.setViewConfig(rolPrivileges.getViewConfig());
                privileges.setCreateRol(rolPrivileges.getCreateRol());
                privileges.setDeleteRol(rolPrivileges.getDeleteRol());
            return persistencePort.save(privileges);
        }).orElseThrow(RolPrivilegesNotFound::new);
    }

    @Override
    public void delete(Long id) {
        persistencePort.delete(id);
    }
}
