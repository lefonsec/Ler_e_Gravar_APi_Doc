package br.com.alura;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoDeFigurinhas {

	public void criar(InputStream inputStream,String saidaArquivo) throws Exception {
		//leitura da imagem.
//		InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMGEzN2VkMmUtMGM1Zi00Y2U1LTlkMDktMTlhMTdmYzZmZDlhXkEyXkFqcGdeQXVyODEyNjEwMDk@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();  // (new File("entrada/piratas.jpg"));
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria nova imagem con transparencia e tamanho novo.
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 100;
		BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);
		
		//copiar a iagem original pra nova imagem. 
		
		Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal,0,0,null);
		
		//configurar a fonte
		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD,20);
		graphics.setColor(Color.green);
		graphics.setFont(fonte);
		
		//escrever a nova imagem com uma frase.
		graphics.drawString("TOPZERA", 0, novaAltura - 43);
		
		//escrever a nova imagem em um arquivo .
		ImageIO.write(novaImagem,"png",new File(saidaArquivo));
		
	}
}
