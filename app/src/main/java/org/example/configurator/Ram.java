package org.example.configurator;

/**
 * Represents the Ram object of a laptop.
 */
public class Ram extends HardwareComponent {

    private String ramName;
    private String ramSize;

    /**
     * Constructs a Ram object with the specified laptop, name and size
     * @param laptopOfHardwareComponent the laptop to which the Ram object is associated
     * @param ramName the name of the Ram
     * @param ramSize the size of the Ram
     */
    public Ram(Laptop laptopOfHardwareComponent, String ramName, String ramSize) {
        super(laptopOfHardwareComponent);
        this.ramName = ramName;
        this.ramSize = ramSize;
    }

    /**
     * Clones the Ram object
     * @return a new Ram object
     */
    @Override
    public HardwareComponent clone() {
        return new Ram(this.getLaptopOfHardwareComponent(), this.ramName, this.ramSize);
    }

    /**
     * Get the name of the Ram
     * @return the name of the Ram
     */
    public String getRamName() {
        return ramName;
    }

    /**
     * Set the name of the Ram
     * @param ramName the name of the Ram
     */
    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    /**
     * Get the size of the Ram
     * @return the size of the Ram
     */
    public String getRamSize() {
        return ramSize;
    }

    /**
     * Set the size of the Ram
     * @param ramSize the size of the Ram
     */
    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    /**
     * Returns a string representation of the Ram object
     * @return a string representation of the Ram object
     */
    @Override
    public String toString() {
        return ramName + " " + ramSize;
    }





}
