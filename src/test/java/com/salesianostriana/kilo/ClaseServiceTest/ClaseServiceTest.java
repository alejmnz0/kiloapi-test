package com.salesianostriana.kilo.ClaseServiceTest;

import com.salesianostriana.kilo.entities.Clase;
import com.salesianostriana.kilo.repositories.ClaseRepository;
import com.salesianostriana.kilo.services.ClaseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

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
                    .build(),
                Clase.builder()
                        .nombre("Femenino")
                        .tutor("Miguel")
                        .build()
        );
    }

}
