package service;

import dao.IDao;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public void guardarOdontologo(Odontologo odontologo) {
        odontologoDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos() {
        return odontologoDao.listarTodos();
    }
}