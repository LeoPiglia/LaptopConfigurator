package org.example;

/**
 * Unit test for the final configuration of a Laptop.
 */

import org.example.configurator.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class FinalConfigurationTest {

    @Test
    public void testFinalLaptopConfiguration() {
        // Crea un'istanza di Laptop
        Laptop laptop = new Laptop("TestLaptop");

        // Crea e aggiungi i componenti al laptop, specificando i nomi per ogni componente
        Ram ram = new Ram(laptop, "Corsair Vengeance", "16GB DDR4");
        Cpu cpu = new Cpu(laptop, "Intel Core i7", "3.2GHz");
        Display display = new Display(laptop, "Dell UltraSharp", "15.6\" Full HD");
        GraphicsCard graphicsCard = new GraphicsCard(laptop, "NVIDIA GTX 1650", "4GB GDDR6");

        // Aggiungi i componenti al laptop
        laptop.addOrReplaceHardwareComponent(ram);
        laptop.addOrReplaceHardwareComponent(cpu);
        laptop.addOrReplaceHardwareComponent(display);
        laptop.addOrReplaceHardwareComponent(graphicsCard);

        // Verifica che il numero di componenti sia corretto
        assertEquals(4, laptop.getHardwareComponents().size(), "il Numero di componenti non corrisponde");

        // Verifica che ogni componente specifico sia presente nel laptop
        assertTrue(laptop.getHardwareComponents().stream()
                        .anyMatch(c -> c instanceof Ram && "Corsair Vengeance".equals(((Ram) c).getRamName())),
                "RAM 'Corsair Vengeance' non trovata");
        assertTrue(laptop.getHardwareComponents().stream()
                        .anyMatch(c -> c instanceof Cpu && "Intel Core i7".equals(((Cpu) c).getCpuName())),
                "CPU 'Intel Core i7' non trovata");
        assertTrue(laptop.getHardwareComponents().stream()
                        .anyMatch(c -> c instanceof Display && "Dell UltraSharp".equals(((Display) c).getDisplayName())),
                "Display 'Dell UltraSharp' non trovato");
        assertTrue(laptop.getHardwareComponents().stream()
                        .anyMatch(c -> c instanceof GraphicsCard && "NVIDIA GTX 1650".equals(((GraphicsCard) c).getGraphicsCardName())),
                "Scheda Grafica 'NVIDIA GTX 1650' non trovata");
    }
}