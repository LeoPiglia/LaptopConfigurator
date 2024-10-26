package org.example.configurator;

public class Antivirus {

    private String HasAntivirusVersion;

    // Costruttore di default
    public Antivirus() {
    }

    public String getHasantivirusversion() {
        return HasAntivirusVersion;
    }

    public void setHasantivirusversion(String HasAntivirusVersion) {
        this.HasAntivirusVersion = HasAntivirusVersion;
    }

    @Override
    public String toString() {
        return "Antivirus{" +
               "HasAntivirusVersion='" + HasAntivirusVersion + '\'' + " " +
               '}';
    }
}
