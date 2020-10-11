package beans.crud_beans;

import dao.PrintedEditionDAO;
import dao.SelectObject;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "updateBean")
@SessionScoped
public class UpdateBean implements Serializable {
    private int id;
    private String newRecipientName;
    private String newEditionName;
    private String newDeliveryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewRecipientName() {
        return newRecipientName;
    }

    public void setNewRecipientName(String newRecipientName) {
        this.newRecipientName = newRecipientName;
    }

    public String getNewEditionName() {
        return newEditionName;
    }

    public void setNewEditionName(String newEditionName) {
        this.newEditionName = newEditionName;
    }

    public String getNewDeliveryName() {
        return newDeliveryName;
    }

    public void setNewDeliveryName(String newDeliveryName) {
        this.newDeliveryName = newDeliveryName;
    }

    public List<Integer> getSelectedID() {
        return  new PrintedEditionDAO().findID();
    }

    public void update(){
        new PrintedEditionDAO().update(id, newRecipientName, newEditionName, newDeliveryName);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/admin-page.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
