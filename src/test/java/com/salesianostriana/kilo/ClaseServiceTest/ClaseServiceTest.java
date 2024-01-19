package com.salesianostriana.kilo.ClaseServiceTest;

import com.salesianostriana.kilo.entities.Aportacion;
import com.salesianostriana.kilo.entities.Clase;
import com.salesianostriana.kilo.repositories.ClaseRepository;
import com.salesianostriana.kilo.services.ClaseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class ClaseServiceTest {

    @Mock
    ClaseRepository claseRepository;

    @InjectMocks
    ClaseService claseService;

    @Test
    void getRankingTest (){

        List<Clase> data = List.of(
            Clase.builder()
                    .nombre("Frutos secos")
                    .tutor("Luismi")
                    .aportaciones(Set.of(Aportacion.builder()
                            .fecha(LocalDate.now()).build()))
                    .build(),
                Clase.builder()
                        .nombre("Femenino")
                        .tutor("Miguel")
                        .aportaciones(Set.of(Aportacion.builder()
                                .fecha(LocalDate.now()).build()))
                        .build(),
                Clase.builder()
                        .nombre("Colectivo")
                        .tutor("Jesus")
                        .aportaciones(Set.of(Aportacion.builder()
                                .fecha(LocalDate.now()).build(),
                                Aportacion.builder()
                                        .fecha(LocalDate.now()).build()))
                        .build()
        );
    }

}
