package org.example.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.jena.ontology.OntModel;
import org.example.configurator.*;
import org.example.ontology.OntologyLoader;
import org.example.ontology.QueryService;
import org.example.ontology.SPARQLQueryExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LaptopConfiguratorModellazioneGestioneConoscezaApp extends Application {

    private Laptop laptop;
    private QueryService queryService;

    /**
     * Starts the JavaFX application, initializes the GUI components, and loads the ontology.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.ENGLISH);
        primaryStage.setTitle("Laptop Configurator");

        String ontologyFilePath = "LaptopConfiguratorModellazioneGestioneConoscenza.rdf";
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        if (model != null) {
            SPARQLQueryExecutor queryExecutor = new SPARQLQueryExecutor(model);
            queryService = new QueryService(queryExecutor);

            laptop = new Laptop("MyLaptop");

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(20, 20, 20, 20));
            layout.setStyle("-fx-background-color: #f0f0f0;"); // Background color

            Label welcomeLabel = new Label("Welcome to the laptop configurator!");
            welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");


            ComboBox<String> componentSelector = new ComboBox<>();
            componentSelector.getItems().addAll("Processor", "Memory", "Storage", "Graphics Card", "Display", "Battery", "Operating System", "Audio System", "Cooling System", "Colour", "Guarantee", "Security", "Accessory");
            componentSelector.setPromptText("Select a component");
            componentSelector.setStyle("-fx-font-size: 14px; -fx-padding: 8 10 8 10;");

            Button configButton = new Button("Configure");
            configButton.setStyle("-fx-font-size: 14px; -fx-padding: 8 10 8 10;");

            Button finalizeButton = new Button("Finalize Configuration");
            finalizeButton.setStyle("-fx-font-size: 14px; -fx-padding: 8 10 8 10;");

            String buttonHoverStyle = "-fx-background-color: #4CAF50; -fx-text-fill: white;";

            configButton.setOnMouseEntered(e -> configButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"));
            configButton.setOnMouseExited(e -> configButton.setStyle("-fx-font-size: 14px; -fx-padding: 8 10 8 10;"));

            finalizeButton.setOnMouseEntered(e -> finalizeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"));
            finalizeButton.setOnMouseExited(e -> finalizeButton.setStyle("-fx-font-size: 14px; -fx-padding: 8 10 8 10;"));

            configButton.setOnAction(e -> configureComponent(componentSelector.getValue()));
            finalizeButton.setOnAction(e -> showFinalConfiguration());

            layout.getChildren().addAll(welcomeLabel, componentSelector, configButton, finalizeButton);

            Scene scene = new Scene(layout, 400, 300);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            System.err.println("Error loading the ontology.");
        }
    }

    /**
     * Configures the selected component of the laptop.
     *
     * @param selectedComponent the name of the component chosen by the user
     */

    private void configureComponent(String selectedComponent) {
        if (selectedComponent == null) {
            showError("Please select a component to configure.");
            return;
        }

        switch (selectedComponent) {
            case "Audio System":
                configureAudioSystem();
                break;
            case "Battery":
                configureBattery();
                break;
            case "Colour":
                configureColour();
                break;
            case "Cooling System":
                configureCoolingSystem();
                break;
            case "Guarantee":
                configureGuarantee();
                break;
            case "Operating System":
                configureOperatingSystem();
                break;
            case "Security":
                configureSecurity();
                break;
            case "Accessory":
                configureAccessory();
                break;
            case "Port":
                configurePort();
                break;
            case "Hardware Component":
                configureHardwareComponent();
                break;
            default:
                showError("Invalid component selected.");
        }
    }

        /**
         * Configures the audio system component of the laptop.
         */

        private void configureAudioSystem() {
            List<AudioSystem> audioSystems = queryService.getAudioSystemComponents(laptop);
            if (audioSystems.isEmpty()) {
                showError("No audio systems found.");
                return;
            }
            ChoiceDialog<AudioSystem> audioDialog = new ChoiceDialog<>(audioSystems.get(0), audioSystems);
            audioDialog.setTitle("Audio System Configuration");
            audioDialog.setHeaderText("Select an audio system");
            audioDialog.setContentText("Audio System:");

            audioDialog.showAndWait().ifPresent(selectedAudioSystem -> {
                laptop.setAudioSystem(selectedAudioSystem);
                showSuccess("You have added the audio system: " + selectedAudioSystem.getAudioSystemName());
            });
        }

        /**
         * Configures the battery component of the laptop.
         */

        private void configureBattery() {
            List<Battery> batteries = queryService.getBatteryComponents(laptop);
            if (batteries.isEmpty()) {
                showError("No batteries found.");
                return;
            }
            ChoiceDialog<Battery> batteryDialog = new ChoiceDialog<>(batteries.get(0), batteries);
            batteryDialog.setTitle("Battery Configuration");
            batteryDialog.setHeaderText("Select a battery");
            batteryDialog.setContentText("Battery:");

            batteryDialog.showAndWait().ifPresent(selectedBattery -> {
                laptop.setBattery(selectedBattery);
                showSuccess("You have added the battery: " + selectedBattery.getBatteryName());
            });
        }

    private void configureColour() {
        List<Colour> colours = queryService.getColourComponents(laptop);
        if (colours.isEmpty()) {
            showError("No colours found.");
            return;
        }
        ChoiceDialog<Colour> colourDialog = new ChoiceDialog<>(colours.get(0), colours);
        colourDialog.setTitle("Colour Configuration");
        colourDialog.setHeaderText("Select a colour");
        colourDialog.setContentText("Colour:");

        colourDialog.showAndWait().ifPresent(selectedColour -> {
            laptop.setColour(selectedColour);
            showSuccess("You have added the colour: " + selectedColour.getColourName());
        });
    }

    private void configureCoolingSystem() {
        List<CoolingSystem> coolingSystems = queryService.getCoolingSystemComponents(laptop);
        if (coolingSystems.isEmpty()) {
            showError("No cooling systems found.");
            return;
        }
        ChoiceDialog<CoolingSystem> coolingDialog = new ChoiceDialog<>(coolingSystems.get(0), coolingSystems);
        coolingDialog.setTitle("Cooling System Configuration");
        coolingDialog.setHeaderText("Select a cooling system");
        coolingDialog.setContentText("Cooling System:");

        coolingDialog.showAndWait().ifPresent(selectedCoolingSystem -> {
            laptop.setCoolingSystem(selectedCoolingSystem);
            showSuccess("You have added the cooling system: " + selectedCoolingSystem.getCoolingSystemName());
        });
    }

    private void configureGuarantee() {
        List<Guarantee> guarantees = queryService.getGuaranteeComponent(laptop);
        if (guarantees.isEmpty()) {
            showError("No guarantees found.");
            return;
        }
        ChoiceDialog<Guarantee> guaranteeDialog = new ChoiceDialog<>(guarantees.get(0), guarantees);
        guaranteeDialog.setTitle("Guarantee Configuration");
        guaranteeDialog.setHeaderText("Select a guarantee");
        guaranteeDialog.setContentText("Guarantee:");

        guaranteeDialog.showAndWait().ifPresent(selectedGuarantee -> {
            laptop.setGuarantee(selectedGuarantee);
            showSuccess("You have added the guarantee: " + selectedGuarantee.getGuaranteeName());
        });
    }

    /**
     * Configures the Operating System component of the laptop.
     */

    private void configureOperatingSystem() {
        List<OperatingSystem> operatingSystems = queryService.getOperatingSystemComponents(laptop);
        if (operatingSystems.isEmpty()) {
            showError("No operating systems found.");
            return;
        }
        ChoiceDialog<OperatingSystem> operatingSystemDialog = new ChoiceDialog<>(operatingSystems.get(0), operatingSystems);
        operatingSystemDialog.setTitle("Operating System Configuration");
        operatingSystemDialog.setHeaderText("Select an operating system");
        operatingSystemDialog.setContentText("Operating System:");

        operatingSystemDialog.showAndWait().ifPresent(selectedOperatingSystem -> {
            laptop.setOperatingSystem(selectedOperatingSystem);
            showSuccess("You have added the operating system: " + selectedOperatingSystem.getOperatingSystemName());
        });
    }

    /**
     * Configures the security component of the laptop.
     */

    private void configureSecurity() {
        // Create a menu to select the type of security to configure
        List<String> securityOptions = new ArrayList<>();
        securityOptions.add("Antivirus");
        securityOptions.add("Protection Feature");

        ChoiceDialog<String> securityDialog = new ChoiceDialog<>(securityOptions.get(0), securityOptions);
        securityDialog.setTitle("Security Configuration");
        securityDialog.setHeaderText("Select the type of security you want to configure:");
        securityDialog.setContentText("Security:");

        // Show the dialog and act based on the choice
        securityDialog.showAndWait().ifPresent(selectedSecurity -> {
            switch (selectedSecurity) {
                case "Antivirus":
                    configureAntivirus();
                    break;
                case "Protection Feature":
                    configureProtectionFeature();
                    break;
                default:
                    showError("Invalid security type.");
            }
        });
    }

    private void configureAntivirus() {
        List<Antivirus> antiviruses = queryService.getAntivirusComponents(laptop);
        if (antiviruses.isEmpty()) {
            showError("No antivirus programs found.");
            return;
        }
        ChoiceDialog<Antivirus> antivirusDialog = new ChoiceDialog<>(antiviruses.get(0), antiviruses);
        antivirusDialog.setTitle("Antivirus Configuration");
        antivirusDialog.setHeaderText("Select an antivirus program");
        antivirusDialog.setContentText("Antivirus:");

        antivirusDialog.showAndWait().ifPresent(selectedAntivirus -> {
            laptop.addSecurity(selectedAntivirus);
            showSuccess("You have added the antivirus program: " + selectedAntivirus.getAntivirusName());
        });
    }

    private void configureProtectionFeature() {
        List<ProtectionFeature> protectionFeatures = queryService.getProtectionFeatureComponents(laptop);
        if (protectionFeatures.isEmpty()) {
            showError("No protection features found.");
            return;
        }
        ChoiceDialog<ProtectionFeature> protectionFeatureDialog = new ChoiceDialog<>(protectionFeatures.get(0), protectionFeatures);
        protectionFeatureDialog.setTitle("Protection Feature Configuration");
        protectionFeatureDialog.setHeaderText("Select a protection feature");
        protectionFeatureDialog.setContentText("Protection Feature:");

        protectionFeatureDialog.showAndWait().ifPresent(selectedProtectionFeature -> {
            laptop.addSecurity(selectedProtectionFeature);
            showSuccess("You have added the protection feature: " + selectedProtectionFeature.getProtectionFeatureName());
        });
    }

    private void configureAccessory(){
        List<String> accessoryOptions = new ArrayList<>();
        accessoryOptions.add("Mouse");
        accessoryOptions.add("External Keyboard");
        accessoryOptions.add("External Monitor");

        ChoiceDialog<String> accessoryDialog = new ChoiceDialog<>(accessoryOptions.get(0), accessoryOptions);
        accessoryDialog.setTitle("Accessory Configuration");
        accessoryDialog.setHeaderText("Select the type of accessory you want to configure:");
        accessoryDialog.setContentText("Accessory:");

        accessoryDialog.showAndWait().ifPresent(selectedAccessory -> {
            switch (selectedAccessory) {
                case "Mouse":
                    configureMouse();
                    break;
                case "External Keyboard":
                    configureExternalKeyboard();
                    break;
                case "External Monitor":
                    configureExternalMonitor();
                    break;
                default:
                    showError("Invalid accessory type.");
            }
        });
    }

    private void configureMouse() {
        List<Mouse> mice = queryService.getMouseComponents(laptop);
        if (mice.isEmpty()) {
            showError("No mouse found.");
            return;
        }
        ChoiceDialog<Mouse> mouseDialog = new ChoiceDialog<>(mice.get(0), mice);
        mouseDialog.setTitle("Mouse Configuration");
        mouseDialog.setHeaderText("Select a mouse");
        mouseDialog.setContentText("Mouse:");

        mouseDialog.showAndWait().ifPresent(selectedMouse -> {
            laptop.addAccessory(selectedMouse);
            showSuccess("You have added the mouse");
        });
    }

    private void configureExternalKeyboard() {
        List<ExternalKeyboard> externalKeyboards = queryService.getExternalKeyboardComponents(laptop);
        if (externalKeyboards.isEmpty()) {
            showError("No external keyboards found.");
            return;
        }
        ChoiceDialog<ExternalKeyboard> externalKeyboardDialog = new ChoiceDialog<>(externalKeyboards.get(0), externalKeyboards);
        externalKeyboardDialog.setTitle("External Keyboard Configuration");
        externalKeyboardDialog.setHeaderText("Select an external keyboard");
        externalKeyboardDialog.setContentText("External Keyboard:");

        externalKeyboardDialog.showAndWait().ifPresent(selectedExternalKeyboard -> {
            laptop.addAccessory(selectedExternalKeyboard);
            showSuccess("You have added the external keyboard" + selectedExternalKeyboard.getExternalKeyboardName());
        });
    }

    private void configureExternalMonitor() {
        List<ExternalMonitor> externalMonitors = queryService.getExternalMonitorComponents(laptop);
        if (externalMonitors.isEmpty()) {
            showError("No external monitors found.");
            return;
        }
        ChoiceDialog<ExternalMonitor> externalMonitorDialog = new ChoiceDialog<>(externalMonitors.get(0), externalMonitors);
        externalMonitorDialog.setTitle("External Monitor Configuration");
        externalMonitorDialog.setHeaderText("Select an external monitor");
        externalMonitorDialog.setContentText("External Monitor:");

        externalMonitorDialog.showAndWait().ifPresent(selectedExternalMonitor -> {
            laptop.addAccessory(selectedExternalMonitor);
            showSuccess("You have added the external monitor" + selectedExternalMonitor.getExternalMonitorName());
        });
    }

    private void configurePort() {
        List<String> portsOptions = new ArrayList<>();
        portsOptions.add("Usb");
        portsOptions.add("Hdmi");

        ChoiceDialog<String> portsDialog = new ChoiceDialog<>(portsOptions.get(0), portsOptions);
        portsDialog.setTitle("Port Configuration");
        portsDialog.setHeaderText("Select the type of port you want to configure:");
        portsDialog.setContentText("Port:");

        portsDialog.showAndWait().ifPresent(selectedPort -> {
            switch (selectedPort) {
                case "Usb":
                    configureUsbPort();
                    break;
                case "Hdmi":
                    configureHdmiPort();
                    break;
                default:
                    showError("Invalid port type.");
            }
        });
    }

    private void configureUsbPort() {
        List<Usb> usbPorts = queryService.getUsbComponent(laptop);
        if (usbPorts.isEmpty()) {
            showError("No USB ports found.");
            return;
        }
        ChoiceDialog<Usb> usbPortDialog = new ChoiceDialog<>(usbPorts.get(0), usbPorts);
        usbPortDialog.setTitle("USB Port Configuration");
        usbPortDialog.setHeaderText("Select a USB port");
        usbPortDialog.setContentText("USB Port:");

        usbPortDialog.showAndWait().ifPresent(selectedUsbPort -> {
            laptop.addPort(selectedUsbPort);
            showSuccess("You have added the USB port");
        });
    }

    private void configureHdmiPort() {
        List<Hdmi> hdmiPorts = queryService.getHdmiComponents(laptop);
        if (hdmiPorts.isEmpty()) {
            showError("No HDMI ports found.");
            return;
        }
        ChoiceDialog<Hdmi> hdmiPortDialog = new ChoiceDialog<>(hdmiPorts.get(0), hdmiPorts);
        hdmiPortDialog.setTitle("HDMI Port Configuration");
        hdmiPortDialog.setHeaderText("Select an HDMI port");
        hdmiPortDialog.setContentText("HDMI Port:");

        hdmiPortDialog.showAndWait().ifPresent(selectedHdmiPort -> {
            laptop.addPort(selectedHdmiPort);
            showSuccess("You have added the HDMI port");
        });
    }

    private void configureHardwareComponent() {
        List<String> hardwareComponentOptions = new ArrayList<>();
        hardwareComponentOptions.add("Motherboard");
        hardwareComponentOptions.add("Processor");
        hardwareComponentOptions.add("Memory");
        hardwareComponentOptions.add("Storage");
        hardwareComponentOptions.add("Graphics Card");
        hardwareComponentOptions.add("Display");

        ChoiceDialog<String> hardwareComponentDialog = new ChoiceDialog<>(hardwareComponentOptions.get(0), hardwareComponentOptions);
        hardwareComponentDialog.setTitle("Hardware Component Configuration");
        hardwareComponentDialog.setHeaderText("Select the type of hardware component you want to configure:");
        hardwareComponentDialog.setContentText("Hardware Component:");

        hardwareComponentDialog.showAndWait().ifPresent(selectedHardwareComponent -> {
            switch (selectedHardwareComponent) {
                case "Cpu":
                    configureCpu();
                    break;
                case "Display":
                    configureDisplay();
                    break;
                    case "Graphics Card":
                    configureGraphicsCard();
                    break;
                case "Keyboard":
                    configureKeyboard();
                    break;
                case "Ram":
                    configureRam();
                    break;
                case "Storage":
                    configureStorage();
                    break;
                case "Trackpad":
                    configureTrackpad();
                    break;
                case "Webcam":
                    configureWebcam();
                    break;
                default:
                    showError("Invalid hardware component type.");
            }
        });
    }

    private void configureCpu() {
        List<Cpu> cpus = queryService.getCPUComponents(laptop);
        if (cpus.isEmpty()) {
            showError("No CPUs found.");
            return;
        }
        ChoiceDialog<Cpu> cpuDialog = new ChoiceDialog<>(cpus.get(0), cpus);
        cpuDialog.setTitle("CPU Configuration");
        cpuDialog.setHeaderText("Select a CPU");
        cpuDialog.setContentText("CPU:");

        cpuDialog.showAndWait().ifPresent(selectedCpu -> {
            laptop.addHardwareComponent(selectedCpu);
            showSuccess("You have added the CPU: " + selectedCpu.getCpuName());
        });
    }

    private void configureDisplay() {
        List<Display> displays = queryService.getDisplayComponents(laptop);
        if (displays.isEmpty()) {
            showError("No displays found.");
            return;
        }
        ChoiceDialog<Display> displayDialog = new ChoiceDialog<>(displays.get(0), displays);
        displayDialog.setTitle("Display Configuration");
        displayDialog.setHeaderText("Select a display");
        displayDialog.setContentText("Display:");

        displayDialog.showAndWait().ifPresent(selectedDisplay -> {
            laptop.addHardwareComponent(selectedDisplay);
            showSuccess("You have added the display: " + selectedDisplay.getDisplayName());
        });
    }

    private void configureGraphicsCard() {
        List<GraphicsCard> graphicsCards = queryService.getGraphicsCardComponent(laptop);
        if (graphicsCards.isEmpty()) {
            showError("No graphics cards found.");
            return;
        }
        ChoiceDialog<GraphicsCard> graphicsCardDialog = new ChoiceDialog<>(graphicsCards.get(0), graphicsCards);
        graphicsCardDialog.setTitle("Graphics Card Configuration");
        graphicsCardDialog.setHeaderText("Select a graphics card");
        graphicsCardDialog.setContentText("Graphics Card:");

        graphicsCardDialog.showAndWait().ifPresent(selectedGraphicsCard -> {
            laptop.addHardwareComponent(selectedGraphicsCard);
            showSuccess("You have added the graphics card: " + selectedGraphicsCard.getGraphicsCardName());
        });
    }

    private void configureKeyboard() {
        List<Keyboard> keyboards = queryService.getKeyBoardComponents(laptop);
        if (keyboards.isEmpty()) {
            showError("No keyboards found.");
            return;
        }
        ChoiceDialog<Keyboard> keyboardDialog = new ChoiceDialog<>(keyboards.get(0), keyboards);
        keyboardDialog.setTitle("Keyboard Configuration");
        keyboardDialog.setHeaderText("Select a keyboard");
        keyboardDialog.setContentText("Keyboard:");

        keyboardDialog.showAndWait().ifPresent(selectedKeyboard -> {
            laptop.addHardwareComponent(selectedKeyboard);
            showSuccess("You have added the keyboard: " + selectedKeyboard.getKeyboardName());
        });
    }

    private void configureRam() {
        List<Ram> rams = queryService.getRamComponents(laptop);
        if (rams.isEmpty()) {
            showError("No RAMs found.");
            return;
        }
        ChoiceDialog<Ram> ramDialog = new ChoiceDialog<>(rams.get(0), rams);
        ramDialog.setTitle("RAM Configuration");
        ramDialog.setHeaderText("Select a RAM");
        ramDialog.setContentText("RAM:");

        ramDialog.showAndWait().ifPresent(selectedRam -> {
            laptop.addHardwareComponent(selectedRam);
            showSuccess("You have added the RAM: " + selectedRam.getRamName());
        });
    }

    private void configureStorage() {
        List<Storage> storages = queryService.getStorageComponent(laptop);
        if (storages.isEmpty()) {
            showError("No storages found.");
            return;
        }
        ChoiceDialog<Storage> storageDialog = new ChoiceDialog<>(storages.get(0), storages);
        storageDialog.setTitle("Storage Configuration");
        storageDialog.setHeaderText("Select a storage");
        storageDialog.setContentText("Storage:");

        storageDialog.showAndWait().ifPresent(selectedStorage -> {
            laptop.addHardwareComponent(selectedStorage);
            showSuccess("You have added the storage: " + selectedStorage.getStorageName());
        });
    }

    private void configureTrackpad() {
        List<Trackpad> trackpads = queryService.getTrackpadComponents(laptop);
        if (trackpads.isEmpty()) {
            showError("No trackpads found.");
            return;
        }
        ChoiceDialog<Trackpad> trackpadDialog = new ChoiceDialog<>(trackpads.get(0), trackpads);
        trackpadDialog.setTitle("Trackpad Configuration");
        trackpadDialog.setHeaderText("Select a trackpad");
        trackpadDialog.setContentText("Trackpad:");

        trackpadDialog.showAndWait().ifPresent(selectedTrackpad -> {
            laptop.addHardwareComponent(selectedTrackpad);
            showSuccess("You have added the trackpad: " + selectedTrackpad.getTrackpadName());
        });
    }

    private void configureWebcam() {
        List<Webcam> webcams = queryService.getWebcamComponent(laptop);
        if (webcams.isEmpty()) {
            showError("No webcams found.");
            return;
        }
        ChoiceDialog<Webcam> webcamDialog = new ChoiceDialog<>(webcams.get(0), webcams);
        webcamDialog.setTitle("Webcam Configuration");
        webcamDialog.setHeaderText("Select a webcam");
        webcamDialog.setContentText("Webcam:");

        webcamDialog.showAndWait().ifPresent(selectedWebcam -> {
            laptop.addHardwareComponent(selectedWebcam);
            showSuccess("You have added the webcam: " + selectedWebcam.getWebcamName());
        });
    }

    private void showFinalConfiguration() {

            StringBuilder configuration = new StringBuilder();
            configuration.append("Final Configuration:\n");
            configuration.append("Audio System: ").append(laptop.getAudioSystem()).append("\n");
            configuration.append("Battery: ").append(laptop.getBattery()).append("\n");
            configuration.append("Colour: ").append(laptop.getColour()).append("\n");
            configuration.append("Cooling System: ").append(laptop.getCoolingSystem()).append("\n");
            configuration.append("Guarantee: ").append(laptop.getGuarantee()).append("\n");
            configuration.append("Operating System: ").append(laptop.getOperatingSystem()).append("\n");
            configuration.append("Security: ").append(laptop.getSecurities()).append("\n");
            configuration.append("Accessories: ").append(laptop.getAccessories()).append("\n");
            configuration.append("Ports: ").append(laptop.getPorts()).append("\n");
            configuration.append("Hardware Components: ").append(laptop.getHardwareComponents()).append("\n");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Final Configuration");
            alert.setHeaderText(null);
            alert.setContentText(configuration.toString());
            alert.showAndWait();
        }



    // Helper methods for showing alerts
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}