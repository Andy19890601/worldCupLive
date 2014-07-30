package cn.edu.pku.live.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.edu.pku.live.entity.Chat;
import cn.edu.pku.live.util.Page;

/**
 * 
 * @author stanley_hwang
 *
 */
@Repository
public class ChatDao extends AdvancedHibernateDao<Chat>{
	
	public List<Chat> list(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Chat.class);
		criteria.addOrder(Order.desc("id"));
		return hibernateTemplate.findByCriteria(criteria, 0, 30);
	}
	
	public List<Chat> list(Page page){
		DetachedCriteria criteria = DetachedCriteria.forClass(Chat.class);
		return hibernateTemplate.findByCriteria(criteria, page.getIndex() * page.getCount(), page.getSize());
	}
	
}
