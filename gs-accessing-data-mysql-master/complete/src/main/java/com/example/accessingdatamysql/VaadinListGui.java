package com.example.accessingdatamysql;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;

@Route("list")
public class VaadinListGui extends VerticalLayout {
    @Autowired
    MainController mainController;

    @Autowired
    public VaadinListGui(UserRepository userRepository) {
        Grid<User> grid = new Grid<>(User.class);
        grid.setItems(userRepository.findAll());
        grid.removeAllColumns();
        grid.setColumns("id", "name", "email");

        grid.addColumn(new ComponentRenderer<>(User -> {
            Image image = new Image(User.getImage(), "brak zdjęcia");
            return image;
        })).setHeader("Image");


        grid.addColumn(new ComponentRenderer<>(User -> {
            Image image = convertToImage(User.getData());
            return image;
        })).setHeader("plik z dysku");
        add(grid);

        add(new Button("dodaj do bazy", event -> UI.getCurrent().navigate("hello")));

        Button usun = new Button("usuń wpis z bazy");
        TextField usunNumer = new TextField("podaj ID do usuniecia");
        add(usunNumer);
        usun.addClickListener(event -> {
            mainController.deleted(Integer.valueOf(usunNumer.getValue()));
            Notification notification = new Notification(
                    "usunięto użytkownika z bazy danych", 4000);
            notification.open();
        });
        add(usun);

    }

    Image convertToImage(byte[] imageData) {
        StreamResource streamResource = new StreamResource("pobrane", (InputStreamFactory) () -> new ByteArrayInputStream(imageData));
        return new Image(streamResource, "photo");
    }
}
