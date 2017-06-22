package model;

import javax.persistence.*;

@Entity
@Table(name = "Clients", schema = "dbo", catalog = "shop")

@NamedQueries({
        @NamedQuery(name = "Clients.findAll", query = "select r from ClientsEntity r"),
        @NamedQuery(name = "Clients.deleteElement", query = "DELETE FROM ClientsEntity r WHERE r.id = :id")
})
public class ClientsEntity implements EntityInterface {
    private long id;
    private String fio;
    private String address;
    private String phone;

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
    @Column(name = "fio", nullable = false, length = 50)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (id != that.id) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toHtmlTableRow() {
        return "<tr><td>" + this.id + "</td><td>" + this.fio + "</td><td>" + this.address + "</td><td>" + this.phone + "</td><td>"
                + "<a href=\"/DeleteElementServlet?id=" + this.id + "\">Delete</a></td></tr>";
    }
}
