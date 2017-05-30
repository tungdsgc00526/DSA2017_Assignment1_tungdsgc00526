package com.tungds.commons;

import com.tungds.models.Entity;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author TungDS
 */
public class FileMenu {

    public static void SaveData(String filePath,Entity entities) throws IOException{
        Gson gson = new Gson();
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter( filePath));
            writer.write( gson.toJson(entities));

        }
        catch ( IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                writer.close( );
            }
            catch ( IOException e)
            {
            }
        }

    }

    public static Entity LoadData(String filePath) throws FileNotFoundException{
        Gson gson = new Gson();
        Entity result = gson.fromJson(new FileReader(filePath), Entity.class);
        return result;

    }
}
