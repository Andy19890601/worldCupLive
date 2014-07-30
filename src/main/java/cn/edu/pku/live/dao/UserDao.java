package cn.edu.pku.live.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.edu.pku.live.entity.User;

/**
 * Data access 
 * 
 * @author stanley_hwang
 *
 */
@Repository
public class UserDao extends AdvancedHibernateDao<User>{
	
	/**
	 * Check if user exists.
	 * @param username
	 * @return
	 */
	public boolean loginCheck(String username){
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		if(username != null && username.length() > 0){
			criteria.add(Restrictions.eq("username", username));
		}
		List<User> list = hibernateTemplate.findByCriteria(criteria);
		if(list.size() > 0)
			return true;
		return false;
	}
	
}
