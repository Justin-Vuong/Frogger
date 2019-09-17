import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FroggerController {

	@FXML
	private ImageView frogMan;
	
	@FXML
	private GridPane backgroundGrid;

	@FXML
	public void moveFrog(KeyEvent event) {

		
		
		//Load images so that you can play the frog animation
		
		if (event.getCode() == KeyCode.RIGHT) {
			animateFrog();
			System.out.println("Enter Pressed");
			if (frogMan.getX() < 240) {

				frogMan.setX(frogMan.getX() + FroggerConstants.FROG_WIDTH);
			}
			frogMan.setRotate(90);
		}

		if (event.getCode() == KeyCode.LEFT) {
			animateFrog();
			System.out.println("Enter Pressed");
			if (frogMan.getX() > -240) {

				frogMan.setX(frogMan.getX() - FroggerConstants.FROG_WIDTH);
			}
			frogMan.setRotate(-90);
		}

		if (event.getCode() == KeyCode.DOWN) {
			animateFrog();
			if (frogMan.getY() < 0) { // One move away from the top border

				frogMan.setY(frogMan.getY() + FroggerConstants.FROG_HEIGHT);
			}
			frogMan.setRotate(180);
		}

		if (event.getCode() == KeyCode.UP) {
			animateFrog();
			System.out.println("Enter Pressed");
			if (frogMan.getY() > -540) {

				frogMan.setY(frogMan.getY() - FroggerConstants.FROG_HEIGHT);
			}
			frogMan.setRotate(0);
		}

		System.out.print("Frog: " + frogMan.getX() + ", " + frogMan.getY());

	}
	
	public void initializeGame() {
		
		
		Image r = new Image("file:ressources/Road.png");
        Image w = new Image("file:ressources/Water.png");
        Image s = new Image("file:ressources/Sidewalk.png");
        
        Image[][] textureGrid = {
        			{s,s,s,s,s,s,s,s,s},
        			{w,w,w,w,w,w,w,w,w},
                {s,s,s,s,s,s,s,s,s},
                {w,w,w,w,w,w,w,w,w},
                {w,w,w,w,w,w,w,w,w},
                {s,s,s,s,s,s,s,s,s},
                {r,r,r,r,r,r,r,r,r},
                {s,s,s,s,s,s,s,s,s},
                {r,r,r,r,r,r,r,r,r},
                {r,r,r,r,r,r,r,r,r},
            };
        
        ImageView map[][] = new ImageView[10][9];
        
        for(int y = 0; y <10; y++) {
        		for(int x = 0; x <9; x++) {
        			ImageView textureRessource = new ImageView();
        			textureRessource.setImage(textureGrid[y][0]);	
        			map[y][x] = textureRessource;
        				GridPane.setConstraints(map[y][x], x, y);
        }
        }
        
        
        
                
                
                
        
       backgroundGrid.getChildren().addAll(map[0][0], map[0][1], map[0][2], map[0][3], map[0][4], map[0][5], map[0][6], map[0][7], map[0][8], map[1][0], map[1][1], map[1][2], map[1][3], map[1][4], map[1][5], map[1][6], map[1][7], map[1][8], map[2][0], map[2][1], map[2][2], map[2][3], map[2][4], map[2][5], map[2][6], map[2][7], map[2][8], map[3][0], map[3][1], map[3][2], map[3][3], map[3][4], map[3][5], map[3][6], map[3][7], map[3][8], map[4][0], map[4][1], map[4][2], map[4][3], map[4][4], map[4][5], map[4][6], map[4][7], map[4][8], map[5][0], map[5][1], map[5][2], map[5][3], map[5][4], map[5][5], map[5][6], map[5][7], map[5][8], map[6][0], map[6][1], map[6][2], map[6][3], map[6][4], map[6][5], map[6][6], map[6][7], map[6][8], map[7][0], map[7][1], map[7][2], map[7][3], map[7][4], map[7][5], map[7][6], map[7][7], map[7][8], map[8][0], map[8][1], map[8][2], map[8][3], map[8][4], map[8][5], map[8][6], map[8][7], map[8][8], map[9][0], map[9][1], map[9][2], map[9][3], map[9][4], map[9][5], map[9][6], map[9][7], map[9][8]);
    		   //backgroundGrid = gridPane;
       
}


	public void animateFrog() {
		Image movingFrog = new Image("file:ressources/FroggerSprite.gif");
		Image stillFrog = new Image("file:ressources/StillFrogSprite.png");
		frogMan.setImage(movingFrog);
		
		Timeline timeline = new Timeline(new KeyFrame(
		        Duration.millis(850),
		        ae -> frogMan.setImage(stillFrog)
		        ));
		timeline.play();
		
		
	}
	}
