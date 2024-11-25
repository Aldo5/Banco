/*
 * Autor: Aldo Guzmán
 * Fecha: 17/11/2024
 * Descripcion: Estructura de nuestra clase cajero.
 * */
package Dominio;

public class Cajero {
	private String numeroCuenta;
	private String nombre;
	private float dinero;
	private int nip;
	
	//Constructor vacio
	public Cajero() {
	}
	
	//Constructor con parametros
	public Cajero(String numeroCuenta, String nombre, float dinero, int nip) {
		this.numeroCuenta = numeroCuenta;
		this.nombre = nombre;
		this.dinero = dinero;
		this.nip = nip;
	}
	
	//Encapsulamiento
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	//Metodo toString
	@Override
	public String toString() {
		return "Datos bancarios \nNumeroCuenta=" + numeroCuenta + "\nNombre=" + nombre + "\nDinero=" + dinero + "\nnip=" + nip
				+ "\n";
	}
	
	
	
	
}
