package com.tms.rpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccuracyData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private long nonweight;
	private float nonratio;
	private int noncube;
	private long pweight;
	private float pratio;
	private float cratio;
	private float wratio;
	
	@Override
	public String toString() {
		return "AccuracyData [id=" + id + ", nonweight=" + nonweight + ", nonratio=" + nonratio + ", noncube=" + noncube
				+ ", pweight=" + pweight + ", pratio=" + pratio + ", cratio=" + cratio + ", wratio=" + wratio + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getNonweight() {
		return nonweight;
	}
	public void setNonweight(long nonweight) {
		this.nonweight = nonweight;
	}
	public float getNonratio() {
		return nonratio;
	}
	public void setNonratio(float nonratio) {
		this.nonratio = nonratio;
	}
	public int getNoncube() {
		return noncube;
	}
	public void setNoncube(int noncube) {
		this.noncube = noncube;
	}
	public long getPweight() {
		return pweight;
	}
	public void setPweight(long pweight) {
		this.pweight = pweight;
	}
	public float getPratio() {
		return pratio;
	}
	public void setPratio(float pratio) {
		this.pratio = pratio;
	}
	public float getCratio() {
		return cratio;
	}
	public void setCratio(float cratio) {
		this.cratio = cratio;
	}
	public float getWratio() {
		return wratio;
	}
	public void setWratio(float wratio) {
		this.wratio = wratio;
	}
/*
 
 "nonweight":44000,
"nonratio":0.20,
"noncube":500,
"pweight":44000,
"pratio":0.60,
"cratio":7.0,
"wratio":7.0
 */
}