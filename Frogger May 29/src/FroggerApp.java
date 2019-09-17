import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* 
Justin Vuong 
May 23, 2018
Make a 2 player frogger game with scenebuilder.
At this point, I have made the movement of the frog as well as the borders of the frame. Next I will be working on the design of the screen and collision of units (logs, cars, rocks etc.)
*/

public class FroggerApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root;
		try {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("/froggerApp.fxml"));
		    root = loader.load();
			
		    FroggerController controller = loader.getController();
		    
		    
		    Scene scene = new Scene(root, 540, 600);
		    primaryStage.setTitle("Justin's Frogger Application");
			primaryStage.setScene(scene);
			primaryStage.show();
			controller.initializeGame();
			
			scene.setOnKeyPressed(e -> {
			controller.moveFrog(e);
			});
			
			
		} catch (IOException e) {

		}

	}
	


}
