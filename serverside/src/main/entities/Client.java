package src.main.entities;


/**
 * Created with IntelliJ IDEA.
 * User: oksana
 * Date: 09.05.14
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
}
