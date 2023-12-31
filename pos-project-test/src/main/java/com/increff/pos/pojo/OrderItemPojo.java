package com.increff.pos.pojo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="OrderItem")
public class OrderItemPojo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int order_id;
    private int product_id;
    private int quantity;
    private double selling_price;

}
