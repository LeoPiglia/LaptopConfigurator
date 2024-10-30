package org.example.configurator;

public class ExternalKeyboard extends Accessory {

    private String externalKeyboardName;
    private String externalKeyboardLayout;

    /**
     * Constructs an ExternalKeyboard with the specified laptop, connection type, external keyboard name, and external keyboard layout
     * @param AccessoryOfLaptop the laptop to which the external keyboard is associated
     * @param ConnectionType the connection type of the external keyboard for example USB, Bluetooth
     * @param externalKeyboardName the name of the external keyboard. For example, Logitech K120 or Apple Magic Keyboard
     * @param externalKeyboardLayout the layout of the external keyboard for example QWERTY
     */
    public ExternalKeyboard(Laptop AccessoryOfLaptop, String ConnectionType, String externalKeyboardName, String externalKeyboardLayout) {
        super(AccessoryOfLaptop, ConnectionType);
        this.externalKeyboardName = externalKeyboardName;
        this.externalKeyboardLayout = externalKeyboardLayout;
    }

    /**
     * clone the externalKeyboard with the specified laptop
     * @param laptop the laptop to which the accessory is associated
     * @return a new externalKeyboard object with the same attributes of the original one
     */
    @Override
    public Accessory clone(Laptop laptop) {
        return new ExternalKeyboard(laptop, this.getConnectionType(), this.externalKeyboardName, this.externalKeyboardLayout);
    }

    /**
     * Get the name of the external keyboard
     * @return the name of the external keyboard
     */
    public String getExternalKeyboardName() {
        return externalKeyboardName;
    }

    /**
     * Set the name of the external keyboard
     * @param externalKeyboardName the name of the external keyboard
     */
    public void setExternalKeyboardName(String externalKeyboardName) {
        this.externalKeyboardName = externalKeyboardName;
    }

    /**
     * Get the layout of the external keyboard
     * @return the layout of the external keyboard
     */
    public String getExternalKeyboardLayout() {
        return externalKeyboardLayout;
    }

    /**
     * Set the layout of the external keyboard
     * @param externalKeyboardLayout the layout of the external keyboard
     */
    public void setExternalKeyboardLayout(String externalKeyboardLayout) {
        this.externalKeyboardLayout = externalKeyboardLayout;
    }

    /**
     * @return a string representation of the external keyboard
     */
    @Override
    public String toString() {
        return externalKeyboardName + " " + externalKeyboardLayout + " " + getConnectionType();
    }



}
