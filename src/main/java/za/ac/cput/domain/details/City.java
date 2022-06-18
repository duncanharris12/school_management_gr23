package za.ac.cput.domain.details;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;


/*City.java
@Author Nolubabalo Ndongeni 219319464
Date: 10 June 2022
*/
@Entity
public class City implements Serializable {

    @Id
    private String id;
    private String name;

    //@OneToMany(targetEntity = Country.class, mappedBy ="id",
                   // fetch = FetchType.LAZY,cascade = CascadeType.ALL);

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public void setCountry(Country country) {
        this.country = country;
    }


    protected City(){}

    public City(Builder builder)
    {
        this.id =builder.id;
        this.name = builder.name;
        this.country = builder.country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry(){
        return country;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        City cityId = (City) obj;
        return id.equals(cityId.id);
    }

    @Override
    public String toString()
    {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", [country=" + country + ", id="+ id + ", name="+ name+"]";

    }

    public static class Builder {
        private String id;
        private String name;
        private Country country;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCountry(Country country) {
            this.country = country;
            return this;
        }

        public Builder copy(City city) {
            this.id = city.id;
            this.name = city.name;
            this.country = (Country)city.country;
            return this;
        }

        public City build() {
            return new City(this);
        }

    }

}
