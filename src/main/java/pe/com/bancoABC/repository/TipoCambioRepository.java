package pe.com.bancoABC.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.com.bancoABC.entity.TipoCambioEntity;

@ApplicationScoped
public class TipoCambioRepository implements PanacheRepository<TipoCambioEntity> {
    public long contarConsultasPorDni(int dni) {
        return count("dni", dni);
    }
}