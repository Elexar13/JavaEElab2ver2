package beans;


import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "adminBean", eager = true)
@SessionScoped
public class AdminBean implements Serializable {


}
