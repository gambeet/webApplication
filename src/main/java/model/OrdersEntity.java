package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Orders", schema = "dbo", catalog = "shop")
@NamedQuery(name = "Orders.findAll", query = "select r from OrdersEntity r")
public class OrdersEntity implements EntityInterface  {
    private long id;
    private Date date;
    private boolean isPaid;
    private ClientsEntity clientsByClientId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        if (isPaid != that.isPaid) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (isPaid ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id", nullable = false)
    public ClientsEntity getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(ClientsEntity clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    @Override
    public String toHtmlTableRow(){
        String isPaidStr = null;
        if(isPaid)
            isPaidStr = "paid";
        else
            isPaidStr = "not paid";
        return "<tr><td>" + this.id + "</td><td>" + this.date + "</td><td>" + isPaidStr + "</td><td>" + this.clientsByClientId.getFio() + "</td><td>"
                + "<a href=\"/DeleteElementServlet?id=" + this.id + "\">Delete</a></td></tr>";
    }
}
