package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;



public abstract class DAOFactory {
    // Sería mejor por inyección de objetos
    protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
	return factory;
    }
    
    public abstract PedidoDAO getPedidoDAO();
    public abstract ComidaDAO getComidaDAO();
    public abstract TcreditoDAO getTcreditoDAO();
    //public abstract UsuarioDAO getUsuarioDAO();
    //public abstract TelefonoDAO getTelefonoDAO();

}
