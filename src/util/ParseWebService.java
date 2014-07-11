package util;




import java.util.ArrayList;

import model.Localizacao;

import org.json.JSONException;
import org.json.JSONObject;

public class ParseWebService {
	
	public ArrayList<Localizacao> parseJson(String stringJson) {

		ArrayList<Localizacao> arrayLocalizacao = new ArrayList<Localizacao>();
		Localizacao localizacao = null;
		JSONObject jsonObj = null;
		try {

			if (stringJson != null) {
				jsonObj = new JSONObject(stringJson);
				localizacao = new Localizacao();
				
				localizacao.setLatitudeOrigem((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("start_location").getString("lat")).toString());
				localizacao.setLongitudeOrigem((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("start_location").getString("lng")).toString());
				
				localizacao.setLatitudeDestino((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("end_location").getString("lat")).toString());
				localizacao.setLongitudeDestino((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("end_location").getString("lng")).toString());

				localizacao.setPolylinha((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONObject("overview_polyline").getString("points")).toString());
				
				arrayLocalizacao.add(localizacao);

			}
		} catch (JSONException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro de null");
			return arrayLocalizacao = null;
		}
		System.out.println("FOi");
		return arrayLocalizacao;

	}
    
    

}
