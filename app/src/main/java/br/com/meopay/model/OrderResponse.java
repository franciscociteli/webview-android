package br.com.meopay.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OrderResponse implements Serializable {

    private OrderData order;

    public OrderData getOrder() {
        return order;
    }

    public void setOrder(OrderData order) {
        this.order = order;
    }
}
