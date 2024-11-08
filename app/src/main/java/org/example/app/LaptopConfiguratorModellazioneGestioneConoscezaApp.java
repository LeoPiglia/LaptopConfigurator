package org.example.app;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.apache.jena.ontology.OntModel;
import org.example.configurator.*;
import org.example.ontology.OntologyLoader;
import org.example.ontology.QueryService;
import org.example.ontology.SPARQLQueryExecutor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class LaptopConfiguratorModellazioneGestioneConoscezaApp extends Application {

    private Laptop laptop;
    private QueryService queryService;
    private ListView<String> configurationList;

    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.ENGLISH);
        primaryStage.setTitle("Laptop Configurator");

        // Imposta l'icona della finestra
        primaryStage.getIcons().add(new Image("icons/laptop.png"));

        String ontologyFilePath = "LaptopConfiguratorModellazioneGestioneConoscenza.rdf";
        OntologyLoader ontologyLoader = new OntologyLoader(ontologyFilePath);
        OntModel model = ontologyLoader.getOntologyModel();

        if (model != null) {
            SPARQLQueryExecutor queryExecutor = new SPARQLQueryExecutor(model);
            queryService = new QueryService(queryExecutor);
            laptop = new Laptop("MyLaptop");

            // Main layout
            BorderPane mainLayout = new BorderPane();
            mainLayout.setPadding(new Insets(15));
            mainLayout.setStyle("-fx-background-color: #f8f9fa;"); // Light background

            // Header
            Label headerLabel = new Label("Laptop Configurator");
            headerLabel.setStyle("-fx-text-fill: #343a40; -fx-font-weight: bold;");
            VBox headerBox = new VBox(headerLabel);
            headerBox.setPadding(new Insets(10, 0, 20, 0));
            mainLayout.setTop(headerBox);


            // Tabs for component configuration
            TabPane tabPane = createComponentTabs();
            mainLayout.setCenter(tabPane);

            // Sidebar configuration summary
            VBox sidebar = createSidebar();
            mainLayout.setRight(sidebar);

            Scene scene = new Scene(mainLayout, 1070, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            System.err.println("Error loading the ontology.");
        }
    }

    private TabPane createComponentTabs() {
        TabPane tabPane = new TabPane();

        // Creating individual tabs for each component
        tabPane.getTabs().add(createTab("Audio System", this::configureAudioSystem));
        tabPane.getTabs().add(createTab("Battery", this::configureBattery));
        tabPane.getTabs().add(createTab("Colour", this::configureColour));
        tabPane.getTabs().add(createTab("Cooling System", this::configureCoolingSystem));
        tabPane.getTabs().add(createTab("Guarantee", this::configureGuarantee));
        tabPane.getTabs().add(createTab("Operating System", this::configureOperatingSystem));
        tabPane.getTabs().add(createTab("Security", this::configureSecurity));
        tabPane.getTabs().add(createTab("Accessory", this::configureAccessory));
        tabPane.getTabs().add(createTab("Port", this::configurePort));
        tabPane.getTabs().add(createTab("Hardware Component", this::configureHardwareComponent));

        return tabPane;
    }

    private Tab createTab(String title, Runnable configurationMethod) {
        Tab tab = new Tab(title);
        tab.setClosable(false);

        Button configureButton = new Button("Configure " + title);
        configureButton.setFont(new Font("Arial", 15));
        configureButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-padding: 8 16 8 16;");
        configureButton.setOnAction(e -> configurationMethod.run());

        VBox content = new VBox(10, configureButton);
        content.setPadding(new Insets(10));
        tab.setContent(content);

        return tab;
    }

    private VBox createSidebar() {
        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(15));
        sidebar.setStyle("-fx-background-color: #ffffff; -fx-border-color: #dee2e6; -fx-border-width: 1;");

        Label summaryLabel = new Label("Configuration Summary");
        summaryLabel.setFont(new Font("Arial", 16));
        summaryLabel.setStyle("-fx-text-fill: #343a40; -fx-font-weight: bold;");

        configurationList = new ListView<>();
        configurationList.setStyle("-fx-background-color: #f1f3f5; -fx-border-color: #ced4da;");

        Button finalizeButton = new Button("Finalize Configuration");
        finalizeButton.setFont(new Font("Arial", 15));
        finalizeButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-padding: 8 16 8 16;");
        finalizeButton.setOnAction(e -> showFinalConfiguration());

        sidebar.getChildren().addAll(summaryLabel, configurationList, finalizeButton);

        return sidebar;
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


            // Load the custom icon image
            ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/audioSystem.png")));
            customIcon.setFitHeight(50);
            customIcon.setFitWidth(50);

            // Set the custom icon as the graphic for the dialog's header
            audioDialog.setGraphic(customIcon);

            audioDialog.showAndWait().ifPresent(selectedAudioSystem -> {
                laptop.setAudioSystem(selectedAudioSystem);
                updateConfigurationList("Audio System", selectedAudioSystem.getAudioSystemName());
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

            // Load the custom icon image
            ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/battery.png")));
            customIcon.setFitHeight(50);
            customIcon.setFitWidth(50);

            // Set the custom icon as the graphic for the dialog's header
            batteryDialog.setGraphic(customIcon);

            batteryDialog.showAndWait().ifPresent(selectedBattery -> {
                laptop.setBattery(selectedBattery);
                updateConfigurationList("Battery", selectedBattery.getBatteryName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/colour.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        colourDialog.setGraphic(customIcon);

        colourDialog.showAndWait().ifPresent(selectedColour -> {
            laptop.setColour(selectedColour);
            updateConfigurationList("Colour", selectedColour.getColourName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/coolingSystem.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        coolingDialog.setGraphic(customIcon);

        coolingDialog.showAndWait().ifPresent(selectedCoolingSystem -> {
            laptop.setCoolingSystem(selectedCoolingSystem);
            updateConfigurationList("Cooling System", selectedCoolingSystem.getCoolingSystemName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/Guarantee.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        guaranteeDialog.setGraphic(customIcon);

        guaranteeDialog.showAndWait().ifPresent(selectedGuarantee -> {
            laptop.setGuarantee(selectedGuarantee);
            updateConfigurationList("Guarantee", selectedGuarantee.getGuaranteeName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/operativeSystem.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        operatingSystemDialog.setGraphic(customIcon);

        operatingSystemDialog.showAndWait().ifPresent(selectedOperatingSystem -> {
            laptop.setOperatingSystem(selectedOperatingSystem);
            updateConfigurationList("Operating System", selectedOperatingSystem.getOperatingSystemName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/security.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        securityDialog.setGraphic(customIcon);

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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/antivirus.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        antivirusDialog.setGraphic(customIcon);

        antivirusDialog.showAndWait().ifPresent(selectedAntivirus -> {
            laptop.addSecurity(selectedAntivirus);
            updateConfigurationList("Antivirus", selectedAntivirus.getAntivirusName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/protectionFeature.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        protectionFeatureDialog.setGraphic(customIcon);

        protectionFeatureDialog.showAndWait().ifPresent(selectedProtectionFeature -> {
            laptop.addSecurity(selectedProtectionFeature);
            updateConfigurationList("Protection Feature", selectedProtectionFeature.getProtectionFeatureName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/accessory.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        accessoryDialog.setGraphic(customIcon);

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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/mouse.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        mouseDialog.setGraphic(customIcon);

        mouseDialog.showAndWait().ifPresent(selectedMouse -> {
            laptop.addAccessory(selectedMouse);
            updateConfigurationList("Mouse", selectedMouse.getMouseName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/keyboard.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        externalKeyboardDialog.setGraphic(customIcon);

        externalKeyboardDialog.showAndWait().ifPresent(selectedExternalKeyboard -> {
            laptop.addAccessory(selectedExternalKeyboard);
            updateConfigurationList("External Keyboard", selectedExternalKeyboard.getExternalKeyboardName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/monitor.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        externalMonitorDialog.setGraphic(customIcon);

        externalMonitorDialog.showAndWait().ifPresent(selectedExternalMonitor -> {
            laptop.addAccessory(selectedExternalMonitor);
            updateConfigurationList("External Monitor", selectedExternalMonitor.getExternalMonitorName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/port.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        portsDialog.setGraphic(customIcon);

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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/usb.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        usbPortDialog.setGraphic(customIcon);

        usbPortDialog.showAndWait().ifPresent(selectedUsbPort -> {
            laptop.addPort(selectedUsbPort);
            updateConfigurationList("USB Version", selectedUsbPort.toString());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/hdmi.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        hdmiPortDialog.setGraphic(customIcon);

        hdmiPortDialog.showAndWait().ifPresent(selectedHdmiPort -> {
            laptop.addPort(selectedHdmiPort);
            updateConfigurationList("HDMI Version", selectedHdmiPort.getHdmiVersion());
        });
    }

    private void configureHardwareComponent() {
        List<String> hardwareComponentOptions = new ArrayList<>();
        hardwareComponentOptions.add("Graphics Card");
        hardwareComponentOptions.add("Cpu");
        hardwareComponentOptions.add("Keyboard");
        hardwareComponentOptions.add("Ram");
        hardwareComponentOptions.add("Storage");
        hardwareComponentOptions.add("Trackpad");
        hardwareComponentOptions.add("Webcam");
        hardwareComponentOptions.add("Display");

        ChoiceDialog<String> hardwareComponentDialog = new ChoiceDialog<>(hardwareComponentOptions.get(0), hardwareComponentOptions);
        hardwareComponentDialog.setTitle("Hardware Component Configuration");
        hardwareComponentDialog.setHeaderText("Select the type of hardware component you want to configure:");
        hardwareComponentDialog.setContentText("Hardware Component:");

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/laptop.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        hardwareComponentDialog.setGraphic(customIcon);

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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/cpu.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        cpuDialog.setGraphic(customIcon);

        cpuDialog.showAndWait().ifPresent(selectedCpu -> {
            laptop.addHardwareComponent(selectedCpu);
            updateConfigurationList("CPU", selectedCpu.getCpuName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/monitor.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        displayDialog.setGraphic(customIcon);

        displayDialog.showAndWait().ifPresent(selectedDisplay -> {
            laptop.addHardwareComponent(selectedDisplay);
            updateConfigurationList("Display", selectedDisplay.getDisplayName());
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

        // Load the custom icon image
        InputStream iconStream = getClass().getResourceAsStream("/icons/GraphicCard.png");
        if (iconStream != null) {
            ImageView customIcon = new ImageView(new Image(iconStream));
            customIcon.setFitHeight(50);
            customIcon.setFitWidth(50);
            graphicsCardDialog.setGraphic(customIcon);
        }

        graphicsCardDialog.showAndWait().ifPresent(selectedGraphicsCard -> {
            laptop.addHardwareComponent(selectedGraphicsCard);
            updateConfigurationList("Graphics Card", selectedGraphicsCard.getGraphicsCardName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/keyboard.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        keyboardDialog.setGraphic(customIcon);

        keyboardDialog.showAndWait().ifPresent(selectedKeyboard -> {
            laptop.addHardwareComponent(selectedKeyboard);
            updateConfigurationList("Keyboard", selectedKeyboard.getKeyboardName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/ram.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        ramDialog.setGraphic(customIcon);

        ramDialog.showAndWait().ifPresent(selectedRam -> {
            laptop.addHardwareComponent(selectedRam);
            updateConfigurationList("RAM", selectedRam.getRamName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/storage.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        storageDialog.setGraphic(customIcon);

        storageDialog.showAndWait().ifPresent(selectedStorage -> {
            laptop.addHardwareComponent(selectedStorage);
            updateConfigurationList("Storage", selectedStorage.getStorageName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/trackpad.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        trackpadDialog.setGraphic(customIcon);

        trackpadDialog.showAndWait().ifPresent(selectedTrackpad -> {
            laptop.addHardwareComponent(selectedTrackpad);
            updateConfigurationList("Trackpad", selectedTrackpad.getTrackpadName());
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

        // Load the custom icon image
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/webcam.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        // Set the custom icon as the graphic for the dialog's header
        webcamDialog.setGraphic(customIcon);

        webcamDialog.showAndWait().ifPresent(selectedWebcam -> {
            laptop.addHardwareComponent(selectedWebcam);
            updateConfigurationList("Webcam", selectedWebcam.getWebcamName());
        });
    }


    private void updateConfigurationList(String component, String name) {
        String entry = component + ": " + name;
        // Rimuovi l'entry esistente solo se non è una porta, un accessorio, un componente hardware o una sicurezza
        if (!component.equals("Port") && !component.equals("Accessory") && !component.equals("Hardware Component") && !component.equals("Security")) {
            configurationList.getItems().removeIf(item -> item.startsWith(component + ":"));
        }
        // Aggiungi la nuova configurazione alla lista
        configurationList.getItems().add(entry);
    }

    private void showFinalConfiguration() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Final Configuration");
        alert.setHeaderText(null);

        // Costruisci la configurazione finale
        ImageView customIcon = new ImageView(new Image(getClass().getResourceAsStream("/icons/laptop.png")));
        customIcon.setFitHeight(50);
        customIcon.setFitWidth(50);

        alert.setGraphic(customIcon);


        StringBuilder configuration = new StringBuilder("Final Configuration:\n");
        configuration.append("Audio System: ").append(formatComponent(laptop.getAudioSystem())).append("\n");
        configuration.append("Battery: ").append(formatComponent(laptop.getBattery())).append("\n");
        configuration.append("Colour: ").append(formatComponent(laptop.getColour())).append("\n");
        configuration.append("Cooling System: ").append(formatComponent(laptop.getCoolingSystem())).append("\n");
        configuration.append("Guarantee: ").append(formatComponent(laptop.getGuarantee())).append("\n");
        configuration.append("Operating System: ").append(formatComponent(laptop.getOperatingSystem())).append("\n");
        configuration.append("Security: ").append(formatComponent(laptop.getSecurities())).append("\n");
        configuration.append("Accessories: ").append(formatComponent(laptop.getAccessories())).append("\n");
        configuration.append("Ports: ").append(formatComponent(laptop.getPorts())).append("\n");
        configuration.append("Hardware Components: ").append(formatComponent(laptop.getHardwareComponents())).append("\n");


        alert.setContentText(configuration.toString());
        alert.showAndWait();
    }

    private String formatComponent(Object component) {
        return component != null ? component.toString() : "Not configured";
    }

        // Helper methods for showing alerts
        private void showError (String message){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(message);
            alert.showAndWait();
        }

        private void showSuccess (String message){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText(message);
            alert.showAndWait();
        }

        public static void main (String[]args){
            launch(args);
        }
    }