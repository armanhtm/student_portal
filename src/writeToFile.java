import java.io.*;
/**
 * @author Arman Hatami
 * @version 1.0
 * a class for writing to file
 */
public class writeToFile {
    private ObjectOutputStream out;
    private String address;

    /**
     * constructor
     * @param address
     * @throws IOException
     */
    public writeToFile(String address) throws IOException {

        this.address=address;
        File adminFile=new File(address);
        if (adminFile.exists()){
            adminFile.delete(); }

        out=new ObjectOutputStream(new FileOutputStream(new File(address)));

    }

    /**
     * close file after writing
     * @throws IOException
     */
    public void closeFile() throws IOException {
        out.close();

    }

    /**
     * writing to a file
     * @param obj
     * @throws IOException
     */
    public void writeObjectToFile(Object obj) throws IOException {
        try {
            out.writeObject(obj);
        } catch (Exception e) {
            System.out.println("empty file");
        }
    }
}
