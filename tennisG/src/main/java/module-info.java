module singh.g.tennisg {
    requires javafx.controls;
    requires javafx.fxml;


    opens singh.g.tennisg to javafx.fxml;
    exports singh.g.tennisg;
}