package dao;

public class SelectObject {
    private String recipientName;
    private String editionName;
    private String deliveryName;

    public SelectObject(String recipientName, String editionName, String deliveryName) {
        this.recipientName = recipientName;
        this.editionName = editionName;
        this.deliveryName = deliveryName;
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
