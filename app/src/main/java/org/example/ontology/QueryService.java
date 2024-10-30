package org.example.ontology;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;
import org.example.configurator.*;

import java.util.ArrayList;
import java.util.List;

public class QueryService {
    private static SPARQLQueryExecutor queryExecutor;

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
            String version = solution.getLiteral("version").getString();
            antivirusList.add(new Antivirus(laptop, antivirusName, version));
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
            String capacity = solution.getLiteral("capacity").getString();
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

    public List<Guarantee> getGuaranteeComponent (Laptop laptop){
        List<Guarantee> guaranteeList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?guarantee (STR(?period) AS ?periodValue) WHERE { " +
                "?guarantee rdf:type laptop:Guarantee . " +
                "?guarantee laptop:HasGuaranteePeriod ?period . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource guaranteeResource = solution.getResource("guarantee");
            String name = guaranteeResource.getLocalName();
            String period = solution.getLiteral("periodValue").getString();
            guaranteeList.add(new Guarantee(laptop, name, period));
        }
        return guaranteeList;
    }

    public List<Hdmi> getHdmiComponents(Laptop laptop) {
        List<Hdmi> hdmiList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?hdmi ?version WHERE { " +
                "?hdmi rdf:type laptop:Hdmi . " +
                "?hdmi laptop:HasHdmiVersion ?version . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource hdmiResource = solution.getResource("hdmi");
            String version = solution.getLiteral("version").getString();
            hdmiList.add(new Hdmi(laptop, version));
        }
        return hdmiList;
    }

    public List<Keyboard> getKeyBoardComponents(Laptop laptop) {
        List<Keyboard> keyboardList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?keyboard ?layout WHERE { " +
                "?keyboard rdf:type laptop:Keyboard . " +
                "?keyboard laptop:HasKeyBoardLayout ?layout . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource keyboardResource = solution.getResource("keyboard");
            String name = keyboardResource.getLocalName();
            String layout = solution.getLiteral("layout").getString();
            keyboardList.add(new Keyboard(laptop, name, layout));
        }
        return keyboardList;
    }

    public List<OperatingSystem> getOperatingSystemComponents (Laptop laptop){
        List<OperatingSystem> operatingSystemList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?operatingSystem ?edition WHERE { " +
                "?operatingSystem rdf:type laptop:OperatingSystem . " +
                "?operatingSystem laptop:HasOperatingSystemEdition ?edition . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource operatingSystemResource = solution.getResource("operatingSystem");
            String name = operatingSystemResource.getLocalName();
            String edition = solution.getLiteral("edition").getString();
            operatingSystemList.add(new OperatingSystem(laptop, name, edition));
        }
        return operatingSystemList;
    }

    public List <AudioSystem> getAudioSystemComponents(Laptop laptop){
        List<AudioSystem> audioSystemList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?audioSystem ?power WHERE { " +
                "?audioSystem rdf:type laptop:AudioSystem . " +
                "?audioSystem laptop:HasOutputPower ?power . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource audioSystemResource = solution.getResource("audioSystem");
            String name = audioSystemResource.getLocalName();
            String power = solution.getLiteral("power").getString();
            audioSystemList.add(new AudioSystem(laptop, name, power));
        }
        return audioSystemList;
    }

    public List <ProtectionFeature> getProtectionFeatureComponents(Laptop laptop){
        List<ProtectionFeature> protectionFeatureList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?protectionFeature ?type WHERE { " +
                "?protectionFeature rdf:type laptop:ProtectionFeature . " +
                "?protectionFeature laptop:HasProtectionFeatureType ?type . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource protectionFeatureResource = solution.getResource("protectionFeature");
            String name = protectionFeatureResource.getLocalName();
            String type = solution.getLiteral("type").getString();
            protectionFeatureList.add(new ProtectionFeature(laptop, name, type));
        }
        return protectionFeatureList;
    }

