package com.example.repository;

import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {


    // finBy(nombre variable)nombre

    List<Jugador> findBynombre(String nombre);

    List<Jugador> findBycanastasTotalesGreaterThanEqual(Integer canastas_totales);

    List<Jugador> findByasistenciasTotalesBetween(Integer min, Integer max);

    List<Jugador> findByposicion(String posicion);

    List<Jugador> findByfechaNacimientoLessThan(String fechaNacimiento);


    //realiza el select para cumplir los requisitos del enunciado "media de asistencias totales, media de canastas totales y rebotes totales" agrupado por la posicion del jugador
    @Query("SELECT jugador.posicion, AVG(jugador.asistenciasTotales), AVG(jugador.canastasTotales), AVG(jugador.rebotesTotales) " + "FROM Jugador jugador " + "GROUP BY jugador.posicion")
    List<Object[]> AvgAndMaxAndMinPricesPerPosicion();


    @Query("SELECT jugador.posicion, AVG(jugador.asistenciasTotales), MIN(jugador.asistenciasTotales), MAX(jugador.asistenciasTotales), " +
            " AVG(jugador.canastasTotales), MIN(jugador.canastasTotales), MAX(jugador.canastasTotales), " +
            " AVG(jugador.rebotesTotales), MIN(jugador.rebotesTotales), MAX(jugador.rebotesTotales) " +
            "FROM Jugador jugador " + "GROUP BY jugador.posicion ")
    List<Object[]> AvgAndMaxAndMinPricesPerPosicionResumen();




}