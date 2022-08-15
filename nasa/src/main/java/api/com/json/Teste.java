package api.com.json;

import java.util.List;

public class Teste {

	public static void main(String[] args) throws Exception {

//		   System.out.print("Informe seu CEP: ");
//		   String cep = new Scanner(System.in).nextLine();
		Layout arquivo = new Layout();
		Arquivo gravar = new Arquivo();
		
		List<Nasa> nasa = ServicoNasa.buscarNasa();
		
		gravar.openFile();
		extracted(gravar, nasa);
		gravar.closeFile();

	}

	private static void extracted(Arquivo gravar, List<Nasa> nasa) {
		Layout arquivo = new Layout();
		for (Nasa lista : nasa) {
			arquivo.setType(lista.getType());
			arquivo.setTitle(lista.getTitle());
			gravar.gravaLinha(arquivo.toString());
		}
	}

}
