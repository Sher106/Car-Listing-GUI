import java.text.NumberFormat;


public class Car {
    private String Make, Model, VIN;
    public String carImage;
    private final int Year;
    private final String Cost;
    private final String Mileage;
    public boolean CleanRecord;


    //Driver class linked to started method in Listing class
    public Car(int Year, String Make, String Model, String VIN, String Mileage, String Cost, boolean CleanRecord, String carImage) {
        this.Year = Year;
        this.Make = Make;
        this.Model = Model;
        this.VIN = VIN;
        this.Mileage = Mileage;
        this.Cost = String.valueOf(Cost);
        this.CleanRecord = CleanRecord;
        this.carImage = carImage;
    }

    public String toString() {                               //To report each variable
        NumberFormat format = NumberFormat.getCurrencyInstance();
        String description = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        description += "Year: " + Year + "\n";
        description += "Make: " + Make + "\n";
        description += "Model: " + Model + "\n";
        description += "VIN: " + VIN + "\n";
        description += "Mileage: " + Mileage + "\n";
        description += "Cost: " + Cost + "\n";

        if (CleanRecord) {
            description += "\t" + "Clean Record: No Accidents Reported";
        } else {
            description += "\fAccident Record: One Accident Reported";

        }
            return description;
    }
    public String getCarImage() {
        return carImage;
    }
}