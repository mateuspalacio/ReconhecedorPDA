import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AppMain { // PDA = (Q, Σ, δ, {qi}, F)

	static String readFile(String path, Charset encoding)
			throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	static String let(String file) throws FileNotFoundException {
		String content =  new Scanner(new File(file)).useDelimiter("\\Z").next();
		String refinedString = content.replaceAll("\\s+","");
		return refinedString;

	}
	public static void main(String[] args) throws Exception {
		/* linguagem esta´perfeito,
		linguagemfalhaum tem erro na declaração de variável,
		linguagemfalhadois tem erro na declaração de if,
		linguagemfalhatres tem erro em {},
		linguagemfalhaquatro.txt tem erro no while,
		linguagemfalhacinco tem erro no for
		*/
		Linguagens.main(let("linguagem.txt"));
//		Linguagens.main(let("linguagemfalhaum.txt"));
//		Linguagens.main(let("linguagemfalhadois.txt"));
//		Linguagens.main(let("linguagemfalhatres.txt"));
//		Linguagens.main(let("linguagemfalhaquatro.txt"));
//		Linguagens.main(let("linguagemfalhacinco.txt"));

	}
}
