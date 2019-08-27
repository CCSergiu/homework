package week9.doi_unu;

import week9.Person;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) {

        TreeSet personsTreeSetName = new TreeSet(new NameComparator());
        TreeSet personsTreeSetAge = new TreeSet(new AgeComparator());

        Person unu = new Person("Ion", 20);
        Person doi = new Person("Adi", 30);
        Person trei = new Person("Dan", 40);
        Person patru = new Person("Adi", 29);

        personsTreeSetName.add(unu);
        personsTreeSetName.add(doi);
        personsTreeSetName.add(trei);
        System.out.println(personsTreeSetName.toString());


        personsTreeSetAge.add(unu);
        personsTreeSetAge.add(doi);
        personsTreeSetAge.add(trei);
        System.out.println(personsTreeSetAge.toString());


        TreeSet personsTreeSetBoth = new TreeSet(new BothComparators(new NameComparator(), new AgeComparator()));
        personsTreeSetBoth.add(unu);
        personsTreeSetBoth.add(doi);
        personsTreeSetBoth.add(trei);
        personsTreeSetBoth.add(patru);
        System.out.println(personsTreeSetBoth.toString());


    }
}

class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }

}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() == o2.getAge()) {
            return 0;
        } else {
            return -1;
        }
    }

}

class BothComparators implements Comparator<Person> {

    NameComparator nameComparator;
    AgeComparator ageComparator;

    public BothComparators(NameComparator nameComparator, AgeComparator ageComparator) {
        this.nameComparator = nameComparator;
        this.ageComparator = ageComparator;
    }

    public int compare(Person o1, Person o2) {
        if (nameComparator.compare(o1, o2) == 0) {
            return ageComparator.compare(o1, o2);
        } else {
            return nameComparator.compare(o1, o2);
        }
    }

}