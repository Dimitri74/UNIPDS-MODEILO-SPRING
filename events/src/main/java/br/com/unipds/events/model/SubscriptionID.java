package br.com.unipds.events.model;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SubscriptionID implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "subscribed_user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubscriptionID that)) {
            return false;
        }
        return Objects.equals(user, that.user) && Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, session);
    }

    @Override
    public String toString() {
        return "SubscriptionID [user=" + user + ", session=" + session + "]";
    }


}
