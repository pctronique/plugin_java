/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.pctronique.plugins.plugin2;

import fr.pctronique.plugin.main.AddPluginInterface;

/**
 *
 * @author pctronique
 */
public class Plugin2 implements AddPluginInterface {

    @Override
    public String getName() {
        return "plugin2";
    }

    @Override
    public String getMessage() {
        return "the plugin2";
    }
    
}
