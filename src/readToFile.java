import java.io.*;
/**
 * @author Arman Hatami
 * @version 1.0
 * a class for doing reading from file
 */
public class readToFile {
    private ObjectInputStream in;

    /**
     * read from file
     * @param fileAddress
     * @throws FileNotFoundException
     * @throws IOException
     */
    public readToFile(String fileAddress) throws FileNotFoundException, IOException {
        try {
            File admin = new File(fileAddress);
            in = new ObjectInputStream(new FileInputStream(admin));
        }
        catch (Exception e){
            System.out.println("file is not ready yet");
        }
    }

    /**
     * get read object
     * @return object
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public Object readFromFile() throws ClassNotFoundException, IOException {
        try {
            return in.readObject();
        }
        catch (Exception e){
            System.out.println("file is empty");
            return new Object();
        }
    }

    /**
     * close file after reading
     * @throws IOException
     */
    public void closeConnection() throws IOException {
        in.close();
    }
}
