package br.com.acc.agenda.beans;

import br.com.acc.agenda.model.Person;
import br.com.acc.agenda.service.PersonService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String password;

    @EJB
    private PersonService personService;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){

        Person person = personService.findByEmailAndPassword(email, password);

        if(person != null){
            Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            session.put("user", person);
            return "home.xhtml?faces-redirect=true";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Falha na autenticação", "Usuário e/ou senha inválidos." ));
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginBean loginBean = (LoginBean) o;
        return Objects.equals(email, loginBean.email) &&
                Objects.equals(password, loginBean.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
