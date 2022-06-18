
//This is a worker class for Address entity
//In this class I will create all the attributes for this entity.
//In this class I will be creating getters and setters for this entity
//This is a Address.java
package za.ac.cput.domain.details;


import javax.persistence.*;
import java.util.Objects;

/**
 * @uthor Chuma Nxazonke
 * Student number: 219181187
 * Date: 10 June 2022
 */

@Embeddable
public class Address {
//
    private String unitNumber;
    private String complexName;
    private String streetNumber;
    private String streetName;
    private int postalCode;


    @ManyToOne(targetEntity = City.class,cascade = CascadeType.ALL)
    private City city;

    protected Address() {
    }


    public Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
        this.streetName= builder.streetName;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getStreetName() {
        return streetName;
    }


    public City getCity() {
        return city;
    }


    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }


    public static class Builder {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private City city;
        private int postalCode;

        public Builder UnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder ComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder StreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder StreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder PostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder City(City city) {
            this.city = city;
            return this;
        }

        public Builder copy(Address address) {
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }
}
