/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.pctronique.plugins.plugin3;

import fr.pctronique.testplugin.AddPluginInterface;

/**
 *
 * @author pctronique
 */
public class Plugin3 implements AddPluginInterface {

    @Override
    public String getName() {
        return "plugin3";
    }

    @Override
    public String getMessage() {
        return "the plugin3";
    }
    
}
