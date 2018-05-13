public class Fibonacci{  // metodo recursivo
    
    static long fibo(long n) {
        if(n < 2){		// no caso dos numeros serem 0 ou 1.
            return n;	// retorna esses dois numeros (0 e 1).
        }else{
            return fibo(n - 1) + fibo(n - 2);
        }
    }
 
    public static void main(String[] args) {   

		for(int i = 0; i < 10; i++){
	       	System.out.print(Fibonacci.fibo(i)+" ");
	    }
	}
}