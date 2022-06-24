package utils;

public class Operacao {
	
	public static int conta = 0;
	public static int num1;
	public static int num2;
	public static String operador;
	public static int resultado;

	public void calculator(String texto) {
		
		switch (conta) {
		case 0:
			num1 = Integer.parseInt(texto);
			break;
		case 1:
			operador = texto;
			break;
		case 2:
			num2 = Integer.parseInt(texto);
			break;
		default:
			exec();
			break;
		}
		conta++;
	}
	
	public void exec() {
		if(operador.equals("mais")) {
			resultado = num1 + num2;
		}
		else if(operador.equals("menos")) {
			resultado = num1 - num2;
		}
		else if(operador.equals("multiplicar")) {
			resultado = num1 * num2;
		}
		else if(operador.equals("dividir")) {
			resultado = num1 / num2;
		}	
		else {
			System.out.println("operador errado");
		}
			
	}
}
