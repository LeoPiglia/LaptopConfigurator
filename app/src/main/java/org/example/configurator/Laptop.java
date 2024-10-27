package org.example.configurator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Laptop object with its components and accessories.
 */
public class Laptop {
    private String laptopName;
    private List<HardwareComponent> hardwareComponents;
    private List<Port> ports;
    private List<Accessory> accessories;
    private List<Security> securities;
    private AudioSystem audioSystem;
    private Battery battery;
    private Colour colour;
    private CoolingSystem coolingSystem;
    private Guarantee guarantee;
    private OperatingSystem operatingSystem;

    /**
     * Constructor that initializes the laptop with the specified name
     *
     * @param laptopName the name of the laptop
     */
    public Laptop(String laptopName) {
        this.laptopName = laptopName;
        this.hardwareComponents = new ArrayList<>();
        this.accessories = new ArrayList<>();
        this.ports = new ArrayList<>();
        this.securities = new ArrayList<>();
    }

    /**
     * Get the name of the laptop
     *
     * @return the name of the laptop
     */

    public String getLaptopName() {
        return laptopName;
    }

    /**
     * Set the name of the laptop
     *
     * @param laptopName the name of the laptop
     */

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public AudioSystem getAudioSystem() {
        return audioSystem;
    }

    public void setAudioSystem(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public CoolingSystem getCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(CoolingSystem coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public Guarantee getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Guarantee guarantee) {
        this.guarantee = guarantee;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public List<HardwareComponent> getHardwareComponents() {
        return hardwareComponents;
    }

    public void setHardwareComponents(List<HardwareComponent> hardwareComponents) {
        this.hardwareComponents = hardwareComponents;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    /**
     * Adds a hardware component to the laptop
     *
     * @param hardwareComponent the hardware component to be added
     */

    public void addHardwareComponent(HardwareComponent hardwareComponent) {
        hardwareComponents.add(hardwareComponent);
    }

    /**
     * Removes a hardware component from the laptop
     *
     * @param hardwareComponent the hardware component to be removed
     */

    public void removeHardwareComponent(HardwareComponent hardwareComponent) {
        hardwareComponents.remove(hardwareComponent);
    }

    /**
     * Adds a port to the laptop
     *
     * @param port the port to be added
     */

    public void addPort(Port port) {
        ports.add(port);
    }

    /**
     * Removes a port from the laptop
     *
     * @param port the port to be removed
     */

    public void removePort(Port port) {
        ports.remove(port);
    }

    /**
     * Adds an accessory to the laptop
     *
     * @param accessory the accessory to be added
     */

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    /**
     * Removes an accessory from the laptop
     *
     * @param accessory the accessory to be removed
     */

    public void removeAccessory(Accessory accessory) {
        accessories.remove(accessory);
    }

    /**
     * Adds a security to the laptop
     *
     * @param security the security to be added
     */

    public void addSecurity(Security security) {
        securities.add(security);
    }

    /**
     * Removes a security from the laptop
     *
     * @param security the security to be removed
     */

    public void removeSecurity(Security security) {
        securities.remove(security);
    }

    /**
     * clones the laptop object
     */

    public Laptop cloneConfiguration() {
        Laptop clonedInstance = new Laptop(this.laptopName);

        for (HardwareComponent hardwareComponent : hardwareComponents) {
            clonedInstance.addHardwareComponent(hardwareComponent.clone());
        }


        for (Port port : ports) {
            clonedInstance.addPort(port.clone(clonedInstance));
        }

        for (Accessory accessory : accessories) {
            clonedInstance.addAccessory(accessory.clone(clonedInstance));
        }

        for (Security security : securities) {
            clonedInstance.addSecurity(security.clone(clonedInstance));
        }

        clonedInstance.setAudioSystem(this.audioSystem);
        clonedInstance.setBattery(this.battery);
        clonedInstance.setColour(this.colour);
        clonedInstance.setCoolingSystem(this.coolingSystem);
        clonedInstance.setGuarantee(this.guarantee);
        clonedInstance.setOperatingSystem(this.operatingSystem);

        return clonedInstance;
    }

    /**
     * Returns a string representation of the laptop
     *
     * @return a string representation of the laptop
     */

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopName='" + laptopName + '\'' +
                ", hardwareComponents=" + hardwareComponents +
                ", ports=" + ports +
                ", accessories=" + accessories +
                ", securities=" + securities +
                ", audioSystem=" + audioSystem +
                ", battery=" + battery +
                ", colour=" + colour +
                ", coolingSystem=" + coolingSystem +
                ", guarantee=" + guarantee +
                ", operatingSystem=" + operatingSystem +
                '}';
    }

    /**
     * validates the laptop configuration
     * @return true if the laptop configuration is valid, false otherwise
     */
    public boolean ValidateConfiguration(){
        return hardwareComponents.stream().anyMatch(c -> c instanceof Cpu) &&
                hardwareComponents.stream().anyMatch(c -> c instanceof Ram) &&
                hardwareComponents.stream().anyMatch(c -> c instanceof Storage) &&
                hardwareComponents.stream().anyMatch(c -> c instanceof Trackpad) &&
                hardwareComponents.stream().anyMatch(c -> c instanceof Webcam) &&
                hardwareComponents.stream().anyMatch(c -> c instanceof Keyboard) &&
                hardwareComponents.stream().anyMatch(c -> c instanceof Display) &&
                hardwareComponents.stream().anyMatch(c -> c instanceof GraphicsCard);
    }

    /**
     * resets the laptop configuration
     */
    public void resetConfiguration() {
        hardwareComponents.clear();
        ports.clear();
        accessories.clear();
        securities.clear();
        audioSystem = null;
        battery = null;
        colour = null;
        coolingSystem = null;
        guarantee = null;
        operatingSystem = null;
    }


    /**
     * generics method for adding or replace an item in a list
     * @param list the list to which the item is added or replaced
     * @param item the item to be added or replaced
     * @param <T> the type of the item
     */

    public <T> void addOrReplaceItem(List<T> list, T item) {
        list.removeIf(existingItem -> existingItem.getClass().equals(item.getClass()));
        list.add(item);
    }

    /**
     * add or replace HardwareComponent in the laptop
     * @param hardwareComponent the hardware component to be added or replaced
     */

    public void addOrReplaceHardwareComponent(HardwareComponent hardwareComponent) {
        addOrReplaceItem(hardwareComponents, hardwareComponent);
    }

    /**
     * add or replace Port in the laptop
     * @param port the port to be added or replaced
     */

    public void addOrReplacePort(Port port) {
        addOrReplaceItem(ports, port);
    }

    /**
     * add or replace Accessory in the laptop
     * @param accessory the accessory to be added or replaced
     */

    public void addOrReplaceAccessory(Accessory accessory) {
        addOrReplaceItem(accessories, accessory);
    }

    /**
     * add or replace Security in the laptop
     * @param security the security to be added or replaced
     */

    public void addOrReplaceSecurity(Security security) {
        addOrReplaceItem(securities, security);
    }
}

