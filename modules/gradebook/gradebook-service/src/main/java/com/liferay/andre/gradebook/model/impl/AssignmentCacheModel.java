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

package com.liferay.andre.gradebook.model.impl;

import com.liferay.andre.gradebook.model.Assignment;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Assignment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AssignmentCacheModel
	implements CacheModel<Assignment>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AssignmentCacheModel)) {
			return false;
		}

		AssignmentCacheModel assignmentCacheModel =
			(AssignmentCacheModel)object;

		if (assignment == assignmentCacheModel.assignment) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, assignment);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{assignment=");
		sb.append(assignment);
		sb.append(", GroupId=");
		sb.append(GroupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Assignment toEntityModel() {
		AssignmentImpl assignmentImpl = new AssignmentImpl();

		assignmentImpl.setAssignment(assignment);
		assignmentImpl.setGroupId(GroupId);
		assignmentImpl.setCompanyId(companyId);
		assignmentImpl.setUserId(userId);

		if (userName == null) {
			assignmentImpl.setUserName("");
		}
		else {
			assignmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			assignmentImpl.setCreateDate(null);
		}
		else {
			assignmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			assignmentImpl.setModifiedDate(null);
		}
		else {
			assignmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			assignmentImpl.setTitle("");
		}
		else {
			assignmentImpl.setTitle(title);
		}

		if (description == null) {
			assignmentImpl.setDescription("");
		}
		else {
			assignmentImpl.setDescription(description);
		}

		if (dueDate == Long.MIN_VALUE) {
			assignmentImpl.setDueDate(null);
		}
		else {
			assignmentImpl.setDueDate(new Date(dueDate));
		}

		assignmentImpl.resetOriginalValues();

		return assignmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		assignment = objectInput.readLong();

		GroupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		dueDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(assignment);

		objectOutput.writeLong(GroupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(dueDate);
	}

	public long assignment;
	public long GroupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long dueDate;

}