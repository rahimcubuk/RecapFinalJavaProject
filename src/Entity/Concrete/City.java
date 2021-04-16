package Entity.Concrete;

import Core.Entity.IEntity;

public class City implements IEntity {

    private int id;
    private int population;
    private String name;
    private String countryCode;
    private String district;

    public City(int id, int population, String name, String countryCode, String district) {
        this.setId(id);
        this.setPopulation(population);
        this.setName(name);
        this.setCountryCode(countryCode);
        this.setDistrict(district);
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
