package beans.daos.db;

import beans.daos.AbstractDAO;
import beans.daos.UserProfileDAO;
import beans.models.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userProfileDAO")
public class UserProfileDAOImpl extends AbstractDAO implements UserProfileDAO {


    @Override
    public UserProfile findById(int id) {
        return getCurrentSession().get(UserProfile.class, id);
    }

    @Override
    public UserProfile findByType(String type) {
        Criteria crit = createBlankCriteria(UserProfile.class);
        crit.add(Restrictions.eq("type", type));
        return (UserProfile) crit.uniqueResult();
    }
    @Override
    public List<UserProfile> getAll() {
        Criteria crit = createBlankCriteria(UserProfile.class);
        crit.addOrder(Order.asc("type"));
        return (List<UserProfile>)crit.list();
    }
}
