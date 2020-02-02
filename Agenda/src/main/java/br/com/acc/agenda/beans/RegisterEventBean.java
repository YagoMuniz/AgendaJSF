package br.com.acc.agenda.beans;

import br.com.acc.agenda.model.Event;
import br.com.acc.agenda.model.Person;
import br.com.acc.agenda.service.EventService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Named
@ViewScoped
public class RegisterEventBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private EventService service;

    private String title;
    private String description;
    private String location;
    private Date time;


    private Person person;

    @PostConstruct
    public void init(){
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        person = (Person)session.get("user");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String register(){
        Event event = new Event();
        event.setTitle(this.title);
        event.setDescription(this.description);
        event.setLocation(this.location);
        event.setTime(convertToLocalDateTime(time));
        event.setAgenda(person.getAgenda());
        service.save(event);

        return "home.xhtml?faces-redirect=true";
    }

    private LocalDateTime convertToLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterEventBean loginBean = (RegisterEventBean) o;
        return Objects.equals(title, loginBean.title) &&
                Objects.equals(description, loginBean.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }
}
