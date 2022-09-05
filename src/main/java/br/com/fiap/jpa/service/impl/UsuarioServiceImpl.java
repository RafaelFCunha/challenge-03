package br.com.fiap.jpa.service.impl;

import java.util.List;

import br.com.fiap.jpa.dao.impl.UsuarioDAOImpl;
import br.com.fiap.jpa.entity.Usuario;
import br.com.fiap.jpa.service.GenericService;

public class UsuarioServiceImpl extends GenericService<Usuario, Long> {

	private static UsuarioServiceImpl instance = null;
	
	private UsuarioDAOImpl usuarioDAO;
	
	private UsuarioServiceImpl() {
		this.usuarioDAO = UsuarioDAOImpl.getInstance();
	}
	
	public static UsuarioServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new UsuarioServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Usuario instance) {
		try {
			usuarioDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Usuario instance) {
		try {
			usuarioDAO.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			usuarioDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Usuario obter(Long id) {
		Usuario usuario = null;
		
		try {
			usuario = usuarioDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return usuario;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = null;
		
		try {
			usuarios = usuarioDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return usuarios;
	}

}
