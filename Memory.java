
import java.util.*;
import java.text.DecimalFormat;
import java.io.*;
public class Memory {
	double avg;
	double max;
ArrayList<Double> value=new ArrayList<Double>();	

void convert()
{
	
	int i;
	try {
		FileReader fr=new FileReader("G:\\Memory.txt");
		BufferedReader br=new BufferedReader(fr);
		System.out.println("\"values\":{\n");
		for(i=1;i<=1876;i++)
		{
			if(i%2==0)
			{
				String data = br.readLine().trim();
				String val[] = data.split(" ");

				Double no = Double.parseDouble(val[3].trim());
				double d = no / 1000;
				double a = Math.floor(d * 100) / 100;

				value.add(a);
				if(i!=1876)
				System.out.println("\""+i/2+"s\":"+a+",");
				else
					System.out.println("\""+i/2+"s\":"+a);
			}
			else
				br.readLine();
		}
		
		br.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	System.out.println("},");
}
void calcAvg()
{
	double total = 0;
	for(int i = 0; i < value.size(); i++) 
	{
		total += value.get(i);
	}
	
	
	avg = total / value.size();
	
	DecimalFormat df = new DecimalFormat("#.##");
	avg = Double.parseDouble(df.format(avg));
	System.out.println("\"AverageMemory(MB)\":"+avg+",");
}

void calcMax()
{
	max = value.get(0);
	for(int i = 1; i < value.size(); i++)
	{
		if(value.get(i) > max) 
		{
			max = value.get(i);
		}
	}
	System.out.println("\"MaxMemory(MB)\":"+max+",");
}
}
