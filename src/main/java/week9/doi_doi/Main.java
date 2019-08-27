package week9.doi_doi;

import week9.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person unu = new Person("Ion", 20);
        Person doi = new Person("Adi", 30);
        Person trei = new Person("Dan", 40);
        Person patru = new Person("Adi", 30);

        Address primaAdresa = new Address("Strada Dunarii", "Romania");
        Address aDouaAdresa = new Address("Strada Muntelui", "Austria");

        List<Address> addressListUnu = new ArrayList<Address>();
        addressListUnu.add(primaAdresa);

        List<Address> addressListDoi = new ArrayList<Address>();
        addressListDoi.add(aDouaAdresa);

        Hobby primulHobby = new Hobby("Surf", 2, addressListUnu);
        Hobby alDoileaHobby = new Hobby("Alpinism", 3, addressListDoi);

        List<Hobby> hobbiesUnu = new ArrayList<>();
        List<Hobby> hobbiesDoi = new ArrayList<>();

        hobbiesUnu.add(primulHobby);
        hobbiesDoi.add(alDoileaHobby);

        HashMap<Person, List<Hobby>> hashMap = new HashMap<>();

        hashMap.put(unu, hobbiesUnu);
        hashMap.put(doi, hobbiesDoi);
        hashMap.put(trei, hobbiesUnu);
        hashMap.put(patru, hobbiesDoi);
        System.out.println(hashMap);

    }
}
