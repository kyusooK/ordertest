package ordertest.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ordertest.OrderApplication;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateOrder(UpdateOrderCommand updateOrderCommand) {
        //implement business logic here:

        OrderUpdated orderUpdated = new OrderUpdated(this);
        orderUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
