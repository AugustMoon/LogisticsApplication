package order;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OrderBasicImpl.java
 * LogisticsApplication
 */
public class OrderBasicImpl implements Order {
    private String orderId;
    private int orderTime;
    private String destination;
    // Map of item id and quantity
    private Map<String, Integer> orderItems;

    public OrderBasicImpl(String orderId, int orderTime, String destination, Map<String, Integer> orderItems) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.destination = destination;
        this.orderItems = new HashMap<>(orderItems);
    }

    public String toString() {
        StringBuilder orderBuilder = new StringBuilder();
        orderBuilder.append("Order Id: " + orderId);
        orderBuilder.append("\n");
        orderBuilder.append("Order Time: Day " + orderTime);
        orderBuilder.append("\n");
        orderBuilder.append("Destination: " + destination);
        orderBuilder.append("\n");
        orderBuilder.append("List of Order Items:");
        orderBuilder.append("\n");
        for (String itemId : orderItems.keySet()) {
            orderBuilder.append("<> Item ID: " + itemId + "," + " Quantity: " + orderItems.get(itemId));
            orderBuilder.append("\n");
        }
        return orderBuilder.toString();
    }


    @Override
    public String getOrderId() {
        return orderId;
    }

    @Override
    public Map<String, Integer> getOrderItems() {
        // Return a copy of orderItems.
        return new HashMap<>(orderItems);
    }


    @Override
    public String getOrderDestination() {
        return destination;
    }

    @Override
    public int getOrderTime() {
        return orderTime;
    }

    @Override
    public List<String> getOrderItemList() {
        List<String> orderItemList = new ArrayList<>();
        for(String orderItemId: orderItems.keySet()) {
            orderItemList.add(orderItemId);
        }
        return orderItemList;
    }
}