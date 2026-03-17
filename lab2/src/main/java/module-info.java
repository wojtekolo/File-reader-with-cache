module lab2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.wojtekolo.studia to javafx.fxml;
    exports pl.wojtekolo.studia;
    exports pl.wojtekolo.studia.file;
}