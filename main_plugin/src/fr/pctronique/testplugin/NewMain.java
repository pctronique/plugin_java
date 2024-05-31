/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fr.pctronique.testplugin;

import fr.pctronique.plugin.main.AddPluginInterface;
import fr.pctronique.plugin.main.Main_plugin;

/**
 *
 * @author pctronique
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main_plugin main_plugin = new Main_plugin();
        for (AddPluginInterface plugin : main_plugin.getPlugins()) {
            System.out.println(plugin.getName() + " : " + plugin.getMessage());
        }
    }
    
}
