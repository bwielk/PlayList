package playlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SongTest{

	private Song song1;
	private Song song2;
	
	@Before
	public void before(){
		song1 = new Song("Amy Winehouse", "Back to black", "Rehab");
		song2 = new Song("Amy Winehouse", "Me and Mr Jones",  "Rehab");
	}
	
	@Test
	public void song1HasSpec(){
		assertEquals("Back to black", song1.getTitle());
		assertEquals("Amy Winehouse", song1.getArtist());
		assertEquals("Rehab", song1.getAlbum());
	}
	
	@Test
	public void song2HasSpec(){
		assertEquals("Me and Mr Jones", song2.getTitle());
		assertEquals("Amy Winehouse", song2.getArtist());
		assertEquals("Rehab", song2.getAlbum());
	}

}
