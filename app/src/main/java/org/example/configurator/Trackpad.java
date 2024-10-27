package org.example.configurator;

/**
 * Class representing a trackpad of a laptop
 */
public class Trackpad extends HardwareComponent {

    private String trackpadDimensions;
    private String trackpadName;

    /**
     * Constructs a Trackpad object with the specified laptop, dimensions and name
     * @param laptopOfHardwareComponent the laptop to which the Trackpad object is associated
     * @param trackpadDimensions the dimensions of the Trackpad
     * @param trackpadName the name of the Trackpad
     */
    public Trackpad(Laptop laptopOfHardwareComponent, String trackpadDimensions, String trackpadName) {
        super(laptopOfHardwareComponent);
        this.trackpadDimensions = trackpadDimensions;
        this.trackpadName = trackpadName;
    }

    /**
     * Clones the Trackpad object
     * @return a new Trackpad object
     */
    @Override
    public HardwareComponent clone() {
        return new Trackpad(this.getLaptopOfHardwareComponent(), this.trackpadDimensions, this.trackpadName);
    }

    /**
     * Get the dimensions of the Trackpad
     * @return the dimensions of the Trackpad
     */
    public String getTrackpadDimensions() {
        return trackpadDimensions;
    }

    /**
     * Set the dimensions of the Trackpad
     * @param trackpadDimensions the dimensions of the Trackpad
     */
    public void setTrackpadDimensions(String trackpadDimensions) {
        this.trackpadDimensions = trackpadDimensions;
    }

    /**
     * Get the name of the Trackpad
     * @return the name of the Trackpad
     */
    public String getTrackpadName() {
        return trackpadName;
    }

    /**
     * Set the name of the Trackpad
     * @param trackpadName the name of the Trackpad
     */
    public void setTrackpadName(String trackpadName) {
        this.trackpadName = trackpadName;
    }

    /**
     * Returns a string representation of the Trackpad object
     * @return a string representation of the Trackpad object
     */
    @Override
    public String toString() {
        return "Trackpad{" +
                "trackpadDimensions='" + trackpadDimensions + '\'' +
                ", trackpadName='" + trackpadName + '\'' +
                '}';
    }


}
