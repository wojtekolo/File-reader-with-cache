package pl.wojtekolo.studia;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.wojtekolo.studia.file.ResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileReadController {
    @FXML private TableView<String> table1;
    @FXML private TableColumn<String, String> column1;

    @FXML private TableView<Map.Entry<String, String>> table2;
    @FXML private TableColumn<Map.Entry<String, String>, String> column2;
    @FXML private TableColumn<Map.Entry<String, String>, String> column3;

    @FXML private Label lblCached;
    private final StringProperty cached = new SimpleStringProperty("");

    private static final int rows=4;

    @FXML
    public void initialize() {
        column1.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue()));

        column2.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getKey()));
        column3.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getValue()));
        lblCached.textProperty().bind(cached);
    }

    public void updateContent(ResponseDTO dto) {
        String content = dto.data().fullConent();
        String[] allLines = content.split("\n");
        List<String> limitedLines = new ArrayList<>();

        int limit = allLines.length;
        if (limit > rows) {
            limit = rows;
        }

        for (int i = 0; i < limit; i++) {
            limitedLines.add(allLines[i]);
        }
        table1.getItems().setAll(limitedLines);

        if (dto.data().calculatedData() != null) {
            table2.getItems().setAll(dto.data().calculatedData().entrySet());
        }

        if (dto.wasCached()) cached.set("Plik znaleziony w cache");
        else cached.set("Plik nie znaleziony w cache");
    }

}
