package pl.wojtekolo.studia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import pl.wojtekolo.studia.file.*;

import java.io.File;
import java.io.IOException;

public class MainController {

    @FXML
    StackPane leftPane;

    @FXML
    StackPane rightPane;

    private FileReadController fileReadController;

    @FXML
    public void initialize() {
        FileExplorer explorer = new FileExplorer();
        FileCacher cacher = new FileCacher();

        leftPane.getChildren().add(explorer);

        loadView("/OpenedFileView.fxml");

        explorer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                File selectedFile = newValue.getValue();

                if (selectedFile.isFile()) {
                    System.out.println("Kliknięto plik: " + selectedFile.getAbsolutePath());
                    ResponseDTO dto = cacher.getData(selectedFile, new PersonFileProcess());
                    if (fileReadController != null) {
                        fileReadController.updateContent(dto);
                    }
                } else if (selectedFile.isDirectory()) {
                    System.out.println("Kliknięto folder: " + selectedFile.getName());
                }
            }
        });
    }

    public void loadView(String fxmlPath) {
        try {
            rightPane.getChildren().clear();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Pane newLoadedPane = loader.load();

            this.fileReadController = loader.getController();

            rightPane.getChildren().add(newLoadedPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
