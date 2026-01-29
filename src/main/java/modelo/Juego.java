package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "juegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJuego;
    private String titulo;

    @ManyToMany // Unidireccional: El juego conoce a los equipos, pero el equipo no conoce los juegos
    @JoinTable(name = "juego_equipo")
    private List<Equipo> equiposParticipantes = new ArrayList<>();

	public Long getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Long idJuego) {
		this.idJuego = idJuego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Equipo> getEquiposParticipantes() {
		return equiposParticipantes;
	}

	public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
		this.equiposParticipantes = equiposParticipantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idJuego);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(idJuego, other.idJuego);
	}

	@Override
	public String toString() {
		return "Juego [idJuego=" + idJuego + ", titulo=" + titulo + ", equiposParticipantes=" + equiposParticipantes
				+ "]";
	}

	public Juego(Long idJuego, String titulo, List<Equipo> equiposParticipantes) {
		super();
		this.idJuego = idJuego;
		this.titulo = titulo;
		this.equiposParticipantes = equiposParticipantes;
	}

	public Juego() {
		super();
	}

    
}