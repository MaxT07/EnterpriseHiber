package model;

import net.sf.oval.constraints.Length;
import net.sf.oval.constraints.NotEmpty;
import net.sf.oval.constraints.RegEx;
import org.hibernate.mapping.List;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty(message = "Firstname has to be filling")
    private String firstname;

    @Column
    @NotEmpty(message = "Lastname has to be filling")
    private String lastname;

    @Column
    private String age;

    @Column
    @NotEmpty(message = "field 'Phone' has  to be filled")
    @RegEx(pattern = "^((\\+?380)[0-9]{9})$", message = "this format phone has not to be rely")
    private String phone;

    @Column
    @RegEx(pattern ="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "This format for email has not to be rely")
    private String email;

    @Column
    @Length(min = 5, max = 50, message = "Input text between 5 and 50 symbols")
    @NotEmpty(message = "Field 'Position'  has to be filled")
    private String position;
    private int depId;



    public Employee(String firstname, String lastname, String age, String phone, String email, String position, int depId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", depId='" + depId + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public Employee(){

    }

    public Employee(int id, String firstname, String lastname, String age, String phone, String email, String position, int depId){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }


}
