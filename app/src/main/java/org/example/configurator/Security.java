package org.example.configurator;

/**
 * Represents the Security object of a laptop.
 */
public class Security {

    private Laptop laptopOfSecurity;

    /**
     * Constructs a Security object with the specified laptop
     * @param laptopOfSecurity the laptop to which the Security object is associated
     */
    public Security(Laptop laptopOfSecurity) {
        this.laptopOfSecurity = laptopOfSecurity;
    }

    /**
     *
     * @return the laptop to which the Security object is associated
     */
    public Laptop getLaptopOfSecurity() {
        return laptopOfSecurity;
    }

    /**
     * sets the laptop to which the Security object is associated
     * @param laptopOfSecurity the laptop to which the Security object is associated
     */
    public void setLaptopOfSecurity(Laptop laptopOfSecurity) {
        this.laptopOfSecurity = laptopOfSecurity;
    }

    /**
     * Clones the Security object
     * @param laptop the laptop to which the Security object is associated
     * @return a new Security object
     */
    public Security clone(Laptop laptop) {
        return new Security(laptopOfSecurity);
    }
}
