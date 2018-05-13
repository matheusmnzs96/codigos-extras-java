/**
 * Programa calcula o total de paginas de um livro
 * Author: Matheus dos Santos Menezes
 * Instituto de Computação - Universidade Federal do Amazonas
 * August 5, 2017
 * Manaus, AM - Brazil
 */

import java.util.Scanner;

public class Paginas{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean exit = true;

        while(exit){
            
            int p = input.nextInt(); // atualmente lendo P paginas por dia

            if(p == 0){
                exit = false;
            }else{
                
                int d = input.nextInt(); // termina D dias antes
                int q = input.nextInt(); // do que se estivesse lendo Q paginas por dia
                
                System.out.println(d*(p*q)/(p-q)); // total de paginas do LIVRO
            }
        }
    }
}
