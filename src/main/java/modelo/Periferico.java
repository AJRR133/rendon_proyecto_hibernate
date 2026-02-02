package modelo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perifericos")
public class Periferico {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeriferico;
    private String modelo;
    
    @OneToOne(mappedBy = "periferico")
    private Jugador jugador;

	public Long getIdPeriferico() {
		return idPeriferico;
	}

	public void setIdPeriferico(Long idPeriferico) {
		this.idPeriferico = idPeriferico;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPeriferico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periferico other = (Periferico) obj;
		return Objects.equals(idPeriferico, other.idPeriferico);
	}

	@Override
	public String toString() {
		return "Periferico [idPeriferico=" + idPeriferico + ", modelo=" + modelo +  "]";
	}

	public Periferico(Long idPeriferico, String modelo, Jugador jugador) {
		super();
		this.idPeriferico = idPeriferico;
		this.modelo = modelo;
		this.jugador = jugador;
	}

	public Periferico() {
		super();
	}
    
    
    
    
}
