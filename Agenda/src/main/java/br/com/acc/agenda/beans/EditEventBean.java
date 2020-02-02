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
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Named
@ViewScoped
public class EditEventBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private EventService service;

    private String title;
    private String description;
    private String location;
    private LocalDateTime time;

    private Event event;
    private Person person;

    @PostConstruct
    public void init(){
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        event = (Event)session.get("event");
        person = (Person)session.get("user");

        title = event.getTitle();
        description = event.getDescription();
        location = event.getLocation();
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String register(){
        event.setTitle(this.title);
        event.setDescription(this.description);
        event.setLocation(this.location);

        event.setAgenda(this.event.getAgenda());
        service.update(event);

        return "home.xhtml?faces-redirect=true";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditEventBean loginBean = (EditEventBean) o;
        return Objects.equals(title, loginBean.title) &&
                Objects.equals(description, loginBean.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }
}
