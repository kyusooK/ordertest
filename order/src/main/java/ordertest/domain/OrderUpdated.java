package ordertest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ordertest.domain.*;
import ordertest.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderUpdated extends AbstractEvent {

    private Long id;
    private String name;
    private String address;

    public OrderUpdated(Order aggregate) {
        super(aggregate);
    }

    public OrderUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
