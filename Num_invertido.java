/**
 * O algoritmo retorna o numero de forma inversa. Ex: 123 --> 321
 * created by Matheus Menezes - Icomp, UFAM
 * june 14, 2017
 * Manaus - AM, Brazil
 */

import java.util.Scanner;

public class Num_invertido{

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		long n = input.nextLong();
		
		while(n > 0){
			System.out.print(n % 10);
			n = n / 10;
		}
		System.out.println();
    }
}