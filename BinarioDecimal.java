/**
 * Programa transforma numero BINARIO para DECIMAL
 * Author: Matheus dos Santos Menezes
 * Instituto de Computação - Universidade Federal do Amazonas
 * August 7, 2017
 * Manaus, AM - Brazil
 */

import java.util.Scanner;

public class BinarioDecimal{

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        String bin = input.next();  // recebe o binario como uma String

        // converte para decimal e imprime:
        
        int num = Integer.parseInt(bin, 2);

        System.out.println(num);
    }
}