package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.CalculadoraPage;

public class CalculadoraSteps {
	
	
	
private CalculadoraPage calculatorPage = new CalculadoraPage();
	
	@Given("^que eu clique em \"([^\"]*)\"$")
	public void dado_que_eu_clique_em(String num) {
		calculatorPage.calcular(num);
	}
	
	@Then("devo validar o resultado")
	public void entao_devo_validar_o_resultado() {
		calculatorPage.validacao();
	}
}
