import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Maze extends Application{
	private Game game;
	private int currentPlayer = 1;
	private TextField[] message;
	private Button[] up;
	private Button[] down;
	private Button[] left;
	private Button[] right;
	private Button[] build;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	

}
