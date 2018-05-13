/**
 * Programa ler um vetor de N elementos inteiros e calcula de forma RECURSIVA o SOMATÓRIO dos elementos desse vetor.
 * Author: Matheus dos Santos Menezes
 * Instituto de Computação - Universidade Federal do Amazonas
 * August 21, 2017
 * Manaus, AM - Brazil
 */

import java.util.Scanner;

public class SomaRecursiva{    
    
	static int soma(int n, int vetor[]){
	        
	    int s = 0;
	        
	    if (n == 0){
	        return s;
	    }else{
	        s = soma(n-1, vetor) + vetor[n];
	        return s;
	    }  
	}
  
	public static void main(String[] args) {

    	Scanner input = new Scanner(System.in);

	    int n = input.nextInt();      // numero de elementos do vetor.
	    int vet[] = new int[n+1];		// vetor.

	    vet[0] = n;

	    // armazenando os elementos no vetor
	    for(int i = 1; i < vet.length; i++){
	    	vet[i] = input.nextInt();
	    }

	    int s = soma(n, vet); // chamando o metodo recursivo

	    // exibindo a soma dos elementos
	    System.out.println(s);
  	}
}