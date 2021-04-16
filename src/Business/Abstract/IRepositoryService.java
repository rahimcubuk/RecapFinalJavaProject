package Business.Abstract;

import Core.Entity.IEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositoryService<T extends IEntity> {
    void add(T entity);
    void update(T entity);
    void delete(int id);
    ArrayList<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;
}
