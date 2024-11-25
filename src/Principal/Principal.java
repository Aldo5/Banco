/*
 * Autor: Aldo Guzmán
 * Fecha: 17/11/2024
 * Descripcion: Clase principal de un cajero automatico.
 * */
package Principal;

import java.time.LocalDate;
import java.util.Scanner;

import Dominio.Cajero;

import LogicalMetodos.Implementacion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lectura = null;

		String numeroCuenta;
		String nombre;
		float dinero = 0.00f, retiroDinero, depositoDinero;
		int nip;

		Cajero cuenta;
		int menu = 0, subMenu;

		Implementacion imp = new Implementacion();
		
			do {
				try {
				System.out.println("**** Cajero ****");
				System.out.println("1. Registrarse");
				System.out.println("2. Ver registros");
				System.out.println("3. Iniciar sesion");
				System.out.println("4. Salir");
				System.out.println("****************");
				System.out.print("Opcion: ");
				lectura = new Scanner(System.in);
				menu = lectura.nextInt();
				System.out.println("****************");
				
				switch (menu) {
				case 1:
					System.out.print("Ingrese un numero de cuenta: ");
					lectura = new Scanner(System.in);
					numeroCuenta = lectura.nextLine();// no use numerico por que puede comensar con ceros.

					// Verificamos que el numero de cuenta sea de 16 digitos y no sean letras
					// Nota: -Preguntar un metodo mas optiono y efiente long vs string.
					/*
					 * en cuestion de memoria long es mas ligero
					 */
					if (numeroCuenta.matches("\\d{16}")) {
						System.out.print("\nIngrese su nombre: ");
						lectura = new Scanner(System.in);
						nombre = lectura.nextLine();

						System.out.print("\nIngrese un nip: ");
						lectura = new Scanner(System.in);
						nip = lectura.nextInt();
						String nipCadena = String.valueOf(nip); // -> convertir de int a cadena

						// Verificar que el nip sea de 4 digitos
						if (nipCadena.length() == 4) { // Cadena de nip para saber la longitud
							// Crear objeto
							cuenta = new Cajero(numeroCuenta, nombre, dinero, nip);
							System.out.println(imp.altaCliente(cuenta));
						} else {
							System.out.println("El NIP debe tener 4 caracteres");
						}
					} else {
						System.out.println("El numero de cuenta debe tener 16 caracteres");
					}
					break;
				case 2:
					// Manejo de la consulta de la lista para mostrar los usuario o mandar mensaje
					if (imp.consultar().size() > 0)
						System.out.println(imp.consultar());
					else
						System.out.println("No hay registros");
					break;
				case 3:
					// Menu secundario una para realizar otras acciones principales (retirar,
					// consultar y depositar)
					try {
						// Login basico de cajero automatico.
						System.out.print("\nIngrese el número de cuenta:");
						lectura = new Scanner(System.in);
						numeroCuenta = lectura.nextLine();

						System.out.print("\nIngrese el NIP:");
						lectura = new Scanner(System.in);
						nip = lectura.nextInt();

						Cajero usuarioEncontrado = imp.buscar(numeroCuenta, nip); // Llamada al método

						// Verificar si el usuario solicitado existe
						if (usuarioEncontrado != null) {
							System.out.println("Usuairo encontrado: " + usuarioEncontrado);

							do {
								// Submenu del login básico
								System.out.println("***** Menú *****");
								System.out.println("1. Retiro");
								System.out.println("2. Deposito");
								System.out.println("3. Consultar saldo");
								System.out.println("4. Salir");
								System.out.println("****************");
								System.out.print("Opción: ");
								lectura = new Scanner(System.in);
								subMenu = lectura.nextInt();
								System.out.println("****************");

								switch (subMenu) {
								case 1:

									// Opcion retiro de dinero
									System.out.print("\nIngrese el monto a retirar: ");
									lectura = new Scanner(System.in);
									retiroDinero = lectura.nextFloat();
									// Verificar que el usuario no retire mas de $10,000.00
									if (retiroDinero <= 10000) {
										dinero -= retiroDinero;
										// Verificar que haya la cantidad disponible para retirar
										if (dinero > 0) {
											usuarioEncontrado.setDinero(dinero);
											imp.retiroDeposito(usuarioEncontrado);
											System.out.println("Disponible: " + dinero);
										} else {
											System.out.println("No cuenta con el dinero suficiente");
											System.out.println("Disponible: " + usuarioEncontrado.getDinero());
										}
									} else {
										System.out
												.println("Favor de retirar un monto igual o menor a $10,000.00 pesos");
										System.out.println("Disponible: " + usuarioEncontrado.getDinero());
									}

									break;
								case 2:
									// Opción deposito de dinero
									System.out.print("\nIngrese el monto a depositar: ");
									lectura = new Scanner(System.in);
									depositoDinero = lectura.nextFloat();
									// Verificar que el usuario deposite alguna cantidad
									if (depositoDinero > 0) {
										// Verificar que el usuario no deposite mas de $10,000.00
										if (depositoDinero < 10000) {
											dinero += depositoDinero;
											usuarioEncontrado.setDinero(dinero);
											imp.retiroDeposito(usuarioEncontrado);
											System.out.println("Disponible: " + dinero);
										} else {
											System.out.println("Debe ingresar un monto menor a $10,000.00 pesos");
										}
									} else {
										System.out.println("Ingrese una cantidad mayor a  $0.00 pesos");
									}
									break;

								case 3:
									// Mostrar saldo disponible
									System.out.println("Disponible: " + usuarioEncontrado.getDinero());
									break;
								case 4:
									break;
								}
							} while (subMenu < 4);
						} else {
							System.out.println("No se encontró el usuario.");
						}
					} catch (Exception e) {
						System.out.println("Favor de ingresar una opción valida");
					}

					break;

				case 4:
					break;
					default:
						System.out.println("Ingresa una opción valida");
				}
				} catch (Exception e) {
					System.out.println("Error: Ingresa un opción valida");
					lectura.nextLine();
				}
			} while (menu != 4);
			
		
	}

}
