/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unl.cc.poo.practica;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author IVETT
 */
public class Main {

    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria();
        EcuacionCuadratica ecuacion = new EcuacionCuadratica();
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); //Para problemas del . 
        int opcion;
        //Menú principal
        do {
            System.out.println(" ");
            System.out.println("*** EJERCICIOS PRÁCTICA ***");
            System.out.println(" ");
            System.out.println("1. Ejercicio 1: Cuenta Bancaria");
            System.out.println("2. Ejercicio 2: Ecuación Cuadrática");
            System.out.println("3. Salir");
            System.out.println(" ");
            while (true) {
                try {
                    System.out.print("Elija la opción que desee: ");
                    opcion = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un número válido.");
                    sc.nextLine();
                }
            } //Try-catch para identificar errores 

            switch (opcion) {
                case 1:
                    int opcionBanco;
                    do { //Menú del Banco
                        System.out.println(" ");
                        System.out.println("*** CUENTA BANCARIA ***");
                        System.out.println(" ");
                        System.out.println("1. Crear cuenta");
                        System.out.println("2. Depositar");
                        System.out.println("3. Retirar");
                        System.out.println("4. Consultar saldo");
                        System.out.println("5. Consultar historial");
                        System.out.println("6. Volver al menú principal");
                        System.out.println(" ");
                        while (true) {
                            try {
                                System.out.print("Ingrese la opción que desee: ");
                                opcionBanco = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Ingrese un número válido.");
                                sc.nextLine();
                            }
                        }

                        switch (opcionBanco) {
                            case 1: //Para crear una cuenta
                                System.out.print("Ingrese su nombre completo: ");
                                String nombre = sc.nextLine();
                                System.out.print("Ingrese su número de cédula: ");
                                String cedula = sc.nextLine();
                                cuenta.setNombreTitular(nombre);
                                cuenta.generarNuevaCuenta(nombre);
                                System.out.println(" ");
                                System.out.println("¡CUENTA CREADA CON ÉXITO!");
                                System.out.println("--> Titular: " + cuenta.getNombreTitular());
                                System.out.println("--> Número de Cuenta: " + cuenta.getNumeroCuenta());
                                System.out.println("--> Saldo: $" + cuenta.getSaldo());
                                break;
                            case 2: //Para depositar
                                if (cuenta.verificarCuentaActiva()) {
                                    System.out.println(" ");
                                    try {
                                        System.out.print("Monto a depositar: ");
                                        float deposito = sc.nextFloat();
                                        sc.nextLine();
                                        cuenta.depositar(deposito);
                                        if (deposito > 0) {
                                            System.out.println("--> Depósito exitoso: $" + deposito);
                                            System.out.println(" ");
                                        } else {
                                            System.out.println("Ingrese un número mayor a 0");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: Debe ingresar un número válido.");
                                        sc.nextLine();
                                    }
                                } else {
                                    System.out.println("Primero crea una cuenta!!!");
                                }
                                break;
                            case 3: //Para retirar
                                if (cuenta.verificarCuentaActiva()) {
                                    System.out.println(" ");
                                    try {
                                        System.out.print("Monto a retirar: ");
                                        float retiro = sc.nextFloat();
                                        sc.nextLine();
                                        if (retiro > 0 && retiro <= cuenta.getSaldo()) {
                                            cuenta.retirar(retiro);
                                            System.out.println("--> Retiro exitoso: -$" + retiro);
                                            System.out.println(" ");
                                        } else {
                                            System.out.println("Error: Monto inválido o saldo insuficente: $" + cuenta.getSaldo());
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: Debe ingresar un número válido.");
                                        sc.nextLine();
                                    }
                                } else {
                                    System.out.println("Primero crea una cuenta!!!");
                                }
                                break;
                            case 4: //Consultar saldo actual
                                if (cuenta.verificarCuentaActiva()) {
                                    System.out.println(" ");
                                    System.out.println("--> Saldo actual: $" + cuenta.getSaldo());
                                    System.out.println(" ");
                                } else {
                                    System.out.println("Primero crea una cuenta!!!");
                                }

                                break;
                            case 5: //Mostrar el historial de retiros y depositos
                                if (cuenta.verificarCuentaActiva()) {
                                    System.out.println(cuenta.consultarHistorial());
                                } else {
                                    System.out.println("Primero crea una cuenta!!!");
                                }
                                break;
                            case 6: //Para volver al menú principal
                                System.out.println(" ");
                                System.out.println("Saliendo de Ejercicio 1...");
                                break;
                            default:
                                System.out.println("OPCION INVALIDA");
                        }
                    } while (opcionBanco != 6);
                    break;

                case 2: //Menu para la ecuación cuadrática
                    int opcionEcuacion;
                    do {
                        System.out.println(" ");
                        System.out.println("*** ECUACIÓN CUADRÁTICA ***");
                        System.out.println(" ");
                        System.out.println("1. Ingresar coeficientes");
                        System.out.println("2. Calcular discriminante");
                        System.out.println("3. Tipo de raíz");
                        System.out.println("4. Volver al menú principal");
                        System.out.println(" ");
                        while (true) {
                            try {
                                System.out.print("Ingrese la opción que desee: ");
                                opcionEcuacion = sc.nextInt();
                                sc.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Ingrese un número válido.");
                                sc.nextLine();
                            }
                        }
                        switch (opcionEcuacion) {

                            case 1: //Para ingresar los coeficientes
                            try {
                                System.out.print("Coeficiente a: ");
                                float a = sc.nextFloat();
                                sc.nextLine();
                                ecuacion.setVariable_A(a);
                                if (a != 0) {
                                    System.out.print("Coeficiente b: ");
                                    float b = sc.nextFloat();
                                    sc.nextLine();
                                    ecuacion.setVariable_B(b);
                                    System.out.print("Coeficiente c: ");
                                    float c = sc.nextFloat();
                                    sc.nextLine();
                                    ecuacion.setVariable_C(c);
                                    System.out.println(" ");
                                    System.out.println("--> Ecuación: " + a + "x^2 "
                                            + (b >= 0 ? "+ " + b : "- " + Math.abs(b)) + "x "
                                            + (c >= 0 ? "+ " + c : "- " + Math.abs(c))
                                            + " = 0"); //Se usa como valor absoluto para que no afecten los signos predefinidos del modelo de la ecuacion 
                                    System.out.println(" ");
                                } else {
                                    System.out.println("La variable 'a' no puede ser cero.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Ingrese coeficientes válidos (números).");
                                sc.nextLine();
                            }
                            break;
                            case 2: //Para mostrar la discriminate
                                ecuacion.calcularDiscriminante();
                                float discriminante = ecuacion.getResultado();
                                System.out.println("--> Discriminante: " + discriminante);
                                System.out.println(" ");
                                break;

                            case 3: //Identificar el tipo de raíz
                                ecuacion.calcularDiscriminante();
                                float discriminanteTipoRaiz = ecuacion.getResultado();
                                ecuacion.tipoRaices();
                                if (discriminanteTipoRaiz > 0) {
                                    System.out.println("--> Tipo: Raíces reales y distintas");
                                    System.out.println(" ");
                                    System.out.println("Raíz 1: " + ecuacion.getResultadoRaiz1());
                                    System.out.println("Raíz 2: " + ecuacion.getResultadoRaiz2());
                                } else if (discriminanteTipoRaiz == 0) {
                                    System.out.println("--> Tipo: Raíces reales e iguales");
                                    System.out.println(" ");
                                    System.out.println("Raíz doble: " + ecuacion.getResultadoRaiz1());
                                } else if (discriminanteTipoRaiz < 0) {
                                    System.out.println(" ");
                                    System.out.println("--> Tipo: Raíces complejas (no reales)");
                                } else {
                                    System.out.println("La variable A no debe de ser 0 ");
                                }
                                break;

                            case 4: //Volver al menu principal
                                System.out.println(" ");
                                System.out.println("Saliendo de Ejercicio 2...");
                                break;
                            default:
                                System.out.println("Ingrese una opción válida");
                        }

                    } while (opcionEcuacion != 4);

                    break;

                case 3: //Se acaba el programa, se cierra
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opción inválida, intenta nuevamente.");
            }

        } while (opcion != 3);

        sc.close();

    }
}
