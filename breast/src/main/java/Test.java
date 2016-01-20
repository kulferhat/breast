import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws IOException {

		StringBuffer readSb = new StringBuffer("#DIAMETER;VOLUME;PROJECTION;PROFILE\r\n");

		readSb.append(read("E:\\implants\\SiltexRoundModerateProfile.txt", "M"));
		readSb.append(read("E:\\implants\\SiltexRoundModeratePlusProfile.txt", "MP"));
		readSb.append(read("E:\\implants\\SiltexRoundHighProfile.txt", "H"));
		readSb.append(read("E:\\implants\\SiltexRoundUltraHighProfile.txt", "UH"));

		write(readSb.toString(), "E:\\implants\\SiltexRound.txt");
	}

	private static void write(String str, String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(str);
			out.close();
		} catch (IOException e) {
			System.out.println("Exception ");

		}
	}

	private static String read(String fileName, String profileName) throws FileNotFoundException, IOException {
		FileInputStream fstream = new FileInputStream(fileName);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		// Read File Line By Line
		StringBuffer readSb = new StringBuffer();
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console
			// System.out.println(strLine);
			String[] tokens = strLine.split(" ");
			for (int i = 0; i < tokens.length; i++) {
				// System.out.println(i + "\t" + tokens[i]);
			}

			readSb.append(tokens[2] + ";" + tokens[0] + ";" + tokens[4] + ";" + profileName + "\r\n");
		}
		// Close the input stream
		in.close();
		return readSb.toString();
	}
}
