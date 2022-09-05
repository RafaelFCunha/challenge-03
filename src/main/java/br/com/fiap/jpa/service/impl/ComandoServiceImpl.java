package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.ComandoDAOImpl;
import br.com.fiap.jpa.entity.Comando;
import br.com.fiap.jpa.service.GenericService;

public class ComandoServiceImpl extends GenericService<Comando, Long>{

	private static ComandoServiceImpl instance = null;
	
	private ComandoDAOImpl comandoDAO;
	
	private ComandoServiceImpl() {
		this.comandoDAO = ComandoDAOImpl.getInstance();
	}
	
	public static ComandoServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new ComandoServiceImpl();
		}
		
		return instance;
	}

	@Override
	public void inserir(Comando instance) {
		try {
			comandoDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Comando comando) {
		try {
			comandoDAO.atualizar(comando, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
				
	}

	@Override
	public void remover(Long id) {
		try {
			comandoDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}		
	}

	@Override
	public Comando obter(Long id) {
		Comando comando = null;
		
		try {
			comando = comandoDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return comando;
	}

	@Override
	public List<Comando> listar() {
		List<Comando> comandos = null;
		
		try {
			comandos = comandoDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return comandos;
	}
}
