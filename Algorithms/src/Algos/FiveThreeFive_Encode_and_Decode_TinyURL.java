package Algos;

import java.util.HashMap;
import java.util.Map;

//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.decode(codec.encode(url));
public class FiveThreeFive_Encode_and_Decode_TinyURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, String> mp = new HashMap<Integer, String>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		mp.put(longUrl.hashCode(), longUrl);
		return ("http://tinyurl.com/" + longUrl.hashCode());
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return (mp.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""))));
	}

}
