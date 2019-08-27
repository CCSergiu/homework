package week9.doi_doi;

public class Address {
    String address;
    String country;

    public Address(String address, String country) {
        this.address = address;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
