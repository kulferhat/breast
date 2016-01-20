package com.ferhat.breast;

public enum ImplantProfile {
	LOW("L"), MODERATE("M"), MODERATE_PLUS("MP"), HIGH("H"), ULTRA_HIGH("UH");

	private final String text;

	private ImplantProfile(final String text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text + "\t" + name();
	}

	public static ImplantProfile fromString(String text) {
		if (text != null) {
			for (ImplantProfile ip : ImplantProfile.values()) {
				if (text.equalsIgnoreCase(ip.text)) {
					return ip;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		ImplantProfile ip = ImplantProfile.fromString("M");

		System.out.println(ip);
	}
}
