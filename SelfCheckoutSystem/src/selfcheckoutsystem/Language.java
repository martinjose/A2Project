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
      
      //Set ScanCard (Enter Patron ID)
      //Break out into its own method
      //[ScanCard]
      index = iniList.indexOf("[ScanCard]");
      for( int i = index + 1; i < index + 8; i++ )
      {
         line = iniList.get(i);
         if( line.contains("MessageText=") )
            scanCardText = line.replace("MessageText=", "");
         if( line.contains("PictureFile=") )
            scanCardImage = line.replace("PictureFile=", "");
         if( line.contains("Sound=") )
            scanCardSound = line.replace("Sound=", "");
      }
      scanCardText = scanCardText.replaceAll("\\{CRLF}", "\\\n");
      
      //Set ScanItem 
      //Break out into its own method
      //[ScanItem]
      index = iniList.indexOf("[ScanItem]");
      for( int i = index + 1; i < index + 8; i++ )
      {
         line = iniList.get(i);
         if( line.contains("MessageText=") )
            scanItemText = line.replace("MessageText=", "");
         if( line.contains("PictureFile=") )
            scanItemImage = line.replace("PictureFile=", "");
         if( line.contains("Sound=") )
            scanItemSound = line.replace("Sound=", "");
      }
      scanItemText = scanItemText.replaceAll("\\{CRLF}", "\\\n");
      
      //Set Take Receipt (Goodbye)
      //Break out into its own method
      //[TakeReceipt]
      index = iniList.indexOf("[TakeReceipt]");
      for( int i = index + 1; i < index + 6; i++ )
      {
         line = iniList.get(i);
         if( line.contains("MessageText=") )
            takeReceiptText = line.replace("MessageText=", "");
         if( line.contains("PictureFile=") )
            takeReceiptImage = line.replace("PictureFile=", "");
         if( line.contains("Sound=") )
            takeReceiptSound = line.replace("Sound=", "");
      }
      takeReceiptText = takeReceiptText.replaceAll("\\{CRLF}", "\\\n");
      
    }

    public String name() {
        return themeName;
    }

    public String icon() {
        return themeIcon;
    }
    
    public String scanCardText() {
       return scanCardText;
    }
    
    /* Template function
    public String () {
       return ;
    }
   */
    
    public String scanCardImage() {
       return scanCardImage;
    }
    
    public String scanCardSound() {
       return scanCardSound;
    }
    
    public String scanItemText() {
       return scanItemText;
    }

    public String scanItemImage() {
       return scanItemImage;
    }
    
    public String scanItemSound() {
       return scanItemSound;
    }    
    
    public String takeReceiptText() {
       return takeReceiptText;
    }

    public String takeReceiptImage() {
       return takeReceiptImage;
    }
    
    public String takeReceiptSound() {
       return takeReceiptSound;
    }    
    
    //private String iniName;
    private String themeName = null;
    private String themeIcon = null;
    private String scanCardText = null;
    private String scanCardImage = null;
    private String scanCardSound = null;
    private String scanItemText = null;
    private String scanItemImage = null;
    private String scanItemSound = null;
    private String takeReceiptText = null;
    private String takeReceiptImage = null;
    private String takeReceiptSound = null;
    List<String> iniList = new ArrayList<>(); //The read-in text file
}
