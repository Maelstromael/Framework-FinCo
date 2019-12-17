package framework;

import javax.swing.*;
import java.awt.*;

public class Utils {

    public static void showJoptMessage(Component c, String msg){
        JOptionPane.showMessageDialog(c,msg);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
