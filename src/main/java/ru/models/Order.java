package ru.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "orders")
public class Order {

    @JsonProperty("id")
    private String id=new String();
    @JsonProperty("servicename")
    private String serviceName;
    @JsonProperty("targeturl")
    private String targetUrl;
    @JsonProperty("price")
    private int price;
    @JsonIgnore
    private User user;

    public Order(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "servicename")
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Column(name = "targeturl")
    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Order other = (Order) o;
        if (other.id.equals(this.id))
            return true;
        return false;
    }
}
