package dao;

import java.util.List;

public interface IDao<T> {
    void guardar(T t);
    List<T> listarTodos();
}