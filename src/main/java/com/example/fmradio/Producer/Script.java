package com.example.fmradio.Producer;

public class Script {

        private String showName;
        private String scriptText;

    public Script(String showName, String scriptText) {
        this.showName = showName;
        this.scriptText = scriptText;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getScriptText() {
        return scriptText;
    }

    public void setScriptText(String scriptText) {
        this.scriptText = scriptText;
    }

    @Override
    public String toString() {
        return "Script{" +
                "showName='" + showName + '\'' +
                ", scriptText='" + scriptText + '\'' +
                '}';
    }
}
