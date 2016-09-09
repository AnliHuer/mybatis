package io.twu.yang.domain;

public class Account {

    private long accountId;
    private String accountName;

    public Account(Address address) {
        this.address = address;
    }

    public Account() {
    }

    public String getAccountName() {
        return accountName;
    }

    public Address getAddress() {
        return address;
    }

    private Address address;

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
