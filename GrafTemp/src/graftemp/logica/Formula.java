/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graftemp.logica;

import java.util.ArrayList;

/**
 *
 * @author Anderson
 */
public class Formula {

    //Variaveis da barra
    private double temperatura_u;
    private double comprimento_L;
    private double funcao_Fx;
    private double alfa_a;

    private double conducaoCalor_cn;

    double pi = Math.PI;
    double e = Math.E;

    public Formula(double funcao_Fx, double comprimento_L, double alfa_a) {
        this.funcao_Fx = funcao_Fx;
        this.comprimento_L = comprimento_L;
        this.alfa_a = alfa_a;
    }

//    public double conducaoCalor() {
//        double resutado = 0;
//        resutado = (2 * funcao_Fx) * (1 - (Math.cos(Math.toRadians((n * 180 * eixo_x) / comprimento_L))));
//        conducaoCalor_cn = resutado;
//        return resutado;
//    }

    public double somatorio(double intervalo_n, double t, double x){
        double resultado = 0;
        intervalo_n = intervalo_n*2;
        for (int n = 1; n <= intervalo_n; n++) {
            resultado += equacaoDoSomatorio(n, t, x);
           n++;
        }
        return resultado;
    }

    public double equacaoDoSomatorio(double valor_n, double t, double x){
        double resultado = 0;
        double resultado1 = ((1/valor_n)*(1/Math.pow(Math.E, ((valor_n*valor_n*Math.PI*Math.PI*alfa_a*alfa_a*t)/(comprimento_L*comprimento_L)))));
        double resultado22 = (valor_n*Math.PI*x)/comprimento_L;
        double resultado2 = Math.sin(resultado22);
        resultado = resultado1*resultado2;
        return resultado;
    }

    public ArrayList<Double> temperaturaEmRelacaoX(double intervalo_n, double t, double x){
        ArrayList<Double> resultado = new ArrayList<Double>();

        for (int i = 0; i <= x; i++) {
                    resultado.add((80/pi)*(somatorio(intervalo_n, t, i)));
        }
        return resultado;
    }

       public ArrayList<Double> temperaturaEmRelacaoT(double intervalo_n, double t, double x){
        ArrayList<Double> resultado = new ArrayList<Double>();

        for (int i = 0; i <= t ;i++) {
                    resultado.add((80/pi)*(somatorio(intervalo_n, i, x)));
        }
        return resultado;
    }
}
