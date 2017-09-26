package beans.daos;

import beans.models.UserProfile;

import java.util.List;

public interface UserProfileDAO {

    UserProfile findById(int id);
    UserProfile findByType (String type);
    List<UserProfile> getAll();
}
