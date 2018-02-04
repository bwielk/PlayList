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

	public boolean createPlaylist(String name){
		if(!playlistWithTheNameExists(name)){
			playlists.add(new Playlist(name));
			return true;
		}
		return false;
	}
	
	public ArrayList<Playlist> getPlaylists(){
		return playlists;
	}
	
	private boolean playlistWithTheNameExists(String name){
		for(int i=0; i<playlists.size(); i++){
			Playlist currentPlaylist = playlists.get(i);
			if(currentPlaylist.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
}
