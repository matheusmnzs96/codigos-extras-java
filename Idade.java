// Created by Matheus Menezes on 2018-04-17
// ----
// * Funcao que retorna a idade do usuario em anos a partir da data de nascimento (Ex: "16/12/1996")

public int idade(String dataNacimento){
		
	// converte a data de nascimento (String) para LocalDate 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate data = LocalDate.parse(dataNascimento,formatter);
		
	// variavel (tipo LocalDate) contendo a data atual
	LocalDate dataAtual = LocalDate.now();

		// variavel (tipo Period) que calcula o periodo entre as duas datas
	Period idade = Period.between(data, dataAtual);

	// por fim retorna o numero de anos entre as datas
	return idade.getYears();
}