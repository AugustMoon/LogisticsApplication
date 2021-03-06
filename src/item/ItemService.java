package item;

import java.util.Map;

/**
 * item.java
 * LogisticsApplication
 */
final public class ItemService {
    private static ItemService itemServiceInstance;
    private ItemLoader itemLoaderDelegate;
    private Map<String, Item> itemMap;

    private ItemService(String type) {
        itemLoaderDelegate = ItemLoaderFactory.build(type);
    }


    private Map<String, Item> loadItems(String source) {
        return itemLoaderDelegate.loadItems(source);
    }

    private boolean isItemMapLoaded() {
        return itemMap != null;
    }

    public static ItemService getItemServiceInstance() {
        if(itemServiceInstance == null) {
            // Initializing itemServiceInstance to source as a XML file.
            itemServiceInstance = new ItemService("XML");
        }
        return itemServiceInstance;
    }

    public void changeItemLoaderSourceType(String type) {
        itemLoaderDelegate = ItemLoaderFactory.build(type);
    }

    // Publicly exposed method for loading items.
    public boolean loadItemsFromSource(String source) {
        // Initializing itemMap
        itemMap = loadItems(source);
        if(isItemMapLoaded() && !itemMap.isEmpty()) {
            System.out.println("Items loaded successfully!");
            return true;
        }
        System.out.println("Failed to load items!");
        return false;
    }

    // Check if item is available.
    public boolean isValidItem(String itemId) {
        if(isItemMapLoaded() && itemMap.containsKey(itemId)) {
           // System.out.println("Item_ID: " + itemId + " available!");
            return true;
        }
       // System.out.println("Item_ID: " + itemId + " not available!");
        return false;
    }

    // Get Item object by Item_ID
    public Item getItem(String itemId) {
        isValidItem(itemId);
        if(isItemMapLoaded()) {
            return itemMap.get(itemId);
        }
        System.out.println("Item map not initialized!");
        return null;
    }
}
