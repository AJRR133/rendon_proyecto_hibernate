package Repositorio;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import modelo.Patrocinador;
import util.AbstractDao;
import util.HibernateUtil;

public class RepositorioPatrocinador extends AbstractDao<Patrocinador>{

	public RepositorioPatrocinador() {
		setClase(Patrocinador.class); 

	}
	Session sesion = HibernateUtil.getFactoriaSession().openSession();
	HibernateCriteriaBuilder cb = sesion.getCriteriaBuilder();
	
	public List<Patrocinador> buscarPatrocinador(String marca) {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaQuery<Patrocinador> query = cb.createQuery(Patrocinador.class);
	    Root<Patrocinador> root = query.from(Patrocinador.class);
	    
	    query.select(root);
	    query.where(cb.like(root.get("marca"), "%" + marca + "%"));
	    
	    List<Patrocinador> patros = sesion.createQuery(query).getResultList();
	    sesion.close();
	    return patros;
	}

	public Long contarPatrocinadores() {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaQuery<Long> query = cb.createQuery(Long.class);
	    Root<Patrocinador> root = query.from(Patrocinador.class);
	    
	    query.select(cb.count(root));
	    
	    Long total = sesion.createQuery(query).getSingleResult();
	    sesion.close();
	    return total;
	}

	public void actualizarMarca(String antigua, String nueva) {
	    Session sesion = HibernateUtil.getFactoriaSession().openSession();
	    CriteriaUpdate<Patrocinador> update = cb.createCriteriaUpdate(Patrocinador.class);
	    Root<Patrocinador> root = update.from(Patrocinador.class);
	    
	    update.set("marca", nueva);
	    update.where(cb.equal(root.get("marca"), antigua));
	    
	    Transaction tx = sesion.beginTransaction();
	    sesion.createMutationQuery(update).executeUpdate();
	    tx.commit();
	    sesion.close();
	}
}
