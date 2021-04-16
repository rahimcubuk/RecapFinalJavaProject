package Dal.Concrete;

import Core.Helpers.DbHelper;
import Core.Helpers.MySqlHelper;
import Dal.Abstract.ICityDal;
import Entity.Concrete.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlCityDal implements ICityDal {
    private DbHelper dbHelper = new MySqlHelper();
    private Connection connection = null;

    public MySqlCityDal() {
    }

    @Override
    public void add(City entity) throws SQLException {
        PreparedStatement statement = null;
        String sorgu = "insert into city (Name, CountryCode, District, Population) values (?,?,?,?)";
        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement(sorgu);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getCountryCode());
            statement.setString(3, entity.getDistrict());
            statement.setInt(4, entity.getPopulation());
            statement.executeUpdate();
            System.out.println("Kayıt Eklendi.");
        } catch (SQLException exception) {
            dbHelper.showDbErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public void update(City entity) throws SQLException {
        PreparedStatement statement = null;
        String sorgu = "update City set Name=?, CountryCode=?, District=?, Population=? where ID=?";
        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement(sorgu);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getCountryCode());
            statement.setString(3, entity.getDistrict());
            statement.setInt(4, entity.getPopulation());
            statement.setInt(5, entity.getId());
            statement.executeUpdate();
        } catch (SQLException exception) {
            dbHelper.showDbErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
       PreparedStatement statement = null;
       String sorgu = "delete from City where id=?";
       try {
           connection = dbHelper.getConnection();
           statement = connection.prepareStatement(sorgu);
           statement.setInt(1,id);
           statement.executeUpdate();
       }catch (SQLException exception){
           dbHelper.showDbErrorMessage(exception);
       }
       finally {
           statement.close();
           connection.close();
       }
    }

    @Override
    public City getById(int id) throws SQLException {
        City city = new City();
        String sorgu = "select * from city where id=" + id;
        try {
            connection = dbHelper.getConnection();
            ResultSet result = dbHelper.getData(connection, sorgu);
            while (result.next()) {
                city.setId(result.getInt("id"));
                city.setPopulation(result.getInt("population"));
                city.setName(result.getString("name"));
                city.setCountryCode(result.getString("countryCode"));
                city.setDistrict(result.getString("district"));
            }
        } catch (SQLException exception) {
            dbHelper.showDbErrorMessage(exception);
        } finally {
            connection.close();
        }
        return city;
    }

    @Override
    public ArrayList<City> get() throws SQLException {
        ArrayList<City> cities = new ArrayList<>();
        String sorgu = "select * from city where countrycode='TUR'";
        try {
            connection = dbHelper.getConnection();
            ResultSet result = dbHelper.getData(connection, sorgu);
            while (result.next()) {
                cities.add(new City(
                        result.getInt("id"),
                        result.getInt("population"),
                        result.getString("name"),
                        result.getString("countryCode"),
                        result.getString("district")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showDbErrorMessage(exception);
        } finally {
            connection.close();
        }
        System.out.println("Toplam Kayıt: " + cities.size());
        return cities;
    }
}
