/* Autor: Matheus dos Santos Menezes
 Nº Matricula: 21554873 */

import java.util.Scanner;
import java.util.ArrayList;

public class Elf{    // <------ Para compilar, digite no prompt de comando "javac Elf.java" e nao ocorrendo nenhum erro, digite "java Elf"

	//Algoritmo de Escalonamento FCFS
	@SuppressWarnings("unchecked")
	public void fcfs(){ 

		Scanner ler = new Scanner(System.in);

		int tAtual, in, tipo, prio;
		
		ArrayList dur, ing, proc, tIniciais, tFinais;

		System.out.print("Informe a quantidade de processos: ");
		int numProcessos = ler.nextInt();
		System.out.println();

		double mediaExec, mediaEsp;

		while(numProcessos != 0){
			proc = new ArrayList();
			ing = new ArrayList();
			dur = new ArrayList ();
			tFinais = new ArrayList();
			tIniciais = new ArrayList();

			mediaExec = 0;	
			mediaEsp = 0;

			for(int i = 1; i <= numProcessos; i++){
				proc.add(i);
				
				System.out.print("PID: ");
				String pid = ler.next();

				System.out.print("INGRESSO: ");
				in = ler.nextInt();
				ing.add(in);
	
				System.out.print("DURACAO: ");
				in = ler.nextInt();
				dur.add(in);
					
				System.out.print("PRIORIDADE: ");
				prio = ler.nextInt();
				System.out.print("TIPO: "); // CPU Bound = 1; I/O Bound = 2; Ambos = 3
				tipo = ler.nextInt();
				System.out.println();
			}

			tAtual = (int)ing.get(0);

			for(int i = 0; i < numProcessos; i++){
				if((int)ing.get(i) > tAtual){
				tAtual = (int)ing.get(i);
			}
				tIniciais.add(tAtual);
				tAtual += (int)dur.get(i);
				tFinais.add(tAtual);
			}

			for(int i = 0; i < numProcessos; i++){
				mediaExec += (int)tFinais.get(i) - (int)ing.get(i);
				mediaEsp += (int)tIniciais.get(i) - (int)ing.get(i);
			}

			mediaExec = (double)mediaExec / numProcessos;		// calcular tempo médio de execução e de espera
			mediaEsp = (double)mediaEsp / numProcessos;

			System.out.printf("TEMPO MEDIO DE EXECUCAO: %.2f s\n", mediaExec);			
			System.out.printf("TEMPO MEDIO DE ESPERA: %.2f s\n", mediaEsp);
			System.out.println();
			System.out.print("ORDEM DE EXECUCAO: ");
			for (int i = 0; i < numProcessos; i++) {
	    		System.out.print("P"+proc.get(i)+" ");
	   		}
	   		System.out.println();
	   		System.out.println();

	   		System.out.println("DESEJA CONTINUAR? <SIM = 1> <NAO = 0>");
	   		numProcessos = ler.nextInt();
	   		System.out.println();
		}
	}

