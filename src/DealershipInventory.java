import javafx.scene.image.Image;
import java.text.NumberFormat;
public class DealershipInventory {
    public Car[] Inventory;
    private static int count;
    String report, description;

    //Driver class linked to started method in Listing class
    public DealershipInventory(){
        Inventory = new Car [10];
        count = 0;
    }

    //Varying String attached/linked to Listing class
    public void list(int Year, String Make, String Model, String VIN, String Mileage, String Cost, boolean cleanRecord, String carImage) {
        if (count== Inventory.length){
            increaseSize();
        }
        Inventory[count] = (new Car(Year, Make, Model, VIN, Mileage, Cost, cleanRecord, carImage));
        count++;
    }

    public String toString(){
        description = "Number of Cars: " + count;
        return description;
    }
    private void increaseSize(){
        Car[] Temp = new Car[Inventory.length * 2];

        for (int car = 0; car < Inventory.length; car++){
            Temp[car] = Inventory[car];
        }
        Inventory = Temp;
    }
}
