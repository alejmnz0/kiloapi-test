package com.salesianostriana.kilo.kilosDisponiblesTest;

import com.salesianostriana.kilo.entities.Aportacion;
import com.salesianostriana.kilo.entities.DetalleAportacion;
import com.salesianostriana.kilo.entities.KilosDisponibles;
import com.salesianostriana.kilo.entities.TipoAlimento;
import com.salesianostriana.kilo.repositories.AportacionRepository;
import com.salesianostriana.kilo.services.AportacionService;
import com.salesianostriana.kilo.services.TipoAlimentoSaveService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CambiarKilosDetalleTest {

    /*
    public Optional<Aportacion> cambiarKilosDetalle(DetalleAportacion detalle, double kgNuevos){

        double result = kgNuevos - detalle.getCantidadKg();
        double kilosActuales = detalle.getTipoAlimento().getKilosDisponibles().getCantidadDisponible();
        double kilosNuevos = (double) Math.round((kilosActuales + result) *100d) /100d;

        if(result < 0){
            if(kilosActuales < result*-1)
                return Optional.empty();
            else{
                detalle.getTipoAlimento().getKilosDisponibles().setCantidadDisponible(
                        kilosNuevos
                );
                detalle.setCantidadKg(kgNuevos);
                tipoAlimentoSaveService.save(detalle.getTipoAlimento());
                return Optional.of(aportacionRepository.save(detalle.getAportacion()));
            }
        }
        else{
            detalle.getTipoAlimento().getKilosDisponibles().setCantidadDisponible(
                    kilosNuevos
            );
            detalle.setCantidadKg(kgNuevos);
            tipoAlimentoSaveService.save(detalle.getTipoAlimento());
            return Optional.of(aportacionRepository.save(detalle.getAportacion()));
        }
    }
    */
    @Mock
    AportacionRepository aportacionRepository;

    @InjectMocks
    TipoAlimentoSaveService tipoAlimentoSaveService;

    @InjectMocks
    AportacionService aportacionService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize annotated mocks
        aportacionService.setTipoAlimentoSaveService(tipoAlimentoSaveService);
        aportacionService.setAportacionRepository(aportacionRepository);
    }

    @Test
    public void ChangeKilosDetailsResultGreaterOrEqualTo0Test() {

        KilosDisponibles kilosDisponibles = KilosDisponibles.builder()
                .cantidadDisponible(12d)
                .build();

        TipoAlimento tipoAlimento = TipoAlimento.builder()
                .kilosDisponibles(kilosDisponibles)
                .build();

        DetalleAportacion detalle = DetalleAportacion.builder()
                .tipoAlimento(tipoAlimento)
                .cantidadKg(21)
                .build();

        Aportacion aportacion = Aportacion.builder()
                .detalleAportaciones(List.of(detalle))
                .build();

        detalle.setAportacion(aportacion);

        when(tipoAlimentoSaveService.save(detalle.getTipoAlimento())).thenReturn(tipoAlimento);
        when(aportacionRepository.save(detalle.getAportacion())).thenReturn(aportacion);

        Optional<Aportacion> result = aportacionService.cambiarKilosDetalle(detalle, 15.0);

        Assertions.assertEquals(15, result.get().getDetalleAportaciones().get(0).getCantidadKg());
        Assertions.assertEquals(15,tipoAlimento.getKilosDisponibles().getCantidadDisponible());
        Assertions.assertEquals(15, detalle.getCantidadKg());

        verify(tipoAlimentoSaveService, times(1)).save(any(TipoAlimento.class));
        verify(aportacionRepository, times(1)).save(any(Aportacion.class));

    }

    @Test
    public void ChangeKilosDetailsResultLesserThan0Test() {

        KilosDisponibles kilosDisponibles = KilosDisponibles.builder()
                .cantidadDisponible(10d)
                .build();

        TipoAlimento tipoAlimento = TipoAlimento.builder()
                .kilosDisponibles(kilosDisponibles)
                .build();

        DetalleAportacion detalle = DetalleAportacion.builder()
                .tipoAlimento(tipoAlimento)
                .cantidadKg(10)
                .build();

        Aportacion aportacion = Aportacion.builder()
                .detalleAportaciones(List.of(detalle))
                .build();

        detalle.setAportacion(aportacion);

        when(tipoAlimentoSaveService.save(detalle.getTipoAlimento())).thenReturn(tipoAlimento);
        when(aportacionRepository.save(detalle.getAportacion())).thenReturn(aportacion);

        Optional<Aportacion> result = aportacionService.cambiarKilosDetalle(detalle, 5.0);

        Assertions.assertEquals(5, result.get().getDetalleAportaciones().get(0).getCantidadKg());
        Assertions.assertEquals(5,tipoAlimento.getKilosDisponibles().getCantidadDisponible());
        Assertions.assertEquals(5, detalle.getCantidadKg());

        verify(tipoAlimentoSaveService, times(1)).save(any(TipoAlimento.class));
        verify(aportacionRepository, times(1)).save(any(Aportacion.class));
    }



}
