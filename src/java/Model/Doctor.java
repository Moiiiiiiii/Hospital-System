package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "Code",nullable = false,unique = true)
    private String code;
    
    @Column(name = "Password", nullable = false)
    private String password;
    
    @Column(name = "DoctorSpecialty", nullable = false)
    private String Specialty;
    
    @Column(name = "Balance", nullable = false)
    private int balance;
    
    @Column(name = "Available")
    private int available;
     
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "DoctorProperties_ID")
    private DoctorProperties doctorproperties;
    
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Booking> booking = new ArrayList(); 

    public Doctor() {
    }

    public Doctor(String code, String password, String Specialty) {
        this.code = code;
        this.password = password;
        this.Specialty = Specialty;
    }
    
    public Doctor(String code, String password, String Specialty, DoctorProperties doctorproperties) {
        this.code = code;
        this.password = password;
        this.Specialty = Specialty;
        this.doctorproperties = doctorproperties;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String Specialty) {
        this.Specialty = Specialty;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public DoctorProperties getDoctorproperties() {
        return doctorproperties;
    }

    public void setDoctorproperties(DoctorProperties doctorproperties) {
        this.doctorproperties = doctorproperties;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
    
}