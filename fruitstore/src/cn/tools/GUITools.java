package cn.tools;

import javax.swing.*;
import java.awt.*;

public class GUITools {
static Toolkit kit= Toolkit.getDefaultToolkit();

public static void center(Component c){
    int x =(kit.getScreenSize().width-c.getWidth())/2;
    int y =(kit.getScreenSize().height-c.getHeight())/2;
    c.setLocation(x,y);
}

    public static void setTitleImage(JFrame frame,String titleICONpATH) {
        frame.setIconImage(kit.createImage(titleICONpATH));
    }

}
