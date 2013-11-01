package org.ticpy.tekoporu.hotelBooking.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class People implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PEOPLE_PEOPLEID_GENERATOR", sequenceName=" PEOPLE_PEOPLE_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEOPLE_PEOPLEID_GENERATOR")
	@Column(name="people_id")
	private Integer peopleId;

	private String address;

	private String email;

	private String lastname;

	private String name;

	//bi-directional many-to-one association to BDetail
	@OneToMany(mappedBy="peopleId")
	private Set<BDetail> BDetails;

	//bi-directional many-to-one association to City
    @ManyToOne
	@JoinColumn(name="city_id")
	private City city;

    public People() {
    }

	public Integer getPeopleId() {
		return this.peopleId;
	}

	public void setPeopleId(Integer peopleId) {
		this.peopleId = peopleId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BDetail> getBDetails() {
		return this.BDetails;
	}

	public void setBDetails(Set<BDetail> BDetails) {
		this.BDetails = BDetails;
	}
	
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}