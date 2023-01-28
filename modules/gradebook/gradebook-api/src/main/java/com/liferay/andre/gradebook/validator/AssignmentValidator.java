package com.liferay.andre.gradebook.validator;

import com.liferay.andre.gradebook.exception.AssignmentValidationException;
import com.liferay.andre.gradebook.exception.AssignmentValidationException;
import java.util.Date;
public interface AssignmentValidator {
    /**
     * Validates an Assignment
     *
     * @param title
     * @param description
     * @param dueDate
     * @throws AssignmentValidationException
     */
    public void validate(
            String title, String description, Date dueDate)
            throws AssignmentValidationException;
}