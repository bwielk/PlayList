package playlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlbumTest {

	private Album album1;
	private Album album2;
	private Song song1;
	private Song song2;
	private Song song3;
	private Song song4;
	
	@Before
	public void before() {
		album1 = new Album(false, "Amy Winehouse", "Rehab");
		album2 = new Album(true, "Various Artists", "Various Artists");
		song1 = new Song("Amy Winehouse", "Just Friends", "Rehab");
		song2 = new Song("Amy Winehouse", "Rehab", "Rehab");
		song3 = new Song("Cigarettes after sex", "Apocalypse", "Cigarettes after sex");
		song4 = new Song("Cigarettes after sex", "K.", "Cigarettes aftr sex");
	}
	
	@Test
	public void albumStoresSongsFromTheSameAlbumIfItsNotACompilation() {
		assertEquals(true, album1.addSong(song1));
		assertEquals(true, album1.addSong(song2));
		assertEquals(2, album1.getSongs().size());
	}
	
	@Test
	public void albumStoresSongsFromVariousAlbumsIfItsACompilation(){
		assertEquals(true, album2.addSong(song3));
		assertEquals(true, album2.addSong(song4));
		assertEquals(true, album2.addSong(song1));
		assertEquals(3, album2.getSongs().size());
	}
	
	@Test
	public void albumCannotStoreSongsFromVariousAlbumsIfItsACompilation(){
		assertEquals(true, album1.addSong(song1));
		assertEquals(true, album1.addSong(song2));
		assertEquals(false, album1.addSong(song3));
		assertEquals(false, album1.addSong(song4));
		assertEquals(2, album1.getSongs().size());
	}
	
	@Test
	public void albumDoesntStoreTheSameSongTwice(){
		//Album of a specific artist
		assertEquals(true, album1.addSong(song1));
		assertEquals(false, album1.addSong(song1));
		assertEquals(true, album1.addSong(song2));
		assertEquals(2, album1.getSongs().size());
		//Compilation
		assertEquals(true, album2.addSong(song3));
		assertEquals(true, album2.addSong(song1));
		assertEquals(false, album2.addSong(song3));
		assertEquals(2, album2.getSongs().size());
	}
}
