// Tokenizer Applicaitons
// Dr. Y. Jing
// 10 December 2007
// The Unversity of Liverpool, UK

import java.io.*;
import java.util.*;

class Tokens{
	static BufferedReader keyboard = new
		BufferedReader(new InputStreamReader(System.in));
public static void main(String[] args) throws IOException{
	StringTokenizer data;

	System.out.println("Enter your sentence.");
	String theSentence = keyboard.readLine();

	data = new StringTokenizer(theSentence);

	System.out.println("No, of words = "+data.countTokens());
	}
}