package pl.strzelecki.springbootvaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.strzelecki.springbootvaadin.model.Pokemon;
import pl.strzelecki.springbootvaadin.model.PokemonType;

@Route
public class PokemonAdderGui extends VerticalLayout {

    @Autowired
    public PokemonAdderGui(PokemonDeck pokemonDeck) {
        TextField textFieldName = new TextField("name");
        TextField textFieldImage = new TextField("image");
        ComboBox<PokemonType> comboBoxPokemonType =
                new ComboBox<>("Pokemon Type:", PokemonType.values());
        Button buttonAdd = new Button("Add a new Pokemon");
        Button buttonGoToDeck = new Button("Pokemon deck");

        buttonAdd.addClickListener(clickEvent -> {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(textFieldName.getValue());
            pokemon.setImage(textFieldImage.getValue());
            pokemon.setPokemonType(comboBoxPokemonType.getValue());

            textFieldName.clear();
            textFieldImage.clear();
            comboBoxPokemonType.clear();

            pokemonDeck.getPokemonlist().add(pokemon);
            Notification notification =
                    new Notification("Pokemon added.", 2000);
            notification.open();
        });

        buttonGoToDeck.addClickListener(buttonClickEvent ->
                buttonGoToDeck.getUI().ifPresent(ui -> ui.navigate("pokemondeckgui"))
        );

        add(textFieldName, textFieldImage, comboBoxPokemonType, buttonAdd, buttonGoToDeck);
    }
}
