package org.example.app;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class LaptopConfiguratorModellazioneGestioneConoscezaApp {
    private OntModel ontologyModel;

    public void loadOntology(String filePath) {
        try {
            ontologyModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            InputStream in = getClass().getClassLoader().getResourceAsStream(filePath);
            if (in == null) {
                throw new FileNotFoundException("RDF/OWL file not found: " + filePath);
            }
            ontologyModel.read(in, null);
        } catch (FileNotFoundException e) {
            System.err.println("RDF/OWL file not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error loading the ontology: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public boolean isOntologyLoaded() {
        return ontologyModel != null && !ontologyModel.isEmpty();
    }
    public static void main(String[] args) {
        LaptopConfiguratorModellazioneGestioneConoscezaApp app = new LaptopConfiguratorModellazioneGestioneConoscezaApp();
        app.loadOntology("LaptopConfiguratorModellazioneGestioneConoscenza.rdf");

        if (app.isOntologyLoaded()) {
            System.out.println("Ontology loaded successfully.");
        } else {
            System.out.println("Failed to load ontology.");
        }
    }
}