package org.example.configurator;

/**
 * Represents the Keyboard object of a laptop.
 */
public class Keyboard extends HardwareComponent {

    private String keyboardName;
    private String keyboardLayout;

    /**
     * Constructs a Keyboard object with the specified laptop, name and layout
     * @param laptopOfHardwareComponent the laptop to which the Keyboard object is associated
     * @param keyboardName the name of the Keyboard
     * @param keyboardLayout the layout of the Keyboard
     */
    public Keyboard(Laptop laptopOfHardwareComponent, String keyboardName, String keyboardLayout) {
        super(laptopOfHardwareComponent);
        this.keyboardName = keyboardName;
        this.keyboardLayout = keyboardLayout;
    }

    /**
     * Clones the Keyboard object
     * @return a new Keyboard object
     */
    @Override
    public HardwareComponent clone() {
        return new Keyboard(this.getLaptopOfHardwareComponent(), this.keyboardName, this.keyboardLayout);
    }

    /**
     * Get the name of the Keyboard
     * @return the name of the Keyboard
     */
    public String getKeyboardName() {
        return keyboardName;
    }

    /**
     * Set the name of the Keyboard
     * @param keyboardName the name of the Keyboard
     */
    public void setKeyboardName(String keyboardName) {
        this.keyboardName = keyboardName;
    }

    /**
     * Get the layout of the Keyboard
     * @return the layout of the Keyboard
     */
    public String getKeyboardLayout() {
        return keyboardLayout;
    }

    /**
     * Set the layout of the Keyboard
     * @param keyboardLayout the layout of the Keyboard
     */
    public void setKeyboardLayout(String keyboardLayout) {
        this.keyboardLayout = keyboardLayout;
    }

    /**
     * Returns a string representation of the Keyboard object
     * @return a string representation of the Keyboard object
     */

    @Override
    public String toString() {
        return keyboardName + " " + keyboardLayout;
    }
}
