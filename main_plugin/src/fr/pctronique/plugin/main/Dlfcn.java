/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fr.pctronique.plugin.main;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarFile;

/**
 *
 * @author pctronique
 */
public class Dlfcn {
    
    private static String extendFile(File file) {
        if (file == null) {
            return null;
        }
        String reverseFirst = (new StringBuilder(file.getName().toLowerCase())).reverse().toString();
        String reverseExtend = reverseFirst.split("\\.")[0];
        return (new StringBuilder(reverseExtend)).reverse().toString();
    }

    public static File dlopen(File file) {
        if (file == null) {
            return null;
        }
        String extendFile = extendFile(file);
        if("jar".equals(extendFile)) {
            return file;
        }
        return null;
    }

    public static File dlopen(String file) {
        if (file == null) {
            return null;
        }
        return dlopen(new File(file));
    }

    public static Object dlsym(File fileJar, String name) throws Exception {
        if (fileJar == null || name == null) {
            return null;
        }
        String tmp;
        Enumeration enumeration;
        Class tmpClass;
        URLClassLoader loader;
        
        URL u = fileJar.toURI().toURL();
        //On crée un nouveau URLClassLoader pour charger le jar qui se trouve en dehors du CLASSPATH
        loader = new URLClassLoader(new URL[]{u});

        //On charge le jar en mémoire
        JarFile jar = new JarFile(fileJar.getAbsolutePath());

        //On récupère le contenu du jar
        enumeration = jar.entries();

        if(enumeration != null) {
            while (enumeration.hasMoreElements()) {

                tmp = enumeration.nextElement().toString();

                //On vérifie que le fichier courant est un .class (et pas un fichier d'informations du jar )
                if (tmp.length() > 6 && tmp.substring(tmp.length() - 6).compareTo(".class") == 0) {

                    tmp = tmp.substring(0, tmp.length() - 6);
                    tmp = tmp.replaceAll("/", ".");

                    tmpClass = Class.forName(tmp, true, loader);

                    for (Class intf : tmpClass.getInterfaces()) {
                        if (intf.getSimpleName().equals(name)) {
                            return tmpClass.getConstructor().newInstance();
                        }
                    }

                }
            }
        }
        return null;
    }

}
