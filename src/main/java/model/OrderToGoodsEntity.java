package model;

import javax.persistence.*;

@Entity
@Table(name = "OrderToGoods", schema = "dbo", catalog = "shop")

@NamedQueries({
        @NamedQuery(name = "OrderToGoods.findAll", query = "select r from OrderToGoodsEntity r"),
        @NamedQuery(name = "OrderToGoods.deleteElement", query = "DELETE FROM OrderToGoodsEntity r WHERE r.id = :id")
})
public class OrderToGoodsEntity implements EntityInterface  {
    private long id;
    private OrdersEntity ordersByOrderId;
    private GoodsEntity goodsByGoodsId;
    private long quantity;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        else if(quantity != that.quantity) return false;
        else if(ordersByOrderId.getId() != that.ordersByOrderId.getId()) return false;
        else if(goodsByGoodsId.getId() != that.ordersByOrderId.getId()) return false;

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



    @Basic
    @Column(name = "quantity", nullable = false)
    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toHtmlTableRow(){
        return "<tr><td>" + this.id + "</td><td>" + this.ordersByOrderId.getClientsByClientId().getFio() + "</td><td>" + this.goodsByGoodsId.getManufacturer()+ " " + this.goodsByGoodsId.getModel() + "</td><td>" + this.quantity + "</td><td>"
                + "<a href=\"/DeleteElementServlet?id=" + this.id + "\">Delete</a></td><td>" +
                "<a href=\"/edit.jsp?id=" + this.id+ "&goodsId=" + this.goodsByGoodsId.getId() + "&orderId=" + this.ordersByOrderId.getId() + "&quantity=" + this.quantity + "\">Edit</a>" + "</td></tr>";
    }
}
