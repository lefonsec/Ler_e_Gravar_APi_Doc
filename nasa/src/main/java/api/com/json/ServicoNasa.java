package api.com.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ServicoNasa {
	static String webService = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
	static int codigoSucesso = 200;

	public static List<Nasa> buscarNasa() throws Exception {
		String urlParaChamada = webService;

		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = Util.converteJsonEmString(resposta);
			TypeToken<List<Nasa>> tt = new TypeToken<List<Nasa>>() {
			};

			Gson gson = new Gson();

			List<Nasa> nasa = gson.fromJson(jsonEmString, tt.getType());
			return nasa;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e.getMessage());
		}
	}
}