package Repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import modelo.Equipo;
import util.AbstractDao;
import util.HibernateUtil;

public class RepositorioEquipo extends AbstractDao<Equipo>{

	public RepositorioEquipo() {
		setClase(Equipo.class); 

	}
	Session sesion = HibernateUtil.getFactoriaSession().openSession();
	HibernateCriteriaBuilder cb = sesion.getCriteriaBuilder();
	public Equipo obtenerUnSoloEquipo() {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaQuery<Equipo> query = cb.createQuery(Equipo.class);
	    Root<Equipo> root = query.from(Equipo.class);
	    
	    query.select(root);
	    
	    Equipo resultado = sesion.createQuery(query).setMaxResults(1).getSingleResult();
	    sesion.close();
	    return resultado;
	}

	public List<String> obtenerSoloNombres() {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaQuery<String> query = cb.createQuery(String.class);
	    Root<Equipo> root = query.from(Equipo.class);
	    
	    query.select(root.get("nombre"));
	    
	    List<String> nombres = sesion.createQuery(query).getResultList();
	    sesion.close();
	    return nombres;
	}

	
}
