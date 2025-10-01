package pe.com.bancoABC.entity;

public class ErrorResponse {
    public String status;
    public String mensaje;
    public int http_code;

    public ErrorResponse(String status, String mensaje, int http_code) {
        this.status = status;
        this.mensaje = mensaje;
        this.http_code = http_code;
    }
}
