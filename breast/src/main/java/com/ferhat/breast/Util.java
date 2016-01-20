package com.ferhat.breast;

import java.util.List;
import java.util.Vector;

public class Util {
	public static boolean isEmpty(String text) {
		return text == null || text.equals("");
	}

	public static Vector getColumnNames() {
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("DIAMETER");
		columnNames.add("VOLUME");
		columnNames.add("PROJECTION");
		columnNames.add("PROFILE");

		return columnNames;
	}

	public static Vector getEmptyDataForTable() {
		Vector<String> emptyDatas = new Vector<String>();
		emptyDatas.add("");
		emptyDatas.add("");
		emptyDatas.add("");
		emptyDatas.add("");

		return emptyDatas;
	}

	public static List<ImplantItem> mergeListsUniquely(List<ImplantItem> masters, List<ImplantItem> slaves) {
		for (ImplantItem slave : slaves) {
			if (!masters.contains(slave)) {
				masters.add(slave);
			}
		}
		return masters;
	}
}
