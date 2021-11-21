/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ui.MainFrame;
import dao.BookDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
               try {
// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
 UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      MainFrame myFrame = new MainFrame("Book Manager");
    }
}
