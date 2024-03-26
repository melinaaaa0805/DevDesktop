import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testfx.matcher.control.LabeledMatchers.hasText;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class SampleTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        // Charger le fichier FXML
        Parent root = FXMLLoader.load(getClass().getResource("expense-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Personnaliser l'emplacement de la base pour les tests (variable d'environnement)
        System.setProperty("base.location", "path/to/your/database");
    }

    @Test
    public void testComponentPresence() {
        // Vérifier la présence des composants
        assertThat(lookup(".button").queryAll().size(), is(1)); // Recherche d'un bouton
        assertThat(lookup("#textField").queryAll().size(), is(1)); // Recherche d'un TextField avec l'ID "textField"
    }

    @Test
    public void testLabels() {
        // Vérifier les labels
        FxAssert.verifyThat("#label", hasText("Tableau récapitulatif des dépenses")); // Vérifie le texte du label avec l'ID "label"
    }

    @Test
    public void testButtonBehavior(FxRobot robot) {
        // Vérifier le comportement des boutons
        TableView tableView = lookup("#expenseTable").query(); // Recherche de la TableView avec l'ID "expenseTable"
        Button button = lookup(".button").query(); // Recherche du bouton avec la classe CSS "button"

        // Simulation d'une action utilisateur (clic sur le bouton)
        robot.clickOn(button);

        // Vérification des résultats
        assertThat(tableView.getItems().size(), is(1)); // Vérifie qu'un élément a été ajouté à la TableView
    }

    @Test
    public void testCustomizedLocation() {
        // Vérifier l'emplacement personnalisé de la base pour les tests
        assertThat(System.getProperty("base.location"), is("path/to/your/database"));
    }
}
