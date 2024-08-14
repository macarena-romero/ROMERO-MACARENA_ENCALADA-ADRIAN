package test;

import dao.impl.OdontologoDaoH2;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoServiceTest {
    private OdontologoService odontologoService;

    @BeforeEach
    public void setUp() {
        odontologoService = new OdontologoService(new OdontologoDaoH2());
    }

    @Test
    public void testListarTodos() {
        Odontologo odontologo1 = new Odontologo("123", "Juan", "Pérez");
        Odontologo odontologo2 = new Odontologo("456", "Ana", "García");

        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);

        List<Odontologo> odontologos = odontologoService.listarTodos();

        assertEquals(2, odontologos.size());
        assertEquals(odontologo1, odontologos.get(0));
        assertEquals(odontologo2, odontologos.get(1));
    }
}
