package com.example.repository;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {


    List<Equipo> findByLocalidad(String localidad);

    @Query("select jugador from Jugador jugador Where jugador.equipo.nombre = :nombre")
    List<Jugador> findByNombreEquipo(@Param("nombre") String nombre);

    @Query("select jugador from Jugador jugador Where jugador.equipo.nombre = :nombre and jugador.posicion = :posicion")
    List<Jugador> findByNombreEquipoAndPosicion(@Param("nombre") String nombre, @Param("posicion") String posicion);

    @Query("select jugador.nombre, max(jugador.canastasTotales) from Jugador jugador Where jugador.equipo.nombre = :nombre ")
    List<Object[]> findByJugadorMaxCanastasAnotaDeEquipo(@Param("nombre") String nombre);


}