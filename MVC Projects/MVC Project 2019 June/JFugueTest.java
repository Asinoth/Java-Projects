
import org.jfugue.Player;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * 
 */
public class JFugueTest {

    public static void main(String args[]) {
        Player player = new Player();

        player.play("C D E");

        // 
        player.play("I[Cello] E7 D7 E7 F7 D7 C7 D7 E7 E7 D7 E7 D7 C7i D7i B6 A6");

        player.play("[81] [83] [127]");
    }
}
