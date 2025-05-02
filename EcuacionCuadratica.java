/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unl.cc.poo.practica;

/**
 *
 * @author IVETT
 */
public class EcuacionCuadratica {
    //Atributos
    private float variable_A;
    private float variable_B;
    private float variable_C;
    private float resultado;
    private float resultadoRaiz1;
    private float resultadoRaiz2;
    //Inicializar las variables
    public EcuacionCuadratica() {
        this.variable_A = 0;
        this.variable_B = 0;
        this.variable_C = 0;
    }
    //Método para calcular discriminantes con la fórmula b2 - 4ac
    public void calcularDiscriminante() {
        if (variable_A != 0) {
            resultado = ((variable_B * variable_B) - (4 * (variable_A * variable_C)));
        }
    }
    //Método para identificar los tipos de raices
    public void tipoRaices() {
        /**
         * Discriminante > 0 se obtienen 2 soluciones diferente Discriminante =
         * 0 se obtienen 2 resultados iguales Discriminante es < 0 se obtiene 2
         * soluciones complejas
         */
        if (resultado >= 0) {
            float raiz1 = (float) ((-variable_B + Math.sqrt(resultado)) / (2 * variable_A));
            float raiz2 = (float) ((-variable_B - Math.sqrt(resultado)) / (2 * variable_A));
            resultadoRaiz1 = Float.valueOf(raiz1); //casteo
            resultadoRaiz2 = Float.valueOf(raiz2);
        } else if (resultado < 0) {
            float parteReal = (-variable_B / (2 * variable_A));
            float parteImaginaria = (float) (Math.sqrt(-resultado) / (2 * variable_A));
            resultadoRaiz1 = Float.valueOf(parteReal);
            resultadoRaiz2 = Float.valueOf(parteImaginaria);
        }
    }
    //Getters y Setters
    public float getVariable_A() {
        return variable_A;
    }

    public float getResultadoRaiz1() {
        return resultadoRaiz1;
    }

    public void setResultadoRaiz1(Float resultadoRaiz1) {
        this.resultadoRaiz1 = resultadoRaiz1;
    }

    public float getResultadoRaiz2() {
        return resultadoRaiz2;
    }

    public void setResultadoRaiz2(Float resultadoRaiz2) {
        this.resultadoRaiz2 = resultadoRaiz2;
    }

    public void setVariable_A(float variable_A) {
        this.variable_A = variable_A;
    }

    public float getVariable_B() {
        return variable_B;
    }

    public void setVariable_B(float variable_B) {
        this.variable_B = variable_B;
    }

    public float getVariable_C() {
        return variable_C;
    }

    public void setVariable_C(float variable_C) {
        this.variable_C = variable_C;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

}
