package com.example.fmradio.Producer;

import java.io.*;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStorage {

    public static void saveData(List<SongSubmission> submissions, String fileName) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            out.writeInt(submissions.size());
            for (SongSubmission song : submissions) {
                out.writeUTF(song.getTitle());
                out.writeUTF(song.getDuration());
                out.writeUTF(song.getStatus());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<SongSubmission> loadData(String fileName) {
        ObservableList<SongSubmission> songs = FXCollections.observableArrayList();
        try (DataInputStream in = new DataInputStream(new FileInputStream(fileName))) {
            int size = in.readInt();
            for (int i = 0; i < size; i++) {
                String title = in.readUTF();
                String duration = in.readUTF();
                String status = in.readUTF();
                songs.add(new SongSubmission(title, duration, status));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
