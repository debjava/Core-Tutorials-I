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

	private static final int testItems[][] = {new int[210],
		new int[133],
		new int[7], // good test for within boundaries
		new int[111],
		new int[10], // good test of matching group size.
		new int[20] // good test of divisible
	};
	static {
		for(int i=0;i<testItems.length;i++)
		{
			for(int j=0;j<testItems[i].length;j++){
				testItems[i][j] = (int)Math.ceil(Math.random()*10000);
			}
		}
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception 
	{
		int resultPageSize = 10;
		int pageGroupSize = 10;
		int defaultPageCursorPosition = 3;

		response.setContentType("text/html;charset=UTF-8");

		// add parent total so jsp can list links for them.
		request.setAttribute("parentTotal", testItems.length);

		String sParentIndx = request.getParameter("parentId");
		String sCurrentPage = request.getParameter("itemPg");

		int parentIndex = (sParentIndx != null ? Integer.parseInt(sParentIndx) : 0);
		int currentPage = (sCurrentPage != null ? Integer.parseInt(sCurrentPage) : 0);
		request.setAttribute("parentId", parentIndex);
		request.setAttribute("itemPg", currentPage);

		int targetItems[] = testItems[parentIndex];
		int totalItems = targetItems.length;


		int startIndex = currentPage*resultPageSize;
		request.setAttribute("pageStart", startIndex+1);
		int maxResultIndex = Math.min(totalItems, startIndex + resultPageSize);

		List pageItems = new ArrayList();
		for(int i=currentPage*resultPageSize;i<maxResultIndex;i++)
		{
			pageItems.add(targetItems[i]);
		}
		request.setAttribute("pageItems", pageItems);

		// add totalPages so jsp can determine whether or not
		// to show "previous" link
		int totalPages = totalItems/resultPageSize; // 2 pages = 0 to 1
		if(totalItems % resultPageSize > 0)
		{
			totalPages++;
		}
		request.setAttribute("totalPages", totalPages);

		// add this so jsp can tell when to add "..."
		request.setAttribute("defaultPageCursorPosition", defaultPageCursorPosition);
		List pageList = Pagination.getList(totalItems, currentPage,
				resultPageSize, pageGroupSize, defaultPageCursorPosition);

		request.setAttribute("pageList", pageList);

		return mapping.findForward("success");
	}

}
