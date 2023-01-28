create table Gradebook_Assignment (
	assignment LONG not null primary key,
	GroupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	dueDate DATE null,
	title STRING null
);