package layered.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;


@Entity(name = "Country")
public class Country {
    @Id
    @Column(name = "Code")
    private String code;
    @Column(name = "Name")
    private String name;
    @Column(name = "Continent")
    private String continent;
    @Column(name = "Region")
    private String region;
    @Column(name = "SurfaceArea")
    private String surfaceArea;
    @Column(name = "IndepYear")
    private String independenceYear;
    @Column(name = "Population")
    private String population;
    @Column(name = "LifeExpectancy")
    private String lifeExpectancy;
    @Column(name = "GNP")
    private String gnp;
    @Column(name = "GNPOld")
    private String gnpOld;
    @Column(name = "LocalName")
    private String localName;
    @Column(name = "GovernmentForm")
    private String governmentForm;
    @Column(name = "HeadOfState")
    private String headOfState;
    @Column(name = "Capital")
    private String capital;
    @Column(name = "Code2")
    private String code2;

    @OneToMany(mappedBy = "country")
    private List<City> cities;
    @OneToMany(mappedBy = "country")
    private List<Language> languages;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public String getSurfaceArea() {
        return surfaceArea;
    }

    public String getIndependenceYear() {
        return independenceYear;
    }

    public String getPopulation() {
        return population;
    }

    public String getLifeExpectancy() {
        return lifeExpectancy;
    }

    public String getGnp() {
        return gnp;
    }

    public String getGnpOld() {
        return gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public String getCapital() {
        return capital;
    }

    public String getCode2() {
        return code2;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(code, country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, code);
    }
}
