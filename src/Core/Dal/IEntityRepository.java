package Core.Dal;

import Core.Entity.IEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEntityRepository<T extends IEntity> {
    void add(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
    T getById(int id) throws SQLException;
    ArrayList<T> get() throws SQLException;
}
