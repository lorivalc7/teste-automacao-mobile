package pages;
import static utils.Operacao.resultado;

import org.junit.Assert;

import io.appium.java_client.MobileElement;
import utils.Operacao;

public class CalculadoraPage extends BasePage {
	
	private Operacao operacao = new Operacao();
	
	MobileElement element;
	
	public static int contar=0;
	
	public void calcular(String texto) {
		switch (contar) {
		case 0:
			this.element = driver.findElementById("com.google.android.calculator:id/digit_" + texto);
			break;
		
		case 1:
			this.element = driver.findElementByAccessibilityId(texto);
			break;
			
		case 2:
			this.element = driver.findElementById("com.google.android.calculator:id/digit_" + texto);
			break;
			
		default:
			this.element = driver.findElementByAccessibilityId(texto);
			break;
		}
		this.element.click();
		operacao.calculator(texto);
		contar++;
	}
	
	public void validacao() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MobileElement result = driver.findElementById("com.google.android.calculator:id/result_preview");
		boolean bool = resultado == Integer.parseInt(result.getText());
		String msg = bool ? "SUCESSO": "ERROR";
		Assert.assertTrue(msg, bool);
	}
	
}
