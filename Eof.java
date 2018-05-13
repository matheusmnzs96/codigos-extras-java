import java.util.Scanner;

public class Eof{ // leitura de dados ate o fim de arquivo (End Of Line)
	
	public static void main(String[] args){
 
		Scanner ler = new Scanner(System.in);
		
		while(ler.hasNext()){      // enquanto "ler" tiver o próximo pra ler
			int n = ler.nextInt();
		}
			// irá ler até o fim de arquivo que termina com "ctrl + z" (windows) no prompt
	}
}		