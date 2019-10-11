package last_assignment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Package> packages = new ArrayList<>();
        FileReader fileReader = new FileReader();

        fileReader.readFile("/Users/apple/Desktop/homework/src/main/resources/last.txt", packages);
        //   System.out.println(packages.toString());

        Map<String, PackageGroup> map = new LinkedHashMap<>();

        for (Package pack : packages) {
            if (map.containsKey(pack.getKey())) {
                map.get(pack.getKey()).addPackageValue(pack.getPackageValue());
            } else {
                PackageGroup packageGroup = new PackageGroup();
                packageGroup.setDate(pack.getDate());
                packageGroup.setTargetDistanceInKm(pack.getTargetDistanceInKm());
                packageGroup.setTargetLocation(pack.getTargetLocation());
                packageGroup.setTotalPackageValue(pack.getPackageValue());
                map.put(pack.getKey(), packageGroup);
            }
        }

        System.out.println(map.toString());

    }


}
