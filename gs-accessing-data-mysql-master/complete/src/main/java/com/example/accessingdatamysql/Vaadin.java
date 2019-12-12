package com.example.accessingdatamysql;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

//@SpringComponent
@Route(value = "hello")

public class Vaadin extends VerticalLayout {
    public void hello () {
        TextField imie = new TextField("podaj imie");
        TextField podajEmail = new TextField("podaj email");
        Button button = new Button("wyslij", new Icon(VaadinIcon.AIRPLANE));
        Label label = new Label();
        button.addClickListener(event -> {
            label.setText("Zapisano: "+imie.getValue()+" email "+podajEmail.getValue());

        });
        add(imie, podajEmail, button, label);
    }
}
