/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alexandra
 */
@Entity
@Table(name = "LEADERBOARD")
@NamedQueries({
    @NamedQuery(name = "Leaderboard.findAll", query = "SELECT l FROM Leaderboard l"),
    @NamedQuery(name = "Leaderboard.findByUsername", query = "SELECT l FROM Leaderboard l WHERE l.username = :username"),
    @NamedQuery(name = "Leaderboard.findByScore", query = "SELECT l FROM Leaderboard l WHERE l.score = :score")})
public class Leaderboard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "SCORE")
    private double score;

    public Leaderboard() {
    }

    public Leaderboard(String username) {
        this.username = username;
    }

    public Leaderboard(String username, double score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leaderboard)) {
            return false;
        }
        Leaderboard other = (Leaderboard) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assignment2.Leaderboard[ username=" + username + " ]";
    }
    
}
