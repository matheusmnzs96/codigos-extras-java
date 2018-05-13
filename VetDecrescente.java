/**
 * O algoritmo ordena o vetor em ordem DECRESCENTE
 * created by Matheus Menezes - Icomp, UFAM
 * june 21, 2017
 * Manaus - AM, Brazil
 */

public class VetDecrescente{

	public static void main(String[] args){

		int[] vet = {2,3,5,1,4};
		int aux = 0;

		for (int i=0; i < vet.length-1; i++){
        	if(vet[i] < vet[i+1]){
	        	aux = vet[i+1];
	            vet[i+1] = vet[i];
	            vet[i] = aux;
	            i = -1;
	        }
        }

        // imprimindo o vetor
		for (int i=0; i < vet.length; i++){
        	System.out.print(vet[i]+" ");
        }
  		
  		System.out.println();
    }
}