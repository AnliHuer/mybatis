package io.twu.yang.domain;

public class Address {

    private long addressId;
    private String streetName;

    public Address() {
    }

    public Address(String streetName) {
        this.streetName = streetName;
    }

    public Address(long addressId, String streetName) {
        this.addressId = addressId;
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public void setAddress_id(long addressId) {
        this.addressId = addressId;
    }
}
