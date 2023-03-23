package com.example.siontravel.APIREST;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Services.AreasInterfacesServices;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.SocketOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ApiRestTest {

    @Autowired
    private AreasInterfacesServices areasInterfacesServices;

    @Autowired
    private ApiRest apiRest;
    @Test
    public void obtenerTodasLasAreas(){
        Areas areas = Mockito.mock(Areas.class);
        List<Areas> listaAreas = areasInterfacesServices.listarAreasHabilitadas();
        Assertions.assertThat(listaAreas.size()).isGreaterThan(0);
        List<?> getAreas = apiRest.getRutaForIdArea(1);
        //Assertions.assertThat(getAreas.size()).isGreaterThan(0);
        assertNotNull(getAreas);
    }
}