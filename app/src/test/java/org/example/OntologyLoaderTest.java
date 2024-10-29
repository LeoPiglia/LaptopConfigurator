package org.example;

import org.apache.jena.ontology.OntModel;
import org.example.ontology.OntologyLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OntologyLoaderTest {
    private OntologyLoader ontologyLoader;

    @BeforeEach
    public void setUp() {
        // Inizializza l'istanza di OntologyLoader
        ontologyLoader = new OntologyLoader("LaptopConfiguratorModellazioneGestioneConoscenza.rdf");
    }

    @Test
    public void testLoadOntologyFromFilePath() {
        // Carica l'ontologia dal file path specificato
        OntModel model = ontologyLoader.getOntologyModel();

        // Verifica che il modello non sia nullo
        assertNotNull(model, "Il modello dell'ontologia non dovrebbe essere nullo");

        // Verifica che il modello contenga delle dichiarazioni (tripli RDF)
        assertTrue(model.size() > 0, "Il modello dovrebbe contenere delle dichiarazioni RDF");

        // Verifica che il modello contenga una specifica classe (ad esempio, laptop:Cpu)
        String namespace = "http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#";
        assertTrue(model.containsResource(model.createResource(namespace + "HardwareComponent")), "Il modello dovrebbe contenere la risorsa 'HardwareComponent'");
    }

    @Test
    public void testLoadInvalidOntology() {
        // Test con path di un ontologia non valido
        ontologyLoader = new OntologyLoader("LaptopConfigurator.rdf");
        OntModel model = ontologyLoader.getOntologyModel();

        // Verifica che il modello sia nullo o vuoto in caso di file non valido
        assertNotNull(model, "Il modello dell'ontologia non dovrebbe essere nullo anche se il file non è valido");
        assertEquals(0, model.size(), "Il modello dovrebbe essere vuoto se il file non è valido");
    }
}
