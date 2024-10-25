package org.example.app;

import org.apache.jena.ontology.OntModel;
import org.example.ontology.OntologyLoader;

public class Main {
    public static void main(String[] args) {
        String filePath = "LaptopConfiguratorModellazioneGestioneConoscenza.rdf";
        OntologyLoader loader = new OntologyLoader(filePath);
        OntModel ontModel = loader.getOntologyModel();

        if (ontModel != null) {
            System.out.println("Ontologia caricata con successo!");
            ontModel.write(System.out, "RDF/XML");
        } else {
            System.err.println("Errore nel caricamento dell'ontologia.");
        }
    }
}
