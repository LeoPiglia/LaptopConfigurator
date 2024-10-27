package org.example.configurator;

/**
 * This class represents an accessory of a laptop
 */
public class Accessory {
    private Laptop AccessoryOfLaptop;
    private String ConnectionType;


    /**
     * Constructs an Accessory with the specified laptop and connection type
     * @param AccessoryOfLaptop the laptop to which the accessory is associated
     * @param ConnectionType the connection type of the accessory
     */
    public Accessory(Laptop AccessoryOfLaptop, String ConnectionType) {
        this.AccessoryOfLaptop = AccessoryOfLaptop;
        this.ConnectionType = ConnectionType;
    }

    /** create a clone of the accessory with the specified laptop
     * @param laptop the laptop to which the accessory is associated
     * @return a new accessory object with the same attributes of the original one
     */


    public Accessory clone(Laptop laptop) {
        return new Accessory(this.AccessoryOfLaptop, this.ConnectionType);
    }

    /**
     *
     * @return the laptop to which the accessory is associated
     */
    public Laptop getAccessoryOfLaptop() {
        return AccessoryOfLaptop;
    }

    /**
     * sets the laptop to which the accessory is associated
     * @param AccessoryOfLaptop the laptop to which the accessory is associated
     */
    public void setAccessoryOfLaptop(Laptop AccessoryOfLaptop) {
        this.AccessoryOfLaptop = AccessoryOfLaptop;
    }

    /**
     *
     * @return the connection type of the accessory
     */
    public String getConnectionType() {
        return ConnectionType;
    }

    /**
     * sets the connection type of the accessory
     * @param ConnectionType the connection type of the accessory
     */
    public void setConnectionType(String ConnectionType) {
        this.ConnectionType = ConnectionType;
    }
}
