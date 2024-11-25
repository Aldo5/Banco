/*
 * Autor: Aldo Guzmán
 * Fecha: 17/11/2024
 * Descripcion: Implementacion de nuestro metodos para mejor uso de la clase principal.
 * */
package LogicalMetodos;

import java.util.ArrayList;
import java.util.List;

import Dominio.Cajero;

import Interface.MetodosCajero;

public class Implementacion implements MetodosCajero {
	
	private List <Cajero> dataBase = new ArrayList<Cajero>();

	@Override
	public String altaCliente(Cajero cajero) {
		// TODO Auto-generated method stub
		for (Cajero c : dataBase) {
	        if (c.getNumeroCuenta() == cajero.getNumeroCuenta()) {
	            return "Cuenta existente.";
	        }
	        
	    }
		
	    dataBase.add(cajero);
	    return "\n¡CLIENTE GUARDADO EXITOSAMENTE.!";
	}

	@Override
	public List<Cajero> consultar() {
		// TODO Auto-generated method stub
		return dataBase;
	}

	@Override
	public Cajero buscar(String numeroCuenta, int nip) {
		// TODO Auto-generated method stub
		for (Cajero c : dataBase) {
	        if (c.getNumeroCuenta().equalsIgnoreCase(numeroCuenta) && c.getNip() == nip) { 
	        	if (c.getNumeroCuenta().equalsIgnoreCase(numeroCuenta)) {
	            return c; // Retorna el producto si se encuentra
	        }
	        }
	    }
	return null;
	}


	@Override
	public void retiroDeposito(Cajero cajero) {
		for (int i = 0 ; i < dataBase.size(); i++) {
			if(dataBase.get(i).getNumeroCuenta().equals(cajero.getNumeroCuenta())) {
				dataBase.set(i, cajero);
				System.out.println("Transacción exitosa");
				break;
			}
		}
	
		// TODO Auto-generated method stub

	}


}
