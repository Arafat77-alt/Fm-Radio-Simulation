package com.example.fmradio.Listener;

public class DedicateSong {
    private String recipientName;
    private String songName;
    private String textArea;

    public DedicateSong(String recipientName, String songName, String textArea) {
        this.recipientName = recipientName;
        this.songName = songName;
        this.textArea = textArea;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    @Override
    public String toString() {
        return "DedicateSong{" +
                "recipientName='" + recipientName + '\'' +
                ", songName='" + songName + '\'' +
                ", textArea='" + textArea + '\'' +
                '}';
    }
}
