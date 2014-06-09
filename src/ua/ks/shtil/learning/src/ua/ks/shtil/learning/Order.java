package ua.ks.shtil.learning.src.ua.ks.shtil.learning;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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
    private Date dateOfPlacement  = new Date();
    private DeliveryType deliveryType;
    private OrderStatus orderStatus;
    private OrderPosition orderPosition;

    private static int count = 0;

    private List<OrderPosition> orderPositionList ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getClient() {
        return client;
    }

    public void setClient(Customer client) {
        this.client = client;
    }

    public Date getDateOfPlacement() {
        return dateOfPlacement;
    }

    public void setDateOfPlacement(Date dateOfPlacement) {
              this.dateOfPlacement = dateOfPlacement;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderPosition getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(OrderPosition orderPosition) throws Exception{

        for(OrderPosition mOrderPosition: orderPositionList){

            if (count>10){
                throw new Exception("Order count position >10 ");
            }

            if (!mOrderPosition.equals(orderPosition)){
                count = count + 1;
                this.orderPosition = orderPosition;
                this.orderPositionList.add(orderPosition);
            } else {
                throw new Exception("Order have this product or order position >10 ");
            }
        }
        this.orderPositionList.add(orderPosition);

    }

    public Order() {
        orderPositionList =  new ArrayList<OrderPosition>();
    }

    @Override
    public String toString() {
        String oplString = "";
        System.out.println("orderPositionList count =" + orderPositionList.size());

        for(OrderPosition opl: orderPositionList){
            oplString = oplString + opl.toString() +"\n\t";
        }

        return "Order{" +
                "client=" + client +
                ", \ndateOfPlacement=" + dateOfPlacement +
                ", \ndeliveryType=" + deliveryType +
                ", \norderStatus=" + orderStatus +
                ", \norderPositionList= \n\t" + oplString +
                '}';
    }

    public void saveToFileAsText() {


        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("settings.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStreamWriter fw =
                     new OutputStreamWriter(
                             new FileOutputStream(properties.getProperty("order.file")))) {
            fw.write(this.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
