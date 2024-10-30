package org.example.configurator;

/**
 * Represents an external monitor.
 */
public class ExternalMonitor extends Accessory {

    private String externalMonitorName;
    private String externalMonitorResolution;

    /**
     * Constructs an ExternalMonitor object with the specified name and resolution
     * @param externalMonitorName the name of the external monitor
     * @param externalMonitorResolution the resolution of the external monitor
     */

    public ExternalMonitor (Laptop AccessoryOfLaptop, String ConnectionType, String externalMonitorName, String externalMonitorResolution) {
        super(AccessoryOfLaptop, ConnectionType);
        this.externalMonitorName = externalMonitorName;
        this.externalMonitorResolution = externalMonitorResolution;
    }

    /**
     * clone the externalMonitor with the specified laptop
     * @param laptop the laptop to which the accessory is associated
     * @return a new externalMonitor object with the same attributes of the original one
     */

    @Override
    public Accessory clone(Laptop laptop) {
        return new ExternalMonitor(laptop, this.getConnectionType(), this.externalMonitorName, this.externalMonitorResolution);
    }

    /**
     * Get the name of the external monitor
     * @return the name of the external monitor
     */

    public String getExternalMonitorName() {
        return externalMonitorName;
    }

    /**
     * Set the name of the external monitor
     * @param externalMonitorName the name of the external monitor
     */

    public void setExternalMonitorName(String externalMonitorName) {
        this.externalMonitorName = externalMonitorName;
    }

    /**
     * Get the resolution of the external monitor
     * @return the resolution of the external monitor
     */

    public String getExternalMonitorResolution() {
        return externalMonitorResolution;
    }

    /**
     * Set the resolution of the external monitor
     * @param externalMonitorResolution the resolution of the external monitor
     */

    public void setExternalMonitorResolution(String externalMonitorResolution) {
        this.externalMonitorResolution = externalMonitorResolution;
    }

    /**
     * @return a string representation of the external monitor
     */

    @Override
    public String toString() {
        return externalMonitorName + " " + externalMonitorResolution + " " + getConnectionType();
    }

}
