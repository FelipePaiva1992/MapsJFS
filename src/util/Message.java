package util;

import java.util.ArrayList;

public class Message {

	private ArrayList<String> fieldsInvalidMessages;
	private ArrayList<String> sucessMessages;
	
	public Message(){
		this.fieldsInvalidMessages = new ArrayList<String>();
		this.sucessMessages = new ArrayList<String>();
	}
	
	//VERIFICA SE NENHUMA MENSAGEM DE ERRO FOI INCLUIDA
	public boolean allValid(){
	
		if(this.fieldsInvalidMessages.size() > 0){
			return false;
		}
		else{
			return true;
		}
	}

	//ADICIONA MENSAGEM DE ERRO E A ORIGEM DO ERRO
	public void addErrorMessage(String nmField, String message){
		nmField = nmField.trim();
		message = message.trim();
		
		this.fieldsInvalidMessages.add(nmField+" "+message+"\n");
	}
	
	
	//ADICIONA MENSAGEM DE SUCESSO
	public void addSucessMessage(String message){
		message = message.trim();
		sucessMessages.add(message+"\n");
	}
	
	
	//RETORNA MENSAGEM GERADA
	public String getGenerateMessage(){
		
		StringBuilder messageContent = new StringBuilder();
		
		for(String field : this.fieldsInvalidMessages){
			messageContent.append(field.toString());
		}
		
		for(String sucess : this.sucessMessages){
			messageContent.append(sucess.toString());
		}

		return messageContent.toString();

	}
	
}
