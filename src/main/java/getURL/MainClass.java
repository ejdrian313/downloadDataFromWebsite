package getURL;

import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainClass {

	public static void main(String[] args) {
		try {
			String url = "http://stackoverflow.com/questions/2835505";
			PrintWriter writer = new PrintWriter("website.txt", "UTF-8");
			Document document = Jsoup.connect(url).get();

			String question = document.select("#question .post-text").text();
			System.out.println("Question: " + question);
			writer.println("Question: " + question);
	        Elements answerers = document.select("#answers .user-details a");
			
	        
	        for (Element answerer : answerers) {
	        	System.out.println("Answerer: " + answerer.text());
	            writer.println(answerer.text());
	        }
	        writer.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }

}
