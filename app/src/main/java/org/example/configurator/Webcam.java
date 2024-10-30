package org.example.configurator;

public class Webcam extends HardwareComponent {

    private String webcamName;
    private String webcamResolution;

    /**
     * Constructs a Webcam object with the specified laptop, name and resolution
     * @param laptopOfHardwareComponent the laptop to which the Webcam object is associated
     * @param webcamName the name of the Webcam
     * @param webcamResolution the resolution of the Webcam
     */

    public Webcam(Laptop laptopOfHardwareComponent, String webcamName, String webcamResolution) {
        super(laptopOfHardwareComponent);
        this.webcamName = webcamName;
        this.webcamResolution = webcamResolution;
    }

    /**
     * Clones the Webcam object
     * @return a new Webcam object
     */

    @Override
    public HardwareComponent clone() {
        return new Webcam(this.getLaptopOfHardwareComponent(), this.webcamName, this.webcamResolution);
    }

    /**
     * Get the name of the Webcam
     * @return the name of the Webcam
     */

    public String getWebcamName() {
        return webcamName;
    }

    /**
     * Set the name of the Webcam
     * @param webcamName the name of the Webcam
     */

    public void setWebcamName(String webcamName) {
        this.webcamName = webcamName;
    }

    /**
     * Get the resolution of the Webcam
     * @return the resolution of the Webcam
     */

    public String getWebcamResolution() {
        return webcamResolution;
    }

    /**
     * Set the resolution of the Webcam
     * @param webcamResolution the resolution of the Webcam
     */

    public void setWebcamResolution(String webcamResolution) {
        this.webcamResolution = webcamResolution;
    }

    /**
     * Get the name of the Webcam
     * @return the name of the Webcam
     */
    @Override
    public String toString() {
        return webcamName + " " + webcamResolution;
    }
}