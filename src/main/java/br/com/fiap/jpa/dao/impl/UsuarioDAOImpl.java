package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Usuario;

public class UsuarioDAOImpl extends HibernateGenericDAO<Usuario, Long> {

	private static UsuarioDAOImpl instance = null;
	
	private UsuarioDAOImpl() {
		super(Usuario.class);
	}
	
	public static UsuarioDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new UsuarioDAOImpl();
		}
		
		return instance; 
	}
}
