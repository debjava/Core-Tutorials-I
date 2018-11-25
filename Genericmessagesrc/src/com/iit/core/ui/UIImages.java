/********************************************************************************************
* Copyright 2006 IDEAL INVENT Technologies Pvt. Ltd.                                        *
* IDEAL INVENT Technologies Pvt. Ltd reserves all rights in the Program as delivered.       *
* The Program or any portion thereof may not be reproduced in any form whatsoever except    *
* as provided by license without the written consent of IDEAL INVENT Technologies Pvt. Ltd. *
*																							*
* File Name                   : UIImages.java                                               *
* Author                      : Koteswara Rao K                                             *
* Creation Date               : 04-May-2007                                                 *
* Description                 : This is a file which contains all the Images used in the    *
*                               Entire Application                                          *
*                               all the methods which are used for User.                    *
* Modification History        :                                                             *
*																						    *
*     Version No.               Date               Brief description of change              *
*  ---------------------------------------------------------------------------------------  *
*                       |                  |											    *
*                       |                  |											    *
*  ---------------------------------------------------------------------------------------  *
*********************************************************************************************/
package com.iit.core.ui;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;

import com.iit.core.util.FileUtil;

public final class UIImages {

	
	/* This Method is used to get the Save Image Icon in all the files */
	public static ImageIcon getSaveImage()
	{
//		String dcicon ="images/SaveandClose.jpg";
		String dcicon = FileUtil.APPLN_HOME+"/"+"images/SaveandClose.jpg";
		
		ImageIcon ic= new ImageIcon(dcicon);
		//Image save_image=ic.getImage();
		return ic;
	}
	public static ImageIcon getClearImage()
	{
		String dcicon =FileUtil.APPLN_HOME+"/"+"images/clear.jpg";
		ImageIcon dc = new ImageIcon(dcicon);
		return dc ;
	}
	public static ImageIcon getSmsImage()
	{
		String dcicon =FileUtil.APPLN_HOME+"/"+"images/mobile.gif";
		ImageIcon dc = new ImageIcon(dcicon);
		return dc ;
	}
	public static ImageIcon getEmailImage()
	{
		String dcicon =FileUtil.APPLN_HOME+"/"+"images/mailto.gif";
		ImageIcon dc = new ImageIcon(dcicon);
		return dc ;
	}
}
