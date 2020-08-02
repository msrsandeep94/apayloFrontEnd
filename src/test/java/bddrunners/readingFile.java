package bddrunners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class readingFile {

	public static void main(String[] args) {
		try {
			double benchmarkingValue=0.0;
			File folder = new File(System.getProperty("user.dir")+"/src/test/resources/data/entitiesextraction");
			String[] fileNames = folder.list();
			int total = 0;
			for (int i = 0; i< fileNames.length; i++)
			{
				if (fileNames[i].contains(".log"))
				{
					total++;
					File file = new File(folder+"/"+fileNames[i]);
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					StringBuffer stringBuffer = new StringBuffer();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						stringBuffer.append(line);
						if((line.contains("BenchMarking")) && (!line.contains("None")))
						{
							benchmarkingValue=benchmarkingValue+Double.parseDouble(line.substring(line.lastIndexOf(":")).replace(":", "").trim());
						}
						stringBuffer.append("\n");
					}
					fileReader.close();		
				}
			}  
			System.out.println(total);
			System.out.println("Total benchmarking value for "+total+" log files is : "+benchmarkingValue);
			benchmarkingValue=(benchmarkingValue/total);
			System.out.println("Accuracy value for "+total+" logs is : "+benchmarkingValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
