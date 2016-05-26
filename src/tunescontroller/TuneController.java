package tunescontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import favMusic.MusicBean;
import favMusic.MusicFileDAO;

@Controller
@SessionAttributes("sesYear")
public class TuneController {

	@Autowired
	private MusicFileDAO musicFileDao;

	@ModelAttribute("sesYear")
	public Integer initYear() {
		return 1959;
	}

	@RequestMapping(path = "favorite.do", method = RequestMethod.GET)
	public ModelAndView getAddFav(@ModelAttribute("sesYear") int y) {
		MusicBean mb = musicFileDao.getAlbum("" + y);
		System.out.println(y);
		musicFileDao.addToFav(y);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("musicResult.jsp");
		mv.addObject("list", musicFileDao.getFavAlbums());
		mv.addObject("sesYear", new Integer(y));
		mv.addObject("albums", musicFileDao.getAlbums());
		mv.addObject("bean", mb);
		return mv;
	}
	
	@RequestMapping(path = "deleteFavorite.do", method = RequestMethod.GET)
	public ModelAndView getDeleteFav(@ModelAttribute("sesYear") int y) {
		MusicBean mb = musicFileDao.getAlbum("" + y);
		System.out.println(y);
		musicFileDao.deleteFav(y);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("musicResult.jsp");
		mv.addObject("albums", musicFileDao.getAlbums());
		mv.addObject("bean", mb);
		mv.addObject("sesYear", new Integer(y));
		return mv;
	}

	@RequestMapping(path = "goToFavorite.do", method = RequestMethod.GET)
	public ModelAndView getFavPage(@ModelAttribute("sesYear") int y) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("favoritesList.jsp");
		mv.addObject("list", musicFileDao.getFavAlbums());
		return mv;
	}

	@RequestMapping(path = "Year.do", method = RequestMethod.GET)
	public ModelAndView getByYear(@RequestParam("year") String y) {
		MusicBean mb = musicFileDao.getAlbum(y);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("musicResult.jsp");
		mv.addObject("albums", musicFileDao.getAlbums());
		mv.addObject("bean", mb);
		mv.addObject("sesYear", new Integer(y));

		return mv;
	}
	@RequestMapping(path = "YearForm.do", method = RequestMethod.GET)
	public ModelAndView getYearForm() {
		ModelAndView mv = new ModelAndView("getYearForm.jsp");
		mv.addObject("albums", musicFileDao.getAlbums());
		return mv;
	}

	@RequestMapping(path = "getYearList.do", method = RequestMethod.POST)
	public ModelAndView getBook(@RequestParam("year") String y) {
		MusicBean mb = musicFileDao.getAlbum("" + y);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("musicResult.jsp");
		mv.addObject("bean", mb);
		mv.addObject("albums", musicFileDao.getAlbums());
		mv.addObject("sesYear", new Integer(y));
		
		return mv;
	}

	@RequestMapping(path = "deletebutton.do", method = RequestMethod.GET)
	public ModelAndView getDelete(@ModelAttribute("sesYear") int y) {
		MusicBean mb = musicFileDao.getAlbum("" + y);
		mb.deleteComment();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("musicResult.jsp");
		mv.addObject("albums", musicFileDao.getAlbums());
		mv.addObject("bean", mb);
		mv.addObject("sesYear", y);
		return mv;
	}


	@RequestMapping(path = "comment.do", method = RequestMethod.GET)
	public ModelAndView getComment(@RequestParam("comment") String co, @ModelAttribute("sesYear") int y) {
		MusicBean mb = musicFileDao.getAlbum("" + y);
		mb.addComment(co);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("musicResult.jsp");
		mv.addObject("albums", musicFileDao.getAlbums());
		mv.addObject("bean", mb);
		mv.addObject("sesYear", y);
		return mv;
	}

	@RequestMapping(path = "button.do", method = RequestMethod.GET)
	public ModelAndView getByNext(@RequestParam("input") String in, @ModelAttribute("sesYear") int y) {

		if (in != null) {
			switch (in) {
			case "Previous":
				if (y > 1959) {
					--y;
				} else {
					y = 2016;
				}
				break;
			case "Next":
				if (y < 2016) {
					++y;
				} else {
					y = 1959;
				}

				break;
			}
		}

		MusicBean mb = musicFileDao.getAlbum("" + y);
		ModelAndView mv = new ModelAndView();
		mv.addObject("albums", musicFileDao.getAlbums());
		mv.setViewName("musicResult.jsp");
		mv.addObject("bean", mb);
		mv.addObject("sesYear", y);
		return mv;
	}
}