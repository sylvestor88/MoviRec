package movies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.mongodb.MongoDBDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class Recommender {

	private Integer userId;

	public ArrayList<Integer> getRecommendation(Integer uId) {

		ArrayList<Integer> some = new ArrayList<Integer>();

		try {

			MongoDBDataModel dm = new MongoDBDataModel("ds034348.mongolab.com", 34348, "movierec", "rating", false, false, null, "sylvestor88", "silvy0488", "userId", "movieId", "rating", null);

			UserSimilarity similarity = new PearsonCorrelationSimilarity(dm);

			UserNeighborhood neighborhood = new NearestNUserNeighborhood(20,
					similarity, dm);

			UserBasedRecommender recommender = new GenericUserBasedRecommender(
					dm, neighborhood, similarity);

			List<RecommendedItem> recommendations = recommender
					.recommend(uId, 10);

			for (RecommendedItem recommendation : recommendations) {

				//System.out.println(recommendation.getItemID());
				some.add((int) recommendation.getItemID());

			}

		} catch (IOException e) {

			// TODO Auto-generated catch block
			System.out.println("There was an error.");
			e.printStackTrace();

		} catch (TasteException e) {

			// TODO Auto-generated catch block
			System.out.println("There was a taste error.");
			e.printStackTrace();

		}

		return some;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