    public static List <Ram> getRamComponents(Laptop laptop){
        List<Ram> ramList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?ram ?size WHERE { " +
                "?ram rdf:type laptop:Ram . " +
                "?ram laptop:HasRAMSize ?size . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource ramResource = solution.getResource("ram");
            String name = ramResource.getLocalName();
            String size = solution.getLiteral("size").getString();
            ramList.add(new Ram(laptop, name, size));
        }
        return ramList;
    }

    public List <Storage> getStorageComponent (Laptop laptop){
        List<Storage> storageList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?storage ?capacity WHERE { " +
                "?storage rdf:type laptop:Storage . " +
                "?storage laptop:HasStorageCapacity ?capacity . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource storageResource = solution.getResource("storage");
            String name = storageResource.getLocalName();
            String capacity = solution.getLiteral("capacity").getString();
            storageList.add(new Storage(laptop, name, capacity));
        }
        return storageList;
    }

    public List<Trackpad> getTrackpadComponents(Laptop laptop) {
        List<Trackpad> trackpadList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?trackpad ?dimension WHERE { " +
                "?trackpad rdf:type laptop:Trackpad . " +
                "?trackpad laptop:hasTrackpadDimensions ?dimension . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource trackpadResource = solution.getResource("trackpad");
            String name = trackpadResource.getLocalName();
            String dimension = solution.getLiteral("dimension").getString();
            trackpadList.add(new Trackpad(laptop, name, dimension));
        }
        return trackpadList;
    }

    public List<Usb> getUsbComponent (Laptop laptop){
        List<Usb> usbList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?usb ?type WHERE { " +
                "?usb rdf:type laptop:Usb . " +
                "?usb laptop:HasUsbType ?type . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource usbResource = solution.getResource("usb");
            String name = usbResource.getLocalName();
            String type = solution.getLiteral("type").getString();
            usbList.add(new Usb(laptop, type));
        }
        return usbList;
    }

    public List<GraphicsCard> getGraphicsCardComponent (Laptop laptop){
        List<GraphicsCard> graphicsCardList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?graphicsCard ?videoMemory WHERE { " +
                "?graphicsCard rdf:type laptop:GraphicsCard . " +
                "?graphicsCard laptop:HasVideoMemory ?videoMemory . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource graphicsCardResource = solution.getResource("graphicsCard");
            String name = graphicsCardResource.getLocalName();
            String videoMemory = solution.getLiteral("videoMemory").getString();
            graphicsCardList.add(new GraphicsCard(laptop, name, videoMemory));
        }
        return graphicsCardList;
    }

    public List<Webcam> getWebcamComponent (Laptop laptop){
        List<Webcam> webcamList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?webcam ?resolution WHERE { " +
                "?webcam rdf:type laptop:Webcam . " +
                "?webcam laptop:HasWebcamResolution ?resolution . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource webcamResource = solution.getResource("webcam");
            String name = webcamResource.getLocalName();
            String resolution = solution.getLiteral("resolution").getString();
            webcamList.add(new Webcam(laptop, name, resolution));
        }
        return webcamList;
    }

    public List<Mouse> getMouseComponents (Laptop laptop){
        List<Mouse> mouseList = new ArrayList<>();

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX laptop: <http://www.semanticweb.org/leona/ontologies/2024/9/LaptopConfiguratorModellazioneGestioneConoscenza#>" +
                "SELECT ?mouse ?connectionType WHERE { " +
                "?mouse rdf:type laptop:Mouse . " +
                "?mouse laptop:HasConnectionType ?connectionType . " +
                "}";

        ResultSet results = queryExecutor.executeQuery(sparqlQuery);
        while (results != null && results.hasNext()) {
            QuerySolution solution = results.nextSolution();
            Resource mouseResource = solution.getResource("mouse");
            String name = mouseResource.getLocalName();
            String connectionType = solution.getLiteral("connectionType").getString();
            mouseList.add(new Mouse(laptop, name, connectionType));
        }
        return mouseList;
    }
}