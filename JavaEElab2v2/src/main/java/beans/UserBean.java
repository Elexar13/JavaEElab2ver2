package beans;


import dao.PrintedEditionDAO;
import dao.SelectObject;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "userBean", eager = true)
@SessionScoped
public class UserBean implements Serializable {

    public List<SelectObject> getSelectedRows() {
        return  new PrintedEditionDAO().findAll();
    }

    public void logOut(){
        FacesContext facesContext;
        HttpSession session;
        facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.removeAttribute("username");
        session.removeAttribute("password");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
