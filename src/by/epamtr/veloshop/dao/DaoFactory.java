package by.epamtr.veloshop.dao;

import by.epamtr.veloshop.dao.impl.DBVeloDao;

public class DaoFactory {
	private static final DaoFactory INSTANCE = new DaoFactory();
		
	private VeloDao veloDao = new DBVeloDao();
	
	private DaoFactory(){}
	
	public static DaoFactory getInstance(){
		return INSTANCE;
	}
	
	public VeloDao getVeloDao(){
		return veloDao;
	}

}
