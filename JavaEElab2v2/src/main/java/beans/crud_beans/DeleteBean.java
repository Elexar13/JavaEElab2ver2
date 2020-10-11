package beans.crud_beans;

import dao.PrintedEditionDAO;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "deleteBean")
@SessionScoped
public class DeleteBean implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void delete(){
        new PrintedEditionDAO().delete(id);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/admin-page.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}