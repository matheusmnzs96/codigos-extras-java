/**
 * Programa transforma numero DECIMAL para BINARIO utilizando método recursivo
 * Author: Matheus dos Santos Menezes
 * Instituto de Computação - Universidade Federal do Amazonas
 * August 7, 2017
 * Manaus, AM - Brazil
 */

import java.util.Scanner;

public class DecimalBinario{

    public static void decimalParaBinario(int n){
        if(n > 0){
            decimalParaBinario(n / 2);
            System.out.print(n % 2);
        }
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        decimalParaBinario(n);
        System.out.println();
    }
}