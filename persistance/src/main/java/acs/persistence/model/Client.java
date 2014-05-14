package acs.persistence.model;


/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends BaseEntity {

    @Id
    @Column(name = "client_id", nullable = false)
    Integer id;

    @Column(name = "name_client", nullable = false)
    String userName;

    @Column(name = "email", nullable = false)
    String email;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    private Set<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Client)){
            return false;
        }
        Client other = (Client) object;
        if(this.id != other.id && (this.id == null || !this.id.equals(other.id))){
            return false;
        }
        return true;
    }
}
