/**
 * Programa calcula o fatorial de um numero 'n' de modo recursivo
 * Author: Matheus dos Santos Menezes
 * Instituto de Computação - Universidade Federal do Amazonas
 * September 1, 2017
 * Manaus, AM - Brazil
 */

import java.util.Scanner;

public class FatorialRec{

	static long fatorial(long n){

		long fat;

		if(n == 0 || n == 1){
			fat = 1;
		}else{
			fat = n * fatorial(n - 1);
		}

		return fat;
	}

	public static void main(String[] args) {		
		
		Scanner input = new Scanner(System.in);
		
		long n = input.nextLong();

		System.out.println(fatorial(n));
	}    
}