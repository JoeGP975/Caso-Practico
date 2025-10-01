package pe.com.bancoABC.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.com.bancoABC.entity.TipoCambioEntity;
import pe.com.bancoABC.entity.TipoCambioResponse;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.listAll;

@ApplicationScoped
public class TipoCambioRepository implements PanacheRepository<TipoCambioEntity> {
    public List<TipoCambioEntity> findByDni(int dni) {
        return find("dni", dni).list();
    }
}