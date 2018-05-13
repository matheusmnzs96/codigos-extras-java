/*
 * Programa com metodos matematicos
 * Created by Matheus Menezes
 * July 13, 2017
 * Icomp - UFAM
 * Manaus - AM, Brazil
 **/

import java.util.Scanner;

public class Matematica{

	// metodo que calcula a potencia de a ^ b
	public double potencia(double a, double b){
		
		return Math.pow(a, b);
	}

	// metodo que calcula a raiz quadrada de n
	public double raizQuad(double n){
		
		return Math.pow(n, 1.0/2.0);
	}

	// metodo que calcula a raiz cubica de n
	public double raizCub(double n){
		
		return Math.pow(n, 1.0/3.0);
	}

	// menu principal que executa o programa
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		Matematica mat = new Matematica(); // instanciando um novo objeto da classe Matematica

		System.out.print("Digite dois numeros: ");
		double x = input.nextDouble(), y = input.nextDouble();
		
		System.out.println();
		
		System.out.println("Potencia de "+x+" elevado a "+y+" eh: "+mat.potencia(x, y));
		System.out.println("Potencia de "+y+" elevado a "+x+" eh: "+mat.potencia(y, x));
		System.out.println();
		System.out.println("Raiz quadrada de "+x+" eh: "+mat.raizQuad(x));
		System.out.println("Raiz quadrada de "+y+" eh: "+mat.raizQuad(y));
		System.out.println();
		System.out.println("Raiz cubica de "+x+" eh: "+mat.raizCub(x));
		System.out.println("Raiz cubica de "+y+" eh: "+mat.raizCub(y));

	}
}