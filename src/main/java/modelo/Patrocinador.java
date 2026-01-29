package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patrocinadores")
public class Patrocinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatrocinador;
    private String marca;

    @ManyToMany(mappedBy = "patrocinadores")
    private List<Equipo> equipos = new ArrayList<>();

	public Long getIdPatrocinador() {
		return idPatrocinador;
	}

	public void setIdPatrocinador(Long idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPatrocinador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patrocinador other = (Patrocinador) obj;
		return Objects.equals(idPatrocinador, other.idPatrocinador);
	}

	@Override
	public String toString() {
		return "Patrocinador [idPatrocinador=" + idPatrocinador + ", marca=" + marca + ", equipos=" + equipos + "]";
	}

	public Patrocinador(Long idPatrocinador, String marca, List<Equipo> equipos) {
		super();
		this.idPatrocinador = idPatrocinador;
		this.marca = marca;
		this.equipos = equipos;
	}

	public Patrocinador() {
		super();
	}

    
}