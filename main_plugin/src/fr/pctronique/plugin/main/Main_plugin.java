/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.pctronique.plugin.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pctronique
 */
public class Main_plugin {
    
    private final List<AddPluginInterface> all_plugin;
    private final String path;

    public Main_plugin() {
        this.all_plugin = new ArrayList<>();
        this.path = "./plugins/";
    }
    
    public void loadPlugins() {
        this.loadPlugins((File)null);
    }
    
    public void loadPlugins(String file) {
        this.loadPlugins(new File(file));
    }
    
    public void loadPlugins(File file) {
        File folderplugin = new File(LocationJarFile.getPath(), this.path);
        if(file != null) {
            folderplugin = file;
        }
        if(folderplugin.exists()) {
            for (File listFile : folderplugin.listFiles()) {
                File plibobj = Dlfcn.dlopen(listFile);
                if(plibobj == null) {
                    System.err.println("Error loading the library : " + listFile.getAbsolutePath());
                } else {
                    try {
                        AddPluginInterface psqr = (AddPluginInterface)Dlfcn.dlsym(plibobj, "AddPluginInterface");
                        if (psqr == null) {
                            System.err.println("Error accessing the symbol : " + listFile.getAbsolutePath());
                        } else {
                            all_plugin.add(psqr);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Main_plugin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    public List<AddPluginInterface> getPlugins(){
        return all_plugin;
    }
    
}
