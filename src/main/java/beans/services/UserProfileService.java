package beans.services;

import beans.models.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findById(int id);
    UserProfile findByType (String type);
    List<UserProfile> getAll();

}
