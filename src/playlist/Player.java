package playlist;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Album> albums;
	private ArrayList<Playlist> playlists;
	
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
		if(getPlaylistByName(playlistName) != null){
			Playlist playlist = getPlaylistByName(playlistName);
			playlist.getSongs().add(song);
			return true;
		}
		return false;
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
}