package br.com.fiap.jpa;

import br.com.fiap.jpa.entity.Comando;
import br.com.fiap.jpa.entity.Usuario;
import br.com.fiap.jpa.service.impl.ComandoServiceImpl;
import br.com.fiap.jpa.service.impl.UsuarioServiceImpl;

public class App {

	public static void main(String[] args) {
		
		ComandoServiceImpl comandoService = ComandoServiceImpl.getInstance();
		UsuarioServiceImpl usuarioService = UsuarioServiceImpl.getInstance();
		
		/**
		 * Cadastrar novo usuario
		 */
		
		Usuario usuario = new Usuario("Rafael Fernandes", 5);
		usuarioService.inserir(usuario);

		
		/**
		 * Cadastrar um novo comando
		 */
		Comando comando = new Comando(1, "copiar&colar", "Este atalho ensina copiar e colar texto, imagens, etc", usuario);
		
		comandoService.inserir(comando);


/*		Entrada entrada2 = new Entrada(2, "Entrada Sul", evento); */
		
		
		/**
		 * Liste todas as movimentacoes com base no tipo da movimentacao
		*/
		comandoService.listar().forEach(System.out::println);
//		movimentacaoEntradaService.listarTipo("E").forEach(System.out::println); */
		
		/**
		 * Caso a gente precise remover
		 */
		
//		comandoService.remover(1);
	}
}
