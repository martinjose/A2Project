/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfcheckoutsystem;

import java.io.*;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

/**
 * This class controls the running of the system, and thus has relatively loose
 * cohesion; it's running through the various things needed for checking out
 *
 * @author
 */
public class SelfCheckoutSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //Now the system runs the self-checkout, never to stop.
        //TODO: Change this so there's a shutdown user ID.
        //while (true) //Leaving out to stop infinite loop issues.
        {
            //Load the LanguageSelectionForm
            LanguageSelectionForm lang = new LanguageSelectionForm();
            lang.setVisible(true);
            lang.updateLang1("Actual Language 1", "ZombieIcon.jpg");
            lang.updateLang2("Actual language 2", "PIRATEJOLLYROGER.GIF");
            //That will choose which set of language text we'll use.
            while (lang.isVisible())
                sleep(500);
            languageNum = lang.getLanguageNum();
            System.out.println("Language #" + languageNum);

            //Load the login screen
            LoginForm login = new LoginForm();
            login.setBackground("RobotTakeReceipt.jpg");
            login.setVisible(true);
            playSound("ZOMBIESCANCARD.WAV");
            while (login.isVisible()) {
                sleep(500);
            }
            userID = login.getUserID();
            System.out.println("User ID: " + userID);

            //Check the login info
            //If login info bad, TODO
            //If login info good
            //Load the EnterItem screen
            EnterItemForm item = new EnterItemForm();
            item.setBackground("RobotTakeReceipt.jpg");
            item.setVisible(true);
            while (item.isVisible()) {
                sleep(500);
            }

            //If item number good
            //If item number bad (three ways)
            //If "finished" pushed (or timer runs out)
            //Load goodbye screen
            GoodbyeForm goodbye = new GoodbyeForm();
            goodbye.setBackground("RobotTakeReceipt.jpg");
            goodbye.setVisible(true);
            sleep(15000);
            goodbye.setVisible(false);
            //Wait
        }
    }

    //Taken from http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
    public static synchronized void playSound(final String filename) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            SelfCheckoutSystem.class.getClass().getResourceAsStream("/selfcheckoutsystem/sounds/" + filename));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

    private static int languageNum;
    private static String userID;
}
