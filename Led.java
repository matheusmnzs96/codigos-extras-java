/**
 * Problema dos leds (1168) do site de julgamento online https://www.urionlinejudge.com.br
 * Author: Matheus dos Santos Menezes
 * Instituto de Computação - Universidade Federal do Amazonas
 * August 5, 2017
 * Manaus, AM - Brazil
 */

import java.util.Scanner;

public class Led{
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        
        String numero;
        
        int numero_da_vez, soma, i, cont;
        int[] tabela = new int[10];
        
        tabela[0] = 6;
        tabela[1] = 2;
        tabela[2] = 5;
        tabela[3] = 5;
        tabela[4] = 4;
        tabela[5] = 5;
        tabela[6] = 6;
        tabela[7] = 3;
        tabela[8] = 7;
        tabela[9] = 6;

        int n = input.nextInt(); // casos de teste
        
        for(cont = 0; cont < n; cont++){
            
            numero = input.next();
            soma = 0;
            
            for (i = 0; i < numero.length(); i++) {
                numero_da_vez = Character.getNumericValue(numero.charAt(i));
                soma = soma + tabela[numero_da_vez];
            }
            System.out.println(soma+" leds");
        }
    }
}