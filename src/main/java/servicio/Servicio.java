package servicio;

import modelo.*;
import Repositorio.*;
import java.util.List;

public class Servicio {
    
    private RepositorioJugador repoJugador = new RepositorioJugador();
    private RepositorioEquipo repoEquipo = new RepositorioEquipo();
    private RepositorioPeriferico repoPeriferico = new RepositorioPeriferico();
    private RepositorioEntrenador repoEntrenador = new RepositorioEntrenador();
    private RepositorioPatrocinador repoPatrocinador = new RepositorioPatrocinador();
    private RepositorioJuego repoJuego = new RepositorioJuego();

    // --- CRUD ---

    // JUGADOR
    public void createJugador(Jugador j) { 
        repoJugador.create(j); 
    }
    public void updateJugador(Jugador j) { 
        repoJugador.update(j); 
    }
    public void deleteJugador(Jugador j) { 
        repoJugador.delete(j); 
    }
    public Jugador getJugador(int id) { 
        return repoJugador.get(id); 
    }

    // EQUIPO
    public void createEquipo(Equipo e) { 
        repoEquipo.create(e); 
    }
    public void updateEquipo(Equipo e) { 
        repoEquipo.update(e);
    }
    public void deleteEquipo(Equipo e) { 
        repoEquipo.delete(e); 
    }
    public Equipo getEquipo(int id) { 
        return repoEquipo.get(id); 
    }

    // PATROCINADOR
    public void createPatrocinador(Patrocinador p) { 
        repoPatrocinador.create(p); 
    }
    public Patrocinador getPatrocinador(int id) { 
        return repoPatrocinador.get(id); 
    }

    // ENTRENADOR
    public void createEntrenador(Entrenador en) { 
        repoEntrenador.create(en); 
    }
    public void deleteEntrenador(Entrenador en) { 
        repoEntrenador.delete(en); 
    }

    // JUEGO
    public void createJuego(Juego ju) { 
        repoJuego.create(ju); 
    }

    // PERIFÉRICO
    public void createPeriferico(Periferico pe) { 
        repoPeriferico.create(pe); 
    }



    // Métodos del RepositorioJugador
    public List<Object[]> obtenerNombreYId() { 
        return repoJugador.nombreYId(); 
    }
    public List<Jugador> buscarJugadoresPorEquipo(int id) { 
        return repoJugador.buscarPorEquipo(id); 
    }
    public Double obtenerMediaIds() { 
        return repoJugador.mediaIds(); 
    }
    public List<Jugador> obtenerJugadoresOrdenados() { 
        return repoJugador.filtrarYOrdenarPorNombre(); 
    }

    // Métodos del RepositorioEquipo
    public Equipo obtenerUnEquipo() { 
        return repoEquipo.obtenerUnSoloEquipo(); 
    }
    public List<String> obtenerNombresEquipos() { 
        return repoEquipo.obtenerSoloNombres(); 
    }

    // Métodos del RepositorioPatrocinador
    public List<Patrocinador> buscarPatroPorMarca(String marca) { 
        return repoPatrocinador.buscarPatrocinador(marca); 
    }
    public Long obtenerTotalPatrocinadores() { 
        return repoPatrocinador.contarPatrocinadores(); 
    }
    public void cambiarNombreMarca(String antigua, String nueva) { 
        repoPatrocinador.actualizarMarca(antigua, nueva); 
    }
}