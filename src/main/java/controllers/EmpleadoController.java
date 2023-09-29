package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {
	//creacion de usuario
	public String createUsuario(String apellido,String nombre, int edad,String sexo,int salario ) {
	
	SessionFactory sessionFactory = new Configuration().
	configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
    
	Session session= sessionFactory.openSession();
	try {
		Empleado usuario=new Empleado(apellido, nombre, edad, sexo, salario);
		
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		
		sessionFactory.close();
		
		return "Usuario creado";
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return "error al registrar usuario";
	}
	
	//eliminacion de usuario
	public String deleteUsuario(int idempleado) {
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			    
				Session session= sessionFactory.openSession();
				try {
					
					session.beginTransaction();
					Empleado usuario = session.get(Empleado.class, idempleado);
					session.delete(usuario);
					session.getTransaction().commit();
					
					sessionFactory.close();
					
					return "Usuario eliminado";
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return "error al eliminar usuario";				
	}
	
	public String updateUsuario(int idempleado,String apellido) {
		SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").
		addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session= sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado usuario= session.get(Empleado.class, idempleado);
			usuario.setNombre(apellido);
			session.update(usuario);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Usuario actualizado";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al actualizar";
	}
	public String getUsuario(int idempleado) {
		SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").
		addAnnotatedClass(Empleado.class).buildSessionFactory();	
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado usuario= session.get(Empleado.class, idempleado);
			session.getTransaction().commit();		
			sessionFactory.close();
			return usuario.toString();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "usuario no existe";
	}
}

