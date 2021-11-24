package dao;

import entity.Security;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SecurityDAO {
    private String pathStr = "Data";
    private String fileNameChar = "Security_Data_Character.txt";
    private String fileNameByte = "Security_Data_Byte.txt";

    public SecurityDAO() {
        this.createFolder();
    }

    public void createFolder() {
        File folder = new File(pathStr);
        if (folder.exists()) {

        } else {
            folder.mkdirs();

        }
    }


    public void saveListSecurityAsByte(List<Security> listSecurity) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(pathStr + "\\" + fileNameByte);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(listSecurity);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public List<Security> readListSecurityAsByte() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Security> listSecurity = new ArrayList<>();
        try {
            fis = new FileInputStream(pathStr + "\\" + fileNameByte);
            ois = new ObjectInputStream(fis);
            listSecurity = (List<Security>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return listSecurity;
    }

    public void saveListSecurityAsChar(List<Security> listSecurity) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(pathStr + "\\" + fileNameChar);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < listSecurity.size(); i++) {
                bw.write(listSecurity.get(i).getInfoAsString());
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fw.close();
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
