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
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Named
@ViewScoped
public class HomeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Event> events;

    @EJB
    private EventService service;
    private Person person;

    @PostConstruct
    public void init(){
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        person = (Person)session.get("user");
        this.events = service.findByAgendaId(person.getAgenda().getId());
    }

    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String addEvent(){
        return "registerEvent?faces-redirect=true";
    }

    public void delete(Long id){
        service.delete(id);
    }

    public String update(Event event){
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        session.put("event", event);
        return "editEvent.xhtml?faces-redirect=true";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeBean homeBean = (HomeBean) o;
        return Objects.equals(events, homeBean.events) &&
                Objects.equals(service, homeBean.service) &&
                Objects.equals(person, homeBean.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(events, service, person);
    }
}
