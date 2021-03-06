package beans.conventers;

import beans.models.UserProfile;
import beans.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {
	
	@Autowired
	@Qualifier("userProfileService")
	UserProfileService userProfileService;

	/**
	 * Gets UserProfile by Id
	 * @see Converter#convert(Object)
	 */
	public UserProfile convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		UserProfile profile = userProfileService.findById(id);
		System.out.println("Profile: " + profile);
		return profile;
	}
	
}