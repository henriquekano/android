package com.example.henri_000.fechaaconta.config;

import com.example.henri_000.fechaaconta.model.Item;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by henri_000 on 21/08/2015.
 */
public class OrmliteDatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[] {Item.class};

    public static void main(String[] args) throws IOException, SQLException, IOException, SQLException {

        String currDirectory = "user.dir";

        String configDir = "/res/raw";
        String configPath = "/res/raw/ormlite_config.txt";

        /**
         * Gets the project root directory
         */
        String projectRoot = System.getProperty(currDirectory);

        /**
         * Full configuration path includes the project root path, and the location
         * of the ormlite_config.txt file appended to it
         */
        String fullConfigPath = (projectRoot + configPath).replace("\\", "/");

        File configFile = new File(fullConfigPath);

        /**
         * In the a scenario where we run this program serveral times, it will recreate the
         * configuration file each time with the updated configurations.
         */
        if(configFile.exists()) {
            configFile.delete();
            configFile = new File(fullConfigPath);
        }
        configFile.getParentFile().mkdirs();
        configFile.createNewFile();



        /**
         * writeConfigFile is a util method used to write the necessary configurations
         * to the ormlite_config.txt file.
         */
        writeConfigFile("ormlite_config.txt", classes);
    }
}
