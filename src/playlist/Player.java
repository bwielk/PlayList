package playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Player {
	
	private ArrayList<Album> albums;
	private ArrayList<Playlist> playlists;
	private int currentlyPlayed;
	
	public Player(){
		albums = new ArrayList<Album>();
		playlists = new ArrayList<Playlist>();
	}
	
	public boolean addAlbum(Album album){
		if(!albumAlreadyExists(album)){
			albums.add(album);
			return true;
		}
		return false;
	}
	
	public ArrayList<Album> getAlbums(){
		return albums;
	}
	
	private boolean albumAlreadyExists(Album album){
		for(int i=0; i<albums.size(); i++){
			Album currentAlbum = albums.get(i);
				if(	currentAlbum.getTitle().equals(album.getTitle()) &&
					currentAlbum.getArtist().equals(album.getArtist()) &&
					currentAlbum.getSongs().size() == album.getSongs().size()){
				return true;
			}
		}
		return false;
	}

	public boolean createPlaylist(String playlistName){
		if(getPlaylistByName(playlistName) == null){
			playlists.add(new Playlist(playlistName));
			return true;
		}
		return false;
	}
	
	public ArrayList<Playlist> getPlaylists(){
		return playlists;
	}

	public boolean addSongToPlaylist(Song song, String playlistName){
		Song songToAdd = findSong(song.getArtist(), song.getTitle(), song.getAlbum());
		if(songToAdd != null && getPlaylistByName(playlistName) != null){
			Playlist playlist = getPlaylistByName(playlistName);
			playlist.getSongs().add(songToAdd);
			return true;
		}
		return false;
	}
	
	public Song findSong(String artist, String title, String album){
		for(int i=0; i<albums.size(); i++){
			Album currentAlbum = albums.get(i);
			for(int n=0; n<currentAlbum.getSongs().size(); n++){
				Song currentSong = currentAlbum.getSongs().get(n);
				if(currentSong.getArtist().equals(artist) &&
					currentSong.getTitle().equals(title) &&
					currentSong.getAlbum().equals(album)){
					return currentSong;
				}
			}
		}
		return null;
	}
	
	public Playlist getPlaylistByName(String playlistName) {
		for(int i=0; i<playlists.size(); i++){
			Playlist currentPlaylist = playlists.get(i);
			if(currentPlaylist.getName().equals(playlistName)){
				return currentPlaylist;
			}
		}
		return null;
	}

	public String playNextSong(String playlistName) {
		Playlist currentPlaylist = getPlaylistByName(playlistName);
		if(!currentPlaylist.getSongs().isEmpty() && currentPlaylist != null){
			ListIterator<Song> currentPlaylistIterator = currentPlaylist.getSongs().listIterator();
			if(currentPlaylistIterator.hasNext()){
				Song currentlyPlayed = currentPlaylistIterator.next();
				return "Currently played: " + currentlyPlayed.getTitle() + " by " + currentlyPlayed.getArtist();
			}else{
				return "End of the list";
			}
		}else{
			return "The playlist " + playlistName + " is empty or doesn't exist";
		}
	}
}