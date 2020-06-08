package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.ComidaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDAO;
import ec.edu.ups.dao.TcreditoDAO;
import ec.edu.ups.entidades.Comidas;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Tcredito;

/**
 * Servlet implementation class ServletCrearPedido
 */
@WebServlet("/ServletCrearPedido")
public class ServletCrearPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrearPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Instanciamos las clases para crear el pedido
		PedidoDAO peDAO= DAOFactory.getFactory().getPedidoDAO();
		ComidaDAO coDAO=DAOFactory.getFactory().getComidaDAO();
		TcreditoDAO tDAO=DAOFactory.getFactory().getTcreditoDAO();
		Pedido p = new Pedido();
		Comidas c = new Comidas();
		Tcredito t = new Tcredito();
		System.out.println("Hola Servlet De Creacion");
		//Obtencion del pedido para ingresar  en la BD 
		String fecha = request.getParameter("Fecha");

		String nombrec = request.getParameter("nombreC");
	
		String total=request.getParameter("totalP");
		double totalP = Double.parseDouble(total);
		
		String observacion=request.getParameter("observacion");
		
		//Se setea los valores a la entidad de pedido
		p.setFecha(fecha);
		p.setCliente(nombrec);
		p.setTotal(totalP);
		p.setObservaciones(observacion);
		System.out.println(p.toString());
		System.out.println("");
		
		//Obtencion de la Comida para ingresar en la BD
		
		String nombreC= request.getParameter("nombreComida");
		
		String precio=request.getParameter("precioUnitario");
		double precioU = Double.parseDouble(precio);
		
		//Se setea los valores a la entidad de Comida
		c.setNombre(nombreC);
		c.setPrecioU(precioU);
		c.setNumeroP(p);
		System.out.println(c.toString());
		System.out.println("");
		
		//Obtencion de la Tarjeta de Credito para ingresar en la BD
	
		String numero=request.getParameter("numeroTarjeta");
		int numeroT=Integer.parseInt(numero);
		//System.out.println(numeroT);
		String nombreP=request.getParameter("nombrePropietario");
		//System.out.println(nombreP);
		String fechaCaducidad=request.getParameter("FechaCaducidad");
		//System.out.println(fechaCaducidad);
		String cvv=request.getParameter("cvv");
		//System.out.println(cvv);
		
		//Se setea los valores a la entidad de Tarjeta de Credito.
		t.setNumerotarjeta(numeroT);
		t.setNombre(nombreP);
		t.setFechaCaducidad(fechaCaducidad);
		t.setCvv(cvv);
		t.setNumeroP(p);
		System.out.println(t.toString());
		
		System.out.println("");
		System.out.println("DATOS REGRISTRADOS EN LA BD");
		
		
		//doGet(request, response);
	}

}
