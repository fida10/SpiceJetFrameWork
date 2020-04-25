package self.SpiceJet.OnStartUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PropertiesReferencer {
	public static String absPath() throws IOException {
		String absFilePath = new File("").getAbsolutePath().concat("//");
		return absFilePath;
	}
	public static FileInputStream propPath() throws IOException {
		String absFilePath = absPath();
		FileInputStream propertiesFile = new FileInputStream(absFilePath.concat("globalAccesProps.properties"));
		return propertiesFile;
	}
}
