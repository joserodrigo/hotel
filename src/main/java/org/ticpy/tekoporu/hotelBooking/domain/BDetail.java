package org.ticpy.tekoporu.hotelBooking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * The persistent class for the b_details database table.
 * 
 */
@Entity
@Table(name="b_details")
public class BDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="B_DETAILS_BDETAILSID_GENERATOR", sequenceName="B_DETAILS_BDETAILS_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="B_DETAILS_BDETAILSID_GENERATOR")
	@Column(name="bdetails_id")
	private Integer bdetailsId;
	
	
//	//bi-directional many-to-one association to City
//    @ManyToOne
//    @JoinColumn(name="booking_id")
	@Column(name="booking_id")
	private Integer bookingId;
    
//	//bi-directional many-to-one association to City
//    @ManyToOne
//    @JoinColumn(name="people_id")
	@Column(name="people_id")
	private Integer peopleId;
    
//	//bi-directional many-to-one association to City
//    @ManyToOne
//    @JoinColumn(name="room_id")
	@Column(name="room_id")
	private Integer roomId;

    public BDetail() {
    }

	public void setBdetailsId(Integer bdetailsId) {

		this.bdetailsId = bdetailsId;
	}

	public Integer getBdetailsId() {

		return bdetailsId;
	}

	public void setBookingId(Integer bookingId) {

		this.bookingId = bookingId;
	}

	public Integer getBookingId() {

		return bookingId;
	}

	public void setPeopleId(Integer peopleId) {

		this.peopleId = peopleId;
	}

	public Integer getPeopleId() {

		return peopleId;
	}

	public void setRoomId(Integer roomId) {

		this.roomId = roomId;
	}

	public Integer getRoomId() {

		return roomId;
	}


}