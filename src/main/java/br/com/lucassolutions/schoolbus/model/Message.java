package br.com.lucassolutions.schoolbus.model;

public enum Message {
	
	SEARCH_STUDENT_ERROR("Ocorreu um erro ao buscar aluno, tente novamente."),
	NOT_FOUND_STUDENT("Aluno não encontrado na base de dados!"),
	NAME_STUDENT_IS_EMPTY("É necessário digitar um nome para a busca ser realizada."),
	SAVE_STUDENT_SUCSESSFUL("Aluno cadastrado com sucesso"),
	SAVE_STUDENT_ERROR("Ocorreu um erro ao cadastrar aluno, tente novamente."), 
	DELETE_STUDENT_SUCCESSFUL("Aluno excluido com sucesso!"),
	DELETE_STUDENT_ERROR("Ocorreu um erro ao excluir aluno, tente novamente."), 
	DONT_HAVE_STUDENT("Não há estuante cadastrados"), 
	
	NAME_CONTACT_IS_EMPTY("É necessário digitar um nome para a busca ser realizada."), 
	NOT_FOUND_CONTACT("Contato não encontrado na base de dados!"), 
	SEARCH_CONTACT_ERROR("Ocorreu um erro ao buscar contato, tente novamente."), 
	SAVE_CONTACT_SUCSESSFUL("Contato cadastrado com sucesso"), 
	SAVE_CONTACT_ERROR("Ocorreu um erro ao cadastrar contato, tente novamente."),
	DONT_HAVE_CONTACT("Não há contatos cadastrados"), 
	DELETE_CONTACT_SUCCESSFUL("Contato excluido com suecesso!"), 
	DELETE_CONTACT_ERROR("Ocorreu um erro ao excluir contato, tente novamente.");
	
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
