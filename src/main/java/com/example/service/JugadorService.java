package com.example.service;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.hibernate.boot.model.source.spi.SingularAttributeSourceToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    public void testJugador() {

        Equipo sabadell = new Equipo("sabadell", "Sabadell", "24/12/1944");
        equipoRepository.save(sabadell);
        Jugador jason = new Jugador("jason", "1994", 124, 43, 109, "pivot");
        jason.setEquipo(sabadell);
        jugadorRepository.save(jason);
        Jugador paco = new Jugador("paco", "1989", 113, 34, 54, "alero");
        paco.setEquipo(sabadell);
        jugadorRepository.save(paco);


        Equipo FCB = new Equipo("FCB", "Barcelona", "12/09/1926");
        equipoRepository.save(FCB);
        Jugador willy = new Jugador("william", "1983", 132, 46, 89, "defensa");
        willy.setEquipo(FCB);
        jugadorRepository.save(willy);


        Equipo stucom = new Equipo("stucom", "Barcelona", "23/09/1800");
        equipoRepository.save(stucom);
        Jugador albert = new Jugador("albert", "1973", 167, 78, 69, "alero");
        albert.setEquipo(stucom);
        jugadorRepository.save(albert);


        Equipo tiendeo = new Equipo("tiendeo", "Barcelona", "09/02/2001");
        equipoRepository.save(tiendeo);
        Jugador mario = new Jugador("mario", "1991", 111, 31, 20, "alero");
        mario.setEquipo(tiendeo);
        jugadorRepository.save(mario);


        Equipo android = new Equipo("android", "California", "20/05/2003");
        equipoRepository.save(android);


        System.out.println("jugadores que se llamen Jason ");
        System.out.println(jugadorRepository.findBynombre("jason"));


        System.out.println("jugadores que han conseguido  mayor o igual de canastas (130 por ejemplo)");
        System.out.println(jugadorRepository.findBycanastasTotalesGreaterThanEqual(130));


        System.out.println("jugadores con asitencias medias de 10 a 50 ");
        System.out.println(jugadorRepository.findByasistenciasTotalesBetween(10, 50));


        System.out.println("Jugadores que juegan de pivot");
        System.out.println(jugadorRepository.findByposicion("pivot"));


        System.out.println("jugadores que hayan nacido antes de 1992 ");
        System.out.println(jugadorRepository.findByfechaNacimientoLessThan("1992"));


        showStatistics(jugadorRepository.AvgAndMaxAndMinPricesPerPosicion());

        showStatistics2(jugadorRepository.AvgAndMaxAndMinPricesPerPosicionResumen());

        System.out.println("------------------------------------- EQUIPO ---------------------------------------");
        System.out.println("Equipos existentes de Barcelona");
        System.out.println(equipoRepository.findByLocalidad("Barcelona"));

        System.out.println("jugadores del FCB");
        System.out.println(equipoRepository.findByNombreEquipo("FCB"));

        System.out.println("Jugadores que juegan en un equipo, y son defensa");
        System.out.println(equipoRepository.findByNombreEquipoAndPosicion("FCB", "defensa"));
        System.out.println("");

        System.out.println("Jugador con mas canastas de un equipo (ejemplo BCN)");
        showStatistics3(equipoRepository.findByJugadorMaxCanastasAnotaDeEquipo("FCB"));
        System.out.println("-----------------------------------------------");


    }


    private void showStatistics(List<Object[]> statisticsList) {
        for (Object[] statistic : statisticsList) {
            System.out.println("Posicion: " + statistic[0]);
            System.out.println("AVG asistencias = " + statistic[1] + " puntos");
            System.out.println("AVG canastas= " + statistic[2] + " puntos");
            System.out.println("AVG REBOTES = " + statistic[3] + " puntos" + System.lineSeparator());
        }


    }

    private void showStatistics2(List<Object[]> statisticsList) {
        for (Object[] statistic : statisticsList) {
            System.out.println("Posicion: " + statistic[0]);
            System.out.println("AVG asistencias = " + statistic[1] + " puntos");
            System.out.println("AVG canastas= " + statistic[2] + " puntos");
            System.out.println("AVG REBOTES = " + statistic[3] + " puntos" + System.lineSeparator());
        }


    }

    private void showStatistics3(List<Object[]> statisticsList) {
        for (Object[] statistic : statisticsList) {
            System.out.println("Nombre del jugador: " + statistic[0]);
            System.out.println("MAX canastas = " + statistic[1] + System.lineSeparator());
        }
    }


}
