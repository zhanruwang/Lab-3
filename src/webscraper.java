import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class webscraper {
    public static void main (String [] unused){
        String website = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int count=0;
        for(int i=0; i<website.length(); i++){
            if(website.charAt(i)=='p'&&website.charAt(i+1)=='r'&&website.charAt(i+2)=='i'&&website.charAt(i+3)=='n'&&website.charAt(i+6)!='s'){
                count++;
            }
        }
        System.out.println(count);
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
