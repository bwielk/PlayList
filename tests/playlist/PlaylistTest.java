package playlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlaylistTest {

	private Player player;
	private Song song1;
	private Song song2;
	private Song song3;
	private Song song4;
	private Song song5;
	private Album album1;
	private Album album2;
	
	@Before
	public void before(){
		player = new Player();
		player.createPlaylist("Rock");
		player.createPlaylist("Soul");
		song1 = new Song("The Cranberries", "Animal Instinct", "Bury The Hatchet");
		song2 = new Song("The Cranberries", "Fee Fi Fo", "Bury The Hatchet");
		song3 = new Song("The Cranberries", "Loud and Clear", "Bury The Hatchet");
		song4 = new Song("Amy Winehouse", "Back to Black", "Back to Black");
		song5 = new Song("The Velvet Underground", "All Tomorrow's Parties", "The Velvet Underground");
		album1 = new Album(false, "The Cranberries", "Bury The Hatchet");
		album2 = new Album(true, "Various Artist", "Various Songs");
		album1.addSong(song1);
		album1.addSong(song2);
		album1.addSong(song3);
		album2.addSong(song4);
		album2.addSong(song5);
	}
	
	@Test
	public void playlistIsStoreInPlayer(){
		assertEquals(2, player.getPlaylists().size());
	}
	
	@Test
	public void playerCanGetAPlaylistByItsName(){
		Playlist playlistSoul = player.getPlaylistByName("Soul");
		Playlist playlistRock = player.getPlaylistByName("Rock");
		assertEquals(true, player.getPlaylists().contains(playlistSoul));
		assertEquals(true, player.getPlaylists().contains(playlistRock));
	}
	
	@Test
	public void playerCannotGetAPlaylistByItsNameIfThePlaylistHasntBeenCreatedByPlayer(){
		Playlist playlistDisco = player.getPlaylistByName("Disco");
		Playlist playlistSoul = player.getPlaylistByName("Soul");
		assertEquals(true, player.getPlaylists().contains(playlistSoul));
		assertEquals(false, player.getPlaylists().contains(playlistDisco));
	}
	
	@Test
	public void playerAddsANewSongFromAnExistingAlbumToAPlaylist(){
		assertEquals(true, player.addSongToPlaylist(song1, "Rock"));
		assertEquals(true, player.addSongToPlaylist(song2, "Rock"));
		assertEquals(true, player.addSongToPlaylist(song5, "Rock"));
		assertEquals(3, player.getPlaylistByName("Rock").getSongs().size());
	}
	
	@Test
	public void playerCannotAcceptASongUnlessItExistsInPlayersAlbumSet(){
		Song newSong1 = new Song("Amy Winehouse", "Some Unholy War", "Back To Black");
		Song newSong2 = new Song("Anita Baker", "Sweet Love", "Sweet Love");
		assertEquals(true, player.addSongToPlaylist(song4, "Soul"));
		assertEquals(1, player.getPlaylistByName("Soul").getSongs().size());
		assertEquals(false, player.addSongToPlaylist(newSong2, "Soul"));
		assertEquals(1, player.getPlaylistByName("Soul").getSongs().size());
		assertEquals(false, player.addSongToPlaylist(newSong1, "Soul"));
		assertEquals(1, player.getPlaylistByName("Soul").getSongs().size());
	}
}