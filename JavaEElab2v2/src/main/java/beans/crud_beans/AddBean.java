package beans.crud_beans;

import dao.PrintedEditionDAO;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "addBean")
@SessionScoped
public class AddBean implements Serializable {

    private String newRecipientName;
    private String newEditionName;
    private String newDeliveryName;

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

    public void add(){
        new PrintedEditionDAO().add(newRecipientName, newEditionName, newDeliveryName);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/admin-page.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}