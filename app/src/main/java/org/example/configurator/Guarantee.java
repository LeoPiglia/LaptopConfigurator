package org.example.configurator;

public class Guarantee {

    private Laptop laptopOfGuarantee;
    private String guaranteeName;
    private String guaranteePeriod;

    /**
     * Constructs a Guarantee with the specified laptop, name and period
     *
     * @param laptopOfGuarantee the laptop to which the guarantee is associated
     * @param guaranteeName     the name of the guarantee
     * @param guaranteePeriod   the period of the guarantee
     */
    public Guarantee(Laptop laptopOfGuarantee, String guaranteeName, String guaranteePeriod) {
        this.laptopOfGuarantee = laptopOfGuarantee;
        this.guaranteeName = guaranteeName;
        this.guaranteePeriod = guaranteePeriod;
    }

    /**
     * Clones the Guarantee object
     *
     * @param laptop the laptop to which the Guarantee object is associated
     * @return a new Guarantee object
     */

    public Guarantee clone(Laptop laptop) {
        return new Guarantee(laptop, this.guaranteeName, this.guaranteePeriod);
    }

    /**
     * @return the laptop to which the guarantee is associated
     */

    public Laptop getLaptopOfGuarantee() {
        return laptopOfGuarantee;
    }

    /**
     * sets the laptop to which the guarantee is associated
     *
     * @param laptopOfGuarantee the laptop to which the guarantee is associated
     */

    public void setLaptopOfGuarantee(Laptop laptopOfGuarantee) {
        this.laptopOfGuarantee = laptopOfGuarantee;
    }

    /**
     * @return the name of the guarantee
     */

    public String getGuaranteeName() {
        return guaranteeName;
    }

    /**
     * sets the name of the guarantee
     *
     * @param guaranteeName the name of the guarantee
     */

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    /**
     * @return the period of the guarantee
     */

    public String getGuaranteePeriod() {
        return guaranteePeriod;
    }

    /**
     * sets the period of the guarantee
     * @param guaranteePeriod the period of the guarantee
     */

    public void setGuaranteePeriod(String guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    /**
     * @return the name of the guarantee and the period of the guarantee
     */

    @Override
    public String toString() {
        return "Guarantee: " + guaranteeName + ", " + guaranteePeriod;
    }

}
