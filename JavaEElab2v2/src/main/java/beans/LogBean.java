package beans;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "logBean")
@SessionScoped
public class LogBean implements Serializable {

    private String username;
    private String password;

    FacesContext facesContext;
    HttpSession session;

    public LogBean() {
        facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(true);
        System.out.println("CONSTRUCTOR");
       if (session.getAttribute("username") != null & session.getAttribute("password") != null) {
            String URL = "/pages/undefined-page.xhtml";
            if (session.getAttribute("username").equals("admin") & session.getAttribute("password").equals("1111")) {
                URL = "/pages/admin-page.xhtml";
            } else if (session.getAttribute("username").equals("user") & session.getAttribute("password").equals("1234")) {
                URL = "/pages/user-page.xhtml";
            }
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(URL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getLogin() {
        login();
        return username+ " " + password;
    }

    public void login(){
        if (username != null & password != null) {
           if (session.getAttribute("username") == null & session.getAttribute("password") == null) {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                System.out.println(username + " " + password);
                try {
                    String URL = "/pages/undefined-page.xhtml";
                    if (username.equals("admin") & password.equals("1111")) {
                        URL = "/pages/admin-page.xhtml";
                    } else if (username.equals("user") & password.equals("1234")) {
                        URL = "/pages/user-page.xhtml";
                    }
                    FacesContext.getCurrentInstance().getExternalContext().redirect(URL);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
