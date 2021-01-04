package HuLuWaGame.view;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;

public class ChessBoardView {
    
    private ArrayList<ImageView> chessboard = new ArrayList<ImageView>(100);

    public ChessBoardView() {
        URL url_white = getClass().getClassLoader().getResource("White.png");
        URL url_black = getClass().getClassLoader().getResource("Black.png");
        for(int i=0; i<100; i++) {
            int x = i/10;
            int y = i%10;
            if((x+y)%2==0) {
                ImageView imageview = new ImageView();
                imageview.setFitHeight(50);
                imageview.setFitWidth(50);
                imageview.setLayoutX(10+y*50);
                imageview.setLayoutY(10+x*50);
                imageview.setImage(new Image(url_black.toString()));
                chessboard.add(imageview);
            }
            else {
                ImageView imageview = new ImageView();
                imageview.setFitHeight(50);
                imageview.setFitWidth(50);
                imageview.setLayoutX(10+y*50);
                imageview.setLayoutY(10+x*50);
                imageview.setImage(new Image(url_white.toString()));
                chessboard.add(imageview);
            }
        }
    }

    public ImageView get(int i) {
        return this.chessboard.get(i);
    }

}
