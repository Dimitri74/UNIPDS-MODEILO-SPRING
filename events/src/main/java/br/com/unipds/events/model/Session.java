package br.com.unipds.events.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Integer idSession;
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @ManyToOne
    @JoinColumn(name = "tbl_conference_id_conference")
    private Conference conference;

    public Integer getIdSession() {
        return idSession;
    }
    public void setIdSession(Integer idSession) {
        this.idSession = idSession;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public Conference getConference() {
        return conference;
    }
    public void setConference(Conference conference) {
        this.conference = conference;
    }
    @Override
    public String toString() {
        return "Session [idSession=" + idSession + ", title=" + title + ", startDate=" + startDate + ", startTime="
                + startTime + ", conference=" + conference + "]";
    }






}