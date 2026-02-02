package Repositorio;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import jakarta.persistence.criteria.Root;
import modelo.Jugador;
import util.AbstractDao;
import util.HibernateUtil;

public class RepositorioJugador extends AbstractDao<Jugador> {

    public RepositorioJugador() {
        setClase(Jugador.class);
    }

    HibernateCriteriaBuilder cb = HibernateUtil.getFactoriaSession().getCriteriaBuilder();

    // 1.  Nombre e ID 
    public List<Object[]> nombreYId() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Jugador> root = query.from(Jugador.class);

        query.multiselect(root.get("nombre"), root.get("idJugador"));

        List<Object[]> resultados = sesion.createQuery(query).getResultList();
        for (Object[] fila : resultados) {
            System.out.println("Nombre: " + fila[0] + ", ID: " + fila[1]);
        }
        sesion.close();
        return resultados;
    }

    // 2. Buscar por ID de Equipo
    public List<Jugador> buscarPorEquipo(int id) {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        CriteriaQuery<Jugador> query = cb.createQuery(Jugador.class);
        Root<Jugador> root = query.from(Jugador.class);

        query.select(root);
        query.where(cb.equal(root.get("equipo").get("idEquipo"), id));

        List<Jugador> lista = sesion.createQuery(query).getResultList();
        sesion.close();
        return lista;
    }

    // 3. Media de los IDs 
    public Double mediaIds() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        CriteriaQuery<Double> query = cb.createQuery(Double.class);
        Root<Jugador> root = query.from(Jugador.class);

        query.select(cb.avg(root.get("idJugador")));

        Double media = sesion.createQuery(query).getSingleResult();
        sesion.close();
        return media;
    }

    // 4. Consulta que filtre  ordene por nombre
    public List<Jugador> filtrarYOrdenarPorNombre() {
        Session sesion = HibernateUtil.getFactoriaSession().openSession();
        CriteriaQuery<Jugador> query = cb.createQuery(Jugador.class);
        Root<Jugador> root = query.from(Jugador.class);

        query.select(root);
        query.where(cb.greaterThan(root.get("idJugador"), 0));
        query.orderBy(cb.asc(root.get("nombre")));

        List<Jugador> listaOrdenada = sesion.createQuery(query).getResultList();
        sesion.close();
        return listaOrdenada;
    }
}