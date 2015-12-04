/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfcheckoutsystem;

import java.net.URL;
import java.util.*;
import java.io.*;

/**
 *
 * @author mintlaptop
 */
public class Language {

   public Language(String filename)
   {
      //Read language file into iniList
      //Possibly break this out into its own method
      //TODO: catch filenames not leading to actual files
      URL fileurl = Language.class.getClass().getResource("/selfcheckoutsystem/themes/" + filename);
      try
      {
         Scanner scanner = new Scanner(new File(fileurl.getFile()));
         while (scanner.hasNextLine())
         {
            iniList.add(scanner.nextLine());
         }

      } catch (Exception ex)
      {
         System.out.println("Exception: " + ex);
      }
      
      //Set themeName and icon
      //Break out into its own method
      int index = iniList.indexOf("[Languages]");
      String line = null;
      for( int i = index + 1; i < index + 5; i++ )
      { //Maybe not elegant, but I want to run at most five times
         line = iniList.get(i);
         if( line.contains("Name=") )
            themeName = line.replace("Name=", "");
         if( line.contains("Icon=") )
            themeIcon = line.replace("Icon=", "");
      }
      
    }

    public String name() {
        return themeName;
    }

    public String icon() {
        return themeIcon;
    }

    //private String iniName;
    private String themeName = null;
    private String themeIcon = null;
    List<String> iniList = new ArrayList<>(); //The read-in text file
}
