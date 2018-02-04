package playlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest{

	private Player player;
	private Album album1, album2;
	private Song song1, song2, song3, song4;
	@Before
	public void before() {
		player = new Player();
		album1 = new Album(false, "Amy Winehouse", "Rehab");
		album2 = new Album(true, "Various Artists", "Various Artists");
		song1 = new Song("Amy Winehouse", "Just Friends", "Rehab");
		song2 = new Song("Amy Winehouse", "Rehab", "Rehab");
		song3 = new Song("Cigarettes after sex", "Apocalypse", "Cigarettes after sex");
		song4 = new Song("Cigarettes after sex", "K.", "Cigarettes aftr sex");
		album1.addSong(song1);
		album1.addSong(song2);
		album2.addSong(song1);
		album2.addSong(song3);
		album2.addSong(song4);
	}
	
	@Test
	public void playerStoresAlbums() {
		assertEquals(true, player.addAlbum(album1));
		assertEquals(true, player.addAlbum(album2));
		assertEquals(2, player.getAlbums().size());
	}
	
	@Test
	public void cannotAcceptTwoTheSameAlbums(){
		assertEquals(true, player.addAlbum(album1));
		assertEquals(false, player.addAlbum(album1));
		assertEquals(true, player.addAlbum(album2));
		assertEquals(2, player.getAlbums().size());
	}
	
	@Test
	public void playerCanCreatePlaylists(){
		assertEquals(true, player.createPlaylist("Mix"));
	}
	
	@Test
	public void playerStoresMultiplePlaylist(){
		assertEquals(true, player.createPlaylist("Rock"));
		assertEquals(true, player.createPlaylist("My favs"));
		assertEquals(true, player.createPlaylist("Street music"));
		assertEquals(3, player.getPlaylists().size());
	}
	
	@Test
	public void playerCannotAddAPlaylistWithTheSameName(){
		assertEquals(true, player.createPlaylist("Rock"));
		assertEquals(true, player.createPlaylist("My favs"));
		assertEquals(false, player.createPlaylist("Rock"));
		assertEquals(2, player.getPlaylists().size());
	}
}
