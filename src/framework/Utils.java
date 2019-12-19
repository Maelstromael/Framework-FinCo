package framework;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    public static boolean requiredJTextFields(ArrayList<JTextField> requiredTextFields){
        boolean required = true;
        for(JTextField jTextField : requiredTextFields){
            if(jTextField.getText() == null ||jTextField.getText().equals("")) {
                required = !required;
                break;
            }

        }



        return required;
    }
}
