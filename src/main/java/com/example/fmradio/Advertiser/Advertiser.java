package com.example.fmradio.Advertiser;

public class Advertiser {

    private String advertiserId;
    private String name;
    private String companyName;

    public Advertiser(String advertiserId, String name, String companyName) {
        this.advertiserId = advertiserId;
        this.name = name;
        this.companyName = companyName;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


}
