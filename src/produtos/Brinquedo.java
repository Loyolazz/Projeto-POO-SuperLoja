package produtos;

public class Brinquedo extends Produto {
public Brinquedo(int id, String nome) {
		super(id, nome);
		super.setDescricao("");
	}

	@Override
	public void setCusto(int custo) {
		double precoFinal = custo * 1.5; 
		
		try {
			double imposto = this.calcImposto(precoFinal);
			
			// super.setTotalValor(precoFinal);
			super.setPreco(precoFinal);
			super.setImposto(imposto);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public double calcImposto(double precoFinal) {
		double valorImposto = precoFinal * 0.25;
		// super.setTotalImpostoValor(valorImposto);
		return valorImposto;
	}
}
