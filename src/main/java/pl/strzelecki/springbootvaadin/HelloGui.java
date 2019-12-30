package pl.strzelecki.springbootvaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
@StyleSheet("/css/style.css")
public class HelloGui extends VerticalLayout {

    public HelloGui() {
        TextField textFieldHello = new TextField("Your name:");
        Button buttonName = new Button("Hello", new Icon(VaadinIcon.ACADEMY_CAP));
        Label labelName = new Label();

        buttonName.addClickListener(clickEvent -> {
            labelName.setText("Hello " + textFieldHello.getValue() + "!");
            add(new Image("https://www.reactiongifs.com/r/hello-bear.gif", "No image!"));
        });

        add(textFieldHello, buttonName, labelName);
    }
}
