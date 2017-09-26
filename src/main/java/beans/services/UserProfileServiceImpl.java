package beans.services;

import beans.daos.UserProfileDAO;
import beans.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDAO userProfileDAO;

    @Override
    public UserProfile findById(int id) {
        return userProfileDAO.findById(id);
    }

    @Override
    public UserProfile findByType(String type) {
        return userProfileDAO.findByType(type);
    }

    @Override
    public List<UserProfile> getAll() {
        return userProfileDAO.getAll();
    }
}
