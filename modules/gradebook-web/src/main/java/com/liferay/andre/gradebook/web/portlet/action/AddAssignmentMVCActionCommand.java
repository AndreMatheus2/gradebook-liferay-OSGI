package com.liferay.andre.gradebook.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.andre.gradebook.exception.AssignmentValidationException;
import com.liferay.andre.gradebook.model.Assignment;
import com.liferay.andre.gradebook.web.constants.GradebookPortletKeys;
import com.liferay.andre.gradebook.web.constants.MVCCommandNames;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.andre.gradebook.service.AssignmentService;
/**
 * MVC Action Command for adding assignments.
 *
 * @author liferay
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GradebookPortletKeys.GRADEBOOK,
                "mvc.command.name=" + MVCCommandNames.ADD_ASSIGNMENT
        },
        service = MVCActionCommand.class
)
public class AddAssignmentMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Assignment.class.getName(), actionRequest);
// Get parameters from the request.
// Use LocalizationUtil to get a localized parameter.
        Map<Locale, String> titleMap =
                LocalizationUtil.getLocalizationMap(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description", null);
        Date dueDate = ParamUtil.getDate(actionRequest, "dueDate", null);
        try {
// Call the service to add a new assignment.
            _assignmentService.addAssignment(
                    themeDisplay.getScopeGroupId(), titleMap, description, dueDate,
                    sendRedirect(actionRequest, actionResponse));
        }
        catch (AssignmentValidationException ave) {
            ave.printStackTrace();
            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", MVCCommandNames.EDIT_ASSIGNMENT);
        }
        catch (PortalException pe) {pe.printStackTrace();
            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", MVCCommandNames.EDIT_ASSIGNMENT);
        }
    }
    @Reference
    protected AssignmentService _assignmentService;
}