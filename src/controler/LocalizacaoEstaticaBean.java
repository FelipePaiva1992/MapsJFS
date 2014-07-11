package controler;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import model.ArrayDeRetorno;
import model.Localizacao;
import util.RequisicaoWebService;

@ManagedBean
public class LocalizacaoEstaticaBean implements Serializable {
	
	private String enderecoOrigem;
	private String enderecoDestino;
	private ArrayDeRetorno arrayDeRetorno;
	
	public ArrayDeRetorno getArrayDeRetorno() {
		return arrayDeRetorno;
	}
	public void setArrayDeRetorno(ArrayDeRetorno arrayDeRetorno) {
		this.arrayDeRetorno = arrayDeRetorno;
	}
	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}
	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}
	public String getEnderecoDestino() {
		return enderecoDestino;
	}
	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}
	
	public void acharCoordenadas() throws IOException{
		RequisicaoWebService requisicaoWebService = new RequisicaoWebService();		
		this.setArrayDeRetorno(requisicaoWebService.request(this.enderecoOrigem, this.enderecoDestino));
		
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.sendRedirect("paginaMapa.xhtml");
		FacesContext.getCurrentInstance().responseComplete();
		
		System.out.println(this.arrayDeRetorno.getArrayAPI1().get(0).getLatitudeDestino());

	}
	
	
}
