package com.dds.page;

import java.util.ArrayList;
import java.util.List;

public class Pagination 
{
	public static List<Integer> getList(int totalItems,
			int currentPage,
			int resultPageSize,
			int pageGroupSize,
			int defaultCursorPosition)
	{
		List<Integer> pageList = new ArrayList<Integer>();

//		first obtain the first item index of the absolute last page of
//		all known records.
		int finalPageItemStartIndex = (totalItems - totalItems % resultPageSize);
		if(totalItems % resultPageSize == 0)
		{
			finalPageItemStartIndex-=resultPageSize;
		}

//		Now obtain the final page index
		int finalPage = 0;
		if(finalPageItemStartIndex > 0)
		{
			finalPage = 1+(int)Math.ceil((double)finalPageItemStartIndex/resultPageSize);
		}
		int offset = pageGroupSize;
		if(currentPage > defaultCursorPosition)
		{
			offset -= defaultCursorPosition;
		}
		else
		{
			offset -= (int)Math.min(pageGroupSize, currentPage);
		}
		int endPage = Math.min(finalPage, currentPage + offset);
		int startPage = 0;
		if(currentPage > defaultCursorPosition && finalPage >= endPage)
		{
			startPage = Math.max(1,endPage - pageGroupSize + 1);
			pageList.add(0);
		}
		for(int i=startPage;i<endPage;i++)
		{
			pageList.add(i);
		}
		return pageList;
	}

}
