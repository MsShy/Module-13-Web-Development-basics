package dao.substance;


public class Cookie {

    private int id;
    private String cookie;

    public Cookie( int id,String cookie) {
        this.cookie = cookie;
        this.id = id;
    }
    public Cookie( String cookie) {
        this.cookie = cookie;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "id=" + id +
                ", cookie='" + cookie + '\'' +
                '}';
    }
}
