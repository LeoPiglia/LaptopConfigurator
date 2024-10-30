package org.example.configurator;

/**
 * Represents the GraphicsCard object of a laptop.
 */
public class GraphicsCard extends HardwareComponent{

    private String graphicsCardName;
    private String graphicsCardVideoMemory;

    /**
     * Constructs a GraphicsCard object with the specified laptop, name and video memory
     * @param laptopOfHardwareComponent the laptop to which the GraphicsCard object is associated
     * @param graphicsCardName the name of the GraphicsCard
     * @param graphicsCardVideoMemory the video memory of the GraphicsCard
     */
    public GraphicsCard(Laptop laptopOfHardwareComponent, String graphicsCardName, String graphicsCardVideoMemory) {
        super(laptopOfHardwareComponent);
        this.graphicsCardName = graphicsCardName;
        this.graphicsCardVideoMemory = graphicsCardVideoMemory;
    }

    /**
     * Clones the GraphicsCard object
     * @return a new GraphicsCard object
     */
    @Override
    public HardwareComponent clone() {
        return new GraphicsCard(this.getLaptopOfHardwareComponent(), this.graphicsCardName, this.graphicsCardVideoMemory);
    }

    /**
     * Get the name of the GraphicsCard
     * @return the name of the GraphicsCard
     */
    public String getGraphicsCardName() {
        return graphicsCardName;
    }

    /**
     * Set the name of the GraphicsCard
     * @param graphicsCardName the name of the GraphicsCard
     */

    public void setGraphicsCardName(String graphicsCardName) {
        this.graphicsCardName = graphicsCardName;
    }

    /**
     * Get the video memory of the GraphicsCard
     * @return the video memory of the GraphicsCard
     */

    public String getGraphicsCardVideoMemory() {
        return graphicsCardVideoMemory;
    }

    /**
     * Set the video memory of the GraphicsCard
     * @param graphicsCardVideoMemory the video memory of the GraphicsCard
     */

    public void setGraphicsCardVideoMemory(String graphicsCardVideoMemory) {
        this.graphicsCardVideoMemory = graphicsCardVideoMemory;
    }

    /**
     * @return a string representation of the GraphicsCard object
     */

    @Override
    public String toString() {
        return graphicsCardName + " " + graphicsCardVideoMemory;
    }


}
