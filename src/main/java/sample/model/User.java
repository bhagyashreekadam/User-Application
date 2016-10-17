package sample.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name="user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;

	@Column(name="address")
	private String address;

	@Column(name="phonenumber")
	private long phonenumber;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public User()
	{

		
	}
	
	public User(Integer id, String firstname, String lastname,String address,long phonenumber ) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phonenumber = phonenumber;
	}




	@Override
	public String toString() {
		return "RequestLog [id=" + id ;
	}
}