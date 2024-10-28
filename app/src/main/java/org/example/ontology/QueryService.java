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
     * retireves the antivirus version available for the specified laptop
     */
    public List<Antivirus> getAntivirusComponents(Laptop laptop) {
        List<Antivirus> antivirusList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?antivirus ?version WHERE { " +
                "?antivirus rdf:type laptop:Antivirus . " +
                "?antivirus laptop:HasAntivirusVersion ?version . " +
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
                "?battery laptop:HasBatteryCapacity ?capacity . " +
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

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?colour ?name WHERE { " +
                "?colour rdf:type laptop:Colour . " +
                "?colour laptop:HasColourName ?name . " +
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

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?coolingSystem ?type WHERE { " +
                "?coolingSystem rdf:type laptop:CoolingSystem . " +
                "?coolingSystem laptop:HasCoolingSystemType ?type . " +
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

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?cpu ?speed WHERE { " +
                "?cpu rdf:type laptop:Cpu . " +
                "?cpu laptop:HasCPUSpeed ?speed . " +
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

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?display ?resolution WHERE { " +
                "?display rdf:type laptop:Display . " +
                "?display laptop:HasDisplayResolution ?resolution . " +
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

    public List<ExternalKeyboard> getExternalKeyboardComponents(Laptop laptop) {
        List<ExternalKeyboard> externalKeyboardList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?externalKeyboard ?layout ?connectionType WHERE { " +
                "?externalKeyboard rdf:type laptop:ExternalKeyboard . " +
                "?externalKeyboard laptop:HasExternalKeyboardLayout ?layout . " +
                "?externalKeyboard laptop:HasConnectionType ?connectionType . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource externalKeyboardResource = solution.getResource("externalKeyboard");
            String name = externalKeyboardResource.getLocalName();
            String layout = solution.getLiteral("layout").getString();
            String connectionType = solution.getLiteral("connectionType").getString();
            externalKeyboardList.add(new ExternalKeyboard(laptop, name, layout, connectionType));
        }
        return externalKeyboardList;
    }

    public List<ExternalMonitor> getExternalMonitorComponents(Laptop laptop) {
        List<ExternalMonitor> externalMonitorList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?externalMonitor ?resolution ?connectionType WHERE { " +
                "?externalMonitor rdf:type laptop:ExternalMonitor . " +
                "?externalMonitor laptop:HasExternalMonitorResolution ?resolution . " +
                "?externalMonitor laptop:HasConnectionType ?connectionType . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource externalMonitorResource = solution.getResource("externalMonitor");
            String name = externalMonitorResource.getLocalName();
            String resolution = solution.getLiteral("resolution").getString();
            String connectionType = solution.getLiteral("connectionType").getString();
            externalMonitorList.add(new ExternalMonitor(laptop, name, resolution, connectionType));
        }
        return externalMonitorList;
    }
}