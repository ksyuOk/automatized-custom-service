package entities;


/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @Column(name = "client_id", nullable = false)
    Integer clientId;

    @Column(name = "name_client", nullable = false)
    String userName;

    @Column(name = "email", nullable = false)
    String email;

    @OneToMany(mappedBy = "")
    public Set<Order> getOrders(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (this.clientId != null ? this.clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Client)){
            return false;
        }
        Client other = (Client) object;
        if(this.clientId != other.clientId && (this.clientId == null || !this.clientId.equals(other.clientId))){
            return false;
        }
        return true;
    }
}
