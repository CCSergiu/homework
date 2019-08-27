package week9.doi_doi;

import java.util.List;

public class Hobby {
    String name;
    int frequency;
    List<Address> addressList;

    public Hobby(String name, int frequency, List<Address> addressList) {
        this.name = name;
        this.frequency = frequency;
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", addressList=" + addressList +
                '}';
    }
}
