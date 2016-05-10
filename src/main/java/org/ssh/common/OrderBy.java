package org.ssh.common;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Drunker
 * @version 2.2
 * @date 2012-5-23 обнГ1:35:22
 */
public class OrderBy {

	private List<Order> orders = new ArrayList<Order>();

	public void add(Order order) {
		if(order!=null){
			orders.add(order);
		}
	}

	public void build(Criteria criteria) {
		if(criteria!=null){
			for(Order order : orders) {
				criteria.addOrder(order);
			}
		}
	}
}

