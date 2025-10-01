package pe.com.bancoABC.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@Entity
public class TipoCambioEntity extends PanacheEntity {
    public String dni;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date fecha;
    public String compra;
    public String venta;
    public String sunat;

    public static TipoCambioEntity addResponse(String dni, TipoCambioResponse response) {
        long consultas = TipoCambioEntity.consultaPorDni(dni);
        if (consultas >= 10) {
            throw new IllegalStateException("El DNI " + dni + " ya tiene más de 10 consultas de tipo de cambio.");
        }

        TipoCambioEntity entity = new TipoCambioEntity();
        entity.dni = dni;
        entity.fecha = response.getFecha();
        entity.sunat = String.valueOf(response.getSunat());
        entity.compra = String.valueOf(response.getCompra());
        entity.venta = String.valueOf(response.getVenta());
        entity.persist();
        return entity;
    }

    public static long consultaPorDni(String dni) {
        return TipoCambioEntity.count("dni", dni);
    }

}