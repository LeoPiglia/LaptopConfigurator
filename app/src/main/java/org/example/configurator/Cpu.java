package org.example.configurator;

/**
 * Represents the CPU object of a laptop.
 */
public class Cpu extends HardwareComponent {

    private String cpuName;
    private String cpuSpeed;

    /**
     * Constructs a Cpu object with the specified laptop, name and speed
     * @param laptopOfHardwareComponent the laptop to which the CPU object is associated
     * @param cpuName the name of the CPU
     * @param cpuSpeed the speed of the CPU
     */

    public Cpu(Laptop laptopOfHardwareComponent, String cpuName, String cpuSpeed) {
        super(laptopOfHardwareComponent);
        this.cpuName = cpuName;
        this.cpuSpeed = cpuSpeed;
    }

    /**
     * Clones the Cpu object
     * @return a new Cpu object
     */
    @Override
    public HardwareComponent clone() {
        return new Cpu(this.getLaptopOfHardwareComponent(), this.cpuName, this.cpuSpeed);
    }

    /**
     * Get the name of the CPU
     * @return the name of the CPU
     */
    public String getCpuName() {
        return cpuName;
    }

    /**
     * Set the name of the CPU
     * @param cpuName the name of the CPU
     */

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    /**
     * Get the speed of the CPU
     * @return the speed of the CPU
     */

    public String getCpuSpeed() {
        return cpuSpeed;
    }

    /**
     * Set the speed of the CPU
     * @param cpuSpeed the speed of the CPU
     */

    public void setCpuSpeed(String cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    /**
     * @return the string representation of the CPU object
     */

    @Override
    public String toString() {
        return cpuName + " " + cpuSpeed;
    }




}
