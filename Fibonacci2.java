public class Fibonacci2{
    
    public static void main(String[] args){
	    
	    long[] fib = new long[51];
	    
	    fib[0] = 0;
	    fib[1] = 1;
	    
	    System.out.println(fib[0]);
	    System.out.println(fib[1]);
	    
	    for(int i = 2; i < fib.length; i++){   // imprimindo os 50 primeiros numeros da serie
	        fib[i] = fib[i-1] + fib[i-2];
	        System.out.print(fib[i]+" ");
	    }
	}    
}