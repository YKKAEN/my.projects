package springboot.my.projects.database.DBManager;

import springboot.my.projects.database.constructors.Items;

import java.util.ArrayList;

public class ItemDBManager {
    private static ArrayList<Items> itemsList = new ArrayList<>();

    private static Long id = 6L;

    static {
        itemsList.add(new Items(1L, "MacBook Pro 2020", "8 GB RAM, 256 GB SSD, Intel Core i7",1499.99));
        itemsList.add(new Items(2L, "ASUS TUF GAMING", "16 GB RAM, 512 GB SSD, AMD Ryzen 5",999.99));
        itemsList.add(new Items(3L, "Apple Iphone 12 Pro", "6 GB RAM, 128 GB Memory, Super Retina XDR OLED Display",1099.99));
        itemsList.add(new Items(4L, "XIAOMI Redmi Note 8", "6 GB RAM, 64 GB Memory, Android 9 Pie",199.99));
        itemsList.add(new Items(5L, "XIAOMI Redmi Note 10", "8 GB RAM, 128 GB Memory, Android 11",299.99));
        itemsList.add(new Items(6L, "MSI Prestige 15", "Intel Core i7, 1024 GB Memory, 32 GB RAM",1999.99));
    }

    public static ArrayList<Items> getItems() {
        return itemsList;
    }

    public static void addItem(Items item) {
        item.setId(id);
        itemsList.add(item);
        id++;
    }
}