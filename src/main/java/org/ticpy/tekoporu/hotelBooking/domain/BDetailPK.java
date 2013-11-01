package org.ticpy.tekoporu.hotelBooking.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * The primary key class for the b_details database table.
 * 
 */
@Embeddable
public class BDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="booking_id")
	private Integer bookingId;

	@Column(name="people_id")
	private Integer peopleId;

	@Column(name="room_id")
	private Integer roomId;

    public BDetailPK() {
    }
	public Integer getBookingId() {
		return this.bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getPeopleId() {
		return this.peopleId;
	}
	public void setPeopleId(Integer peopleId) {
		this.peopleId = peopleId;
	}
	public Integer getRoomId() {
		return this.roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BDetailPK)) {
			return false;
		}
		BDetailPK castOther = (BDetailPK)other;
		return 
			this.bookingId.equals(castOther.bookingId)
			&& this.peopleId.equals(castOther.peopleId)
			&& this.roomId.equals(castOther.roomId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.bookingId.hashCode();
		hash = hash * prime + this.peopleId.hashCode();
		hash = hash * prime + this.roomId.hashCode();
		
		return hash;
    }
}