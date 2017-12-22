package com.raydevelopers.sony.zyla;

import com.raydevelopers.sony.zyla.models.SongDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 22-12-2017.
 */

public class ReadCSVFile {
    InputStream inputStream;
    public ReadCSVFile(InputStream i)
    {
        this.inputStream=i;
    }
    public ArrayList<SongDetails> read()
    {
        ArrayList<SongDetails> list=new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while((csvLine = bufferedReader.readLine()) != null)
            {
                String[] row = csvLine.split(",");
                list.add(new SongDetails(row[0],row[1],row[2]));
            }

        } catch (IOException e) {
            throw new RuntimeException("Error in reading CSV file: "+e);

        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return list;
    }
}
