/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fr.pctronique.plugin.main;

import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pctronique
 */
public class LocationJarFile {
    
    private final File fileJar;

    public LocationJarFile() {
        fileJar = getLocation(LocationJarFile.class);
    }

    public LocationJarFile(Class theClass) {
        fileJar = getLocation(theClass);
    }
    
    private static File getLocation(Class theClass) {
        if(theClass.getProtectionDomain().getCodeSource().getLocation() == null) {
            return new File(System.getProperty("user.dir"));
        }
        try {
            File file = new File(theClass.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (isJarFile(file)) {
                return file.getParentFile();
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(LocationJarFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new File(System.getProperty("user.dir"));
    }

    private static boolean isJarFile(File file) {
        return LocationJarFile.getFileExt(file.getName()).trim().toLowerCase().equals("jar");
    }

    public static String getFileExt(String filename) {
        int pos = filename.lastIndexOf(".") + 1;
        if (pos > 0 && pos < filename.length()) {
            return filename.substring(pos);
        } else {
            return filename;
        }
    }

    public File getFileJar() {
        return fileJar;
    }

    public File getFileJarParenth() {
        if(fileJar.getPath().equals((new File(System.getProperty("user.dir"))).getPath())) {
            return fileJar;
        }
        return fileJar.getParentFile();
    }
    
    public static String getPath() {
        return (new LocationJarFile()).getFileJarParenth().getAbsolutePath();
    }
    
}
