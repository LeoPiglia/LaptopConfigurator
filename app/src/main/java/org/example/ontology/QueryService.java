package org.example.ontology;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;
import org.example.configurator.*;

import java.util.ArrayList;
import java.util.List;

public class QueryService {
    private SPARQLQueryExecutor queryExecutor;

    public QueryService(SPARQLQueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    /**
     * Retrieves the RAM components for the specified laptop.
     */

    public List<Ram> getRAMComponents(Laptop laptop) {
        List<Ram> ramList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?ram ?size WHERE { " +
                "?ram rdf:type laptop:RAM . " +
                "?ram laptop:hasRAMSize ?size . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource ramResource = solution.getResource("ram");
            String ramName = ramResource.getLocalName();
            String ramSize = solution.getLiteral("size").getString();
            ramList.add(new Ram(laptop, ramName, ramSize));
        }
        return ramList;
    }

    /**
     * Retrieves the storage components for the specified laptop.
     */
    public List<Storage> getStorageComponents(Laptop laptop) {
        List<Storage> storageList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?storage ?capacity WHERE { " +
                "?storage rdf:type laptop:Storage . " +
                "?storage laptop:hasStorageCapacity ?capacity . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource storageResource = solution.getResource("storage");
            String storageName = storageResource.getLocalName();
            String storageCapacity = solution.getLiteral("capacity").getString();
            storageList.add(new Storage(laptop, storageName, storageCapacity));
        }
        return storageList;
    }

    /**
     * retireves the antivirus version for the specified laptop
     */
    public List<Antivirus> getAntivirusComponents(Laptop laptop) {
        List<Antivirus> antivirusList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?antivirus ?version WHERE { " +
                "?antivirus rdf:type laptop:Antivirus . " +
                "?antivirus laptop:hasAntivirusVersion ?version . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource antivirusResource = solution.getResource("antivirus");
            String antivirusName = antivirusResource.getLocalName();
            String antivirusVersion = solution.getLiteral("version").getString();
            antivirusList.add(new Antivirus(laptop, antivirusName, antivirusVersion));
        }
        return antivirusList;
    }

    /**
     * Retrieves the battery components for the specified laptop.
     */
    public List<Battery> getBatteryComponents(Laptop laptop) {
        List<Battery> batteryList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?battery ?capacity WHERE { " +
                "?battery rdf:type laptop:Battery . " +
                "?battery laptop:hasBatteryCapacity ?capacity . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource batteryResource = solution.getResource("battery");
            String name = batteryResource.getLocalName();
            double capacity = solution.getLiteral("capacity").getDouble();
            batteryList.add(new Battery(laptop, name, capacity));
        }
        return batteryList;
    }


    public List<Colour> getColourComponents(Laptop laptop) {
        List<Colour> colourList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?colour WHERE { " +
                "?colour rdf:type laptop:Colour . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource colourResource = solution.getResource("colour");
            String name = colourResource.getLocalName();
            colourList.add(new Colour(laptop, name));
        }
        return colourList;
    }

    public List<CoolingSystem> getCoolingSystemComponents(Laptop laptop) {
        List<CoolingSystem> coolingSystemList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?coolingSystem ?type WHERE { " +
                "?coolingSystem rdf:type laptop:CoolingSystem . " +
                "?coolingSystem laptop:hasCoolingSystemType ?type . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource coolingSystemResource = solution.getResource("coolingSystem");
            String name = coolingSystemResource.getLocalName();
            String type = solution.getLiteral("type").getString();
            coolingSystemList.add(new CoolingSystem(laptop, name, type));
        }
        return coolingSystemList;
    }

    public List<Cpu> getCPUComponents(Laptop laptop) {
        List<Cpu> cpuList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?cpu ?speed WHERE { " +
                "?cpu rdf:type laptop:CPU . " +
                "?cpu laptop:hasCPUSpeed ?speed . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource cpuResource = solution.getResource("cpu");
            String name = cpuResource.getLocalName();
            String speed = solution.getLiteral("speed").getString();
            cpuList.add(new Cpu(laptop, name, speed));
        }
        return cpuList;
    }

    public List<Display> getDisplayComponents(Laptop laptop) {
        List<Display> displayList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX laptop: <http://www.semanticweb.org/fabio/ontologies/2024/7/LaptopConfigModellazione#> " +
                "SELECT ?display ?resolution WHERE { " +
                "?display rdf:type laptop:Display . " +
                "?display laptop:hasDisplayResolution ?resolution . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource displayResource = solution.getResource("display");
            String name = displayResource.getLocalName();
            String resolution = solution.getLiteral("resolution").getString();
            displayList.add(new Display(laptop, name, resolution));
        }
        return displayList;
    }




}