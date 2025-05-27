module hust.soict.ict.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens main.java.hust.soict.ict.javafx to javafx.fxml;
    opens hust.soict.ict.aims.screen.customer.view to javafx.fxml;
    opens hust.soict.ict.aims.screen.customer.controller to javafx.fxml;
    opens hust.soict.ict.aims.media to javafx.base;
    exports main.java.hust.soict.ict.javafx;
    exports hust.soict.ict.test.screen.customer.store;
    exports hust.soict.ict.aims.screen.customer.controller;
}
