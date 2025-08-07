package com.example.fmradio.StationManager;

import java.io.*;

public class BinaryFileUtil {


    public static void saveStationData(StationData data, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
            System.out.println("✅ Station data saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static StationData loadStationData(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("⚠ File not found: " + filePath);
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (StationData) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

