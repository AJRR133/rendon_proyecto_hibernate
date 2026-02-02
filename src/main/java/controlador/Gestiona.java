package controlador;

import modelo.*;
import servicio.Servicio;

public class Gestiona {
    public static void main(String[] args) {
        Servicio servicio = new Servicio();

        System.out.println("=== INICIANDO CARGA DE DATOS ===");

        // 1. Guardamos el Patrocinador 
        Patrocinador patro1 = new Patrocinador();
        patro1.setMarca("Red Bull");
        servicio.createPatrocinador(patro1); 

        // 2. Creamos el Equipo
        Equipo equipo1 = new Equipo();
        equipo1.setNombre("G2 Esports");
  

        // primero guardamos el equipo solo.
        servicio.createEquipo(equipo1);

        equipo1.getPatrocinadores().add(patro1);
        servicio.updateEquipo(equipo1); 

        // 4. Con el Jugador y Periférico
        Periferico peri1 = new Periferico();
        peri1.setModelo("Logitech G Pro");
        
        Jugador jug1 = new Jugador();
        jug1.setNombre("Caps");
        jug1.setPeriferico(peri1);
        jug1.setEquipo(equipo1);
        
        servicio.createJugador(jug1);

    }
}