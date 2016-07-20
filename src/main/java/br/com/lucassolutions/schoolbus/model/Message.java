package br.com.lucassolutions.schoolbus.model;

public enum Message {
	
	NOT_FOUND_STUDENT("Aluno não encontrado na base de dados!"),
	NOT_FOUND_CONTACT("Contato não encontrado na base de dados!"), 
	NOT_FOUND_RESPONSIBLE("Responsavel não encontrado na base de dados!"),
	
	NAME_IS_EMPTY("É necessário digitar um nome para a busca ser realizada."),
	SEARCH_ERROR("Ocorreu um erro ao realizar a busca, tente novamente."),
	SAVE_ERROR("Ocorreu um erro ao cadastrar, tente novamente."),
	SAVE_SUCSESSFUL("Cadastro realizado com sucesso"),
	DONT_HAVE_DATA("Não há dados cadastrados na base"), 
	DELETE_ERROR("Ocorreu um erro ao excluir contato, tente novamente."), 
	DELETE_SUCCESSFUL("Exclusão realizada com suecesso!");
	
	private String key;
	
	Message(String key){
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
