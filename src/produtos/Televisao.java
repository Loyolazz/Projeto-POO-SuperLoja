package produtos;

public class Televisao extends Produto {
    int tamanho;
    String tecnologia;
    
  
    private int classe;
	
	public Televisao(int id, String nome, int classe) {
		super(id, nome);
		this.classe = classe;
		super.setDescricao("Classe "+classe);
	}

	@Override
	public void setCusto(int custo) {
		
		try {
			double porcentagemPreco = this.verificaPorcentagemPrecoClasse(this.classe);
			double precoFinal = custo * porcentagemPreco; 
			double imposto = this.calcImposto(precoFinal);
			
			super.setPreco(precoFinal);
			super.setImposto(imposto);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public double calcImposto(double precoFinal) {
		double porcentagemImposto = this.verificaPorcentagemImpostoClasse(this.classe);
		double valorImposto = precoFinal * porcentagemImposto;
		
		return valorImposto;
	}
	
	private double verificaPorcentagemPrecoClasse(int classe) {
		double porcentagemPreco;
		
		switch (classe){
			case 1:
				porcentagemPreco = 1.5;
				break;
			case 2:
				porcentagemPreco = 1.6;
				break;
			case 3:
				porcentagemPreco = 1.7;
				break;
			default:
				throw new IllegalArgumentException("Classe invalida: " + classe);
		}
		return porcentagemPreco;
	}
	
	private double verificaPorcentagemImpostoClasse(int classe) {
		double porcentagemImposto;
		
		switch (classe){
			case 1:
				porcentagemImposto = 0.1;
				break;
			case 2:
				porcentagemImposto = 0.15;
				break;
			case 3:
				porcentagemImposto = 0.2;
				break;
			default:
				throw new IllegalArgumentException("Classe invalida: " + classe);
		}
		
		return porcentagemImposto;
	}
    
    
}
