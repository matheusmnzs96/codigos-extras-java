import java.util.Scanner;

public class Primo{
	
	public static void main(String[] args){
	
 		Scanner ler = new Scanner(System.in);

 		int n = ler.nextInt();
 		int qtdDivisores = 0; // somará o numero de divisores de n.

 		for(int i = 1; i <= n; i++){
 			if(n % i == 0){
 				qtdDivisores++;
 			}
 		}

 		if(qtdDivisores <= 2){			// caso os divisores sejam apenas o 1 e o próprio n,
 			System.out.println(n+" eh primo");	// n será primo.
 		}else{
 			System.out.println(n+" nao eh primo");
 		}
	}    
}