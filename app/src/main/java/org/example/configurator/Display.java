package org.example.configurator;

public class Display extends HardwareComponent{

    private String displayName;
    private String displayResolution;

    /**
     * Constructs a Display object with the specified laptop, name and resolution
     * @param laptopOfHardwareComponent the laptop to which the Display object is associated
     * @param displayName the name of the Display
     * @param displayResolution the resolution of the Display
     */

    public Display(Laptop laptopOfHardwareComponent, String displayName, String displayResolution) {
        super(laptopOfHardwareComponent);
        this.displayName = displayName;
        this.displayResolution = displayResolution;
    }

    /**
     * Clones the Display object
     * @return a new Display object
     */

    @Override
    public HardwareComponent clone() {
        return new Display(this.getLaptopOfHardwareComponent(), this.displayName, this.displayResolution);
    }

    /**
     * Get the name of the Display
     * @return the name of the Display
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the name of the Display
     * @param displayName the name of the Display
     */

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the resolution of the Display
     * @return the resolution of the Display
     */

    public String getDisplayResolution() {
        return displayResolution;
    }

    /**
     * Set the resolution of the Display
     * @param displayResolution the resolution of the Display
     */

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    /**
     * @return a string representation of the Display object
     */

    @Override
    public String toString() {
        return displayName + " " + displayResolution;
    }



}
