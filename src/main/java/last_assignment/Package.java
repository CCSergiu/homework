package last_assignment;

import java.time.LocalDate;

public class Package {

    private String targetLocation;
    private int targetDistanceInKm;
    private int packageValue;
    private LocalDate date;

    public Package(String targetLocation, int targetDistanceInKm, int packageValue, LocalDate date) {
        this.targetLocation = targetLocation;
        this.targetDistanceInKm = targetDistanceInKm;
        this.packageValue = packageValue;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Package{" +
                "targetLocation='" + targetLocation + '\'' +
                ", targetDistanceInKm=" + targetDistanceInKm +
                ", packageValue=" + packageValue +
                ", date=" + date +
                '}' + "\n";
    }

    public String getKey() {
        return targetLocation + " " + date;
    }

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

    public int getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(int packageValue) {
        this.packageValue = packageValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
