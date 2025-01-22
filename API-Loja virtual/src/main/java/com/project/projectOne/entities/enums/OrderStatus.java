package com.project.projectOne.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
    public static OrderStatus valueOf(int code){
        for(OrderStatus order : OrderStatus.values()){
            if(code == order.getCode()){
                return order;
            }
        }
        throw  new IllegalArgumentException("The informed order status is invalid");
    }
}
