package pl.strzelecki.springbootvaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.strzelecki.springbootvaadin.model.Pokemon;
import pl.strzelecki.springbootvaadin.model.PokemonType;

import java.util.List;
import java.util.stream.Collectors;

@Route
public class PokemonDeckGui extends VerticalLayout {

    @Autowired
    public PokemonDeckGui(PokemonDeck pokemonDeck) {
        ComboBox<PokemonType> comboBoxPokemonType =
                new ComboBox<>("Pokemon Type:", PokemonType.values());
        Button buttonGoToAdd = new Button("Add a new Pokemon");

        comboBoxPokemonType.addValueChangeListener(click -> {
            removeAll();
            add(comboBoxPokemonType, buttonGoToAdd);

            List<Pokemon> pokemonlist = pokemonDeck.getPokemonlist();
            List<Pokemon> pokemons = pokemonlist.stream()
                    .filter(pokemon -> pokemon.getPokemonType() == comboBoxPokemonType.getValue())
                    .collect(Collectors.toList());
            Grid<Pokemon> grid = new Grid<>(Pokemon.class);

            grid.setItems(pokemons);
            grid.removeColumnByKey("image");
            grid.addColumn(new ComponentRenderer<>(pokemon -> {
                return new Image(pokemon.getImage(), pokemon.getName());
            })).setHeader("Pokemon Image");

            add(grid);
        });
        buttonGoToAdd.addClickListener(buttonClickEvent ->
                buttonGoToAdd.getUI().ifPresent(ui -> ui.navigate("pokemonaddergui"))
        );

        add(comboBoxPokemonType, buttonGoToAdd);
    }
}
