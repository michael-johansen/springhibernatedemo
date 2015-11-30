package mvc.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

public class Movie {
    @Min(1)
    private int id;
    @NotBlank
    @Length(max = 32)
    private String name;
    @Min(1900)
    private int year;
    @Min(1)
    @Max(100)
    private int awards;
    @Min(1)
    @Max(100)
    private int nominations;

    // Default constructor is used by spring to create new instances
    public Movie() {
    }

    public Movie(int id, String name, int year, int awards, int nominations) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.awards = awards;
        this.nominations = nominations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAwards() {
        return awards;
    }

    public void setAwards(int awards) {
        this.awards = awards;
    }

    public int getNominations() {
        return nominations;
    }

    public void setNominations(int nominations) {
        this.nominations = nominations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
