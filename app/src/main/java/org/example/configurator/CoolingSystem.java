package org.example.configurator;

public class CoolingSystem {

    private Laptop laptopOfCoolingSystem;
    private String coolingSystemName;
    private String coolingSystemType;

    /**
     * Constructs a CoolingSystem with the specified laptop, name and type
     *
     * @param laptopOfCoolingSystem the laptop to which the cooling system is associated
     * @param coolingSystemName     the name of the cooling system
     * @param coolingSystemType     the type of the cooling system
     */

    public CoolingSystem(Laptop laptopOfCoolingSystem, String coolingSystemName, String coolingSystemType) {
        this.laptopOfCoolingSystem = laptopOfCoolingSystem;
        this.coolingSystemName = coolingSystemName;
        this.coolingSystemType = coolingSystemType;
    }

    /**
     * Clones the CoolingSystem object
     *
     * @param laptop the laptop to which the CoolingSystem object is associated
     * @return a new CoolingSystem object
     */

    public CoolingSystem clone(Laptop laptop) {
        return new CoolingSystem(laptop, this.coolingSystemName, this.coolingSystemType);
    }

    /**
     * @return the laptop to which the cooling system is associated
     */

    public Laptop getLaptopOfCoolingSystem() {
        return laptopOfCoolingSystem;
    }

    /**
     * sets the laptop to which the cooling system is associated
     *
     * @param laptopOfCoolingSystem the laptop to which the cooling system is associated
     */

    public void setLaptopOfCoolingSystem(Laptop laptopOfCoolingSystem) {
        this.laptopOfCoolingSystem = laptopOfCoolingSystem;
    }

    /**
     * @return the name of the cooling system
     */

    public String getCoolingSystemName() {
        return coolingSystemName;
    }

    /**
     * sets the name of the cooling system
     * @param coolingSystemName the name of the cooling system
     */

    public void setCoolingSystemName(String coolingSystemName) {
        this.coolingSystemName = coolingSystemName;
    }

    /**
     * @return the type of the cooling system
     */

    public String getCoolingSystemType() {
        return coolingSystemType;
    }

    /**
     * sets the type of the cooling system
     * @param coolingSystemType the type of the cooling system
     */

    public void setCoolingSystemType(String coolingSystemType) {
        this.coolingSystemType = coolingSystemType;
    }

    /**
     * @return the laptop to which the cooling system is associated
     */

    public String toString() {
        return "CoolingSystem{" +
                "laptopOfCoolingSystem=" + laptopOfCoolingSystem +
                ", coolingSystemName='" + coolingSystemName + '\'' +
                ", coolingSystemType='" + coolingSystemType + '\'' +
                '}';
    }
}
