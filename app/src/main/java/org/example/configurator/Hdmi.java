package org.example.configurator;

/**
 * Represents the Hdmi object of a laptop.
 */
public class Hdmi extends Port{

    private String hdmiVersion;

    /**
     * Constructs a Hdmi object with the specified laptop and Hdmi version
     * @param laptopOfPort the laptop to which the Hdmi object is associated
     * @param hdmiVersion the Hdmi version of the Hdmi object
     */

    public Hdmi(Laptop laptopOfPort, String hdmiVersion) {
        super(laptopOfPort);
        this.hdmiVersion = hdmiVersion;
    }

    /**
     * Gets the version of the HDMI port.
     *
     * @return the HDMI version
     */
    public String getHdmiVersion() {
        return hdmiVersion;
    }

    /**
     * Sets the version of the HDMI port.
     *
     * @param hdmiVersion the HDMI version (e.g., 1.4, 2.0, 2.1)
     */
    public void setHdmiVersion(String hdmiVersion) {
        this.hdmiVersion = hdmiVersion;
    }

    /**
     * Clones the Hdmi object
     * @param laptop the laptop to which the Hdmi object is associated
     * @return a new Hdmi object
     */
    /**
     * Clones the HDMI port with a different laptop.
     *
     * @param laptop the laptop to which the HDMI port will be associated
     * @return a new Hdmi object with the same HDMI version but a new laptop association
     */
    public Hdmi clone(Laptop laptop) {
        return new Hdmi(laptop, this.hdmiVersion);
    }

    /**
     *
     * @return the laptop to which the Hdmi object is associated
     */
    public String toString() {
        return hdmiVersion;
    }
}
