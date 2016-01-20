package com.ferhat.breast;

import java.util.Vector;

public class ImplantItem {
	// #DIAMETER;VOLUME;PROJECTION;PROFILE
	private float diameter;
	private int volume;
	private float projection;
	private ImplantProfile profile;

	public ImplantItem(float diameter, int volume, float projection, ImplantProfile profile) {
		super();
		this.diameter = diameter;
		this.volume = volume;
		this.projection = projection;
		this.profile = profile;
	}

	public float getDiameter() {
		return diameter;
	}

	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public float getProjection() {
		return projection;
	}

	public void setProjection(float projection) {
		this.projection = projection;
	}

	public ImplantProfile getProfile() {
		return profile;
	}

	public void setProfile(ImplantProfile profile) {
		this.profile = profile;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("DIAMETER=[").append(diameter).append(" cm]");
		sb.append("\tVOLUME=[").append(volume).append(" cc]");
		sb.append("\tPROJECTION=[").append(projection).append(" cm]");
		sb.append("\tPROFILE=[").append(profile.name()).append("]");
		return sb.toString();
	}

	public Vector<String> getVector() {
		Vector<String> data = new Vector<String>();
		data.add(diameter + " cm");
		data.add(volume + " cc");
		data.add(projection + " cm");
		data.add(profile.name());

		return data;
	}
}
