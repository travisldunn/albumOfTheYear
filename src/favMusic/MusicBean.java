package favMusic;

import java.util.ArrayList;
import java.util.HashSet;

public class MusicBean {
	private String year;
	private String name;
	private String albumName;
	private String albumLink;
	private String tune;
	private String itunesLink;
	private ArrayList<String> commented = new ArrayList<>();
//	private HashSet<Integer> favorite = new HashSet<>();

	public MusicBean(String year, String name, String albumName, String albumLink, String tune, String itunesLink) {
		super();
		this.year = year;
		this.name = name;
		this.albumName = albumName;
		this.albumLink = albumLink;
		this.tune = tune;
		this.itunesLink = itunesLink;
	}


//	public void addFavorite(int y) {
//		favorite.add(y);
//	}
//	public HashSet<Integer> getFavorite() {
//		return favorite;
//	}
//
//
//	public void setFavorite(HashSet<Integer> yearfavorited) {
//		this.favorite = yearfavorited;
//	}


	public void addComment(String com) {
		commented.add(com);
	}
	public void deleteComment() {
		commented.clear();
	}

	public ArrayList<String> getComments() {
		return commented;
	}

	public void setComments(ArrayList<String> commented) {
		this.commented = commented;
	}

	public String getAlbumLink() {
		return albumLink;
	}

	public void setAlbumLink(String albumLink) {
		this.albumLink = albumLink;
	}

	public String getItunesLink() {
		return itunesLink;
	}

	public void setItunesLink(String itunesLink) {
		this.itunesLink = itunesLink;
	}

	public String getTune() {
		return tune;
	}

	public void setTune(String tune) {
		this.tune = tune;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	@Override
	public String toString() {
		return "MusicBean [year=" + year + ", name=" + name + ", albumName=" + albumName + "]";
	}

}
