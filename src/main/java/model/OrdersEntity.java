package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Orders", schema = "dbo", catalog = "shop")
public class OrdersEntity {
    private long id;
    private long clientId;
    private Date date;
    private boolean isPaid;
    private Collection<OrderToGoodsEntity> orderToGoodsById;
    private ClientsEntity clientsByClientId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "clientId", nullable = false)
    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "isPaid", nullable = false)
    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;
        if (clientId != that.clientId) return false;
        if (isPaid != that.isPaid) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (isPaid ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<OrderToGoodsEntity> getOrderToGoodsById() {
        return orderToGoodsById;
    }

    public void setOrderToGoodsById(Collection<OrderToGoodsEntity> orderToGoodsById) {
        this.orderToGoodsById = orderToGoodsById;
    }

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id", nullable = false)
    public ClientsEntity getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(ClientsEntity clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }
}