	//Algoritmo de escalonamento SJF
	@SuppressWarnings("unchecked")
	public void sjf(){

		Scanner ler = new Scanner(System.in);
		
		int in, idProcAtual, prio, tipo;
		ArrayList proc, ing, cpIng = new ArrayList(), dur;
		int[] tFinais = new int[1], tIniciais = new int[1];
		double mediaEsp, mediaExec;
		
		String ordExec = "";

		System.out.print("Informe a quantidade de processos: ");
		int numProcessos = ler.nextInt();
		System.out.println();
		
		while(numProcessos != 0){
			proc = new ArrayList();
			ing = new ArrayList();
			dur = new ArrayList();

			tFinais = new int[numProcessos];
			tIniciais = new int[numProcessos];
			for(int i = 0; i < numProcessos; i++){
				System.out.print("PID: ");
				String pid = ler.next();
				
				System.out.print("INGRESSO: ");
				in = ler.nextInt();
				ing.add(in);
	
				System.out.print("DURACAO: ");
				in = ler.nextInt();
				dur.add(in);
					
				System.out.print("PRIORIDADE: ");
				prio = ler.nextInt();
				System.out.print("TIPO: "); // CPU Bound = 1; I/O Bound = 2; Ambos = 3
				tipo = ler.nextInt();
				System.out.println();
			}

			cpIng = (ArrayList) ing.clone();

			int exec;
			int qtdProc = numProcessos;

			int tAtual = (int)ing.get(0);
			while(qtdProc > 0){
				proc = new ArrayList();
				for(int i = 0; i < numProcessos; i++){
					if(((int)ing.get(i) != -1) && ((int)ing.get(i) <= tAtual)){
						proc.add(i);
					}
				}

				if(proc.isEmpty()){
					tAtual++;
				}else{
					exec = (int)proc.get(0);
					for(int i = 0; i < proc.size(); i++){
						idProcAtual = (int)proc.get(i);

						if((int)dur.get(idProcAtual) < (int) dur.get(exec)){
							exec = (int)proc.get(i);
						}
					}

					tIniciais[exec] = tAtual;
					tAtual += (int)dur.get(exec);
					tFinais[exec] = tAtual;
					ing.set(exec, -1);

					ordExec += "P"+(exec+1)+" "; //coloca a ordem de execução
					qtdProc--;
				}
			}

			mediaExec = 0;
			mediaEsp = 0;
			for(int i = 0; i < numProcessos; i++){
				mediaExec += tFinais[i] - (int)cpIng.get(i);
				mediaEsp += tIniciais[i] - (int)cpIng.get(i);
			}

			mediaExec = (double)mediaExec / numProcessos;   // calcular tempo médio de execução e de espera
			mediaEsp = (double)mediaEsp / numProcessos;

			System.out.printf("TEMPO MEDIO DE EXECUCAO: %.2f s\n", mediaExec);			
			System.out.printf("TEMPO MEDIO DE ESPERA: %.2f s\n", mediaEsp);
			System.out.println();
			System.out.print("ORDEM DE EXECUCAO: "+ordExec);
			System.out.println();
			System.out.println();
			System.out.println("DESEJA CONTINUAR? <SIM = 1> <NAO = 0>");
	   		numProcessos = ler.nextInt();
	   		System.out.println();
		}
	}

	//Algoritmo de Escalonamento Round-Roubin(RR) 
	// ** Quantum = 2
	@SuppressWarnings("unchecked")
	public void rr(){

		Scanner ler = new Scanner(System.in);

		String ordExec;
		int quantum = 2, in, tAtual, exec, q, tFinais[], qtdProc, novaDur, tExec[];
		int tipo, prio;
		ArrayList proc, ing, dur, cpIng, cpDur;
		double mediaExec, mediaEsp;

		System.out.println("Quantum --> 2");
		System.out.println();
		System.out.print("Informe a quantidade de processos: ");
		int numProcessos = ler.nextInt();

		while(numProcessos != 0){

			proc = new ArrayList();
			ing = new ArrayList();
			dur = new ArrayList();
			ordExec = "";
			qtdProc = numProcessos;
			tFinais = new int[numProcessos];
			tExec = new int[numProcessos];

			for(int i = 0; i < numProcessos; i++){
				System.out.print("PID: ");
				String pid = ler.next();
				
				System.out.print("INGRESSO: ");
				in = ler.nextInt();
				ing.add(in);
	
				System.out.print("DURACAO: ");
				in = ler.nextInt();
				dur.add(in);
					
				System.out.print("PRIORIDADE: ");
				prio = ler.nextInt();
				System.out.print("TIPO: "); // CPU Bound = 1; I/O Bound = 2; Ambos = 3
				tipo = ler.nextInt();
				System.out.println();
			}

			cpIng = (ArrayList) ing.clone();
			cpDur = (ArrayList) dur.clone();

			tAtual = (int)ing.get(0);
			proc = new ArrayList();

			proc = new ArrayList();

			while(qtdProc > 0){

				for(int i = 0; i < numProcessos; i++){
					if(((int)ing.get(i) != -1) && ((int)ing.get(i) <= tAtual)){
						proc.add(i);
						ing.set(i, -1);
					}
				}

				if(proc.isEmpty()){
					tAtual++;
				}else{
					exec = (int)proc.remove(0);
					ordExec += "P"+(exec+1)+" "; //coloca a ordem de execução
					q = quantum;
					while((q > 0) && ((int)dur.get(exec) > 0)){
						tAtual++;
						q--;
						novaDur = (int)dur.get(exec) - 1;
						dur.set(exec, novaDur);
					}
					if((int)dur.get(exec) > 0){
						for(int i = 0; i < numProcessos; i++){
							if(((int)ing.get(i) != -1) && ((int)ing.get(i) <= tAtual)){
								proc.add(i);
								ing.set(i, -1);
							}
						}
						proc.add(exec);
					}else{
						tFinais[exec] = tAtual;
						qtdProc--;
					}
				}
			}

			mediaExec = 0;
			mediaEsp = 0;
			for(int i = 0; i < numProcessos; i++){
				tExec[i] = tFinais[i] - (int)cpIng.get(i);
				mediaExec += tExec[i];
				mediaEsp += tExec[i] - (int)cpDur.get(i);
			}

			mediaExec = (double)mediaExec / numProcessos;   // calcular tempo médio de execução e de espera
			mediaEsp = (double)mediaEsp / numProcessos;

			System.out.printf("TEMPO MEDIO DE EXECUCAO: %.2f s\n", mediaExec);			
			System.out.printf("TEMPO MEDIO DE ESPERA: %.2f s\n", mediaEsp);
			System.out.println();
			System.out.print("ORDEM DE EXECUCAO: "+ordExec);
			System.out.println();
			System.out.println();
			System.out.println("DESEJA CONTINUAR? <SIM = 1> <NAO = 0>");
	   		numProcessos = ler.nextInt();
	   		System.out.println();

		}

	}

