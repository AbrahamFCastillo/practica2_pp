package mx.smartkode.sk.crud.model;

public class Jugador {
    private Integer id;
    private String email;
    private String username;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "Jugador [id=" + id + ", email=" + email + ", username=" + username + "]";
    }
}
