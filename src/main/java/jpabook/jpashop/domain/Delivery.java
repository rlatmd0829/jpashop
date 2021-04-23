package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    Address address;

    @Enumerated(EnumType.STRING) // ORDINAL은 컬럼이 숫자로 들어간다. 중간에 상태가 생기면 순서가 바뀌기 때문에 쓰면안되고 String으로 써야한다.
    private DeliveryStatus status; // READY, COMP
}
