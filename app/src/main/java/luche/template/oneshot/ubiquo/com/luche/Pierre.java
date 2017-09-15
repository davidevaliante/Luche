package luche.template.oneshot.ubiquo.com.luche;

/**
 * Created by akain on 14/09/2017.
 */

public class Pierre {
    public String nome,cognome,city,img,phone;

    public Pierre(){

    }

    public Pierre(String nome, String city, String img, String phone) {
        this.nome = nome;
        this.cognome = cognome;
        this.city = city;
        this.img = img;
        this.phone = phone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
