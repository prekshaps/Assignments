package org.rpa.rpaui.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parameters")
public class ParameterData {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="_cube")
	private int cube;
	@Column(name="_weight")
	private int weight;
	@Column(name="_linearfeet")
	private int linearfeet;
	@Column(name="_skid")
	private int skid;
	@Column(name="_cubeper")
	private float cubeper;
	@Column(name="_weightper")
	private float weightper;
	@Column(name="_linearfeetper")
	private float linearfeetper;
	@Column(name="_skidper")
	private float skidper;
	@Column(name="_height")
	private long height;
	@Column(name="_width")
	private long width;
	@Column(name="_length")
	private long length;
	@Column(name="_sku")
	private long sku;
    public ParameterData() {
		
	}
	public int getCube() {
		return cube;
	}
	public void setCube(int cube) {
		this.cube = cube;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getLinearfeet() {
		return linearfeet;
	}
	public void setLinearfeet(int linearfeet) {
		this.linearfeet = linearfeet;
	}
	public int getSkid() {
		return skid;
	}
	public void setSkid(int skid) {
		this.skid = skid;
	}
	public float getCubeper() {
		return cubeper;
	}
	public void setCubeper(float cubeper) {
		this.cubeper = cubeper;
	}
	public float getWeightper() {
		return weightper;
	}
	public void setWeightper(float weightper) {
		this.weightper = weightper;
	}
	public float getLinearfeetper() {
		return linearfeetper;
	}
	public void setLinearfeetper(float linearfeetper) {
		this.linearfeetper = linearfeetper;
	}
	public float getSkidper() {
		return skidper;
	}
	public void setSkidper(float skidper) {
		this.skidper = skidper;
	}
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	public long getWidth() {
		return width;
	}
	public void setWidth(long width) {
		this.width = width;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public long getSku() {
		return sku;
	}
	@Override
	public String toString() {
		return "ParameterData [id=" + id + ", cube=" + cube + ", weight=" + weight + ", linearfeet=" + linearfeet
				+ ", skid=" + skid + ", cubeper=" + cubeper + ", weightper=" + weightper + ", linearfeetper="
				+ linearfeetper + ", skidper=" + skidper + ", height=" + height + ", width=" + width + ", length="
				+ length + ", sku=" + sku + ", getId()=" + getId() + ", getCube()=" + getCube() + ", getWeight()="
				+ getWeight() + ", getLinearfeet()=" + getLinearfeet() + ", getSkid()=" + getSkid() + ", getCubeper()="
				+ getCubeper() + ", getWeightper()=" + getWeightper() + ", getLinearfeetper()=" + getLinearfeetper()
				+ ", getSkidper()=" + getSkidper() + ", getHeight()=" + getHeight() + ", getWidth()=" + getWidth()
				+ ", getLength()=" + getLength() + ", getSku()=" + getSku() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public void setSku(long sku) {
		this.sku = sku;
	}
	
	
}
