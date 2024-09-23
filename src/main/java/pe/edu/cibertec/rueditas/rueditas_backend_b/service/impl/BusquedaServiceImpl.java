package pe.edu.cibertec.rueditas.rueditas_backend_b.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas.rueditas_backend_b.dto.BuscarRequestDTO;
import pe.edu.cibertec.rueditas.rueditas_backend_b.service.BusquedaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class BusquedaServiceImpl implements BusquedaService  {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarVehiculo(BuscarRequestDTO buscarRequestDTO) throws IOException {

        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){

            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(";");
                if (buscarRequestDTO.numeroPlaca().equals(datos[1])) {

                    datosVehiculo = new String[7];
                    datosVehiculo[0] = datos[0]; // Recuperando id
                    datosVehiculo[1] = datos[1]; // Recuperando placa
                    datosVehiculo[2] = datos[2]; // Recuperando marca
                    datosVehiculo[3] = datos[3]; // Recuperando modelo
                    datosVehiculo[4] = datos[4]; // Recuperando Nro de Asientos
                    datosVehiculo[5] = datos[5]; // Recuperando precio
                    datosVehiculo[6] = datos[6]; // Recuperando color

                }
            }

        } catch (IOException e){
            datosVehiculo = null;
            throw new IOException(e);
        }

        return datosVehiculo;
    }
}
