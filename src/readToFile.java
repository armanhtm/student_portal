import java.io.*;

public class readToFile {
    private ObjectInputStream in;

    public readToFile(String fileAddress) throws FileNotFoundException, IOException {
        try {
            File admin = new File(fileAddress);
            in = new ObjectInputStream(new FileInputStream(admin));
        }
        catch (Exception e){
            System.out.println("file is not ready yet");
        }
    }

    public Object readFromFile() throws ClassNotFoundException, IOException {
        try {
            return in.readObject();
        }
        catch (Exception e){
            System.out.println("file is empty");
            return new Object();
        }
    }

    public void closeConnection() throws IOException {
        in.close();
    }
}
