package org.example.configurator;

public class ProtectionFeature extends Security {

    private String protectionFeatureType;
    private String protectionFeatureName;

    /**
     * Costruisce un oggetto ProtectionFeature con il laptop specificato e il tipo di protezione
     * @param laptopOfSecurity il laptop a cui l'oggetto ProtectionFeature è associato
     * @param protectionFeatureType il tipo di protezione dell'oggetto ProtectionFeature
     */
    public ProtectionFeature(Laptop laptopOfSecurity, String protectionFeatureName, String protectionFeatureType) {
        super(laptopOfSecurity);
        this.protectionFeatureType = protectionFeatureType;
        this.protectionFeatureName = protectionFeatureName;
    }

    /**
     * Clona l'oggetto ProtectionFeature
     * @param laptop il laptop a cui l'oggetto ProtectionFeature è associato
     * @return un nuovo oggetto ProtectionFeature
     */

    @Override
    public Security clone(Laptop laptop) {
        return new ProtectionFeature(laptop, this.protectionFeatureName, this.protectionFeatureType );
    }

    /**
     * Restituisce il tipo di protezione
     * @return il tipo di protezione
     */

    public String getProtectionFeatureType() {
        return protectionFeatureType;
    }

    /**
     * Imposta il tipo di protezione
     * @param protectionFeatureType il tipo di protezione
     */

    public void setProtectionFeatureType(String protectionFeatureType) {
        this.protectionFeatureType = protectionFeatureType;
    }

    /**
     * Restituisce il nome della protezione
     * @return il nome della protezione
     */

    public String getProtectionFeatureName() {
        return protectionFeatureName;
    }

    /**
     * Imposta il nome della protezione
     * @param protectionFeatureName il nome della protezione
     */

    public void setProtectionFeatureName(String protectionFeatureName) {
        this.protectionFeatureName = protectionFeatureName;
    }

    /**
     * Restituisce una rappresentazione in stringa dell'oggetto ProtectionFeature
     * @return una rappresentazione in stringa dell'oggetto ProtectionFeature
     */

    @Override
    public String toString() {
        return protectionFeatureType;
    }
}
