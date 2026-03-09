package br.com.unipds.events.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_subscription")
public class Subscription {

    @EmbeddedId
    private SubscriptionID id;

    @Column(name = "created_at")
    private LocalDateTime cratedAt;

    @Column(name = "level")
    private Integer level;

    @Column(name = "unique_id", nullable = false, length = 45)
    private String uniqueID;

    public SubscriptionID getId() {
        return id;
    }

    public void setId(SubscriptionID id) {
        this.id = id;
    }

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(LocalDateTime cratedAt) {
        this.cratedAt = cratedAt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String toString() {
        return "Subscription [id=" + id + ", cratedAt=" + cratedAt + ", level=" + level + ", uniqueID=" + uniqueID
                + "]";
    }

}