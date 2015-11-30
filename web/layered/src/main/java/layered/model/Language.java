package layered.model;

import javax.persistence.*;

@Entity(name = "CountryLanguage")
public class Language {
    @Id
    @Column(name = "Id")
    private Long id;
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    @ManyToOne
    private Country country;
    @Column(name = "Language")
    private String language;
    @Column(name = "IsOfficial")
    private String isOfficial;
    @Column(name = "Percentage")
    private String percentage;

    public Long getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public String getPercentage() {
        return percentage;
    }
}
