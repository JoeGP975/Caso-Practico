package pe.com.bancoABC.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.Date;


public class TipoCambioResponse {
    private String dni;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha;
    private String sunat;
    private String compra;
    private String venta;


    public TipoCambioResponse(String dni, Date fecha,String sunat, String compra, String venta) {
        this.dni = dni;
        this.fecha = fecha;
        this.sunat = sunat;
        this.compra = compra;
        this.venta = venta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getSunat() {
        return sunat;
    }

    public void setSunat(String sunat) {
        this.sunat = sunat;
    }
}