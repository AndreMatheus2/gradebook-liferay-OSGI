/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.andre.gradebook.service.impl;

import com.liferay.andre.gradebook.service.base.AssignmentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.andre.gradebook.model.Assignment",
	service = AopService.class
)
public class AssignmentLocalServiceImpl extends AssignmentLocalServiceBaseImpl {
	public Assiginment addAssignment(long groupId, String title, String description,
									 Date dueDate, ServicContext servicContext) throws PortalException {

		Grup grup = groupLocalService.getGroup(groupId);
		Long userId = servicContext.getUserId();
		User user = userLocalService.getUser(userId);

		Long assignmentId = counterLocalService.increment(Assignment.class);

		Assignment assignment = createAssignment(assignmentId);

		assignment.setCompanyId(grup.getCompany());
		assignment.setCreateDate(serviceContext.getCreateDate(new Date()));
		assignment.setDueDate(dueDate);
		assignment.setDescription(description);
		assignment.setGroupId(groupId);
		assignment.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		assignment.setTitle(title);
		assignment.setUserId(userId);
		assignment.setUserName(user.getSreenName);

		return super.addAssignment(assignment);
	}

	public Assiginment addAssignment(long assignmentId, String title, String description,
									 Date dueDate, ServicContext servicContext) throws PortalException {

		Assignment assignment = getAssignment(assignmentId());

		assignment.setModifiedDate(new Date());
		assignment.setTitle(title);
		assignment.setDueDate(dueDate);
		assignment.setDescription(description);
		assignment = super.updateAssignment(assignment);
		return assignment;
	}

	public List<Assignment> getAssignmentByGroupId(long groupId){
		return assignmentPersistence.findByGroupId(groupId);
	}
	public List<Assignment> getAssignmentByGroupId(long groupId, int start, int end){
		return assignmentPersistence.findByGroupId(groupId, start, end);
	}
	public List<Assignment> getAssignmentByGroupId(long groupId, int start, int end, OrderByComparator<Assignment> orderByComparator){
		return assignmentPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}

	public List<Assignment> getAssignmentByKeywords(long groupId, String keywords, int start, int end,
												   OrderByComparator<Assignment> orderByComparator){
		return assignmentLocalService.dynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
	}

	public Long getAssignmentCountByKeywords(long groupId, String keywords){
		return assignmentLocalService.dynamicQueryCount(
				getKeywordSearchDynamicQuery(groupId, keywords));
	}
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords){
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		if (Validator.isNot(keywords)){
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}
		return dynamicQuery;
	}
}