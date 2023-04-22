package com.ty.hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Observation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int O_id;
	private String dname;
	private String robservation;
	@JoinColumn
	@ManyToOne
	private Encounter encounter;

	public int getO_id() {
		return O_id;
	}

	public void setO_id(int o_id) {
		O_id = o_id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getRobservation() {
		return robservation;
	}

	public void setRobservation(String robservation) {
		this.robservation = robservation;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

}
