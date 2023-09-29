package Views;

import controllers.EmpleadoController;

public class EmpleadoViews {

	public static void main(String[] args) {
		//creacion usuario
	//	String usuario =new EmpleadoController().createUsuario("Dominguez","Rodolfo",20,"Masculino",2500);
		
		//eliminacion de usuario
	//	String usuario =new EmpleadoController().deleteUsuario(1);
		//System.out.println(usuario);
	
		//update usuario
	//	String usuario= new EmpleadoController().updateUsuario(2, "Valverde");
		//System.out.println(usuario);
		
		//read user
		String usuario= new EmpleadoController().getUsuario(3);
		
		System.out.println(usuario);
	}
	
	
}
