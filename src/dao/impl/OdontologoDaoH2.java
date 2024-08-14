package dao.impl;

import dao.IDao;
import db.H2Connection;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger logger = LogManager.getLogger(OdontologoDaoH2.class);

    public OdontologoDaoH2() {
        try (Connection connection = H2Connection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("RUNSCRIPT FROM 'classpath:create.sql'");
        } catch (SQLException e) {
            logger.error("Error al crear la tabla odontologos", e);
        }
    }

    @Override
    public void guardar(Odontologo odontologo) {
        String sql = "INSERT INTO odontologos (numero_matricula, nombre, apellido) VALUES (?, ?, ?)";
        try (Connection connection = H2Connection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            logger.info("Odontólogo guardado: " + odontologo);
        } catch (SQLException e) {
            logger.error("Error al guardar el odontólogo", e);
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        String sql = "SELECT * FROM odontologos";
        try (Connection connection = H2Connection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Odontologo odontologo = new Odontologo(
                        resultSet.getString("numero_matricula"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido")
                );
                odontologos.add(odontologo);
            }
            logger.info("Odontólogos listados: " + odontologos);
        } catch (SQLException e) {
            logger.error("Error al listar los odontólogos", e);
        }
        return odontologos;
    }
}