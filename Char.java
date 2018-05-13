public class Char{ // programa para entender como ler um caractere
	
	public static void main(String[] args) throws Exception{

		System.out.print("Digite um caractere: ");
		
		char caractere = (char)System.in.read(); // <------ Lendo um caractere

		System.out.println("O caractere digitado foi \""+caractere+"\" caro usuario"); /* imprime o carectere 
																														entre aspas */
		// Outro Exemplo de impressão na tela usando printf();:
												  
		System.out.printf("O caractere digitado foi \"%c\" caro usuario\n", caractere); // %c é utilizado para caracteres																	
		
		System.out.println("\"aspas\""); //  \"argumento\" --> imprime um argumento entre aspas
	}
}