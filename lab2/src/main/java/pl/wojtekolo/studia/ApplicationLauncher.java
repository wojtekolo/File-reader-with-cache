package pl.wojtekolo.studia;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.wojtekolo.studia.file.FileExplorer;

public class ApplicationLauncher extends javafx.application.Application{
    @Override
    public void start(Stage stage) throws Exception {
        var resource = getClass().getResource("/MainView.fxml");

        FXMLLoader loader = new FXMLLoader(resource);
        javafx.scene.Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.sizeToScene();

        stage.setTitle("Lab 02 - Przeglądarka plików z cache");
        stage.show();
    }
}
