/*
 * Flow: As discussed the URL will be stored in the database with corresponding to an auto incremented id.
 * Then this program will take that id as an input and make a alphanumeric url from that id.
 * Input : Id from the database
 * Output: A short url 
 * */

public class UrlShortener {

	//this function uses the character and give a short url
	private String idToShortURL(int n)
	{
	    String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	 
	    StringBuffer shorturl = new StringBuffer();
	    while (n>0)
	    {
	        shorturl.append(str.charAt(n%62));
	        n = n/62;
	    }
	 
	    shorturl.reverse();
	    return shorturl.toString();
	}
	
	// Function to get integer ID back from a short url 
	int shortURLtoID(String shortURL)
	{
	    int id = 0; 
	    for (int i=0; i < shortURL.length(); i++)
	    {
	        if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
	          id = id*62 + shortURL.charAt(i) - 'a';
	        if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
	          id = id*62 + shortURL.charAt(i) - 'A' + 26;
	        if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
	          id = id*62 + shortURL.charAt(i) - '0' + 52;
	    }
	    return id;
	}
	
	public static void main(String[] args) {
		int n = 12345; //id from the database
		UrlShortener shortener = new UrlShortener();
	    String shorturl = shortener.idToShortURL(n);
	    System.out.println("Short url :  " + shorturl);
	    System.out.println("URL id in the database " + shortener.shortURLtoID(shorturl));
	}

}
