import Business.Concrete.CityManager;
import Dal.Abstract.ICityDal;
import Dal.Concrete.MySqlCityDal;
import Entity.Concrete.City;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<City> cities;

        City city = new City(4090,3000, "Suleymanli","TUR","Manisa");
        CityManager cityManager = new CityManager(new MySqlCityDal());

        getCities(cityManager);

        getCityById(cityManager,1);

        addCity(cityManager, city);

        updateCity(cityManager);
        deleteCity(cityManager, 4090);

    }

    private static void deleteCity(CityManager cityManager, int id) {
        cityManager.delete(id);
        getCityById(cityManager,id);
    }

    private static void updateCity(CityManager cityManager) {
        City city2 = new City(4090,3000, "Suleymanli","TUR","Akhisar");
        cityManager.update(city2);
        getCityById(cityManager,4090);
    }

    private static void addCity(CityManager cityManager, City city) {
        cityManager.add(city);
    }

    private static void getCityById(CityManager cityManager, int id) {
        try {
            City city = cityManager.getById(id);
            System.out.println(city.getId() + " - " + city.getName());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void getCities(CityManager cityManager) {
        ArrayList<City> cities;
        try {
            cities = cityManager.getAll();
            for (City city : cities) {
                System.out.println(city.getId() + " - " + city.getName());
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
