package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Comando;

public class ComandoDAOImpl extends HibernateGenericDAO<Comando, Long> {
	
	private static ComandoDAOImpl instance = null;
	
	private ComandoDAOImpl() {
		super(Comando.class);
	}
	
	public static ComandoDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new ComandoDAOImpl();
		}
		
		return instance;
	}

}
