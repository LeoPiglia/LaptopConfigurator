package org.example.configurator;

/**
 * Represents the Mouse object of a laptop.
 */
public class Mouse extends Accessory {

    private String mouseName;
    /**
     * Constructs a Mouse object with the specified laptop and connection type
     * @param AccessoryOfLaptop the laptop to which the Mouse object is associated
     * @param ConnectionType the connection type of the Mouse object
     */

    public Mouse(Laptop AccessoryOfLaptop, String ConnectionType, String mouseName) {
        super(AccessoryOfLaptop, ConnectionType);
        this.mouseName = mouseName;
    }

    /**
     * Clones the Mouse object
     * @param laptop the laptop to which the Mouse object is associated
     * @return a new Mouse object
     */

    @Override
    public Accessory clone(Laptop laptop) {
        return new Mouse(laptop, this.getConnectionType(), this.mouseName);
    }

    /**
     *
     * @return the laptop to which the Mouse object is associated
     */
    @Override
    public String toString() {
        return "Mouse{" +
                "laptopOfMouse=" + getAccessoryOfLaptop() +
                ", ConnectionType='" + getConnectionType() + '\'' +
                '}';
    }


}
