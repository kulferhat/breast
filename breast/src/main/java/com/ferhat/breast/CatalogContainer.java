package com.ferhat.breast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogContainer {

	private List<ImplantItem> diameterSortedList = new ArrayList<ImplantItem>();

	private Map<String, ImplantItem> implantsMap = new HashMap<String, ImplantItem>();

	public CatalogContainer(String fileName) throws IOException {
		loadCatalog(fileName);
	}

	public ImplantItem getImplant(ImplantProfile ip, float diameter) {
		return implantsMap.get(ip.name() + "_" + diameter);
	}

	// #DIAMETER;VOLUME;PROJECTION;PROFILE
	public void loadCatalog(String fileName) throws IOException {

		// FileInputStream fstream = new FileInputStream(fileName);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(getClass().getResourceAsStream(fileName));
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console
			// System.out.println(strLine);
			if (strLine.startsWith("#"))
				continue;
			String[] tokens = strLine.split(";");
			ImplantItem implant = new ImplantItem(Float.parseFloat(tokens[0]), Integer.parseInt(tokens[1]), Float.parseFloat(tokens[2]), ImplantProfile.fromString(tokens[3]));
			diameterSortedList.add(implant);
			implantsMap.put(implant.getProfile().name() + "_" + implant.getDiameter(), implant);
			// System.out.println(implant);
		}

		Collections.sort(diameterSortedList, new DiameterComparator());

		for (ImplantItem implant : diameterSortedList) {
			System.out.println(implant);
		}
	}

	class DiameterComparator implements Comparator<ImplantItem> {

		public int compare(ImplantItem o1, ImplantItem o2) {
			if (o1.getDiameter() < o2.getDiameter()) {
				return -1;
			} else if (o1.getDiameter() > o2.getDiameter()) {
				return 1;
			}

			// if diameters equals check volume
			if (o1.getVolume() < o2.getVolume()) {
				return -1;
			} else if (o1.getVolume() > o2.getVolume()) {
				return 1;
			}

			// if diameter and volumes equal, check projection
			if (o1.getProjection() < o2.getProjection()) {
				return -1;
			} else if (o1.getProjection() > o2.getProjection()) {
				return 1;
			}

			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		String fileName = "SmoothRound.txt";
		new CatalogContainer(fileName).loadCatalog(fileName);
	}

	public List<ImplantItem> getAlternativeImplants(ImplantProfile targetImplantProfile, Float diameter) {
		List<ImplantItem> alternatives = new ArrayList<ImplantItem>();
		alternatives = Util.mergeListsUniquely(alternatives, getAlternativesByProfile(targetImplantProfile, diameter));
		//alternatives = Util.mergeListsUniquely(alternatives, getAlternativesByDiameter(targetImplantProfile, diameter));

		return alternatives;
	}

	private List<ImplantItem> getAlternativesByProfile(ImplantProfile targetImplantProfile, Float diameter) {
		ImplantItem min = null;
		ImplantItem max = null;
		for (ImplantItem implantItem : diameterSortedList) {
			if (implantItem.getProfile() == targetImplantProfile) {
				if (implantItem.getDiameter() < diameter) {
					min = implantItem;
				} else if (implantItem.getDiameter() > diameter) {
					max = implantItem;
				}
			}

			if (max != null)
				break;
		}

		List<ImplantItem> alternatives = new ArrayList<ImplantItem>();
		if (min != null)
			alternatives.add(min);
		if (max != null)
			alternatives.add(max);

		return alternatives;
	}

	private List<ImplantItem> getAlternativesByDiameter(ImplantProfile targetImplantProfile, Float diameter) {
		ImplantItem min = null;
		ImplantItem max = null;
		for (ImplantItem implantItem : diameterSortedList) {
			if (implantItem.getDiameter() < diameter) {
				min = implantItem;
			} else if (implantItem.getDiameter() > diameter) {
				max = implantItem;
			}
			if (max != null)
				break;
		}

		List<ImplantItem> alternatives = new ArrayList<ImplantItem>();
		if (min != null)
			alternatives.add(min);
		if (max != null)
			alternatives.add(max);

		return alternatives;
	}

}
