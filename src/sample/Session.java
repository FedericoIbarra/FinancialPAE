package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DataModels.Entry;
import sample.DataModels.User;

import java.io.*;

public class Session {
    private static Session ourInstance = new Session();

    private String user;
    private FileOutputStream fileOutputStream;
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
    }

    /**
     * Push new entry into file.
     * @param entry new Entry.
     */

    public void pushEntry(Entry entry) {

        try {
            fileOutputStream = new FileOutputStream("./src/sample/Data/" + filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entry);
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
     * @return List of entries.
     */

    public ObservableList getData () {

        ObservableList data = FXCollections.observableArrayList();

        System.out.println("No carga el archivo");
        try {
            fileInputStream = new FileInputStream("./src/sample/Data/" + filename);
            objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println("Si carga el archivo");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
          while (fileInputStream.available() > 0) {
              data.add((Entry) objectInputStream.readObject());
          }
          objectInputStream.close();
          fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }

}
