package com.example.siontravel.Controller;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Repository.AreasRepository;
import com.example.siontravel.Model.Services.AreasInterfacesServices;
import com.example.siontravel.Model.Services.RutasInterfacesServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class HomeControllerTest {
    @Mock
    private AreasRepository areasRepository;

    @Mock
    private AreasInterfacesServices areasInterfacesServices;

    @Mock
    private RutasInterfacesServices rutasInterfacesServices;

    private Areas areas;

    @BeforeEach
    void stepUp(){
        MockitoAnnotations.initMocks(this);
        areas = new Areas();
        areas.setNombre("Cartagena");
        areas.setDireccion("Terminal de Cartagena");
        areas.setHabilitado(1);
        areas.setId(12);
    }

    @Test
    void index() {
         when(areasRepository.findAll()).thenReturn(Arrays.asList(areas));
         assertNotNull(areasInterfacesServices.listarAreasHabilitadas());
    }

    @Test
    void booking() {
        assertNotNull(rutasInterfacesServices.onWayTrip(1,2,"2023-03-27", 2));
        assertNotNull(rutasInterfacesServices.roundTrip(1,2,"2023-03-31", 2));
    }

    @Test
    void bookingConfirm() {
    }

    @Test
    void calculoDePrecioParaReserva() {
    }

    @Test
    void numeroDeReserva() {

    }

    @Test
    void guardarReserva() {
    }

    @Test
    void testIndexAdmin() {
    }

    @Test
    void indexLogin() {
    }

    @Test
    void menu() {
    }

    @Test
    void user() {
    }
}