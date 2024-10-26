package org.example.configurator;

/**
 * Abstract class representing a hardware component of a laptop
 */
public abstract class HardwareComponent {

    private Laptop laptopOfHardwareComponent;

    /**
     * constructor to associate the hardware component with a specific laptop
     * @param laptopOfHardwareComponent the laptop to which the hardware component is associated
     */
    public HardwareComponent(Laptop laptopOfHardwareComponent) {
        this.laptopOfHardwareComponent = laptopOfHardwareComponent;
    }

    /**
     * Default constructor for creating a hardware component
     */
    public HardwareComponent() {}

    /**
     * @return the laptop to which the hardware component is associated
     */
    public Laptop getLaptopOfHardwareComponent () {
        return laptopOfHardwareComponent;
    }

    /**
     * sets the laptop to which the hardware component is associated
     * @param laptopOfHardwareComponent the laptop to which the hardware component is associated
     */
    public void setLaptopOfHardwareComponent (Laptop laptopOfHardwareComponent) {
        this.laptopOfHardwareComponent = laptopOfHardwareComponent;
    }

    /** abstract method to clone the hardware component
     * @return a new hardware component instance with the same attributes of the original one
     */
    @Override
    public abstract HardwareComponent clone();
}

