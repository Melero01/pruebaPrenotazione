
import com.app.pruebaprenotazione.model.Buscar;
import com.app.pruebaprenotazione.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarService{
    public List<Hotel> BotonBuscar(Buscar buscar, List<Hotel> listaHoteles){
        String srtBuscar;
        List<Hotel> coincidan = new ArrayList<>();
        srtBuscar = buscar.getHotelBuscar().toLowerCase();
        for(Hotel hoteles : listaHoteles) {
            if ((hoteles.getLocalizacion().toLowerCase().contains(srtBuscar)) ||
                    (hoteles.getNombre().toLowerCase().contains(srtBuscar))) {
                coincidan.add(hoteles);
            }
        }
        return coincidan;
    }
}

