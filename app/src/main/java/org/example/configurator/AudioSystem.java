package org.example.configurator;

/**
 * This class represents the audio system of a laptop
 */
public class AudioSystem {

    private Laptop laptopOfAudioSystem;
    private String audioSystemName;
    private String audioSystemPower;

    /**
     * Constructs an AudioSystem with the specified laptop and power
     * @param laptopOfAudioSystem the laptop to which the audio system is associated
     * @paam audioSystemName the name of the audio system
     * @param audioSystemPower the power of the audio system
     */
    public AudioSystem(Laptop laptopOfAudioSystem, String audioSystemName, String audioSystemPower) {
        this.laptopOfAudioSystem = laptopOfAudioSystem;
        this.audioSystemName = audioSystemName;
        this.audioSystemPower = audioSystemPower;

    }

    /**
     * Clones the AudioSystem object
     * @param laptop the laptop to which the AudioSystem object is associated
     * @return a new AudioSystem object
     */
    public AudioSystem clone(Laptop laptop) {
        return new AudioSystem(laptop, this.audioSystemName, this.audioSystemPower);
    }

    /**
     *
     * @return the laptop to which the audio system is associated
     */
    public Laptop getLaptopOfAudioSystem() {
        return laptopOfAudioSystem;
    }

    /**
     * sets the laptop to which the audio system is associated
     * @param laptopOfAudioSystem the laptop to which the audio system is associated
     */
    public void setLaptopOfAudioSystem(Laptop laptopOfAudioSystem) {
        this.laptopOfAudioSystem = laptopOfAudioSystem;
    }

    /**
     *
     * @return the power of the audio system
     */
    public String getAudioSystemPower() {
        return audioSystemPower;
    }

    /**
     * sets the power of the audio system
     * @param audioSystemPower the power of the audio system
     */
    public void setAudioSystemPower(String audioSystemPower) {
        this.audioSystemPower = audioSystemPower;
    }

    /**
     *
     * @return the name of the audio system
     */

    public String getAudioSystemName() {
        return audioSystemName;

    }

    /**
     * sets the name of the audio system
     * @param audioSystemName the name of the audio system
     */

    public void setAudioSystemName(String audioSystemName) {
        this.audioSystemName = audioSystemName;
    }

    /**
     *
     * @return a string representation of the AudioSystem object
     */

    @Override
    public String toString() {
        return audioSystemName + " " + audioSystemPower;

    }
}