package util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import model.ArrayDeRetorno;
import model.Localizacao;


public class RequisicaoWebService {

	public ArrayDeRetorno request(String origem, String destino) throws IOException{
		
		String url = this.criaUrl(origem,destino);
		String jsonString = this.chamarWebService(url);
		ParseWebService parse = new ParseWebService();
		
		
		ArrayList<Localizacao> arrayLocalizacao = new ArrayList<Localizacao>();
		arrayLocalizacao = parse.parseJson(jsonString);
		
		ArrayDeRetorno arrayDeRetorno = new  ArrayDeRetorno();
		arrayDeRetorno.setArrayAPI1(arrayLocalizacao);
		return arrayDeRetorno;
	}

	public String criaUrl(String origem, String destino) throws UnsupportedEncodingException {
		
		// a string da url
		String urlString = "http://maps.googleapis.com/maps/api/directions/json";
	
		
		
		// os parametros a serem enviados
		Properties parametrosDirecoes = new Properties();

		parametrosDirecoes.setProperty("origin", URLEncoder.encode(origem, "UTF-8"));
		parametrosDirecoes.setProperty("destination",URLEncoder.encode(destino, "UTF-8"));
		parametrosDirecoes.setProperty("sensor","false");

		// o iterador, para criar a URL
		Iterator<?> i = parametrosDirecoes.keySet().iterator();
		// o contador
		int counter = 0;

		// enquanto ainda existir parametros
		while (i.hasNext()) {

			// pega o nome
			String name = (String) i.next();
			// pega o valor
			String value = parametrosDirecoes.getProperty(name);

			// adiciona com um conector (? ou &)
			// o primeiro é ?, depois são &
			urlString += (++counter == 1 ? "?" : "&")
				+ name
				+ "="
				+ value;

		}
		
		return urlString;

	}
	
	
	public String chamarWebService (String urlString) throws IOException{
		
	URL url = new URL(urlString);

	HttpURLConnection connection =  (HttpURLConnection) url.openConnection(); 
	
	// seta o metodo  
	connection.setRequestProperty("Accept", "application/json");
	connection.setRequestProperty("Content-Type", "application/json");
	connection.setRequestMethod("GET");
	
	// seta a variavel para ler o resultado  
	connection.setDoInput(true);  
	connection.setDoOutput(true);  
	
	// conecta com a url destino  
	try {
		connection.setRequestProperty("User-Agent", "Chrome/27.0.1453.110");
		connection.connect();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	// abre a conexão pra input  
			BufferedReader br =  
			    new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			// le ate o final  
			StringBuffer newData = new StringBuffer(10000);  
			String s = "";  
			while (null != ((s = br.readLine()))) {  
			    newData.append(s);  
			}  
			br.close(); 
			return new String(newData);
	 
	}

}