	//Algoritmo de Escalonamento Prioridade
	@SuppressWarnings("unchecked")
	public void prio(){
		
		Scanner ler = new Scanner(System.in);

  
		int in, tipo, tAtual, exec, idProcAtual, qtdProc;
		ArrayList ing, dur, prio, proc, cpIng;
		int[] tFinais, tIniciais;
		String ordExec;

		System.out.print("Informe o numero de processos: ");
		int numProcessos = ler.nextInt();

		while(numProcessos != 0){
			proc = new ArrayList();
			ing = new ArrayList();
			dur = new ArrayList();
			prio = new ArrayList();

			for(int i = 0; i < numProcessos; i++){
				System.out.print("PID: ");
				String pid = ler.next();

				System.out.print("INGRESSO: ");
				in = ler.nextInt();
				ing.add(in);
	
				System.out.print("DURACAO: ");
				in = ler.nextInt();
				dur.add(in);
					
				System.out.print("PRIORIDADE: ");
				in = ler.nextInt();
				prio.add(in);

				System.out.print("TIPO: "); // CPU Bound = 1; I/O Bound = 2; Ambos = 3
				tipo = ler.nextInt();
				System.out.println();
			}

			tIniciais = new int[numProcessos];
			tFinais = new int[numProcessos];

			cpIng = (ArrayList) ing.clone();

			ordExec = ""; //coloca a ordem de execução

			tAtual = (int)ing.get(0);

			qtdProc = numProcessos;
			while(qtdProc > 0){
				proc = new ArrayList();
				for(int i = 0; i < numProcessos; i++){
					if(((int)ing.get(i) != -1) && ((int)ing.get(i) <= tAtual)){
						proc.add(i);
					}
				}

				if(proc.isEmpty()){
					tAtual++;
				}else{
					exec = (int)proc.get(0);
					for(int i = 0; i < proc.size(); i++){
						idProcAtual = (int)proc.get(i);
						if((int)prio.get(idProcAtual) > (int)prio.get(exec)){
							exec = (int)proc.get(i);
						}
					}

					tIniciais[exec] = tAtual;
					tAtual += (int)dur.get(exec);
					tFinais[exec] = tAtual;
					ing.set(exec, -1);

					ordExec += "P"+(exec+1)+" "; //coloca a ordem de execução
					qtdProc--;
				}
			}

			double mediaExec = 0;  
			double mediaEsp = 0;
			for(int i = 0; i < numProcessos; i++){
				mediaExec += tFinais[i] - (int)cpIng.get(i);
				mediaEsp += tIniciais[i] - (int)cpIng.get(i);
			}
			mediaExec = (double)mediaExec / numProcessos;  // calcular tempo médio de execução e de espera
			mediaEsp = (double)mediaEsp / numProcessos;

			System.out.printf("TEMPO MEDIO DE EXECUCAO: %.2f s\n", mediaExec);			
			System.out.printf("TEMPO MEDIO DE ESPERA: %.2f s\n", mediaEsp);
			System.out.println();
			System.out.print("ORDEM DE EXECUCAO: "+ordExec);
			System.out.println();
			System.out.println();
			System.out.println("DESEJA CONTINUAR? <SIM = 1> <NAO = 0>");
	   		numProcessos = ler.nextInt();
	   		System.out.println();
		}
	}


//-----------------------Menu Principal--------------------------------------------------
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		Elf elf = new Elf();

