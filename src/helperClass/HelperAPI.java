/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import object.User;

/**
 *
 * @author Kavinesh
 */
public class HelperAPI implements Serializable{
    
    public static void changeFrame(JPanel rootPanel, JPanel newPanel){
        rootPanel.removeAll();
        rootPanel.repaint();
        rootPanel.revalidate();
        rootPanel.add(newPanel);
        rootPanel.repaint();
        rootPanel.revalidate();
    }
    
    
    
     public void RegisterUser(User user) {
        File f = new File("user.ser");

        try {
            FileOutputStream fos = new FileOutputStream("user.ser", true);
            if (f.length() == 0) {

                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(user);
                oos.close();
                fos.close();
            } else {
                NoHeaderObjectOutputStream Noos = new NoHeaderObjectOutputStream(fos);
                Noos.writeObject(user);
                Noos.close();
                fos.close();
            }

        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
           
        }

    }
     
     
     
     public void userLogin(String email, String passwrod){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

     
        try {
            fis = new FileInputStream("user.ser");
            ois = new ObjectInputStream(fis);
            
            User u = null;
            while ((u = (User) ois.readObject()) != null) {
                System.out.println(u.getAddress());
                System.out.println(u.getName());
            }
            
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(HelperAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(HelperAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(HelperAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
     }
}
