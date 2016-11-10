package br.ufc.mapreduce.stubs;

public class StubHelper {

	static int counter = 0;
	static String names[] = {"splitter-task-chunk",
			"mapper-task-chunk",
			"combiner-task-chunk",
			"shuffler-task-chunk",
			"reducer-task-chunk"};
	
	static boolean values[] = {true,false,false,false,false};
	public static boolean is_ready(String name){
		for(int i=0;i<5;i++)
			if(names[i].equals(name)){
				boolean res = values[i];
				values[i] = false;
				return res;
			}
				
		return true;
	}
	
	public static void perform(String name){
		if(name.startsWith("splitter") && counter!=0){
			values[0] = false;
			values[1] = false;
			values[2] = false;
			values[3] = false;
			values[4] = false;
			return;
		}
		
		for(int i=0;i<5;i++)
			if(names[i].equals(name)){
				values[i] = true;
			}
		counter ++;
	}
	
	
}
