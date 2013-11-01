package org.ticpy.tekoporu.hotelBooking.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROOM_ROOMID_GENERATOR", sequenceName=" ROOM_ROOM_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROOM_ROOMID_GENERATOR")
	@Column(name="room_id")
	private Long roomId;

	private Integer delete;

	@Column(name="room_desc")
	private String roomDesc;

	//bi-directional many-to-one association to BDetail
	@OneToMany(mappedBy="roomId")
	private Set<BDetail> BDetails;

    public Room() {
    }

	public Long getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Integer getDelete() {
		return this.delete;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	public String getRoomDesc() {
		return this.roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public Set<BDetail> getBDetails() {
		return this.BDetails;
	}

	public void setBDetails(Set<BDetail> BDetails) {
		this.BDetails = BDetails;
	}
	
}