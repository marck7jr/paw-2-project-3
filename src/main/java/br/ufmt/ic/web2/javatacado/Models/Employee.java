package br.ufmt.ic.web2.javatacado.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name = "employee_seq", sequenceName = "employee_id_seq", allocationSize = 1)
public class Employee {
    @Id
    @Column
    @GeneratedValue(generator = "employee_seq", strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne
    private Account account;
    private float salary;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredAt;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firedAt;
    @ManyToOne
    @JoinTable(name = "role_employees")
    private Role role;
    @ManyToOne
    @JoinTable(name = "subsidiary_employees")
    private Subsidiary subsidiary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getHiredAt() {
        return hiredAt;
    }

    public void setHiredAt(Date hiredAt) {
        this.hiredAt = hiredAt;
    }

    public Date getFiredAt() {
        return firedAt;
    }

    public void setFiredAt(Date firedAt) {
        this.firedAt = firedAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        result = prime * result + ((firedAt == null) ? 0 : firedAt.hashCode());
        result = prime * result + ((hiredAt == null) ? 0 : hiredAt.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + Float.floatToIntBits(salary);
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
        Employee other = (Employee) obj;
        if (account == null) {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        if (firedAt == null) {
            if (other.firedAt != null)
                return false;
        } else if (!firedAt.equals(other.firedAt))
            return false;
        if (hiredAt == null) {
            if (other.hiredAt != null)
                return false;
        } else if (!hiredAt.equals(other.hiredAt))
            return false;
        if (id != other.id)
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
            return false;
        return true;
    }

    public Subsidiary getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(Subsidiary subsidiary) {
        this.subsidiary = subsidiary;
    }
}