package last_assignment;

import java.time.LocalDate;

public class PackageGroup {

    private String targetLocation;
    private int targetDistanceInKm;
    private int totalPackageValue;
    private LocalDate date;

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public int getTargetDistanceInKm() {
        return targetDistanceInKm;
    }

    public void setTargetDistanceInKm(int targetDistanceInKm) {
        this.targetDistanceInKm = targetDistanceInKm;
    }

    @Override
    public String toString() {
        return "PackageGroup{" +
                "targetLocation='" + targetLocation + '\'' +
                ", targetDistanceInKm=" + targetDistanceInKm +
                ", totalPackageValue=" + totalPackageValue +
                ", date=" + date +
                '}' + "\n";
    }

    public int getTotalPackageValue() {
        return totalPackageValue;
    }

    public void setTotalPackageValue(int totalPackageValue) {
        this.totalPackageValue = totalPackageValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void addPackageValue(int value) {
        this.totalPackageValue += value;
    }
}
