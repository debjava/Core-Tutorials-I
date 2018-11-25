package com.dds.page;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class InputAction extends Action 
{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception 
	{
		/*
		 * The following is the total no of records
		 * coming from the database.
		 */
		String totalNoRecords = request.getParameter("inputText");
		System.out.println("totalRecords==========>>>>"+totalNoRecords);
		request.setAttribute("inputText", totalNoRecords);
		/*
		 * The following variable is used to hold the
		 * total no of records. If the total no of records
		 * is 100, there will be 10 pages provided page
		 * size will be 10. 
		 */
		int totalItems = Integer.parseInt( totalNoRecords );
		String sPageSize = request.getParameter("pageSizeText");
		request.setAttribute("pageSizeText", sPageSize);
		System.out.println("sPageSize==========>>>>"+sPageSize);
		String sPageGrpSize = request.getParameter("pageGrpSize");
		request.setAttribute("pageGrpSize", sPageGrpSize);
		
		/*
		 * The following variable is used to
		 * display the total no of items per 
		 * page. If the resultPageSize is 10,
		 * only 10 items will be displayed
		 * perpage.
		 */
		int resultPageSize = Integer.parseInt( sPageSize );//10;
		/*
		 * The following variable is used for displaying the
		 * totol no of numbers where the user can click to
		 * see the results. For example if the group size is
		 * 5, it will display like this
		 * 1,2,3,4,5. If the group size is 10, it will be displayed
		 * like this
		 * 1,2,3,4,5,6,7,8,8,9,10
		 */
		int pageGroupSize = Integer.parseInt( sPageGrpSize );//10;
		/*
		 * The following variable is used to give ... for
		 * long records.
		 */
		int defaultPageCursorPosition = 5;

		// add parent total so jsp can list links for them.
		System.out.println("********************** InputAction : execute ********************");
		System.out.println("********************** InputAction : execute ********************");
		System.out.println("********************** InputAction : execute ********************");
		
		String sCurrentPage = request.getParameter("itemPg");
		
		System.out.println("sCurrentPage or itemPg==========>>>>"+sCurrentPage);
	
		
		int currentPage = (sCurrentPage != null ? Integer.parseInt(sCurrentPage) : 0);
		
		System.out.println("currentPage==========>>>>"+currentPage);
		
		
		request.setAttribute("itemPg", currentPage);
	
		
		System.out.println("totalItems==============>>>"+totalItems);

		int startIndex = currentPage*resultPageSize;
		
		System.out.println("startIndex==============>>>"+startIndex);
		request.setAttribute("pageStart", startIndex+1);
		
		int endIndex = Math.min(totalItems, startIndex + resultPageSize);
		
		System.out.println("maxResultIndex==============>>>"+endIndex);

		List pageItems = new ArrayList();
		
		/*
		 * Adding the data to the List
		 */
		for( int i = startIndex+1 ; i < endIndex+1 ; i++ )
			pageItems.add(i+"===>"+"Test Page");
		
		System.out.println("PageItems============>>>>"+pageItems);
		request.setAttribute("pageItems", pageItems);
		
		int totalPages = totalItems/resultPageSize; // 2 pages = 0 to 1
				
		if(totalItems % resultPageSize > 0)
		{
			totalPages++;
		}
		
		System.out.println("totalPages==============>>>"+totalPages);
		
		request.setAttribute("totalPages", totalPages);

		// add this so jsp can tell when to add "..."
		request.setAttribute("defaultPageCursorPosition", defaultPageCursorPosition);
		List pageList = Pagination.getList(totalItems, currentPage,
				resultPageSize, pageGroupSize, defaultPageCursorPosition);
		
		System.out.println("defaultPageCursorPosition==============>>>"+defaultPageCursorPosition);

		request.setAttribute("pageList", pageList);
		
		System.out.println("pageList==============>>>"+pageList);
		
		System.out.println("********************** InputAction : execute ********************");
		System.out.println("********************** InputAction : execute ********************");
		System.out.println("********************** InputAction : execute ********************");

		return mapping.findForward("success");
	}

}
