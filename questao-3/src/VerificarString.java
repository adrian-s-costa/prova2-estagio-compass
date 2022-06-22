import java.util.Scanner;

public class VerificarString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String frase = "";
		String humor = "";
		String contador = "";
		String testeDivertido = "";
		String testeChateado = "";
		boolean running = true;

		while (running) {

			contador = "";
			testeDivertido = "";
			testeChateado = "";
			frase = "";

			while (frase == "") {
				System.out.println("Digite sua frase");
				frase = scan.nextLine();
			}
			
			// verifica quantos "emojis" tem na frase e o contador itera de acordo com o humor do emoji, "a" para divertido
			// e "b" para chateado
			
			for (int i = 0; i < frase.length(); i++) {

				if (frase.charAt(i) == ':' && frase.charAt(i + 1) == '-' && frase.charAt(i + 2) == ')') {
					contador += "a";
				}

				if (frase.charAt(i) == ':' && frase.charAt(i + 1) == '-' && frase.charAt(i + 2) == '(') {
					contador += "b";
				}

			}
			
			//como o indicado é que uma frase só tenha o emoji de só um tipo de humor, então o teste de cada humor verifica se só 
			// há um tipo de humor na frase, caso sim a frase recebe aquele humor, caso contrário recebe "neutro" 
			
			for (int c = 0; c < contador.length(); c++) {
				testeDivertido += "a";
				testeChateado += "b";
			}
			
			//caso não haja nenhum emoji na frase ele recebe um falor default para ser diferenciada do contador
			
			if (testeDivertido.equals("")) {
				testeDivertido = "default";
			}
			if (testeChateado.equals("")) {
				testeChateado = "default";
			}

			if (contador.equals(testeDivertido)) {
				humor = "divertido";
			} else if (contador.equals(testeChateado)) {
				humor = "chateado";
			} else {
				humor = "neutro";
			}
			
			System.out.println(humor + " \n");
			System.out.println("Deseja verificar o humor de outra frase?");
			System.out.println("1 - Para finalizar");
			System.out.println("2 - Para executar novamente");
			int resp = new Scanner(System.in).nextInt();
			if (resp == 1) {
				running = false;
			}
		}
	}
}