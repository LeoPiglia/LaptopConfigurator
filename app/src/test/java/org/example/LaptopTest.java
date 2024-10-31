package org.example;



import org.example.configurator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the Laptop class.
 */
class LaptopTest {

    private Laptop laptop;
    private HardwareComponent cpu;
    private HardwareComponent ram;
    private Port usbPort;
    private Accessory mouse;
    private Security antivirus;

    /**
     * Setup the test environment.
     */
    @BeforeEach
    void setUp() {
        laptop = new Laptop("TestLaptop");

        // Creazione dei mock senza configurazioni di comportamento
        cpu = Mockito.mock(Cpu.class);
        ram = Mockito.mock(Ram.class);
        usbPort = Mockito.mock(Port.class);
        mouse = Mockito.mock(Accessory.class);
        antivirus = Mockito.mock(Security.class);
    }

    @Test
    void testAddHardwareComponent() {
        laptop.addHardwareComponent(cpu);
        assertTrue(laptop.getHardwareComponents().contains(cpu));
    }

    @Test
    void testRemoveHardwareComponent() {
        laptop.addHardwareComponent(cpu);
        laptop.removeHardwareComponent(cpu);
        assertFalse(laptop.getHardwareComponents().contains(cpu));
    }

    @Test
    void testAddPort() {
        laptop.addPort(usbPort);
        assertTrue(laptop.getPorts().contains(usbPort));
    }

    @Test
    void testRemovePort() {
        laptop.addPort(usbPort);
        laptop.removePort(usbPort);
        assertFalse(laptop.getPorts().contains(usbPort));
    }

    @Test
    void testAddAccessory() {
        laptop.addAccessory(mouse);
        assertTrue(laptop.getAccessories().contains(mouse));
    }

    @Test
    void testRemoveAccessory() {
        laptop.addAccessory(mouse);
        laptop.removeAccessory(mouse);
        assertFalse(laptop.getAccessories().contains(mouse));
    }

    @Test
    void testAddSecurity() {
        laptop.addSecurity(antivirus);
        assertTrue(laptop.getSecurities().contains(antivirus));
    }

    @Test
    void testRemoveSecurity() {
        laptop.addSecurity(antivirus);
        laptop.removeSecurity(antivirus);
        assertFalse(laptop.getSecurities().contains(antivirus));
    }

    @Test
    void testCloneConfiguration() {
        laptop.addHardwareComponent(cpu);
        laptop.addPort(usbPort);
        laptop.addAccessory(mouse);
        laptop.addSecurity(antivirus);

        Laptop clonedLaptop = laptop.cloneConfiguration();

        // Verifica che il nome del laptop sia lo stesso
        assertEquals(laptop.getLaptopName(), clonedLaptop.getLaptopName());

        // Verifica che le liste contengano lo stesso numero di elementi
        assertEquals(laptop.getHardwareComponents().size(), clonedLaptop.getHardwareComponents().size());
        assertEquals(laptop.getPorts().size(), clonedLaptop.getPorts().size());
        assertEquals(laptop.getAccessories().size(), clonedLaptop.getAccessories().size());
        assertEquals(laptop.getSecurities().size(), clonedLaptop.getSecurities().size());

        // Verifica che gli elementi siano clonati e non siano le stesse istanze
        assertNotSame(laptop.getHardwareComponents().get(0), clonedLaptop.getHardwareComponents().get(0));
        assertNotSame(laptop.getPorts().get(0), clonedLaptop.getPorts().get(0));
        assertNotSame(laptop.getAccessories().get(0), clonedLaptop.getAccessories().get(0));
        assertNotSame(laptop.getSecurities().get(0), clonedLaptop.getSecurities().get(0));
    }

    @Test
    void testValidateConfiguration() {
        laptop.addHardwareComponent(cpu);
        laptop.addHardwareComponent(ram);
        assertFalse(laptop.ValidateConfiguration());

        HardwareComponent trackpad = Mockito.mock(Trackpad.class);
        HardwareComponent webcam = Mockito.mock(Webcam.class);
        HardwareComponent keyboard = Mockito.mock(Keyboard.class);
        HardwareComponent display = Mockito.mock(Display.class);
        HardwareComponent graphicsCard = Mockito.mock(GraphicsCard.class);
        HardwareComponent storage = Mockito.mock(Storage.class);

        laptop.addHardwareComponent(trackpad);
        laptop.addHardwareComponent(webcam);
        laptop.addHardwareComponent(keyboard);
        laptop.addHardwareComponent(display);
        laptop.addHardwareComponent(graphicsCard);
        laptop.addHardwareComponent(storage);

        assertTrue(laptop.ValidateConfiguration());
    }

    @Test
    void testResetConfiguration() {
        laptop.addHardwareComponent(cpu);
        laptop.addPort(usbPort);
        laptop.addAccessory(mouse);
        laptop.addSecurity(antivirus);

        laptop.resetConfiguration();
        assertTrue(laptop.getHardwareComponents().isEmpty());
        assertTrue(laptop.getPorts().isEmpty());
        assertTrue(laptop.getAccessories().isEmpty());
        assertTrue(laptop.getSecurities().isEmpty());
        assertNull(laptop.getAudioSystem());
        assertNull(laptop.getBattery());
        assertNull(laptop.getColour());
        assertNull(laptop.getCoolingSystem());
        assertNull(laptop.getGuarantee());
        assertNull(laptop.getOperatingSystem());
    }

    @Test
    void testAddOrReplaceHardwareComponent() {
        HardwareComponent newCpu = Mockito.mock(Cpu.class);
        laptop.addOrReplaceHardwareComponent(cpu);
        laptop.addOrReplaceHardwareComponent(newCpu);

        assertEquals(1, laptop.getHardwareComponents().size());
        assertTrue(laptop.getHardwareComponents().contains(newCpu));
    }

    @Test
    void testAddOrReplacePort() {
        Port newPort = Mockito.mock(Port.class);
        laptop.addOrReplacePort(usbPort);
        laptop.addOrReplacePort(newPort);

        assertEquals(1, laptop.getPorts().size());
        assertTrue(laptop.getPorts().contains(newPort));
    }

    @Test
    void testAddOrReplaceAccessory() {
        Accessory newAccessory = Mockito.mock(Accessory.class);
        laptop.addOrReplaceAccessory(mouse);
        laptop.addOrReplaceAccessory(newAccessory);

        assertEquals(1, laptop.getAccessories().size());
        assertTrue(laptop.getAccessories().contains(newAccessory));
    }

    @Test
    void testAddOrReplaceSecurity() {
        Security newSecurity = Mockito.mock(Security.class);
        laptop.addOrReplaceSecurity(antivirus);
        laptop.addOrReplaceSecurity(newSecurity);

        assertEquals(1, laptop.getSecurities().size());
        assertTrue(laptop.getSecurities().contains(newSecurity));
    }
}