package Controle;

import Visualisacao.EntradaSaida;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Carro;
import Modelo.Fabrica;

public class Controladora {

	private Fabrica fabrica = new Fabrica();

	public void exibeMenu() {
		int opcao;
		int quantidadeDeCarros;
		boolean validaEstoque = false;
		do {
			opcao = EntradaSaida.solicitaOpcao(validaEstoque);
			switch (opcao) {

			case 0:
				quantidadeDeCarros = EntradaSaida.solicitaQuantidade();

				for (int i = 0; i < quantidadeDeCarros; i++) {
					Carro carro = new Carro();
					String modelo = EntradaSaida.solicitaModelo(i);
					String cor = EntradaSaida.solicitaCor(i);
					carro.setModelo(modelo);
					carro.setCor(cor);
					fabrica.fabricarCarro(carro);

				}
				validaEstoque = EntradaSaida.validaEstoque(quantidadeDeCarros);
				break;

			case 1:

				String informacoes = this.fabrica.geraListaEstoque();
				EntradaSaida.imprimeListaDeCarros(informacoes);

				break;

			case 2:
				String modelo = EntradaSaida.solicitaModeloVenda();
				String cor = EntradaSaida.solicitaCorVenda();
				boolean validaVenda = fabrica.verificaCorEModelo(cor, modelo);
				EntradaSaida.exibeVenda(validaVenda, modelo, cor);
				break;

			}
		} while (opcao != 3);
		EntradaSaida.exibeMsgEncerraPrograma();
	}

}
