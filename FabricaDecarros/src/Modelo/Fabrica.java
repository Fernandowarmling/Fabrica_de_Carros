package Modelo;

import java.util.ArrayList;

public class Fabrica {

	private ArrayList<Carro> listaCarros = new ArrayList<Carro>();

	public ArrayList<Carro> getListaCarros() {
		return listaCarros;
	}

	public void setListaCarros(ArrayList<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}

	public void fabricarCarro(Carro carro) {
		listaCarros.add(carro);

	}

	// public boolean validaEstoque(ArrayList<Carro> listaCarros) {
	// boolean validadorEstoque;
	// if (listaCarros.isEmpty()) {
	// validadorEstoque = false;
	// } else {
	// validadorEstoque = true;
	// }
	// return validadorEstoque;
	// }
	public String geraListaEstoque() {
		String informacoes = "Carro  | Modelo | Cor | \n";
		int i = 0;
		for (Carro carro : listaCarros) {
			i++;
			informacoes += "Carro " + (i) + " | " + carro.getModelo() + " | " + carro.getCor() + " |\n";
		}
		return informacoes;

	}

	public void vendeCarro(Carro carro) {
		listaCarros.remove(carro);

	}

	public boolean verificaCorEModelo(String cor, String modelo) {
		boolean validaCarro = false;
		for (Carro carro : listaCarros) {
			if ((carro.modelo.equals(modelo)) && (carro.cor.equals(cor))) {
				validaCarro = true;
				vendeCarro(carro);
				return validaCarro;
			}
		}
		return validaCarro;

	}

}
