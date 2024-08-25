package com.bug_tracker.BugTrackerApp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bugs")
public class Bug {

    // define fields

    @Id
    @Column(name = "bug_name")
    private String bug_name;

    @Column(name = "bug_description")
    private String bug_description;

    @Column(name = "reporter")
    private String reporter;

    @Column(name = "date_added")
    private String date_added;

    @Column(name = "resolved")
    private boolean resolved;

    @Column(name = "date_resolved")
    private String date_resolved;

    @Column(name = "severity")
    private int severity;

    // define constructors

    public Bug() {

    }

    public Bug(String bug_name,
            String bug_description,
            String reporter,
            String date_added,
            boolean resolved,
            String date_resolved,
            int severity) {
        this.bug_name = bug_name;
        this.bug_description = bug_description;
        this.reporter = reporter;
        this.date_added = date_added;
        this.resolved = resolved;
        this.date_resolved = date_resolved;
        this.severity = severity;
    }

    // define getters/setters

    public String getBug_name() {
        return bug_name;
    }

    public void setBug_name(String bug_name) {
        this.bug_name = bug_name;
    }

    public String getBug_description() {
        return bug_description;
    }

    public void setBug_description(String bug_description) {
        this.bug_description = bug_description;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public String getDate_resolved() {
        return date_resolved;
    }

    public void setDate_resolved(String date_resolved) {
        this.date_resolved = date_resolved;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Bug [Name=" + bug_name + ", Reporter=" + reporter + ", resolved=" + resolved + "]";
    }

}