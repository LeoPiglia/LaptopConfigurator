package org.example.configurator;

public class OperatingSystem {

    private Laptop laptopOfOperatingSystem;
    private String operatingSystemName;
    private String operatingSystemEdition;

    /**
     * Constructs an OperatingSystem with the specified laptop, name and edition
     * @param laptopOfOperatingSystem the laptop to which the operating system is associated
     * @param operatingSystemName the name of the operating system
     * @param operatingSystemEdition the edition of the operating system
     */

    public OperatingSystem(Laptop laptopOfOperatingSystem, String operatingSystemName, String operatingSystemEdition) {
        this.laptopOfOperatingSystem = laptopOfOperatingSystem;
        this.operatingSystemName = operatingSystemName;
        this.operatingSystemEdition = operatingSystemEdition;
    }

    /**
     * Clones the OperatingSystem object
     * @param laptop the laptop to which the OperatingSystem object is associated
     * @return a new OperatingSystem object
     */

    public OperatingSystem clone(Laptop laptop) {
        return new OperatingSystem(laptop, this.operatingSystemName, this.operatingSystemEdition);
    }

    /**
     * @return the laptop to which the operating system is associated
     */

    public Laptop getLaptopOfOperatingSystem() {
        return laptopOfOperatingSystem;
    }

    /**
     * sets the laptop to which the operating system is associated
     * @param laptopOfOperatingSystem the laptop to which the operating system is associated
     */

    public void setLaptopOfOperatingSystem(Laptop laptopOfOperatingSystem) {
        this.laptopOfOperatingSystem = laptopOfOperatingSystem;
    }

    /**
     * @return the name of the operating system
     */

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    /**
     * sets the name of the operating system
     * @param operatingSystemName the name of the operating system
     */

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    /**
     * @return the edition of the operating system
     */

    public String getOperatingSystemEdition() {
        return operatingSystemEdition;
    }

    /**
     * sets the edition of the operating system
     * @param operatingSystemEdition the edition of the operating system
     */

    public void setOperatingSystemEdition(String operatingSystemEdition) {
        this.operatingSystemEdition = operatingSystemEdition;
    }

    /**
     * @return the name of the operating system
     */

    @Override
    public String toString() {
        return "OperatingSystem{" +
                ", operatingSystemName='" + operatingSystemName +
                ", operatingSystemEdition='" + operatingSystemEdition + '\'' +
                '}';
    }
}
