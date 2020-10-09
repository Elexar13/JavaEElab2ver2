package beans;


import dao.PrintedEditionDAO;
import dao.SelectObject;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "userBean", eager = true)
@SessionScoped
public class UserBean implements Serializable {

    private static final List<SelectObject> selectedRows = new PrintedEditionDAO().findAll();

    public UserBean() {
        //PrintedEditionDAO pe = new PrintedEditionDAO();
        //selectedRows = pe.findAll();

    }

    public List<SelectObject> getSelectedRows() {
//        selectedRows.forEach(System.out::println);
        return selectedRows;
    }

}
