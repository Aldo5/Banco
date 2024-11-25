/*
 * Autor: Aldo Guzmán
 * Fecha: 17/11/2024
 * Descripcion: Metodos para nuestro cajero
 * */
package Interface;

import java.util.List;

import Dominio.Cajero;

public interface MetodosCajero {

	public String altaCliente(Cajero cajero);
	public List <Cajero> consultar();
	public Cajero buscar(String numeroCuenta, int nip);
	public void retiroDeposito(Cajero cajero);
	
}
