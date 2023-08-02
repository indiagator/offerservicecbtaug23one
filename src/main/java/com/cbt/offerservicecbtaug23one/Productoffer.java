package com.cbt.offerservicecbtaug23one;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "productoffers")
public class Productoffer {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "hscode", length = 8)
    private String hscode;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "unitprice")
    private Integer unitprice;

    @Column(name = "offername", length = 50)
    private String offername;

    @Column(name = "sellername", length = 50)
    private String sellername;

}