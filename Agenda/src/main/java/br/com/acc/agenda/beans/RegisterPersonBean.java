package br.com.acc.agenda.beans;

import br.com.acc.agenda.model.Agenda;
import br.com.acc.agenda.model.Person;
import br.com.acc.agenda.service.AgendaService;
import br.com.acc.agenda.service.PersonService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;

@Named
@ViewScoped
public class RegisterPersonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String password;
    private String passwordConfirm;

    @EJB
    private PersonService personService;
    @EJB
    private AgendaService agendaService;

    public RegisterPersonBean() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String register(){

        if(this.password.equals(this.passwordConfirm)){

            Agenda agenda = new Agenda("Agenda Pessoal");
            agendaService.save(agenda);

            Person person = new Person();
            person.setAgenda(agenda);
            person.setEmail(this.email);
            person.setName(this.name);
            person.setPassword(this.password);
            Person personDB = personService.save(person);
            if(personDB != null){
                return "login.xhtml?faces-redirect=true";
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Falha no registro", "Aconteceu uma falha ao registrar o usuário." ));

            return "";

        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senhas devem coincidir." ));
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterPersonBean that = (RegisterPersonBean) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password);
    }
}
