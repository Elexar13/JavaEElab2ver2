package dao;

public class SelectObject {
    private int id;
    private String recipientName;
    private String editionName;
    private String deliveryName;

    public SelectObject(int id, String recipientName, String editionName, String deliveryName) {
        this.id = id;
        this.recipientName = recipientName;
        this.editionName = editionName;
        this.deliveryName = deliveryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    @Override
    public String toString() {
        return "SelectObject{" +
                "recipientName='" + recipientName + '\'' +
                ", editionName='" + editionName + '\'' +
                ", deliveryName='" + deliveryName + '\'' +
                '}';
    }
}
