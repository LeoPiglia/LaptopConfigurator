package org.example.configurator;

/**
 * Represents the Usb object of a laptop.
 */
public class Usb extends Port {

    private String usbType;

    /**
     * Constructs a Usb object with the specified laptop and USB type.
     *
     * @param laptopOfUsb the laptop to which the Usb object is associated
     * @param usbType the type of the USB (e.g., USB-A, USB-C, USB 3.0)
     */
    public Usb(Laptop laptopOfUsb, String usbType) {
        super(laptopOfUsb);
        this.usbType = usbType;
    }

    /**
     * Gets the type of the USB port.
     *
     * @return the USB type
     */
    public String getUsbType() {
        return usbType;
    }

    /**
     * Sets the type of the USB port.
     *
     * @param usbType the USB type (e.g., USB-A, USB-C, USB 3.0)
     */
    public void setUsbType(String usbType) {
        this.usbType = usbType;
    }

    /**
     * Clones the USB port with a different laptop.
     *
     * @param laptop the laptop to which the USB port will be associated
     * @return a new Usb object with the same USB type but a new laptop association
     */

    public Usb clone(Laptop laptop) {
        return new Usb(laptop, this.usbType);
    }

    /**
     * Returns a string representation of the USB port.
     *
     * @return a string representation of the USB port
     */
    @Override
    public String toString() {
        return usbType;
    }
}
