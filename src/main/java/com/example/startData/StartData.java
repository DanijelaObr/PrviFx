package com.example.startData;

import com.example.utill.LoggerHelper;
import com.example.Players.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StartData {
    private static String  matrixDimensions;
    private static String numberOfPlayers;
    private static List<MatrixField> matrixAvailableFields = new ArrayList<MatrixField>();
    private static List<MatrixField> matrixNonAvailableFields = new ArrayList<MatrixField>();

    private Player player;
    public static List<MatrixField> getMatrixAvailableFields() {
        return matrixAvailableFields;
    }

    public static void setMatrixAvailableFields(List<MatrixField> matrixAvailableFields) {
        StartData.matrixAvailableFields = matrixAvailableFields;
    }

    public static List<MatrixField> getMatrixNonAvailableFields() {
        return matrixNonAvailableFields;
    }

    public static void setMatrixNonAvailableFields(List<MatrixField> matrixNonAvailableFields) {
        StartData.matrixNonAvailableFields = matrixNonAvailableFields;
    }

    public static List<MatrixField> getMatrixFields() {
        return matrixAvailableFields;
    }

    public static void setMatrixFields(List<MatrixField> matrixFields) {
        StartData.matrixAvailableFields = matrixFields;
    }
    public static int getMatrixDimensions() {
        int matrix = Integer.parseInt(matrixDimensions);
        return matrix;
    }

    public static void setMatrixDimensions(String matrixDimensions) {
        StartData.matrixDimensions = matrixDimensions;
    }

    public static String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static void setNumberOfPlayers(String numberOfPlayers) {
        StartData.numberOfPlayers = numberOfPlayers;
    }

    private static void parseMatrixAvailableFields(JSONObject field) {
        JSONObject matrixFields = (JSONObject) field.get("field");

        Integer x = Integer.parseInt(String.valueOf(matrixFields.get("x")));
        Integer y = Integer.parseInt(String.valueOf(matrixFields.get("y")));
        Integer id = Integer.parseInt(String.valueOf(matrixFields.get("id")));
        MatrixField matrixField = new MatrixField(x, y, id);
        matrixAvailableFields.add(matrixField);
    }

    public static void setAllowedMatrixFields(int numberOfColumns) {
        JSONParser jsonParser = new JSONParser();
        String fileName = "";
        switch (numberOfColumns){
            case 7: fileName = "src/main/resources/mat-paths/mat-path-7x7.json"; break;
            case 8: fileName = "src/main/resources/mat-paths/mat-path-8x8.json"; break;
            case 9: fileName = "src/main/resources/mat-paths/mat-path-9x9.json"; break;
            case 10: fileName = "src/main/resources/mat-paths/mat-path-10x10.json"; break;
        }
        try (FileReader reader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(reader);
            JSONArray allowedFields = (JSONArray) obj;

            allowedFields.forEach(field -> parseMatrixAvailableFields((JSONObject) field));
        } catch (Exception e) {
            LoggerHelper.exceptionsLogger(StartData.class, e);
        }
    }
}
