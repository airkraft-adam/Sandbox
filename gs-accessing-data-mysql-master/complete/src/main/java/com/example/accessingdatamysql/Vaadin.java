package com.example.accessingdatamysql;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "hello")

public class Vaadin extends VerticalLayout {
    @Autowired
    private MainController mainController;

    public Vaadin() {
        TextField imie = new TextField("podaj imie");
        TextField podajEmail = new TextField("podaj email");
        TextField image = new TextField("podaj image");
        TextField plik = new TextField("podaj plik");


        Button button = new Button("wyslij", new Icon(VaadinIcon.AIRPLANE));
        Label label = new Label();
        Button button1 = new Button("pokaż w bazie", event -> UI.getCurrent().navigate("list"));

        button.addClickListener(event -> {
            label.setText("Zapisano: " + imie.getValue() + " email " + podajEmail.getValue());
            add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHgl4su2tAaJhC-QisFCW5e-ta3UUEG4f-bHzCwc1KzkRgJpJ0AA&s", "zapisano"));

            mainController.addUser(imie.getValue(), podajEmail.getValue(), image.getValue(), plik.getValue());

            Notification notification = new Notification(
                    "zapisano użytkownika do bazy danych", 4000);
            notification.open();
        });


        add(imie, podajEmail, image, plik, button, button1, label);
    }


}