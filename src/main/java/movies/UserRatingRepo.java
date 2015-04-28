package movies;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRatingRepo extends MongoRepository<Ratings, Integer>{
	
}
