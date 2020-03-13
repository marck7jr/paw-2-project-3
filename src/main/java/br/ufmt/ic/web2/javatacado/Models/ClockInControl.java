package br.ufmt.ic.web2.javatacado.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name = "clockincontrol_seq", sequenceName = "clockincontrol_id_seq", allocationSize = 1)
public class ClockInControl {
    @Id
    @Column
    @GeneratedValue(generator = "clockincontrol_seq", strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne
    private Employee employee;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    private Date checkIn;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss.SSS")
    private Date checkOut;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
        result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClockInControl other = (ClockInControl) obj;
        if (checkIn == null) {
            if (other.checkIn != null)
                return false;
        } else if (!checkIn.equals(other.checkIn))
            return false;
        if (checkOut == null) {
            if (other.checkOut != null)
                return false;
        } else if (!checkOut.equals(other.checkOut))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}