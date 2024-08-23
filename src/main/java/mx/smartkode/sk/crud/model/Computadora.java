package mx.smartkode.sk.crud.model;

public class Computadora {
    private Integer id;
    private String marca;
    private String modelo;
    private Double velocidadProcesador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
 
    public Double getVelocidadProcesador() {
        return velocidadProcesador;
    }

    public void setVelocidadProcesador(Double velocidadProcesador) {
        this.velocidadProcesador = velocidadProcesador;
    }

    @Override
    public String toString() {
        return "Computadora [marca=" + marca + ", modelo=" + modelo + ", velocidadProcesador=" + velocidadProcesador + "]";
    }
}

