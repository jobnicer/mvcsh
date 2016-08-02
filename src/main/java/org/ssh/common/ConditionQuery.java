package org.ssh.common;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import java.util.ArrayList;
import java.util.List;

public class ConditionQuery {


	private List<Criterion> criterions = new ArrayList<Criterion>();

	public void add(Criterion criterion) {
		if(criterion!=null)
		{
			criterions.add(criterion);
		}
	}

	public void build(Criteria criteria) {
		if(criteria!=null){
			for(Criterion criterion : criterions) {
				criteria.add(criterion);
			}
		}
	}

}
