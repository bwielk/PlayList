package playlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest{

	private Player player;
	private Album album1, album2;
	private Song song1, song2, song3, song4, song5, song6, song7, song8, song9;
	
	@Before
	public void before() {
		player = new Player();
		album1 = new Album(false, "Amy Winehouse", "Rehab");
		album2 = new Album(true, "Various Artists", "Various Artists");
		song1 = new Song("Amy Winehouse", "Just Friends", "Rehab");
		song2 = new Song("Amy Winehouse", "Rehab", "Rehab");
		song3 = new Song("Cigarettes after sex", "Apocalypse", "Cigarettes after sex");
		song4 = new Song("Cigarettes after sex", "K.", "Cigarettes after sex");
		song5 = new Song("Guns n' Roses", "Sweet Child O' Mine", "Greatest Hits");
		song6 = new Song("The Cranberries", "Zombie", "No Need To Argue");
		song7 = new Song("Coldplay", "Fix You", "X&Y");
		song8 = new Song("The Velvet Underground", "Venus In Fur", "Deluxe");
		song9 = new Song("The Velvet Underground", "I'll Be Your Mirror", "Deluxe");
		album1.addSong(song1);
		album1.addSong(song2);
		album2.addSong(song1);
		album2.addSong(song3);
		album2.addSong(song4);
		album2.addSong(song5);
		album2.addSong(song6);
		album2.addSong(song7);
		album2.addSong(song8);
		album2.addSong(song9);
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
	
	@Test
	public void playerCanFindRecordsFromAddedAlbumsByParameters(){
		assertEquals(true, player.addAlbum(album1));
		assertEquals(true, player.addAlbum(album2));
		assertNotNull(player.findSong("Amy Winehouse", "Just Friends", "Rehab"));
		assertNotNull(player.findSong("Cigarettes after sex", "K.", "Cigarettes after sex"));
	}
	
	@Test
	public void playerCannotFindRecordsIfTheyAreNotFromAddedAlbums(){
		assertEquals(true, player.addAlbum(album1));
		assertEquals(true, player.addAlbum(album2));
		assertNull(player.findSong("Amy Winehouse", "Some Unholy War", "Rehab"));
		assertNotNull(player.findSong("Cigarettes after sex", "K.", "Cigarettes after sex"));
		assertNull(player.findSong("Cigarettes after sex", "Sweet", "Cigarettes after sex"));
	}
	
	private void createRockPlaylist(){
		assertEquals(true, player.addAlbum(album1));
		assertEquals(true, player.addAlbum(album2));
		player.createPlaylist("Rock");
		player.addSongToPlaylist(song3, "Rock");
		player.addSongToPlaylist(song4, "Rock");
		player.addSongToPlaylist(song5, "Rock");
		player.addSongToPlaylist(song6, "Rock");
		player.addSongToPlaylist(song7, "Rock");
		player.addSongToPlaylist(song8, "Rock");
		player.addSongToPlaylist(song9, "Rock");
	}
	
	@Test
	public void playerCanBrowseThroughAPlaylist(){
		createRockPlaylist();
		assertEquals(7, player.getPlaylistByName("Rock").getSongs().size());
		assertEquals("Currently played: Apocalypse by Cigarettes after sex", player.playNextSong("Rock"));
		assertEquals("Currently played: K. by Cigarettes after sex", player.playNextSong("Rock"));
	}
}