package org.example.configurator;

public class Antivirus extends Security {

    private String antivirusName;
    private String antivirusVersion;



    public Antivirus(Laptop laptopOfSecurity, String antivirusName, String antivirusVersion) {
        super(laptopOfSecurity);
        this.antivirusVersion = antivirusVersion;
        this.antivirusName = antivirusName;
    }

    /**
     * Clones the Antivirus object
     * @param laptop the laptop to which the Antivirus object is associated
     * @return a new Antivirus object
     */

    @Override
    public Security clone(Laptop laptop) {
        return new Antivirus(laptop, this.antivirusName, this.antivirusVersion);
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
     * Get the name of the antivirus
     * @return the name of the antivirus
     */

    public String getAntivirusName() {
        return antivirusName;
    }

    /**
     * Set the name of the antivirus
     * @param antivirusName the name of the antivirus
     */

    public void setAntivirusName(String antivirusName) {
        this.antivirusName = antivirusName;
    }

    /**
     *
     * @return a string representation of the Antivirus object
     */
    @Override
    public String toString() {
        return antivirusName + " " + antivirusVersion;
    }
}
