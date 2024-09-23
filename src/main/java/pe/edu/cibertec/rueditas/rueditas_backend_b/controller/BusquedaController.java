package pe.edu.cibertec.rueditas.rueditas_backend_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas.rueditas_backend_b.dto.BuscarRequestDTO;
import pe.edu.cibertec.rueditas.rueditas_backend_b.dto.BuscarResponseDTO;
import pe.edu.cibertec.rueditas.rueditas_backend_b.service.BusquedaService;

@RestController
@RequestMapping("/busqueda")
public class BusquedaController {

    @Autowired
    BusquedaService busquedaService;

    @PostMapping("/resultado")
    public BuscarResponseDTO resultado(@RequestBody BuscarRequestDTO buscarRequestDTO) {

        try {
            String[] datosVehiculo = busquedaService.buscarVehiculo(buscarRequestDTO);
            if (datosVehiculo == null) {
                return new BuscarResponseDTO("01", "Error: Vehiculo no encontrado", "", "", "", "", 0, 0, "");
            }
            return new BuscarResponseDTO("00", "", datosVehiculo[0], datosVehiculo[1], datosVehiculo[2],
                    datosVehiculo[3], Integer.valueOf(datosVehiculo[4]), Integer.valueOf(datosVehiculo[5]), datosVehiculo[6]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new BuscarResponseDTO("99", "Error: Ocurrió un problema", "", "", "", "", 0, 0, "");
        }
    }
}