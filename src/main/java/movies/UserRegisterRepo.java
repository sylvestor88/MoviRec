package movies;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRegisterRepo extends MongoRepository<UserRegister, Integer> {
	
	@Query(value="{ 'email' : ?0}")
    UserRegister getUserByEmail(String email);
	
}
