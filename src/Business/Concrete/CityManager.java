package Business.Concrete;

import Business.Abstract.ICityService;
import Dal.Abstract.ICityDal;
import Entity.Concrete.City;

import java.sql.SQLException;
import java.util.ArrayList;

public class CityManager implements ICityService {
    private ICityDal cityDal;

    public CityManager(ICityDal cityDal) {
        this.cityDal = cityDal;
    }

    @Override
    public void add(City entity) {
        try {
            cityDal.add(entity);
            System.out.println("Ekleme Başarılı.");
        } catch (SQLException exception) {
            System.out.println("HATA: " + exception.getMessage());
        }
    }

    @Override
    public void update(City entity) {
        try {
            cityDal.update(entity);
            System.out.println("Güncelleme Başarılı.");
        } catch (SQLException exception) {
            System.out.println("HATA: " + exception.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            cityDal.delete(id);
            System.out.println("Silme Başarılı.");
        } catch (SQLException exception) {
            System.out.println("HATA: " + exception.getMessage());
        }
    }

    @Override
    public ArrayList<City> getAll() throws SQLException {
        ArrayList<City> cities = cityDal.get();
        return cities;
    }

    @Override
    public City getById(int id) throws SQLException {
        return cityDal.getById(id);
    }
}
