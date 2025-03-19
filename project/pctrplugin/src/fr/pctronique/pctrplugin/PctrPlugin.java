/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.pctronique.pctrplugin.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pctronique
 */
public class PctrPlugin {
    
    private final List<Object> all_plugin;
    private final String path;
    private final String nameInterf;

    public PctrPlugin(String nameInterf) {
        this.all_plugin = new ArrayList<>();
        this.nameInterf = nameInterf;
        this.path = "./plugins/";
    }
    
    public PctrPlugin loadPlugins() {
        return this.loadPlugins((File)null);
    }
    
    public PctrPlugin loadPlugins(String file) {
        return this.loadPlugins(new File(file));
    }
    
    public PctrPlugin loadPlugins(File file) {
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
                        Object psqr = (Object)Dlfcn.dlsym(plibobj, this.nameInterf);
                        if (psqr == null) {
                            System.err.println("Error accessing the symbol : " + listFile.getAbsolutePath());
                        } else {
                            all_plugin.add(psqr);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(PctrPlugin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return this;
    }
    
    public List<Object> getPlugins(){
        return all_plugin;
    }
    
}
