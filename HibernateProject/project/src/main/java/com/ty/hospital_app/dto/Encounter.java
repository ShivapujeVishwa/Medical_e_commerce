package com.ty.hospital_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	private String reason;
	private String DOJ;
	private String dischargeDate;
	@OneToMany(mappedBy = "encounter")
	private List<Observation> observation;
	@JoinColumn
	@ManyToOne
	private Person person;
	@JoinColumn
	@ManyToOne
	private Branch branch;
	@OneToMany(mappedBy = "encounter")
	private List<Medorder> medorder;

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDOJ() {
		return DOJ;
	}

	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public List<Observation> getObservation() {
		return observation;
	}

	public void setObservation(List<Observation> observation) {
		this.observation = observation;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Medorder> getMedorder() {
		return medorder;
	}

	public void setMedorder(List<Medorder> medorder) {
		this.medorder = medorder;
	}

}
