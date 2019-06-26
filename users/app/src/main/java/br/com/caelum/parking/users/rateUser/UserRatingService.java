package br.com.caelum.parking.users.rateUser;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.caelum.parking.users.shared.domain.User;
import br.com.caelum.parking.users.shared.exception.UserNotFoundException;

@Service
class UserRatingService {
	
	private enum Rating {
		client {
			@Override
			User setRating(User user, BigDecimal rating) {
				user.setClientRating(rating);
				return user;
			}
		}, partner {
			@Override
			User setRating(User user, BigDecimal rating) {
				user.setPartnerRating(rating);
				return user;
			}
		};
		
		abstract User setRating(User user, BigDecimal rating);
		
		public static User setUserRating(String ratingType, User user, BigDecimal rating) {
			return Rating.valueOf(ratingType.toLowerCase()).setRating(user, rating);
		}
	}
	
	
	private final UserRatingRepository userRepository;
	
	UserRatingService(UserRatingRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	void updateUserRating(Long id, String ratingType, BigDecimal rating) {
		User user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		
		Rating.setUserRating(ratingType, user, rating);
		
		this.userRepository.save(user);
	}

}
