/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fr.pctronique.testplugin;

import fr.pctronique.pctrplugin.PctrPlugin;

/**
 *
 * @author pctronique
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PctrPlugin pctrPlugin = new PctrPlugin("AddPluginInterface");
        pctrPlugin.loadPlugins();
        for (Object plugin : pctrPlugin.getPlugins()) {
            AddPluginInterface addPluginInterface = (AddPluginInterface)plugin;
            System.out.println(addPluginInterface.getName() + " : " + addPluginInterface.getMessage());
        }
    }
    
}
