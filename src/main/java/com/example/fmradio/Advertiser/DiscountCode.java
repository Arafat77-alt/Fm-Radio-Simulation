package com.example.fmradio.Advertiser;

import java.time.LocalDate;

public class DiscountCode {
    private String occasion;
    private int discount;
    private LocalDate expirydate;
    private String code;

    public DiscountCode(String occasion, int discount, LocalDate expirydate, String code) {
        this.occasion = occasion;
        this.discount = discount;
        this.expirydate = expirydate;
        this.code = code;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public LocalDate getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(LocalDate expirydate) {
        this.expirydate = expirydate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DiscountCode{" +
                "occasion='" + occasion + '\'' +
                ", discount=" + discount +
                ", expirydate=" + expirydate +
                ", code='" + code + '\'' +
                '}';
    }


}
