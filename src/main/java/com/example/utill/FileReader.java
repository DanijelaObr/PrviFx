package com.example.utill;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    protected List<String> linesOfPathsFile = new ArrayList<>();


    public  List<String> readImageSources(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(filePath));
            String line = br.readLine();
            while (line != null) {
                linesOfPathsFile.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesOfPathsFile;
    }
}
