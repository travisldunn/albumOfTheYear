package favMusic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MusicFileDAO {
	private static final String filename = "WEB-INF/Albums.txt";
	private List<Integer> fav = new ArrayList<>();
	private List<MusicBean> albums = new ArrayList<>();

	@Autowired
	private ApplicationContext ac;

	@PostConstruct
	public void init() {
		System.out.println("in init");
		try (InputStream is = ac.getResource(filename).getInputStream();
				BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String year = tokens[0];
				String name = tokens[1];
				String album = tokens[2];
				String albumLink = tokens[3];
				String tune = tokens[4];
				String itunesLink = tokens[5];

				albums.add(new MusicBean(year, name, album, albumLink, tune, itunesLink));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public List<MusicBean> getAlbums() {
		return albums;
	}

	public void setAlbums(List<MusicBean> albums) {
		this.albums = albums;
	}

	public MusicBean getAlbum(String year) {
		for (MusicBean musicBean : albums) {
			if (musicBean.getYear().equals(year)) {
				return musicBean;
			} else {
				System.out.println("not found");
			}
		}
		return null;
	}

	public List<MusicBean> getFavAlbums() {
		List<MusicBean> theBest = new ArrayList<>();
		for (int f : fav) {
			theBest.add(getAlbum("" + f));

		}
		return theBest;
	}

	public List<Integer> getFav() {
		return fav;
	}

	public void setFav(List<Integer> fav) {
		this.fav = fav;
	}

	public void addToFav(int year) {
		boolean isInCollection = false;
		for (int years : fav) {
			if (years == year) {
				isInCollection = true;
			}
		}
		if (!isInCollection) {
			fav.add(year);
		}
	}

	public void deleteFav(int year) {
		boolean notInCollection = true;
		int counter = 0;
		while (notInCollection) {
			if (fav.get(counter) == year) {
				notInCollection = false;
				break;
			} else {
				counter++;
			}
		}
		if (!notInCollection) {
			fav.remove(counter);
		}
	}
}