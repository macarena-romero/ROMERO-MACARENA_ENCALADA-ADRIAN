package dao.impl;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
public class OdontologoDaoMemoria implements IDao<Odontologo> {
    private static final Logger logger = LogManager.getLogger(OdontologoDaoMemoria.class);
    private List<Odontologo> odontologos;

    public OdontologoDaoMemoria() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado: " + odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Odontólogos listados: " + odontologos);
        return odontologos;
    }
}
