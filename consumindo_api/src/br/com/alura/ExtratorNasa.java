package br.com.alura;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorNasa {

	// PEGAR/EXTRAIR SO OS DADOS QUE INTERESSA.
	public List<Conteudo> extraiConteudos(String json) {

		JsonParse parse = new JsonParse();
		List<Map<String, String>> listaDeAtribustos = parse.parse(json);

		List<Conteudo> conteudos = new ArrayList<>();

		for (Map<String, String> atributos : listaDeAtribustos) {
			String titulo = atributos.get("title");
			String urlImage = atributos.get("url");
			var conteudo = new Conteudo(titulo, urlImage);
			conteudos.add(conteudo);
		}
		return conteudos;

	}
}
