package com.salesianostriana.kilo.kilosDisponiblesTest;

import com.salesianostriana.kilo.repositories.AportacionRepository;
import com.salesianostriana.kilo.services.TipoAlimentoSaveService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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


    @Test
    void cambiarKiosDetalle(){
        
    }


}
