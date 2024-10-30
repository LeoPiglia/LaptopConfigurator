package org.example.configurator;

public class Port {

    /**
     * Represents a port on a laptop.
     */
    private Laptop laptopOfPort;

    /**
     * Constructs a Port with the specified laptop
     * @param laptopOfPort the laptop to which the port is associated
     */
    public Port(Laptop laptopOfPort) {
        this.laptopOfPort = laptopOfPort;
    }

    /**
     *
     * @return the laptop to which the port is associated
     */
    public Laptop getLaptopOfPort() {
        return laptopOfPort;
    }

    /**
     *
     * @param laptopOfPort the laptop to which the port is associated
     */
    public void setLaptopOfPort(Laptop laptopOfPort) {
        this.laptopOfPort = laptopOfPort;
    }

    /**
     * Clones the Port object
     * @return a new Port object
     */

    public Port clone(Laptop laptop) {
        return new Port(this.laptopOfPort);
    }

    /**
     *
     * @return the laptop to which the Port object is associated
     */

    public String toString() {
        return laptopOfPort.toString();
    }
}
