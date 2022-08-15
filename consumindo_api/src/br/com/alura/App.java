package br.com.alura;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {

		GeradoDeFigurinhas geradora = new GeradoDeFigurinhas();
	

		String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
		ClienteHttp cliente = new ClienteHttp();
		String json = cliente.buscaDados(url);

		// EXIBIR E MANUPULAR OS DADOS DO JEITO QUE A GENTE QUISER.
		
		ExtratorNasa extratorNasa = new ExtratorNasa();
		List<Conteudo> extraiConteudos = extratorNasa.extraiConteudos(json);
		
		for (Conteudo conteudos : extraiConteudos) {
			String urlImagem = conteudos.getUrlImagem();
			String titulo = conteudos.getTitulo();
			InputStream inputStream = new URL(urlImagem).openStream();

			String saidaArquivo = "saida/" + titulo + ".png";

			geradora.criar(inputStream, saidaArquivo);
			System.out.println(titulo);
			System.out.println();
		}
	}

}
