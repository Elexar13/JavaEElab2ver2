package beans;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "loginBean", eager = true)
@RequestScoped
public class LogInBean implements Serializable {

    @ManagedProperty(value = "#{login}")
    private String login;
    @ManagedProperty(value = "#{password}")
    private String password;

    public LogInBean() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void getPage(){
        try {
            String URL = "/undefined-page.xhtml";
            if (login.equals("admin") & password.equals("1111")){
                URL = "/admin-page.xhtml";
            }
            else if (login.equals("user") & password.equals("1234")){
                URL = "/user-page.xhtml";
            }
            FacesContext.getCurrentInstance().getExternalContext().dispatch(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
