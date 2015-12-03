/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfcheckoutsystem;

/**
 *
 * @author mintlaptop
 */
public class Language {

    public Language(String filename) {
        //Set themeName
        themeName = "Zombie";
        themeIcon = "ZombieIcon.jpg";
        //Set themeIcon
    }

    public String name() {
        return themeName;
    }

    public String icon() {
        return themeIcon;
    }

    //private String iniName;
    private String themeName;
    private String themeIcon;
}
