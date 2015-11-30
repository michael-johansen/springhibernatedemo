package hibernate.simple;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Database assigns value
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "CountryCode")
    private String countryCode;
    @Column(name = "District")
    private String district;
    @Column(name = "Population")
    private int population;

    /** Default constructor required by Hibernate, if no constructors are specified Java will add a default constructor.
     */
    public City() {
    }

    public City(String name, String countryCode, String district, int population) {
        this();
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, countryCode);
    }

    /**
     * https://developer.jboss.org/wiki/EqualsandHashCode?_sscc=t
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
//        return Objects.equals(name, city.name) && Objects.equals(countryCode, city.countryCode);
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(name, countryCode);
        return Objects.hash(id);
    }
}
