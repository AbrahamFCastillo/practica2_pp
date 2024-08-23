package mx.smartkode.sk.crud.model;

public class Alumno {
	
	private String nombre;
	private Float promedio;
	private Integer edad; 
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPromedio() {
		return promedio;
	}
	public void setPromedio(Float promedio) {
		this.promedio = promedio;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", promedio=" + promedio + ", edad=" + edad + "]";
	}
	

	

}
