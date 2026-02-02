package controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import servicio.Servicio;

public class Gestiona2 {

	private static final Logger logger = LogManager.getLogger(Gestiona2.class);

	public static void main(String[] args) {
		Servicio servicio = new Servicio();


		// 1. Obtener 1 equipo
		logger.debug(servicio.obtenerUnEquipo());

		// 2. Listado de nombres equipos
		logger.debug(servicio.obtenerNombresEquipos());

		// 3. obtener nombre e id de jugadores
		logger.debug(servicio.obtenerNombreYId());

		// 4. buscar por patrocinador pasado por parametro
		logger.debug(servicio.buscarPatroPorMarca("Red"));

		// 5. AVG y COUNT
		// total patrocinadores y media ids
		logger.debug(servicio.obtenerTotalPatrocinadores());
		logger.debug(servicio.obtenerMediaIds());

		/// 6. Filtrar y Ordenar
		// obtener jugadores
		logger.debug(servicio.obtenerJugadoresOrdenados());

		// 7.actualizar nombre marca

		servicio.cambiarNombreMarca("Red Bull", "Red Bull Racing");

	}
}