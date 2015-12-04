/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfcheckoutsystem;

import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.Thread.sleep;
import javax.sound.sampled.*;

/**
 * This class controls the running of the system, and thus has relatively loose
 * cohesion; it's running through the various things needed for checking out
 *
 * @author
 */
public class SelfCheckoutSystem
{

   private final int MAX_LANGUAGES = 4;

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) throws InterruptedException
   {
      // TODO code application logic here
      //Now the system runs the self-checkout, never to stop.
      //TODO: Change this so there's a shutdown user ID.
      //while (true) //Leaving out to stop infinite loop issues.
      {
         //Load language options
         loadLanguageOptions();
         Language lang1 = new Language(langOptions.get(0));
         Language lang2 = new Language(langOptions.get(1));
         Language lang3 = new Language(langOptions.get(2));
         Language lang4 = new Language(langOptions.get(3));
         //Load the LanguageSelectionForm
         LanguageSelectionForm lang = new LanguageSelectionForm();
         lang.updateLang1(lang1.name(), lang1.icon());
         lang.updateLang2(lang2.name(), lang2.icon());
         lang.updateLang3(lang3.name(), lang3.icon());
         lang.updateLang4(lang4.name(), lang4.icon());
         lang.setVisible(true);
         //That will choose which set of language text we'll use.
         while (lang.isVisible())
         {
            sleep(500);
         }
         languageNum = lang.getLanguageNum();
         System.out.println("Using language #" + languageNum);
         Language chosenLang = new Language(langOptions.get(languageNum-1));

         //Load the login screen
         LoginForm login = new LoginForm();
         login.setBackground(chosenLang.scanCardImage());
         login.setText(chosenLang.scanCardText());
         login.setVisible(true);
         playSound(chosenLang.scanCardSound());
         while (login.isVisible())
         {
            sleep(500);
         }
         userID = login.getUserID();
         System.out.println("User ID: " + userID);

         //Check the login info
         //If login info bad, TODO
         //If login info good
         //Load the EnterItem screen
         //TODO: Should be a while loop
         EnterItemForm item = new EnterItemForm();
         item.setBackground(chosenLang.scanItemImage());
         item.setText(chosenLang.scanItemText());
         item.setVisible(true);
         playSound(chosenLang.scanItemSound());
         while (item.isVisible())
         {
            sleep(500);
         }

         //If item number good
         //If item number bad (three ways)
         //If "finished" pushed (or timer runs out)
         //Load goodbye screen
         GoodbyeForm goodbye = new GoodbyeForm();
         goodbye.setBackground(chosenLang.takeReceiptImage());
         goodbye.setText(chosenLang.takeReceiptText());
         goodbye.setVisible(true);
         playSound(chosenLang.takeReceiptSound());
         sleep(15000);
         goodbye.setVisible(false);
         //Wait
      }
   }

   //Taken from http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
   public static synchronized void playSound(final String filename)
   {
      new Thread(new Runnable()
      {
         // The wrapper thread is unnecessary, unless it blocks on the
         // Clip finishing; see comments.
         public void run()
         {
            try
            {
               Clip clip = AudioSystem.getClip();
               AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                       SelfCheckoutSystem.class.getClass().getResourceAsStream("/selfcheckoutsystem/sounds/" + filename));
               clip.open(inputStream);
               clip.start();
            } catch (Exception e)
            {
               System.err.println(e.getMessage());
            }
         }
      }).start();
   }

   private static void loadLanguageOptions()
   {
      String filename = "languageOptions.txt"; //Where the language list resides
      URL fileurl = SelfCheckoutSystem.class.getClass().getResource("/selfcheckoutsystem/configuration/" + filename);
      String line = null;
      try
      { //Probably a more-compact way of doing this with Scanner
         int i = 0;
         FileReader fileReader = new FileReader(new File(fileurl.getFile()));
         BufferedReader themeReader = new BufferedReader(fileReader);
         while ((line = themeReader.readLine()) != null)
         {
            langOptions.add(line);
            i++;
         }
         themeReader.close();
      } catch (IOException ex)
      {
         System.out.println("IOException: " + ex);
      }
   }

   private static int languageNum;
   private static String userID;
   private static ArrayList<String> langOptions = new ArrayList<String>();
}
