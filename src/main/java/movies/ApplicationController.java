package movies;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.Consumes;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

	@Autowired
	private UserRegisterRepo userRepo;
	
	@Autowired
	private UserRatingRepo ratingRepo;
	
	@Autowired
	private MovieRepo movRepo;
	

	Integer new_user = 1944;
	Integer record_id = 103999;
	
	@RequestMapping(value = "/")
	public String mainPage() {
		return "index";
	}
	
	/*@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(Model model) {
		
		model.addAttribute("user", new User());
		
		return "error";
	}*/
		

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		model.addAttribute("userregister", new UserRegister());

		return "login";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(@ModelAttribute UserRegister userregister, Model model) {

		model.addAttribute("userregister", userregister);
		
		String username = userregister.getEmail();
		String password = userregister.getPassword();

		UserRegister user = userRepo.getUserByEmail(username);	
		
		if(!(user == null)){
			
			if(password.equals(user.getPassword())){
				
				userregister.setRecommendations(user.getRecommendations());
				return "home";
			}else{
				
				return "loginError";
			}
		} 
		
		return "loginError";
	}

	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {

		model.addAttribute("userregister", new UserRegister());

		return "register";
	}

	
	@Consumes({ "application/xml", "application/json", "text/html" })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute UserRegister userregister,
			Model model) {

		model.addAttribute("userregister", userregister);		
				
		userregister.setUserId(new_user++);

		String createDate = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT
				.format(new Date());
		userregister.setCreated_at(createDate);
		
		ArrayList<GetMovie> new_recom = new ArrayList<GetMovie>();
		
		new_recom = getRecomm();
		
		userregister.setRecommendations(new_recom);
		
		insertRatings(userregister.getUserId(), userregister.getRating1(), userregister.getRating2(), userregister.getRating3(), userregister.getRating4(), userregister.getRating5());
		
		userRepo.save(userregister);

		//userRepo.delete(userregister.getUserId());
		return "home";
	}
	
	public int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	public void insertRatings(Integer userId, Integer rating1, Integer rating2, Integer rating3, Integer rating4, Integer rating5){
		
		Integer mId1 = 2001;
		Integer mId2 = 2052;
		Integer mId3 = 2288;
		Integer mId4 = 2096;
		Integer mId5 = 2069;
		
		Ratings r1 = new Ratings();
		r1.setId(record_id++);
		r1.setUserId(userId);
		r1.setMovieId(mId1);
		r1.setRating(rating1);
		ratingRepo.save(r1);
		
		Ratings r2 = new Ratings();
		r2.setId(record_id++);
		r2.setUserId(userId);
		r2.setMovieId(mId2);
		r2.setRating(rating2);
		ratingRepo.save(r2);
		
		Ratings r3 = new Ratings();
		r3.setId(record_id++);
		r3.setUserId(userId);
		r3.setMovieId(mId3);
		r3.setRating(rating3);
		ratingRepo.save(r3);
		
		Ratings r4 = new Ratings();
		r4.setId(record_id++);
		r4.setUserId(userId);
		r4.setMovieId(mId4);
		r4.setRating(rating4);
		ratingRepo.save(r4);
		
		Ratings r5 = new Ratings();
		r5.setId(record_id++);
		r5.setUserId(userId);
		r5.setMovieId(mId5);
		r5.setRating(rating5);
		ratingRepo.save(r5);
		
	}
	
	public ArrayList<GetMovie> getRecomm(){
		
		ArrayList<GetMovie> send = new ArrayList<GetMovie>();
		
		for(int i =0; i < 10; i++) {
			
			Random rand = new Random();
			int r = rand.nextInt((3682 - 2001) + 1) + 2001;
			Movies movie = movRepo.findOne(r);
			GetMovie gm = new GetMovie();
			gm.setMovieName(movie.getMovieName());
			gm.setMovieYear(movie.getMovieYear());
			gm.setUrl(movie.getUrI());
			send.add(gm);
		}
		
		
		return send;
	}
}
