package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "entrenadores")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrenador;
    private String nombre;

    @OneToMany // Unidireccional: Equipo no sabe quién es su entrenador en la BD
    @JoinColumn(name = "idEntrenador")
    private List<Equipo> equiposAsignados = new ArrayList<>();

	public Long getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(Long idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Equipo> getEquiposAsignados() {
		return equiposAsignados;
	}

	public void setEquiposAsignados(List<Equipo> equiposAsignados) {
		this.equiposAsignados = equiposAsignados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEntrenador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		return Objects.equals(idEntrenador, other.idEntrenador);
	}

	@Override
	public String toString() {
		return "Entrenador [idEntrenador=" + idEntrenador + ", nombre=" + nombre + ", equiposAsignados="
				+ equiposAsignados + "]";
	}

	public Entrenador(Long idEntrenador, String nombre, List<Equipo> equiposAsignados) {
		super();
		this.idEntrenador = idEntrenador;
		this.nombre = nombre;
		this.equiposAsignados = equiposAsignados;
	}

	public Entrenador() {
		super();
	}

    
}