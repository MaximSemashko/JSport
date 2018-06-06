package animations;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

import javax.xml.soap.Node;

public class Shake {
    private TranslateTransition tt;

    public Shake(Button node) {
        tt = new TranslateTransition(Duration.millis(100),
                (javafx.scene.Node) node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
      }
      public void playAnim(){
        tt.playFromStart();
    }
}
