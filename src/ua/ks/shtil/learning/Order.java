package ua.ks.shtil.learning;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Структура заказа не очень сложна. Каждый заказ имеет уникальный номер, который используется для отслеживания,
 * а также информацию о клиенте, дату размещения, способ доставки (авиа или наземной службой) и состояние заказа.
 * Каждый заказ может содержать несколько позиций. На текущий момент мы ограничиваем количество позиций заказа
 * десятью.
 */
public class Order {

	//TODO add properties (except order positions)


    private int id;
    private Customer client;
    private Date dateOfPlacement;
    private DeliveryType deliveryType;
    private OrderStatus orderStatus;

    private OrderPosition orderPosition;



}
