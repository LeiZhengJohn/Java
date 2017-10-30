package function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import seqString.SeqString;

public class TextFileEncrytion {
	public SeqString jiaMi(SeqString s,int key) {
		SeqString str = new SeqString();
		int ch;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i) ^ (((int)Math.sqrt(key)) % 126 +1);
			if(ch == 13) {
				ch = ch + 1;
			}
			if(ch == 10) {
				ch =  ch + 1;
			}
			str.concat(new SeqString(String.valueOf((char)ch)));
		}
		return str;
	}
	
	public SeqString jieMi(SeqString s,int key) {
		SeqString str = new SeqString();
		int ch,temp;
		for (int i = 0; i < s.length(); i++) {
			temp = s.charAt(i);
			if(temp == 14) {
				temp = temp - 1;
			}
			if(temp == 11) {
				temp =  temp - 1;
			}
			ch = temp ^ (((int)Math.sqrt(key)) % 126 +1);
			str.concat(new SeqString(String.valueOf((char)ch)));
		}
		return str;
	}
	
	public void encryptFile (String origin,String encryption,int key) throws IOException {
		FileReader fin = new FileReader(origin);
		BufferedReader bin = new BufferedReader(fin);
		FileWriter fout = new FileWriter(encryption);
		SeqString encryptedLine,textLine;
		String aline;
		do {
			aline = bin.readLine();
			if(aline != null) {
				textLine = new SeqString(aline);
				encryptedLine = jiaMi(textLine, key);
				fout.write(encryptedLine.getString()+ "\r\n");
			}
		}while(aline != null);
		bin.close();
		fin.close();
		fout.close();
	}
	
	public void decryptFile (String encryption,String origin,int key) throws IOException {
		FileReader fin = new FileReader(encryption);
		BufferedReader bin = new BufferedReader(fin);
		FileWriter fout = new FileWriter(origin);
		SeqString decryptedLine,textLine;
		String aline;
		do {
			aline = bin.readLine();
			if(aline != null) {
				textLine = new SeqString(aline);
				decryptedLine = jieMi(textLine, key);
				fout.write(decryptedLine.getString()+ "\r\n");
			}
		}while(aline != null);
		bin.close();
		fin.close();
		fout.close();
	}
}
