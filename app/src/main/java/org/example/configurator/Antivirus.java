package org.example.configurator;

public class Antivirus extends Security {

    private String antivirusVersion;


    public Antivirus(Laptop laptopOfSecurity, String antivirusVersion) {
        super(laptopOfSecurity);
        this.antivirusVersion = antivirusVersion;
    }

    /**
     * Clones the Antivirus object
     * @param laptop the laptop to which the Antivirus object is associated
     * @return a new Antivirus object
     */

    @Override
    public Security clone(Laptop laptop) {
        return new Antivirus(laptop, this.antivirusVersion);
    }

    /**
     * Get the version of the antivirus
     * @return the version of the antivirus
     */
    public String getAntivirusVersion() {
        return antivirusVersion;
    }

    /**
     * Set the version of the antivirus
     * @param antivirusVersion the version of the antivirus
     */
    public void setAntivirusVersion(String antivirusVersion) {
        this.antivirusVersion = antivirusVersion;
    }

    /**
     *
     * @return a string representation of the Antivirus object
     */
    @Override
    public String toString() {
        return "Antivirus{" +
                "laptopOfAntivirus=" + getLaptopOfSecurity() +
                ", antivirusVersion='" + antivirusVersion + '\'' +
                '}';
    }
}
