public class Fibonacci3{

    public static void main(String[] args) {

        for(long a=0, b=1, i=0; i<61; b+=a, a=b-a, i++) {  // imprimindo os 60 primeiros numeros da série
			System.out.println(a);
		}
	}
}
