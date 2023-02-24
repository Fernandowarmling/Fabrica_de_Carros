package Visualisacao;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Controle.Controladora;
import Modelo.Carro;
import Modelo.Fabrica;

public class EntradaSaida {

	public static int solicitaOpcao(boolean validaEstoque) {

		String[] opcoes = { "Fabricar Carros", "Listar Estoque", "Vender Carro", "Sair do Programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione  a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		while (validaEstoque == false && (menu.getSelectedIndex() > 0) && (menu.getSelectedIndex() < 3)) {
			JOptionPane.showMessageDialog(null, "Não existem carros fabricados", "Atenção",
					JOptionPane.WARNING_MESSAGE);
			JOptionPane.showConfirmDialog(null, menu, "Selecione  a opção desejada", JOptionPane.OK_CANCEL_OPTION);

		}
		return menu.getSelectedIndex();
	}

	public static int solicitaQuantidade() {
		int quantidade;
		do {
			quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de carros a produzir"));
			if (quantidade <= 0) {
				erroInformacao();
			}
		} while (quantidade <= 0);

		return quantidade;
	}

	public static boolean validaEstoque(int quantidadeDeCarros) {
		boolean validadorEstoque;
		if (quantidadeDeCarros == 0) {
			validadorEstoque = false;
		} else {
			validadorEstoque = true;
		}

		return validadorEstoque;
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O Programa sera encerrado");
	}

	public static String solicitaModelo(int i) {
		String modelo;
		do {
			modelo = JOptionPane.showInputDialog("Informe o modelo do carro desejado " + (i + 1));
			if (modelo.equals("")) {
				erroInformacao();
			}
		} while (modelo.equals(""));

		return modelo;
	}

	public static String solicitaCor(int i) {
		String cor;
		do {
			cor = JOptionPane.showInputDialog("Informe a cor do carro desejado " + (i + 1));
			if (cor.equals("")) {
				erroInformacao();
			}
		} while (cor.equals(""));

		return cor;
	}

	public static void imprimeListaDeCarros(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Lista de Veiculos em Estoque",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void erroInformacao() {
		JOptionPane.showMessageDialog(null, "Dados informados estão em desacordo com o solicitado", "Atenção",
				JOptionPane.WARNING_MESSAGE);
	}

	public static String solicitaModeloVenda() {
		String modelo;
		do {
			modelo = JOptionPane.showInputDialog("Informe o modelo do carro a ser vendido ");
			if (modelo.equals("")) {
				erroInformacao();
			}
		} while (modelo.equals(""));

		return modelo;
	}

	public static String solicitaCorVenda() {
		String cor;
		do {
			cor = JOptionPane.showInputDialog("Informe a cor do carro a ser vendido ");
			if (cor.equals("")) {
				erroInformacao();
			}
		} while (cor.equals(""));
		return cor;
	}

	public static void exibeVenda(Boolean validaVenda, String modelo, String cor) {
		if (validaVenda == true) {
			JOptionPane.showMessageDialog(null, "Venda de carro do modelo: " + modelo + " e da  cor " + cor + ".",
					"Venda Concluida", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
					"Erro carro de modelo: " + modelo + " e da  cor " + cor + "não cadastrado",
					"Veiculo não existente ", JOptionPane.INFORMATION_MESSAGE);

		}

	}

}
