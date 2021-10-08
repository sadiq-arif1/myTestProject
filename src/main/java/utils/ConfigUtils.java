package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    static public Properties getProp(String filename){
        Properties myProp = new Properties();
        try {
            File propFile = new File("src/test/resources/"+filename+".properties");
            if (propFile.exists())
                myProp.load(new FileInputStream(propFile));
            else
                System.out.println("File not found");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return myProp;
    }
}
