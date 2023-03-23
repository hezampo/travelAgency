package com.example.siontravel.Controller;

import com.example.siontravel.Model.Entity.Rutas;
import com.example.siontravel.Model.Services.RutasImplementServices;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
class RutasControllerTest {
    @Mock
    private RutasImplementServices rutasImplementServices;
    @Ignore
    public void whenFindAllRutas(){
        Rutas rutas = Mockito.mock(Rutas.class);

        Mockito.when(rutasImplementServices.onWayTrip(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(),ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(null);

        //Mockito.when(rutasImplementServices.onWayTrip(1, 2, "2023-03-21")).thenReturn(List<?> oneway);

    }
}