		Scanner ler = new Scanner(System.in);
		System.out.println("<FCFS = 1> <SJF = 2> <RR = 3> <PRIORIDADE = 4>");
		System.out.println();
		System.out.print("Informe quantos algoritmos de Escalonamento voce deseja executar(*min. dois): ");
		int numAlg = ler.nextInt();
		int alg, alg2, alg3;
		if(numAlg == 2){
			System.out.print("Escolha os algoritmos de escalonamento: ");
			alg = ler.nextInt();
			alg2 = ler.nextInt();
			if((alg == 1) && (alg2 == 2)){ // fcfs e sjf
				System.out.println();
				System.out.println("Escalonamento FCFS");
				System.out.println();
				elf.fcfs();
				System.out.println();
				System.out.println("Escalonamento SJF");
				System.out.println();
				elf.sjf();
			}else{
				if((alg == 1) && (alg2 == 3)){ // fcfs e rr
					System.out.println();
					System.out.println("Escalonamento FCFS");
					System.out.println();
					elf.fcfs();
					System.out.println();
					System.out.println("Escalonamento RR");
					System.out.println();
					elf.rr();
				}else{
					if((alg == 1) && (alg2 == 4)){ // fcfs e prioridade
						System.out.println();
						System.out.println("Escalonamento FCFS");
						System.out.println();
						elf.fcfs();
						System.out.println();
						System.out.println("Escalonamento PRIORIDADE");
						System.out.println();
						elf.prio();
					}else{
						if((alg == 2) && (alg2 == 3)){
							System.out.println();
							System.out.println("Escalonamento SJF");
							System.out.println();
							elf.sjf();
							System.out.println();
							System.out.println("Escalonamento RR");
							System.out.println();
							elf.rr();
						}else{
							if((alg == 2) && (alg2 == 4)){
								System.out.println();
								System.out.println("Escalonamento SJF");
								System.out.println();
								elf.sjf();
								System.out.println();
								System.out.println("Escalonamento PRIORIDADE");
								System.out.println();
								elf.prio();
							}else{
								if((alg == 3) && (alg2 == 4)){
									System.out.println();
									System.out.println("Escalonamento RR");
									System.out.println();
									elf.rr();
									System.out.println();
									System.out.println("Escalonamento PRIORIDADE");
									System.out.println();
									elf.prio();
								}
							}
						}
					}
				}
			}

		}else{
			if(numAlg == 3){
				System.out.print("Escolha os algoritmos de escalonamento: ");
				alg = ler.nextInt();
				alg2 = ler.nextInt();
				alg3 = ler.nextInt();
				if((alg == 1) && (alg2 == 2) && (alg3 == 3)){
					System.out.println();
					System.out.println("Escalonamento FCFS");
					System.out.println();
					elf.fcfs();
					System.out.println();
					System.out.println("Escalonamento SJF");
					System.out.println();
					elf.sjf();
					System.out.println();
					System.out.println("Escalonamento RR");
					System.out.println();
					elf.rr();
				}else{
					if((alg == 1) && (alg2 == 2) && (alg3 == 4)){
						System.out.println();
						System.out.println("Escalonamento FCFS");
						System.out.println();
						elf.fcfs();
						System.out.println();
						System.out.println("Escalonamento SJF");
						System.out.println();
						elf.sjf();
						System.out.println();
						System.out.println("Escalonamento PRIORIDADE");
						System.out.println();
						elf.prio();
					}else{
						if((alg == 1) && (alg2 == 3) && (alg3 == 4)){
							System.out.println();
							System.out.println("Escalonamento FCFS");
							System.out.println();
							elf.fcfs();
							System.out.println();
							System.out.println("Escalonamento RR");
							System.out.println();
							elf.rr();
							System.out.println();
							System.out.println("Escalonamento PRIORIDADE");
							System.out.println();
							elf.prio();
						}else{
							if((alg == 2) && (alg2 == 3) && (alg3 == 4)){
								System.out.println();
								System.out.println("Escalonamento SJF");
								System.out.println();
								elf.sjf();
								System.out.println();
								System.out.println("Escalonamento RR");
								System.out.println();
								elf.rr();
								System.out.println();
								System.out.println("Escalonamento PRIORIDADE");
								System.out.println();
								elf.prio();
							}
						}
					}
				}
			}else{
				if(numAlg == 4){
					System.out.println();
					System.out.println("Escalonamento FCFS");
					System.out.println();
					elf.fcfs();
					System.out.println();
					System.out.println("Escalonamento SJF");
					System.out.println();
					elf.sjf();
					System.out.println();
					System.out.println("Escalonamento RR");
					System.out.println();
					elf.rr();
					System.out.println();
					System.out.println("Escalonamento PRIORIDADE");
					System.out.println();
					elf.prio();
				}
			}
		}
	}
}
