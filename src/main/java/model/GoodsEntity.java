package model;

import javax.persistence.*;

@Entity
@Table(name = "Goods", schema = "dbo", catalog = "shop")
@NamedQueries({
        @NamedQuery(name = "Goods.findAll", query = "select r from GoodsEntity r"),
        @NamedQuery(name = "Goods.deleteElement", query = "DELETE FROM GoodsEntity r WHERE r.id = :id")
})
public class GoodsEntity implements EntityInterface {
    private long id;
    private String manufacturer;
    private String model;
    private double price;
    private String description;

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
    @Column(name = "manufacturer", nullable = false, length = 50)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "model", nullable = false, length = 50)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toHtmlTableRow() {
        return "<tr><td>" + this.id + "</td><td>" + this.manufacturer + "</td><td>" + this.model + "</td><td>" + this.price + "</td><td>" + this.description + "</td><td>"
                + "<a href=\"/DeleteElementServlet?id=" + this.id + "\">Delete</a></td><td>" +
                "<a href=\"/edit.jsp?id=" + this.id+ "&manufacturer=" + this.manufacturer + "&model=" + this.model + "&price=" + this.price + "&description=" + this.description.replace("+", "%2B") + "\">Edit</a>" + "</td></tr>";
    }
}
