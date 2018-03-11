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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import object.Product;
import object.User;
import static oms.MainClass.dtm;

/**
 *
 * @author Kavinesh
 */
public class HelperAPI implements Serializable {

    public static void changeFrame(JPanel rootPanel, JPanel newPanel) {
        rootPanel.removeAll();
        rootPanel.repaint();
        rootPanel.revalidate();
        rootPanel.add(newPanel);
        rootPanel.repaint();
        rootPanel.revalidate();
    }

    public void DeleteFile(File f1, File f2, File f3) {
        f1.delete();
        f2.renameTo(f3);
    }

    public void updateUserInformation(User user) {
        File f = new File("temp.ser");
        try {
            FileOutputStream fos = new FileOutputStream("temp.ser", true);
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

    public boolean userLogin(String email, String password, String role) {
        boolean flag = false;
        for (User u : this.ReadUsers()) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password) && u.getRole().equals(role)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public ArrayList<User> ReadUsers() {
        ArrayList<User> Users = new ArrayList<User>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("user.ser");
            ois = new ObjectInputStream(fis);
            User u = null;
            while ((u = (User) ois.readObject()) != null) {
                Users.add(u);
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException ex) {

            }

        }
        return Users;
    }
    
    
    
     public ArrayList<Product> ReadProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("products.ser");
            ois = new ObjectInputStream(fis);
            Product u = null;
            while ((u = (Product) ois.readObject()) != null) {
                products.add(u);
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException ex) {

            }

        }
        return products;
    }

    public int getLastID() {
        int ID = 22222;
        File f = new File("user.ser");
        if (f.length() == 0) {
            return ID;
        } else {
            for (User user : this.ReadUsers()) {
                ID = user.getId();
            }

            return ID + 1;
        }
    }

    public void UpdateUserDataTable(JTable jTable1) {

        dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Name");
        dtm.addColumn("Email");
        dtm.addColumn("Password");
        dtm.addColumn("Contact");
        dtm.addColumn("Address");
        dtm.addColumn("Role");

        for (User user : new HelperAPI().ReadUsers()) {
            dtm.addRow(new Object[]{user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getContact(), user.getAddress(), user.getRole()});
        }

        jTable1.setModel(dtm);
        jTable1.updateUI();

    }
    
    
    public void UpdateProductDataTable(JTable table1){
     dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Name");
        dtm.addColumn("Type");
        dtm.addColumn("Stock");
        dtm.addColumn("Price");

        for (Product user : new HelperAPI().ReadProducts()) {
            dtm.addRow(new Object[]{user.getID(), user.getName(), user.getType(), user.getStock(), user.getPrice()});
        }

        table1.setModel(dtm);
        table1.updateUI();
    } 
   
}
