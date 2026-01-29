package controlador;

import modelo.*;
import servicio.Servicio;

public class Gestiona {
    public static void main(String[] args) {
        Servicio servicio = new Servicio();

        System.out.println("=== INICIANDO CARGA DE DATOS ===");

        // 1. Guardamos el Patrocinador de forma independiente
        Patrocinador patro1 = new Patrocinador();
        patro1.setMarca("Red Bull");
        servicio.createPatrocinador(patro1); // Aquí se guarda y obtiene ID

        // 2. Creamos el Equipo
        Equipo equipo1 = new Equipo();
        equipo1.setNombre("G2 Esports");
        
        // ¡IMPORTANTE! 
        // En lugar de persistir el equipo con el patrocinador dentro directamente,
        // primero guardamos el equipo solo.
        servicio.createEquipo(equipo1);

        // 3. Ahora que ambos existen en la BD, los relacionamos usando UPDATE (merge)
        // Esto evita el error de "detached entity"
        equipo1.getPatrocinadores().add(patro1);
        servicio.updateEquipo(equipo1); 

        // 4. Con el Jugador y Periférico (1:1)
        Periferico peri1 = new Periferico();
        peri1.setModelo("Logitech G Pro");
        // Si tienes CascadeType.ALL en Jugador, NO llames a createPeriferico.
        // Deja que el Jugador lo gestione.
        
        Jugador jug1 = new Jugador();
        jug1.setNombre("Caps");
        jug1.setPeriferico(peri1);
        jug1.setEquipo(equipo1);
        
        servicio.createJugador(jug1);

        System.out.println("=== PROCESO COMPLETADO SIN ERRORES ===");
    }
}