package org.example.configurator;

/**
 * Represents the Storage object of a laptop.
 */
public class Storage extends HardwareComponent {

    private String storageCapacity;
    private String storageName;

    /**
     * Constructs a Storage object with the specified laptop, capacity and name
     * @param laptopOfHardwareComponent the laptop to which the Storage object is associated
     * @param storageCapacity the capacity of the Storage
     * @param storageName the name of the Storage
     */
    public Storage(Laptop laptopOfHardwareComponent, String storageCapacity, String storageName) {
        super(laptopOfHardwareComponent);
        this.storageCapacity = storageCapacity;
        this.storageName = storageName;
    }

    /**
     * Clones the Storage object
     * @return a new Storage object
     */
    @Override
    public HardwareComponent clone() {
        return new Storage(this.getLaptopOfHardwareComponent(), this.storageCapacity, this.storageName);
    }

    /**
     * Get the capacity of the Storage
     * @return the capacity of the Storage
     */
    public String getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * Set the capacity of the Storage
     * @param storageCapacity the capacity of the Storage
     */
    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    /**
     * Get the name of the Storage
     * @return the name of the Storage
     */
    public String getStorageName() {
        return storageName;
    }

    /**
     * Set the name of the Storage
     * @param storageName the name of the Storage
     */
    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    /**
     * Returns a string representation of the Storage object
     * @return a string representation of the Storage object
     */
    @Override
    public String toString() {
        return storageName + " " + storageCapacity;
    }


}
