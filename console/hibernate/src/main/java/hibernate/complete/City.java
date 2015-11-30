package hibernate.complete;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    @ManyToOne
//  Inefficient query: Possible fix 2
//    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @Column(name = "District")
    private String district;
    @Column(name = "Population")
    private int population;

    public City() {
    }

    public City(String name, String district, int population) {
        this();
        this.name = name;
        this.district = district;
        this.population = population;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", name, country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(country, city.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}
