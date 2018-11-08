package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DataModels.Entry;
import sample.DataModels.EntryTable;
import sample.DataModels.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private static Session ourInstance = new Session();

    private String user;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;
    private String filename;

    public static Session getSession() {
        return ourInstance;
    }

    private Session() {
    }

    /**
     * Configures session with a given username.
     * @param user username.
     */

    public void setUser(String user) {
        this.user = user;
        filename = user.concat(".data");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./src/sample/Data/" + filename);
            ObjectOutputStream o = new ObjectOutputStream(fileOutputStream);
            o.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Push new entry into file.
     * @param entry new Entry.
     */

    public void pushEntry(Entry entry) {



        try {
            ObservableList<Entry> list = getData(false);

            FileOutputStream fileOutputStream = new FileOutputStream("./src/sample/Data/" + filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            list.add(entry);

            list.forEach(e -> {
                try {
                    objectOutputStream.writeObject(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });

            list = null;


            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get current session username.
     * @return username.
     */

    public String getUser() {
        return user;
    }

    /**
     * Get data from filesystem.
     * @param asTable true if the data is for Table, false if it's raw data.
     * @return List of entries.
     */

    public ObservableList getData (boolean asTable) {

        ObservableList<Entry> data = FXCollections.observableArrayList();
        ObservableList<EntryTable> tableData = FXCollections.observableArrayList();

        try {
            fileInputStream = new FileInputStream("./src/sample/Data/" + filename);
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
          while (fileInputStream.available() > 0) {

              if (asTable){
                  tableData.add(new EntryTable((Entry) objectInputStream.readObject()));
              } else {
                  Entry e = (Entry) objectInputStream.readObject();
                  System.out.println(e.getReference());
                  data.add(e);
              }

          }
//          objectInputStream.close();
          fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(asTable) return tableData;
        else return data;
    }


    /**
     * Loads data from file into a List of users for future use.
     */
    public List<User> loadUsers() {
        List<User> usersList = new ArrayList<User>();

        try {
            FileInputStream fileInputStream = new FileInputStream("./src/sample/Data/users.data");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            while (fileInputStream.available() > 0) {
                usersList.add((User) objectInputStream.readObject());
            }

            objectInputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return usersList;
    }


    /**
     * Adds new users to file.
     * @param newUser new user.
     * @return false if an error occurs.
     */
    public boolean pushUser (User newUser) {

        List<User> users = loadUsers();

        try {
            FileOutputStream fileOutput = new FileOutputStream("./src/sample/Data/users.data");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput);

           // objectOutputStream.writeObject(newUser);
            users.add(newUser);

            users.forEach(e -> {
                try {
                    objectOutputStream.writeObject(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });

            users = null;

            objectOutputStream.close();
            fileOutput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            System.out.println();
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
