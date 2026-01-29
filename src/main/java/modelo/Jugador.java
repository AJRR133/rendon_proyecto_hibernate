package modelo;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugador {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJugador;
    private String nombre;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPeriferico")
    private Periferico periferico; // 1:1 Bidireccional

    @ManyToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo; // N:1 Bidireccional

	public Long getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Long idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Periferico getPeriferico() {
		return periferico;
	}

	public void setPeriferico(Periferico periferico) {
		this.periferico = periferico;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idJugador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(idJugador, other.idJugador);
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", periferico=" + periferico + ", equipo="
				+ equipo + "]";
	}

	public Jugador(Long idJugador, String nombre, Periferico periferico, Equipo equipo) {
		super();
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.periferico = periferico;
		this.equipo = equipo;
	}

	public Jugador() {
		super();
	}
    
    
    
    
}
