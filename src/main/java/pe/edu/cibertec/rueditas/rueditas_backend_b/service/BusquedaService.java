package pe.edu.cibertec.rueditas.rueditas_backend_b.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas.rueditas_backend_b.dto.BuscarRequestDTO;

import java.io.IOException;

public interface BusquedaService {

    String[] buscarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException;

}
