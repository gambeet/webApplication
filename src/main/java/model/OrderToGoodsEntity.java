package model;

import javax.persistence.*;

@Entity
@Table(name = "OrderToGoods", schema = "dbo", catalog = "shop")
@NamedQuery(name = "OrderToGoods.findAll", query = "select r from OrderToGoodsEntity r")
public class OrderToGoodsEntity implements EntityInterface  {
    private long id;
    private OrdersEntity ordersByOrderId;
    private GoodsEntity goodsByGoodsId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderToGoodsEntity that = (OrderToGoodsEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id", nullable = false)
    public OrdersEntity getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(OrdersEntity ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "goodsId", referencedColumnName = "id", nullable = false)
    public GoodsEntity getGoodsByGoodsId() {
        return goodsByGoodsId;
    }

    public void setGoodsByGoodsId(GoodsEntity goodsByGoodsId) {
        this.goodsByGoodsId = goodsByGoodsId;
    }

    @Override
    public String toHtmlTableRow(){
        return "<tr><td>" + this.id + "</td><td>" + this.ordersByOrderId.getId() + "</td><td>" + this.goodsByGoodsId.getId() + "</td></tr>";
    }
}
