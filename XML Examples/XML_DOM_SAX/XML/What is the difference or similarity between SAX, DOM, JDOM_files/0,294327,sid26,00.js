 //- searchWebServices Javascript File -

	if(26 == 96 || 26 == 97 || 26 == 98 || 26 == 99 || 26 == 100) var CHANNELHEADER = "on"; else CHANNELHEADER = "off";
var SID = 26;
	function HEADER_CHANNEL() {
		sid96size = (SID == 96) ? '_big' : '';
		sid97size = (SID == 97) ? '_big' : '';
		sid98size = (SID == 98) ? '_big' : '';
		sid99size = (SID == 99) ? '_big' : '';
		sid100size = (SID == 100) ? '_big' : '';
		if (ISFIXEDWIDTH) document.write(OPEN_FIXED_WIDTH_TABLE());
		if (PORTFOLIOBAND == "on" && JSdigitalGuideID != 63) document.write(PORTFOLIO_BAND());
		if (LEADERBOARD == "on") document.write(LEADER_BOARD());
		document.write('<table border="0" cellspacing="0" cellpadding="0" width="100%">');
		document.write('<tr class="colorHeader">');
		document.write('<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="39" alt=""></td>');
		document.write('<td width="100%" valign="top"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="6" alt=""><br>');
		document.write('<a href="http://searchWebServices.techtarget.com/home/0,289692,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/header_logo.gif" border="0" alt=""></a></td>');
		document.write('<td rowspan="2" align="right" valign="top"><img src="http://media.techtarget.com/searchWebServices/images/header_background.gif" width="297" height="68" alt="" border="0"></td>');
		document.write('</tr>');
		document.write('<tr class="colorHeader">');
		document.write('<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="20" border="0" alt=""></td>');
		document.write('<td valign="top"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="51" height="1" alt=""><a href="http://www.techtarget.com"><img src="http://media.techtarget.com/searchWebServices/images/header_tagline.gif" alt="Part of the IT Channel TechTarget Sites" border="0"></a></td>');
		document.write('</tr>');
		document.write('</table>');
		document.write('<!-- END: logo and variable links -->');
		
		HEADER_CHANNEL_TABS();

		if (HEADERNAV == "on") document.write(PAGE_NAVIGATION());
		if (HEADERSEARCH == "on" && JSdigitalGuideID != 9 && JSdigitalGuideID != 63) document.write(HEADER_SEARCH());
		if (!ISHOME && SPONSORBANNER == "on") document.write(SPONSOR_BANNER());

	};


	function HEADER_CHANNEL_TABS() {
		document.write('<!-- BEGIN: tabs -->');
		document.write('<table border="0" cellspacing="0" cellpadding="0" width="100%">');
		document.write('<tr class="colorF">');
		document.write('<td background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><img src="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif" width="8" height="22" alt=""></td>');
		document.write('<td background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><a href="http://searchitchannel.techtarget.com/"><img src="http://media.techtarget.com/searchWebServices/images/tab_it_channel' + sid96size + '.gif" alt="IT Channel" border="0"></a></td>');
		document.write('<td align="center" background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><img src="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif" alt=""></td>');
		document.write('<td background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><a href="http://searchnetworkingchannel.techtarget.com/"><img src="http://media.techtarget.com/searchWebServices/images/tab_networking_channel' + sid100size + '.gif" alt="Networking Channel" border="0"></a></td>');
		document.write('<td align="center" background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><img src="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif" alt=""></td>');
		document.write('<td background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><a href="http://searchsecuritychannel.techtarget.com/"><img src="http://media.techtarget.com/searchWebServices/images/tab_security_channel' + sid97size + '.gif" alt="Security Channel" border="0"></a></td>');
		document.write('<td align="center" background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><img src="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif" alt=""></td>');
		document.write('<td background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><a href="http://searchstoragechannel.techtarget.com/"><img src="http://media.techtarget.com/searchWebServices/images/tab_storage_channel' + sid98size + '.gif" alt="Storage Channel" border="0"></a></td>');
		document.write('<td align="center" background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><img src="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif" alt=""></td>');
		document.write('<td background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><a href="http://searchsystemschannel.techtarget.com/"><img src="http://media.techtarget.com/searchWebServices/images/tab_systems_channel' + sid99size + '.gif" alt="Systems Channel" border="0"></a></td>');
		document.write('<td align="center" background="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif"><img src="http://media.techtarget.com/searchWebServices/images/header_gradient_separator.gif" alt=""></td>');
		document.write('</tr>');
		document.write('</table>');
		document.write('<!-- END: tabs -->');
	}


	function FOOTER_CHANNEL_TABS() {
		document.write('<table border="0" cellspacing="0" cellpadding="0" width="100%">');
		document.write('<tr class="colorHeader">');
		document.write('<td colspan="3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3" alt=""></td>');
		document.write('</tr>');
		document.write('</table>');
		HEADER_CHANNEL_TABS();
	}


 	function HEADER_DISPLAY_CODE_0() {
		if((navigator.appName == "Netscape" && parseInt(navigator.appVersion) < 5) || WEBREPORTING == "off") {
			//do nothing
		} else document.write(WEB_REPORTING());
		if (memberUpdate == "on" && memUpd != -1 && memberUpdateOverride == -1) document.write(MEMBER_UPDATE());
		if(CHANNELHEADER == "on")
			HEADER_CHANNEL();
		else {
			if (ISFIXEDWIDTH) document.write(OPEN_FIXED_WIDTH_TABLE());
			if (PORTFOLIOBAND == "on" && JSdigitalGuideID != 63) document.write(PORTFOLIO_BAND());
			if (LOGO == "on" || BYLINE == "on" || HEADERMEDIALINKS == "on") document.write(HEADER_CORE());
			if (LEADERBOARD == "on") document.write(LEADER_BOARD());
			if (HEADERNAV == "on") document.write(PAGE_NAVIGATION());
	
			if (HEADERSEARCH == "on" && JSdigitalGuideID != 9 && JSdigitalGuideID != 63) document.write(HEADER_SEARCH());
			else if (HEADERNAV == "on") document.write('<table border="0" cellspacing="0" cellpadding="0" width="100%">'+
			'<tr class="color0"><td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3" alt=""></td></tr>'+
			'</table>');
			if (!ISHOME && SPONSORBANNER == "on") document.write(SPONSOR_BANNER());
			//Exception code for whatis pages | spacing needs to follow the old format.
			var bIsDice = (window.location.href.indexOf("/dice/") != -1 || window.location.href.indexOf("/diceHeader/") != -1);
			if (JSdigitalGuideID == 9 && !bIsDice && (HEADERNAV == "on" || LEADERBOARD == "on" || SPONSORBANNER == "on"))
			document.write('<table border="0" cellpadding="0" cellspacing="0">'+
			'<tr>'+
			'<td width="100%"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="15" alt=""></td>'+
			'</tr>'+
			'</table>');
		}
	}


	function OPEN_FIXED_WIDTH_TABLE_DISPLAY_CODE_0() {
		return '<table width="776" cellpadding="0" cellspacing="0" border="0"><tr><td width="100%" bgcolor="#FFFFFF" background="">';
	}


	function PORTFOLIO_BAND_DISPLAY_CODE_0() {
		if (CHANNELHEADER == "on") {
			var portStyle = 'colorHeader'
			var textStyle = 'textF'
			var lineStyle = 'colorPortfolioBand'
		} else {
			var portStyle = 'colorPortfolioBand'
			var textStyle = 'textOnColorPortfolioBand'
			var lineStyle = 'color1'
		}
		if (ipcON == "onREMOVEWHENRELEASED") {
			var handle = getChipValue('IPC','handle'), newMsgs = getChipValue('IPC','newMsgs'),
			ipcInboxURL = "http://searchWebServices.techtarget.com/ITKnowledgeExchange/inbox/0,,sid26_ipu"+
			getChipValue("IPC","userID")+"_idx1_off25,00.html",
			pfoBand = new Array('<table border="0" cellpadding="0" cellspacing="0" class="'+portStyle+'" width="100%">',
			'<tr class="'+portStyle+'">',
			'<td colspan="10"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3"></td>',
			'</tr>',
			'<tr class="'+portStyle+'">',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="15"></td>',
			'<td nowrap><span class="a2"><span class="textC">'+(
				// USERNAME - HANDLE DISPLAY
				(ttUser == -1) ? 'Welcome <b>Guest</b>' :
				(thisSite == -1) ? 'Welcome <b>TechTarget Member</b>' :
				(handle != '') ? 'Logged in as: <b>'+handle+'</b>' :
				'Logged in as: <b>'+DisplayName+'</b>'
			)+'</span></span></td>',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="15" height="1"></td>',
			'<td><img src="http://media.techtarget.com/digitalguide/images/Misc/envelope_small.gif" border="0"></a><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" height="1" width="3"></td>',
			'<td nowrap><span class="a2"><span class="textC">'+(
				// IPC MESSAGE COUNT
				(handle == '') ? 'You have <a href="http://searchWebServices.techtarget.com/ITKnowledgeExchange/0,294907,sid26,00.html" class="textC"><span class="a2">'+
				'<b>1 New</b> ITKnowledge Exchange Message</span></a>' :
				(newMsgs > 0) ? 'You have <a href="'+ipcInboxURL+'" class="textC"><span class="a2">'+
				'<b>'+newMsgs+' New</b> ITKnowledge Exchange Messages</span></a>' :
				'TKnowledge Exchange Messages'
			)+'</span></span></td>',
			'<td width="100%"><span class="a2">&nbsp;</span></td>',
			'<td nowrap><span class="a2">'+(
				// FREE-ACCESS / EXPLORE NETWORK LINK
				(ttUser == -1) ? '<span class="textC">FREE access to member only site features - </span>' :
				(thisSite == -1) ? '&nbsp;' :
				'<span class="textC">Explore the <a href="http://searchtechtarget.techtarget.com" class="textC">'+
				'<span class="a2">TechTarget Network</span></a></span>'
			)+'</span></td>',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" height="1" width="10"></td>',
			'<td nowrap><a href="http://searchWebServices.techtarget.com/register/1,289568,sid26,00.html" class="'+textStyle+'"><span class="a2">'+(
				// LOGIN-OUT / EDIT PROFILE LINKS
				(ttUser == -1) ? '<b>Register Now</b></span></a>&nbsp;&nbsp;<font class="textF">|</font>&nbsp;&nbsp;<a href="'+
				((ALTLOGIN != "no") ? ALTLOGIN : 'http://searchWebServices.techtarget.com/login/1,289498,sid26,00.html')+'" class="'+textStyle+'"><span class="a2"><b>Log-in</b>' :
				(thisSite == -1) ? '<b>Add this site to your TechTarget Member Profile</b>' :
				'<b>Edit Profile</b></span></a>&nbsp;&nbsp;<font class="textF">|</font>&nbsp;&nbsp;<a href="'+
				((ALTLOGOUT != "no") ? ALTLOGOUT : 'http://searchWebServices.techtarget.com/logout/1,289500,sid26,00.html')+'" class="'+textStyle+'"><span class="a2"><b>Log-out</b>'
			)+'</span></a></td>',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
			'</tr>',
			'<tr class="'+portStyle+'">',
			'<td colspan="10"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3"></td>',
			'</tr>',
			'</table>');
		} else {
			var pfoBand = new Array('<table border="0" cellpadding="0" cellspacing="0" class="'+portStyle+'" width="100%">',
			'<tr class="'+portStyle+'"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3"></td></tr>',
			'<tr class="'+portStyle+'">',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="15"></td>',
			'<td width="100%"><span class="a2"><span class="'+textStyle+'"><b>Explore the TechTarget Network at </b>'+
			'<a href="http://searchtechtarget.techtarget.com/" class="'+textStyle+'"><span class="a2">SearchTechTarget.com</span></a>.</span>'+
			'</span></td>',
			'<td nowrap align="right" class="a2">'+((USERINFO == "on") ? '<span class="'+textStyle+'">'+((loggedIn != -1) ? '<i>You\'re logged in as:</i> <b>'+DisplayName+'</b>&nbsp;'+
			'<a href="http://searchWebServices.techtarget.com/register/1,289568,sid26,00.html" class="'+textStyle+'"><span class="a2">Edit your Profile</span></a>&nbsp;<span class="yellow">|</span>&nbsp;'+
			'<a href="'+((ALTLOGOUT != "no") ? ALTLOGOUT : 'http://searchWebServices.techtarget.com/logout/1,289500,sid26,00.html')+'" class="'+textStyle+'"><span class="a2">Log-out</span></a>' :
			'<a href="http://searchWebServices.techtarget.com/register/1,289568,sid26,00.html" class="'+textStyle+'"><span class="a2">Activate your FREE membership today</span></a>&nbsp;<span class="yellow">|</span>&nbsp;'+
			'<a href="'+((ALTLOGIN != "no") ? ALTLOGIN : 'http://searchWebServices.techtarget.com/login/1,289498,sid26,00.html')+'" class="'+textStyle+'"><span class="a2">Log-in</span></a>')+'</span>' : '&nbsp;')+
			'</td>',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
			'</tr>',
			'<tr class="'+portStyle+'"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3"></td></tr>',
			'<tr class="'+lineStyle+'"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td></tr>',
			'<tr class="'+portStyle+'"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td></tr>',
			'</table>');
		}
		return pfoBand.join("");
	}
	
	
	function MEDIA_LINKS_DISPLAY_CODE_0() {
		var hasImage = 0;
		if (hasImage) {
			var mediaCode = "WC",
			links = new Array('<map name="headermap">'),
			popupWinName = "mediaPopup",
			popupWinProp = "width=388,height=388,menubar=no,resizable=no,status=no,titlebar=no,scrollbars=no";
			switch (mediaCode) {
				case "MCW": links.push(
					'<area shape="rect" coords="81,36 142,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab1,00.html" alt="Magazine"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">',
					'<area shape="rect" coords="150,36 229,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab2,00.html" alt="Conferences"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">',
					'<area shape="rect" coords="237,36 296,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab3,00.html" alt="Web Sites"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">');
					break;
				case "MW": links.push(
					'<area shape="rect" coords="124,36 185,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab1,00.html" alt="Magazine"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">',
					'<area shape="rect" coords="193,36 252,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab3,00.html" alt="Web Sites"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">');
					break;
				case "CW": links.push(
					'<area shape="rect" coords="115,36 194,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab2,00.html" alt="Conferences"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">',
					'<area shape="rect" coords="202,36 261,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab3,00.html" alt="Web Sites"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">');
					break;
				case "W": links.push(
					'<area shape="rect" coords="159,36 218,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab1,00.html" alt="Web Sites"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">');
					break;
			} links.push('<area shape="default" nohref alt="">',
			'</map>',
			'<img src="http://media.techtarget.com/searchWebServices/images/header_mediaLinks_WC.gif" width="300" height="59" ismap usemap="#headermap" alt="TechTarget Application Development Media" border="0">');
			return links;
		} else return new Array('<img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="290" height="6" alt="" border="0">');
	}



	function LEADER_BOARD_DISPLAY_CODE_0() {
		var board = new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%">',
		'<tr class="colorC">');
		if (!ISFIXEDWIDTH) board.push('<td width="50%" rowspan="99"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>');
		board.push('<td colspan="7"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="10" alt=""></td>',
		'<td width="100%" rowspan="99"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>',
		'</tr>','<tr class="colorF">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="19" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="728" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="19" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'</tr>','<tr>',
		'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td align="center" valign="top" background="http://media.techtarget.com/digitalguide/images/Misc/background_ad_side_728_90.gif">'+
		'<img src="http://media.techtarget.com/digitalguide/images/Misc/ad_sideHeader_728_90.gif" width="19" height="90" border="0" alt=""></td>',
		'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td>'+PAGE_AD(12)+'</td>',
		
		'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td align="center" valign="top" background="http://media.techtarget.com/digitalguide/images/Misc/background_ad_side_728_90.gif">'+
		'<img name="toggle728x90" src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="19" height="90" border="0" alt=""></td>',
		'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'</tr>','<tr class="colorF">',
		'<td colspan="7"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'</tr>','<tr class="colorC">',
		'<td colspan="7"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="10" alt=""></td>',
		'</tr>',
		'</table>',
		'<table border="0" cellspacing="0" cellpadding="0" width="100%">',
		'<tr class="color0">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3" alt=""></td>',
		'</tr>',
		'</table>');
		//window.alert(board);
		return board.join("");
	}	

	function HEADER_SEARCH_CHANNEL() {
		return new Array('<table border="0" cellspacing="0" cellpadding="0" width="100%">',
		'<tr bgcolor="#BDBDBD">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'</tr>',
		'</table>',
		'<table border="0" cellspacing="0" cellpadding="0" width="100%">',
		'<form action="http://searchWebServices.techtarget.com/search/1,293876,sid26,00.html">',
		'<tr class="colorEF">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="7" height="25" alt=""></td>',
		'<td nowrap class="a2"><span class="text6"><b>SEARCH this site and the web</b></span></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="9" height="1" alt=""></td>',
		'<td><input type="text" name="query" size="8" class="i3width125"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="7" height="1" alt=""></td>',
		'<td><input type="image" src="http://media.techtarget.com/digitalguide/images/Misc/button_search_cccccc.gif"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="9" height="1" alt=""></td>',
		'<td nowrap><a href="http://searchWebServices.techtarget.com/integratedSearchAdvanced/0,289518,sid26,00.html" class="text6"><span class="a1">ADVANCED SEARCH</span></a>&nbsp;&nbsp;',
		'<span class="textF"><span class="a2">|</span></span>&nbsp;&nbsp;',
		'<a href="http://searchWebServices.techtarget.com/siteMap/0,294352,sid26,00.html" class="text6"><span class="a1">SITE MAP</span></a></td>',
		'<td width="100%"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td><a href="http://www.google.com"><img src="http://media.techtarget.com/digitalguide/images/Misc/searchPoweredByGoogle_onGray.gif" width="151" height="23" alt="Search Powered by Google" border="0"></a></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="3" height="1" alt=""></td>',
		'<td>',
		'</tr>',
		'</form>',
		'</table>',
		'<table border="0" cellspacing="0" cellpadding="0" width="100%">',
		'<tr bgcolor="#BDBDBD">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'</tr>',
		'</table>').join("");
	}

	function HEADER_SEARCH_DISPLAY_CODE_0() {
		if(CHANNELHEADER == "on") return HEADER_SEARCH_CHANNEL();
		else return new Array('<table border="0" cellspacing="0" cellpadding="0" width="100%">',
		'<form name="search" action="http://searchWebServices.techtarget.com/search/1,293876,sid26,00.html" method="get">',
		'<tr class="color0">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="7" height="25" alt=""></td>',
		'<td nowrap class="a2"><span class="textF"><b>SEARCH this site and the web</b></span></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="9" height="1" alt=""></td>',
		'<td><input type="text" name="query" size="8" class="i3width125"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="7" height="1" alt=""></td>',
		'<td><input type="image" src="http://media.techtarget.com/digitalguide/images/Misc/button_search_cccccc.gif"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="9" height="1" alt=""></td>',
		'<td nowrap><a href="http://searchWebServices.techtarget.com/integratedSearchAdvanced/0,289518,sid26,00.html" class="textF"><span class="a1">ADVANCED SEARCH</span></a>&nbsp;&nbsp;',
		'<span class="textF"><span class="a2">|</span></span>&nbsp;&nbsp;',
		'<a href="http://searchWebServices.techtarget.com/siteMap/0,294352,sid26,00.html" class="textF"><span class="a1">SITE MAP</span></a></td>',
		'<td width="100%"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td><a href="http://www.google.com"><img src="http://media.techtarget.com/digitalguide/images/Misc/searchPoweredByGoogle_onBlack.gif" width="147" height="23" alt="Search Powered by Google" border="0"></a></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="3" height="1" alt=""></td>',
		'</tr>',
		'</form>',
		'</table>').join("");
	}
	
	function HEADER_SEARCH_CLICKTHRU_DISPLAY_CODE_0() {
		return new Array(
		'<table border="0" cellspacing="0" cellpadding="0" width="100%">',
		'<form name="search" action="http://searchWebServices.techtarget.com/search/1,293876,sid26,00.html" method="get">',
		'<tr class="color0">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="25" alt=""></td>',
		'<td nowrap class="a2"><span class="textF"><b>SEARCH</b></span></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="7" height="1" alt=""></td>',
		'<td><input type="text" name="query" size="8" class="i3width125"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="1" alt=""></td>',
		'<td><input type="image" src="http://media.techtarget.com/digitalguide/images/Misc/button_search_cccccc.gif"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="7" height="1" alt=""></td>',
		'</form>',
		'<td nowrap><a href="http://searchWebServices.techtarget.com/integratedSearchAdvanced/0,289518,sid26,00.html" class="textF"><span class="a1">ADVANCED SEARCH</span></a>',		'&nbsp;&nbsp;<span class="textF"><span class="a2">|</span></span>&nbsp;&nbsp;<a href="http://searchWebServices.techtarget.com/siteMap/0,294352,sid26,00.html" class="textF"><span class="a1">SITE MAP</span></a></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td><a href="http://www.google.com"><img src="http://media.techtarget.com/digitalguide/images/Misc/searchPoweredByGoogle_onBlack.gif" width="147" height="23" alt="Search Powered by Google" border="0"></a></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/digitalguide/images/Misc/homepageHeader_background_onBlack.gif"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1" alt=""></td>',
		'<td nowrap class="a2"><span class="textF"><b><a href="http://searchWebServices.techtarget.com/clickThruAbout/0,296381,sid26,00.html"><img src="http://media.techtarget.com/digitalguide/images/Misc/clickthru_logo.gif" border="0"></a></b></span></td>',
		'<form name="clickThruFormHeader" method="get" onSubmit="clickThruValidate(clickThruFormHeader)">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="3" height="1" alt=""></td>',
		'<td><input type="text" name="clickThruID" size="8" class="i3width50"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1" alt=""></td>',
		'<td><input type="image" src="http://media.techtarget.com/digitalguide/images/Misc/button_go_cccccc.gif" action="submit"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="7" height="1" alt=""></td>',
		'</form>',
		'<td>',
		'</tr>',
		'</table>').join("");
	}


	function SPONSOR_BANNER_DISPLAY_CODE_0() {
		return new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%">',
		'<tr><td colspan="3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="15"></td></tr>',
		'<tr>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
		'<td width="100%" class="color4">',
		'<table border="0" cellpadding="0" cellspacing="1" width="100%">',
		'<tr bgcolor="#FFFFFF">',
		'<td><img src="http://media.techtarget.com/digitalguide/images/Misc/platinum_site_sponsor.gif" width="77" height="33"></td>',
		'<td width="100%">'+PAGE_AD(9)+'</td>','</tr>','</table>',
		'</td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
		'</tr>',
		'</table>').join("");
	}



	function PAGE_NAVIGATION() {
		var navClass = 'colorNav'
		var nav = new Array('<div class="color1">',
		'<table border="0" cellspacing="0" cellpadding="0">',
		'<tr class="' + 'colorNav' + '">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>'), links = new Array();
		
		
		
		  if (!ISHOME) links.push('<td><a href="http://searchWebServices.techtarget.com/home/0,289692,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_home.gif" width="30" height="22" alt="Home" border="0"></a></td>');
		  links.push('<td><a href="http://searchWebServices.techtarget.com/news/0,289141,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_news.gif" width="30" height="22" border="0" alt="News"></a></td>');
		   links.push('<td><a href="http://searchWebServices.techtarget.com/topicsMain/0,295490,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_topics.gif" width="37" height="22" border="0" alt="Topics"></a></td>');
		   links.push('<td><a href="http://searchWebServices.techtarget.com/ITKnowledgeExchange/0,294907,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_itke.gif" width="135" height="22" border="0" alt="ITKnowledge Exchange"></a></td>');
		   links.push('<td><a href="http://searchWebServices.techtarget.com/tips/0,289484,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_tips.gif" width="23" height="22" border="0" alt="Tips"></a></td>');
		   links.push('<td><a href="http://searchWebServices.techtarget.com/expert/Knowledgebase/0,289622,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_ate.gif" width="94" height="22" border="0" alt="Ask the Experts"></a></td>');
		   links.push('<td><a href="http://searchWebServices.techtarget.com/webcasts/0,295024,sid26,00.html?asrc=SS_NAV_WC"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_webcasts.gif" width="57" height="22" border="0" alt="Webcasts"></a></td>');
		     links.push('<td><a href="http://searchWebServices.bitpipe.com/?asrc=SS_NAV_WP"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_whitepapers.gif" width="76" height="22" border="0" alt="White Papers"></a></td>');
		   links.push('<td><a href="http://searchWebServices.bitpipe.com/itdownloads?asrc=SS_NAV_DL"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_downloads.gif"  height="22" border="0" alt="Downloads" ></a></td>');
		   links.push('<td><a href="http://searchWebServices.techtarget.com/careers/0,289753,sid26,00.html" target="_blank"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_careers.gif" width="49" height="22" border="0" alt="Careers"></a></td>');
		  nav.push(links.join('<td align="center" width="5%"><img src="http://media.techtarget.com/searchWebServices/images/homeNav_separator.gif" width="2" height="22" alt=""></td>'));
		nav.push('<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>','</tr>','</table>','</div>');
		return nav.join("");
	}
 function PAGE_FOOTER_TOP_DISPLAY_CODE_0 () {}


	function PAGE_FOOTER_BOTTOM_DISPLAY_CODE_0() {
		if(CHANNELHEADER == "on") var trClass = 'colorHeader'; else var trClass = 'color1';
		if(CHANNELHEADER == "on") var lineColor = 'color9'; else var lineColor = 'color0';
		if (FOOTERMEDIABAR == "on" && typeof FOOTER_MEDIABAR == "function") document.write(FOOTER_MEDIABAR());
		if(CHANNELHEADER != "on") document.write('<table border="0" cellspacing="0" cellpadding="0" width="100%">'+
		'<tr class="color0">'+
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3" alt=""></td>'+
		'</tr>'+
		'</table>');
		if (FOOTERNAV == "on") {
			document.write(PAGE_NAVIGATION() + '<table border="0" cellspacing="0" cellpadding="0" width="100%">'+
			'<tr class="' + lineColor + '">'+
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3" alt=""></td>'+
			'</tr>'+
			'</table>');
		}
		if ((FOOTERLINKS == "on" || FOOTERSEARCH == "on") && JSdigitalGuideID != 63) {
			document.write('<table border="0" cellpadding="0" cellspacing="0" width="100%">'+
			'<tr class="' + trClass + '">'+
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>'+
			'<td width="100%"'+((FOOTERLINKS == "on") ? ' height="29" class="textOnColor1">'+FOOTER_LINKS() : '>&nbsp;')+'</td>'+
			'<td'+((FOOTERSEARCH == "on" && JSdigitalGuideID != 9) ? ' class="' + trClass + '">'+FOOTER_SEARCH() : '>&nbsp;')+'</td>'+
			'</tr>'+
			'<tr class="' + trClass + '">'+
			'<td colspan="3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="5"></td>'+
			'</tr>'+
			'</table>');
		} else {
			document.write('<table border="0" cellpadding="0" cellspacing="0" width="100%">'+
			'<tr class="' + trClass + '">'+
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="7"></td>'+
			'</tr>'+
			'</table>');
		}
		document.write('<table border="0" cellpadding="2" cellspacing="0" width="100%">');
		if (PORTFOLIOBOX == "on") {
			document.write('<tr class="' + trClass + '">'+
			'<td width="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>'+
			'<td width="100%" colspan="2" class="color9">'+PORTFOLIO_BOX()+'</td>'+
			'<td width="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>'+
			'</tr>');
		}
		document.write('<tr class="' + trClass + '">'+
		'<td width="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td>'+
		'<td class="textOnColor1"><b>All Rights Reserved, <a href="http://searchWebServices.techtarget.com/copyright/0,289135,sid26,00.html" class="textOnColor1"><span class="bold">Copyright 2001 - 2006</span></a>, TechTarget</b></td>'+
		'<td align="right" nowrap><a href="http://www.techtarget.com/html/privacy_policy.html" target="_blank" class="textOnColor1">Read our Privacy Statement</a></td>'+
		'<td width="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td>'+
		'</tr>'+
		 '<tr class="' + trClass + '"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="4"></td></tr>'+
		'</table>');
		document.write(LIFTSTUDY_QUEUE());
		if (ISFIXEDWIDTH) document.write(CLOSE_FIXED_WIDTH_TABLE());
		if (typeof f360I_TRACKING == "function") document.write(f360I_TRACKING());
	}


	 function FOOTER_LINKS_DISPLAY_CODE_0() {
		var links = new Array('<a href="http://searchWebServices.techtarget.com/aboutUs/0,289153,sid26,00.html" class="textOnColor1">About Us</a>',
		'<a href="http://searchWebServices.techtarget.com/contactUs/0,289157,sid26,00.html" class="textOnColor1">Contact Us</a>',
		'<a href="http://searchWebServices.techtarget.com/buyersGuideForVendors/0,289879,sid26,00.html" class="textOnColor1">For Advertisers</a>',
		'<a href="http://searchWebServices.techtarget.com/forBusinessPartners/0,289198,sid26,00.html" class="textOnColor1">For Business Partners</a>',
		'<a href="http://searchWebServices.techtarget.com/reprints/0,296569,sid26,00.html" class="textOnColor1">Reprints</a>',
		'<a href="http://searchWebServices.techtarget.com/rssLanding/0,295701,sid26,00.html" class="textOnColor1">RSS</a>');
		 return links.join('&nbsp;&nbsp;|&nbsp;&nbsp;');
	}


	function FOOTER_SEARCH_DISPLAY_CODE_0() {
		if(CHANNELHEADER == "on")
		{
			var trClass = 'colorHeader'; 
			var lineColor = 'color9';
			var imageColor = 'gray';
		}
		else
		{
			var trClass = 'color1';
			var lineColor = 'color0';
			var imageColor = 'black';
		}

		return new Array('<table border="0" cellpadding="0" cellspacing="0" class="' + lineColor + '">',
		'<form name="search" action="http://searchWebServices.techtarget.com/search/1,293876,sid26,00.html" method="get">',
		'<tr>',
		'<td class="' + trClass + '"><img src="http://media.techtarget.com/digitalguide/images/Misc/footer_searchWidget_corner_' + imageColor +'.gif" width="29" height="29" alt=""></td>',
		'<td class="textF"><span class="a2"><b>SEARCH</b>&nbsp;</span></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1" alt=""></td>',
		'<td><input type="text" name="query" size="8" class="i3width125"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1" alt=""></td>',
		'<td><input type="image" src="http://media.techtarget.com/digitalguide/images/Misc/button_search_cccccc.gif"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1" alt=""></td>',
		'</tr>',
		'</form>',
		'</table>').join("");
	}



	function PORTFOLIO_BOX_DISPLAY_CODE_0() {
 if(CHANNELHEADER == "on") var trClass = 'colorHeader'; else var trClass = 'color1';
		var box = new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%">',
		'<tr bgcolor="#FFFFFF">',
		'<td width="5"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
		'<td width="100%"><img src="http://media.techtarget.com/searchWebServices/images/footerTaglineSite.gif" alt="SearchWebServices.com is part of the TechTarget network of industry-specific IT Web sites">'+
		'<img src="http://media.techtarget.com/digitalguide/images/footerTagline.gif" width="353" height="18" alt="SearchWebServices.com is part of the TechTarget network of industry-specific IT Web sites"></td>',
		'<td width="102" valign="top" rowspan="4" class="' + trClass + '"><a href="http://www.techtarget.com"><img src="http://media.techtarget.com/digitalguide/images/footerTTlogo.gif" width="102" height="104" border="0"></a></td>',
		'</tr>',
		'<tr><td colspan="2" height="2"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="2"></td></tr>',
		'<tr><td colspan="2" height="5" class="' + trClass + '"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="5"></td></tr>',
		'<tr class="' + trClass + '">',
		'<td width="5" height="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
		'<td width="100%" height="79" valign="top">',
		'<table border="0" cellpadding="0" cellspacing="0" width="100%">',
		'<tr>',
		'<td valign="top" class="textOnColor1" nowrap>');		

		              box.push('<span class="textOnColor1"><b>CIO AND IT MANAGEMENT</b></span><br>');
					   box.push('<a href="http://searchCIO.techtarget.com" class="textOnColor1">SearchCIO.com</a><br>');             box.push('<a href="http://searchSMB.techtarget.com" class="textOnColor1">SearchSMB.com</a><br>');             box.push('<a href="http://WhatIs.techtarget.com" class="textOnColor1">WhatIs.com</a><br>');                                box.push('<p>');
				          box.push('<span class="textOnColor1"><b>STORAGE AND DATA CENTER</b></span><br>');
					   box.push('<a href="http://searchStorage.techtarget.com" class="textOnColor1">SearchStorage.com</a><br>');               box.push('<a href="http://search400.techtarget.com" class="textOnColor1">Search400.com</a><br>');                     box.push('<a href="http://searchDataCenter.techtarget.com" class="textOnColor1">SearchDataCenter.com</a><br>');                          box.push('<p>');
				    
				box.push('</td>',
				'<td width="5"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
				'<td valign="top" class="textOnColor1" nowrap>');    box.push('<span class="textOnColor1"><b>WINDOWS AND DISTRIBUTED COMPUTING</b></span><br>');
					   box.push('<a href="http://searchWinIT.techtarget.com" class="textOnColor1">SearchWinIT.com</a><br>');                           box.push('<a href="http://searchExchange.techtarget.com" class="textOnColor1">SearchExchange.com</a><br>');         box.push('<a href="http://searchSQLServer.techtarget.com" class="textOnColor1">SearchSQLServer.com</a><br>');               box.push('<a href="http://searchWindowsSecurity.techtarget.com" class="textOnColor1">SearchWindowsSecurity.com</a><br>');         box.push('<a href="http://searchWinComputing.techtarget.com" class="textOnColor1">SearchWinComputing.com</a><br>');     box.push('<a href="http://searchServerVirtualization.techtarget.com" class="textOnColor1">SearchServerVirtualization.com</a><br>');     box.push('<a href="http://labmice.techtarget.com" class="textOnColor1">Labmice.net</a><br>');     box.push('<a href="http://searchOpenSource.techtarget.com" class="textOnColor1">SearchOpenSource.com</a><br>');     box.push('<a href="http://searchDomino.techtarget.com" class="textOnColor1">SearchDomino.com</a><br>');  box.push('<p>');
				                  box.push('<span class="textOnColor1"><b>NETWORKING</b></span><br>');
					   box.push('<a href="http://searchNetworking.techtarget.com" class="textOnColor1">SearchNetworking.com</a><br>');           box.push('<a href="http://searchVoIP.techtarget.com" class="textOnColor1">SearchVoIP.com</a><br>');                     box.push('<a href="http://searchMobileComputing.techtarget.com" class="textOnColor1">SearchMobileComputing.com</a><br>');                      box.push('<p>');
				     
				box.push('</td>',
				'<td width="5"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
				'<td valign="top" class="textOnColor1" nowrap>');
				           box.push('<span class="textOnColor1"><b>SECURITY</b></span><br>');
					   box.push('<a href="http://searchSecurity.techtarget.com" class="textOnColor1">SearchSecurity.com</a><br>');                                                  box.push('<p>');
				                                                                 box.push('<p>');
				                    box.push('<span class="textOnColor1"><b>APPLICATION DEVELOPMENT</b></span><br>');
					   box.push('<a href="http://www.theserverside.com" class="textOnColor1">TheServerSide.com</a><br>');           box.push('<a href="http://www.theserverside.net" class="textOnColor1">TheServerSide.NET</a><br>');           box.push('<a href="http://searchAppSecurity.techtarget.com" class="textOnColor1">SearchAppSecurity.com</a><br>');               box.push('<a href="http://searchWebServices.techtarget.com" class="textOnColor1">SearchWebServices.com</a><br>');       box.push('<a href="http://searchVB.techtarget.com" class="textOnColor1">SearchVB.com</a><br>');              box.push('<p>');
				            box.push('<span class="textOnColor1"><b>ENTERPRISE APPLICATIONS</b></span><br>');
					   box.push('<a href="http://searchCRM.techtarget.com" class="textOnColor1">SearchCRM.com</a><br>');                     box.push('<a href="http://searchDataManagement.techtarget.com" class="textOnColor1">SearchDataManagement.com</a><br>');               box.push('<a href="http://searchOracle.techtarget.com" class="textOnColor1">SearchOracle.com</a><br>');       box.push('<a href="http://searchSAP.techtarget.com" class="textOnColor1">SearchSAP.com</a><br>');           box.push('<a href="http://www.2020software.com" class="textOnColor1">2020software.com</a><br>');            box.push('<p>');
				                                                                 box.push('<p>');
				                                                                 box.push('<p>');
				  box.push('</td>',
		'<td width="5"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
		'</tr>',
		'</table>',
		'</td>',
		'</tr>',
		'<tr class="' + trClass + '"><td colspan="3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="10"></td></tr>',
		'<tr class="' + trClass + '">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td>',
		'<td colspan="2" class="textOnColor1">'), links = new Array();
		 links.push('<a href="http://expertAnswerCenter.techtarget.com/" class="textOnColor1">TechTarget Expert Answer Center</a>');
		 links.push('<a href="http://events.techtarget.com/" class="textOnColor1">TechTarget Events</a>',
		'<a href="http://www.techtarget.com/" class="textOnColor1">TechTarget Corporate Web Site</a>',
		'<a href="http://www.techtarget.com/mediakit/" class="textOnColor1">Media Kit</a>');
		
			links.push('<a href="http://searchWebServices.techtarget.com/siteMap/0,294352,sid26,00.html" class="textOnColor1">Site Map</a>');
		 box = box.concat(links.join('&nbsp;&nbsp;|&nbsp;&nbsp;'));
		box.push('</td>',
		'</tr>',
		'<tr class="' + trClass + '"><td colspan="3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="10"></td></tr>',
		'<tr><td colspan="3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="2"></td></tr>',
		'<tr bgcolor="#FFFFFF">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td>',
		'<td colspan="2"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="2"><br>'+
		'Explore <a href="http://searchtechtarget.techtarget.com/" class="text0"><b>SearchTechTarget.com</b></a>, the guide to the TechTarget network of industry-specific IT Web sites.<br>'+
		'<img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="2"><br></td>',
		'</tr>',
		'</table>');
		return box.join("");
	}

	
 function HEADER_DISPLAY_CODE_1() {
	if((navigator.appName == "Netscape" && parseInt(navigator.appVersion) < 5) || WEBREPORTING == "off") {
	//do nothing
	} else document.write(WEB_REPORTING());
	document.write('<table border="0" cellspacing="0" cellpadding="0" width="860">');
	document.write('<tr>');
	document.write('<td class="colorF" width="100%">');
	document.write('<span class="hideToPrint">');
	document.write('<!-- BEGIN: header -->');

	if (PORTFOLIOBAND == "on" && JSdigitalGuideID != 63) document.write(PORTFOLIO_BAND_DISPLAY_CODE_1());
	
	if (LEADERBOARD == "on") document.write(LEADER_BOARD());
	if (LOGO == "on" || HEADERMEDIALINKS == "on") document.write(HEADER_CORE());

	if (HEADERNAV == "on") {
		document.write(PAGE_NAVIGATION_DISPLAY_CODE_1('top'));
		document.write(STRIPE_DISPLAY_CODE_1('top'));
	}
	if (HEADERSEARCH == "on") {
		document.write(HEADER_SEARCH());
	}
	if (!ISHOME && SPONSORBANNER == "on") document.write(SPONSOR_BANNER_DISPLAY_CODE_1());
	
	document.write('	<!-- END: header -->');
	document.write('	</span>');
}

function SPONSOR_BANNER_DISPLAY_CODE_1() {
		return new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%">',
		'<tr>',
		'<td width="100%"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td align="right" rowspan="3"><img src="http://media.techtarget.com/searchWebServices/images/header_portfolioBand_curveEnd.gif" width="25" height="36" alt=""></td>',
		'</tr>',
		'<tr>',
		'<td>',
		'<table border="0" cellpadding="0" cellspacing="0" width="100%">',
		'<tr>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/label_portfolioBand.gif" width="14" height="33" alt="Ad"></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td>'+PAGE_AD(9)+'</td>',
		'</tr>',
		'</table>',
		'</td>',
		'</tr>',
		'<tr>',
		'<td class="color9"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="745" height="1" alt=""></td>',
		'</tr>',
		'</table>').join("");
	}


function PORTFOLIO_BAND_DISPLAY_CODE_1() {
	var pfoBand = new Array('<!-- BEGIN: portfolio band -->',
	'<table border="0" cellpadding="0" cellspacing="0" width="100%">',
	'<tr class="colorPortfolioBand">',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="14" alt=""></td>',
	'<td width="100%"><span class="textOnColorPortfolioBand"><span class="h2">Explore the TechTarget Network at </span></span><a href="http://www.searchtechtarget.com" class="textOnColorPortfolioBand"><span class="h2">SearchTechTarget.com</span></a></td>',
	'<td nowrap align="right"><span class="textOnColorPortfolioBand">'+((USERINFO == "on") ? '<span class="textOnColorPortfolioBand">'+((loggedIn != -1) ? '<span class="h2"><i>You\'re logged in as:</i> '+DisplayName+'</span>&nbsp;'+
			'<a href="http://searchWebServices.techtarget.com/register/1,289568,sid26,00.html" class="textOnColorPortfolioBand2"><span class="h2">Edit your Profile</span></a>&nbsp;<span class="yellow">|</span>&nbsp;'+
			'<a href="'+((ALTLOGOUT != "no") ? ALTLOGOUT : 'http://searchWebServices.techtarget.com/logout/1,289500,sid26,00.html')+'" class="textOnColorPortfolioBand2"><span class="h2">Logout</span></a>' :
			'<a href=javascript:buildOmedaURL("HL15"); class="textOnColorPortfolioBand2"><span class="h2">Get your FREE subscription to <b></b> today</span></a>&nbsp;<span class="yellow">|</span>&nbsp;'+
			'<a href="'+((ALTLOGIN != "no") ? ALTLOGIN : 'http://searchWebServices.techtarget.com/login/1,289498,sid26,00.html')+'" class="textOnColorPortfolioBand2"><span class="h2">Login</span></a>')+'</span></span>' : '&nbsp;')+
	'</span></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="3" height="1" alt=""></td>',
	'<td rowspan="4" class="color1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="11" height="1" alt=""></td>',
	'</tr>',
	'<tr class="colorPortfolioBand">',
	'<td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="2" alt=""></td>',
	'</tr>',
	'<tr class="color6">',
	'<td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'</tr>',
	'<tr class="colorPortfolioBand">',
	'<td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="2" alt=""></td>',
	'</tr>',
	'</table>',
	'<!-- END: portfolio band -->');
	return pfoBand.join("");
}


function HEADER_CORE_DISPLAY_CODE_1() {
	var core = new Array('<!-- BEGIN: logo and media pop-up -->',
'<table border="0" cellpadding="0" cellspacing="0" width="100%">',
'<tr class="colorHeader">',
'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="56" alt=""></td>',
'<td valign="middle">');
	if (LOGO == "on") core.push('<a href="http://searchWebServices.techtarget.com/home/0,289692,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/header_siteLogo.gif" alt="searchWebServices" border="0"></a>');
	core.push ('</td>',
	'<td width="100%"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td>');
	if (MEDIALINKS == "on") core = core.concat(MEDIA_LINKS());
	else core.push('<img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="208" height="56" alt="">');
	core.push('</td>',
	'<td rowspan="99" class="color1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>',
	'</tr>',
	'</table>',
	'<!-- END: logo and media pop-up -->');
	return core.join("");
}


function LEADER_BOARD_DISPLAY_CODE_1() {
	var board = new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%">',
	'<tr class="colorF">',
	'<td valign=top><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="14" height="1" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="728" height="1" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="106" height="1" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td rowspan="99" class="color1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>',
	'</tr>',
	'<tr>',
	'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td align="center" valign="top" background="http://media.techtarget.com/digitalguide/images/Misc/background_ad_side_728_90.gif"><img src="http://media.techtarget.com/digitalguide/images/Misc/leaderboard_advertisement.gif" width="14" height="90" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td>'+PAGE_AD(12)+'</td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td align="center" valign="top" background="http://media.techtarget.com/digitalguide/images/Misc/background_ad_side_728_90.gif">',
	'<img name="toggle728x90" src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="16" height="90" border="0" alt="">',
	'</td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'</tr>',
	'<tr class="colorF">',
	'<td colspan="7"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'</tr>',
	'<tr class="color3">',
	'<td colspan="7"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'</tr>',
	'</table>',
	'<!-- END: 728x90 leader board ad -->');
	return board.join("");
}			

function PAGE_FOOTER_BOTTOM_DISPLAY_CODE_1() {
	document.write('</td>');
	document.write('</tr>');
	document.write('<tr>');
	document.write('<td class="colorF" width="100%">');
	document.write('<span class="hideToPrint">');

	if (FOOTERSEARCH == "on") {
		document.write(FOOTER_SEARCH());
	}
//	if (FOOTERNAV == "on") {
//		document.write(STRIPE_DISPLAY_CODE_1('bottom'));
//		document.write(PAGE_NAVIGATION_DISPLAY_CODE_1('bottom'));
//	}
	document.write(STRIPE_DISPLAY_CODE_1('bottom'));
	document.write(PAGE_NAVIGATION_DISPLAY_CODE_1('bottom'));
	if (PORTFOLIOBOX == "on") {
		document.write(PORTFOLIO_BOX());
	}
	document.write('</span>');
	document.write('</td>');
	document.write('</tr>');
	document.write('</table>');
	document.write('</body>');
	document.write('</html>');
	document.write(LIFTSTUDY_QUEUE());
	if (typeof f360I_TRACKING == "function") document.write(f360I_TRACKING());
}



function FOOTER_LINKS_DISPLAY_CODE_1() {
	var links = new Array('<a href="http://searchWebServices.techtarget.com/aboutUs/0,289153,sid26,00.html" class="textOnColor1">About Us</a>',
	'<a href="http://searchWebServices.techtarget.com/contactUs/0,289157,sid26,00.html" class="textOnColor1">Contact Us</a>',
	'<a href="http://searchWebServices.techtarget.com/buyersGuideForVendors/0,289879,sid26,00.html" class="textOnColor1">For Advertisers</a>',
	'<a href="http://searchWebServices.techtarget.com/forBusinessPartners/0,289198,sid26,00.html" class="textOnColor1">For Business Partners</a>',
	'<a href="http://searchWebServices.techtarget.com/reprints/0,296569,sid26,00.html" class="textOnColor1">Reprints</a>',
	'<a href="http://searchWebServices.techtarget.com/rssLanding/0,295701,sid26,00.html" class="textOnColor1">RSS</a>');
	 return links.join('&nbsp;&nbsp;|&nbsp;&nbsp;');
}


function PAGE_FOOTER_TOP_DISPLAY_CODE_1() {}

function PAGE_NAVIGATION_DISPLAY_CODE_1(position) {
	var positionAttrib;
	if(position == 'top') positionAttrib = ' id="menuBar"';
	else positionAttrib = '';
	var spanClass = ' class="first"';
	var firstLink = true;
	var nav = new Array('<table border="0" cellspacing="0" cellpadding="0" width="100%">','<tr>','<td width="100%" valign="top"><div' + positionAttrib + ' class="navBar">'), links = new Array();
	if (!ISHOME) {
		links.push('<span id="navList" class="first"><a href="http://searchWebServices.techtarget.com/home/0,289692,sid26,00.html" class="navLink">HOME</a></span>');
		spanClass = '';
	}
	  links.push('<span id="navList"' + spanClass + '><a href="http://searchWebServices.techtarget.com/news/0,289141,sid26,00.html" class="navLink">NEWS</a></span>');
		spanClass = '';
		   links.push('<span id="navList"' + spanClass + '><a href="http://searchWebServices.techtarget.com/topicsMain/0,295490,sid26,00.html" class="navLink">TOPICS</a></span>');
		spanClass = '';
		         links.push('<span id="navList"' + spanClass + '><a href="http://searchWebServices.techtarget.com/webcasts/0,295024,sid26,00.html?asrc=SS_NAV_WC" class="navLink">WEBCASTS</a></span>');
		spanClass = '';
		     links.push('<span id="navList"' + spanClass + '><a href="http://searchWebServices.bitpipe.com/?asrc=SS_NAV_WP" class="navLink">WHITE PAPERS</a></span>');
		spanClass = '';
		     links.push('<span id="navList"' + spanClass + '><a href="http://searchWebServices.techtarget.com/careers/0,289753,sid26,00.html" target="_blank" class="navLink">CAREERS</a></span>');
		spanClass = '';
		  nav.push(links.join(''));
	nav.push('</div>');
	if(position == 'bottom') nav.push('<td valign="top"><img src="http://media.techtarget.com/searchWebServices/images/footer_curveEnd_bottom.gif" width="25" height="19" alt=""></td>');
	else if(position == 'top') nav.push('<td valign="top"><img src="http://media.techtarget.com/searchWebServices/images/header_curveEnd_top.gif" width="25" height="19" alt=""></td>');
	nav.push('</td>','</tr>','</table>');
	return nav.join("");
}

function STRIPE_DISPLAY_CODE_1(position) {	
	stripe = new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%">',
	'<tr>',
	'<td width="100%" align="right" class="color1"><img src="http://media.techtarget.com/searchWebServices/images/header_gradient_860.gif" width="835" height="8" alt=""></td>');
	if(position == 'bottom') stripe.push('<td background="http://media.techtarget.com/searchWebServices/images/footer_curveEnd_middle.gif" class="color1">');
	else if(position == 'top') stripe.push('<td background="http://media.techtarget.com/searchWebServices/images/header_curveEnd_middle.gif" class="color1">'); 
	stripe.push('<img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="25" height="8" alt="">',
	'</td>',
	'</tr>',
	'</table>');
	return stripe.join("");
}	

function HEADER_SEARCH_DISPLAY_CODE_1() {
	if(clickThruLive == 'on')
		return SEARCHBOX_CLICKTHRU_DISPLAY_CODE_1('top');
	else
		return SEARCHBOX_DISPLAY_CODE_1('top');
}

function FOOTER_SEARCH_DISPLAY_CODE_1() {
	if(clickThruLive == 'on')
		return SEARCHBOX_CLICKTHRU_DISPLAY_CODE_1('bottom');
	else
		return SEARCHBOX_DISPLAY_CODE_1('bottom');
}

function SEARCHBOX_DISPLAY_CODE_1(position) {
	searchbox = new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%">',
	'<tr class="searchBarBackground">',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="24" alt=""></td>',
	'<td nowrap><span class="h2"><span class="textF"><b>Search</b> this site and the web:</span></span></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="6" height="1" alt=""></td>',
	'<td>',
	'<table border="0" cellspacing="0" cellpadding="0">',
	'<form name="search" action="http://searchWebServices.techtarget.com/search/1,293876,sid26,00.html" method="get">',
	'<tr>',
	'<td><input type="text" name="query" size="8" class="searchbarTextbox"></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="3" height="1" alt=""></td>',
	'<td><input type="image" src="http://media.techtarget.com/searchWebServices/images/button_go.gif"></td>',
	'</tr>',
	'</tr>',
	'</table>',
	'</td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="10" height="1" alt=""></td>',
	'<td nowrap>',
	'<a href="http://searchWebServices.techtarget.com/integratedSearchAdvanced/0,289518,sid26,00.html" class="searchbarLink">ADVANCED SEARCH</a>',
	'&nbsp;&nbsp;<span class="textF"><span class="h2">|</span></span>&nbsp;&nbsp;',
	'<a href="http://searchWebServices.techtarget.com/siteMap/0,294352,sid26,00.html" class="searchbarLink">SITE MAP</a>',
	'</td>',
	'<td width="100%"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColor6.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="24" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>',
	'<td><a href="http://www.google.com"><img src="http://media.techtarget.com/digitalguide/images/Misc/searchPoweredByGoogle_onGrey6.gif" width="149" height="24" alt="Search Powered by Google" border="0"></a></td>',
	'<!--<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="1" alt=""></td>-->');
	if(position == 'bottom'){
		if(JSfooterAdSense == 'on') searchbox.push('<td background="http://media.techtarget.com/searchWebServices/images/footer_curveEnd_top_onColor9.gif">');
		else searchbox.push('<td background="http://media.techtarget.com/searchWebServices/images/footer_curveEnd_top.gif">');
	}
	else if(position == 'top') searchbox.push('<td background="http://media.techtarget.com/searchWebServices/images/header_curveEnd_bottom.gif">');
	searchbox.push('<img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="25" height="24" alt=""></td>',	
	'</tr>',	
	'</form></table>',	
	'<!-- END: navigation & search bar -->');
	return searchbox.join("");
}

function SEARCHBOX_CLICKTHRU_DISPLAY_CODE_1(position) {
	searchbox = new Array('<!-- BEGIN: search bar -->',
			'<table border="0" cellpadding="0" cellspacing="0" width="100%">',
			'<tr class="searchBarBackground">',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="24" alt=""></td>',
			'<td nowrap><span class="h2"><span class="textF"><b>SEARCH:</b></span></span></td>',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="6" height="1" alt=""></td>',
			'<td>',
				'<table border="0" cellspacing="0" cellpadding="0">',
				'<form name="search" action="http://searchWebServices.techtarget.com/search/1,293876,sid26,00.html" method="get">',
				'<tr>',
				'<td><input type="text" name="query" size="8" class="searchbarTextbox"></td>',
				'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="3" height="1" alt=""></td>',
				'<td><input type="image" src="http://media.techtarget.com/searchWebServices/images/button_go.gif"></td>',
				'</tr>',
				'</form>',
				'</table>',
			'</td>',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>',
			'<td nowrap><a href="http://searchWebServices.techtarget.com/integratedSearchAdvanced/0,289518,sid26,00.html" class="searchbarLink">ADVANCED SEARCH</a>&nbsp;&nbsp;<span class="textF"><span class="h2">|</span></span>&nbsp;&nbsp;<a href="http://searchWebServices.techtarget.com/siteMap/0,294352,sid26,00.html" class="searchbarLink">SITE MAP</a></td>',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="15" height="1" alt=""></td>',
			'<td><a href="http://www.google.com"><img src="http://media.techtarget.com/digitalguide/images/Misc/searchPoweredByGoogle_onGrey6.gif" width="149" height="24" alt="Search Powered by Google" border="0"></a></td>',
			'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="83" height="1" alt=""></td>',
	'<!-- END: search bar -->');
		if(position == 'bottom'){
		searchbox.push('<!-- BEGIN: ClickThru Form Header Footer-->',
					'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColor6.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="24" alt=""></td>',
					'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="1" alt=""></td>',
					'<td><a href="http://searchWebServices.techtarget.com/clickThruAbout/0,296381,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/clickthru_logo.gif" width="91" height="16" alt="CLICKTHRU" border="0"></a></td>',
					'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>',
					'<td>',
						'<table border="0" cellspacing="0" cellpadding="0">',
						'<form name="clickThruFormFooter" method="get" onSubmit="clickThruValidate(clickThruFormFooter)">',
						'<tr>',
						'<td><input type="text" name="clickThruID" size="8" class="searchbarTextbox2"></td>',
						'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="3" height="1" alt=""></td>',
						'<td><input type="image" src="http://media.techtarget.com/searchWebServices/images/button_go.gif" action="submit"></td>',
						'</tr>',
						'</form>',
						'</table>',
					'</td>',
			'<!--END: ClickThru Form Header Footer-->');
			if(JSfooterAdSense == 'on') searchbox.push('<td background="http://media.techtarget.com/searchWebServices/images/footer_curveEnd_top_onColor9.gif">');
		else searchbox.push('<td background="http://media.techtarget.com/searchWebServices/images/footer_curveEnd_top.gif">');
			}
		else if(position == 'top') searchbox.push(
				'<!-- BEGIN: ClickThru Form Header Footer-->',
					'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColor6.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="24" alt=""></td>',
					'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="1" alt=""></td>',
					'<td><a href="http://searchWebServices.techtarget.com/clickThruAbout/0,296381,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/clickthru_logo.gif" width="91" height="16" alt="CLICKTHRU" border="0"></a></td>',
					'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>',
					'<td>',
						'<table border="0" cellspacing="0" cellpadding="0">',
						'<form name="clickThruFormHeader" method="get" onSubmit="clickThruValidate(clickThruFormHeader)">',
						'<tr>',
						'<td><input type="text" name="clickThruID" size="8" class="searchbarTextbox2"></td>',
						'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="3" height="1" alt=""></td>',
						'<td><input type="image" src="http://media.techtarget.com/searchWebServices/images/button_go.gif" action="submit"></td>',
						'</tr>',
						'</table>',
					'</td>',
			'<!--END: ClickThru Form Header Footer-->',
		'<td background="http://media.techtarget.com/searchWebServices/images/header_curveEnd_bottom.gif">');
		
	searchbox.push('<img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="25" height="24" alt=""></td>',	
	'</tr>',	
	'</form></table>');
	return searchbox.join("");

}

function PORTFOLIO_BOX_DISPLAY_CODE_1() {
	var box = new Array('<!-- BEGIN: TechTarget website network links -->',
	'<table border="0" cellpadding="0" cellspacing="0" width="100%">',
	'<tr class="color6">',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="19" alt=""></td>',
	'<td width="100%"><span class="h2"><span class="textF"><b>',
	'SearchWebServices.com',
	'</b> is part of the TechTarget network of industry-specific IT Web Sites</span></span></td>',
	'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColor6.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="19" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="174" height="19" alt=""></td>',
	'<td class="color1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>	',
	'</tr>',
	'</table>',
	'<table border="0" cellspacing="0" cellpadding="0" width="100%">',
	'<tr class="colorFooter">',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="644" height="20" alt=""></td>',
	'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColorEF.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="20" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="174" height="20" alt=""></td>',
	'<td rowspan="99" class="color1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>',
	'</tr>',
	'<tr class="colorFooter">',
	'<td valign="top">',
	'<table border="0" cellspacing="0" cellpadding="0">',
	'<tr>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1" alt=""></td>',
	'<td width="180" valign="top">');
	
	            
				 box.push('<p><span class="h2"><b>CIO AND IT MANAGEMENT</b></span><br>');   box.push('<a href="http://searchCIO.techtarget.com" class="footerLink">SearchCIO.com</a><br>');     
				   box.push('<a href="http://searchSMB.techtarget.com" class="footerLink">SearchSMB.com</a><br>');     
				   box.push('<a href="http://WhatIs.techtarget.com" class="footerLink">WhatIs.com</a><br>');                box.push('<p>');
			        
				 box.push('<p><span class="h2"><b>STORAGE AND DATA CENTER</b></span><br>');   box.push('<a href="http://searchStorage.techtarget.com" class="footerLink">SearchStorage.com</a><br>');      
				   box.push('<a href="http://search400.techtarget.com" class="footerLink">Search400.com</a><br>');         
				   box.push('<a href="http://searchDataCenter.techtarget.com" class="footerLink">SearchDataCenter.com</a><br>');             box.push('<p>');
			    
			box.push('</td>',
			'<td width="5"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
			'<td width="205" valign="top">');
			   
				 box.push('<p><span class="h2"><b>WINDOWS AND DISTRIBUTED COMPUTING</b></span><br>');   box.push('<a href="http://searchWinIT.techtarget.com" class="footerLink">SearchWinIT.com</a><br>');            
				   box.push('<a href="http://searchExchange.techtarget.com" class="footerLink">SearchExchange.com</a><br>');   
				   box.push('<a href="http://searchSQLServer.techtarget.com" class="footerLink">SearchSQLServer.com</a><br>');      
				   box.push('<a href="http://searchWindowsSecurity.techtarget.com" class="footerLink">SearchWindowsSecurity.com</a><br>');   
				   box.push('<a href="http://searchWinComputing.techtarget.com" class="footerLink">SearchWinComputing.com</a><br>'); 
				   box.push('<a href="http://searchServerVirtualization.techtarget.com" class="footerLink">SearchServerVirtualization.com</a><br>'); 
				   box.push('<a href="http://labmice.techtarget.com" class="footerLink">Labmice.net</a><br>'); 
				   box.push('<a href="http://searchOpenSource.techtarget.com" class="footerLink">SearchOpenSource.com</a><br>'); 
				   box.push('<a href="http://searchDomino.techtarget.com" class="footerLink">SearchDomino.com</a><br>'); box.push('<p>');
			            
				 box.push('<p><span class="h2"><b>NETWORKING</b></span><br>');   box.push('<a href="http://searchNetworking.techtarget.com" class="footerLink">SearchNetworking.com</a><br>');    
				   box.push('<a href="http://searchVoIP.techtarget.com" class="footerLink">SearchVoIP.com</a><br>');         
				   box.push('<a href="http://searchMobileComputing.techtarget.com" class="footerLink">SearchMobileComputing.com</a><br>');           box.push('<p>');
			     
			box.push('</td>',
			'<td width="5"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
			'<td width="160" valign="top">');
			       
				 box.push('<p><span class="h2"><b>SECURITY</b></span><br>');   box.push('<a href="http://searchSecurity.techtarget.com" class="footerLink">SearchSecurity.com</a><br>');                         box.push('<p>');
			                                    box.push('<p>');
			             
				 box.push('<p><span class="h2"><b>APPLICATION DEVELOPMENT</b></span><br>');   box.push('<a href="http://www.theserverside.com" class="footerLink">TheServerSide.com</a><br>');    
				   box.push('<a href="http://www.theserverside.net" class="footerLink">TheServerSide.NET</a><br>');    
				   box.push('<a href="http://searchAppSecurity.techtarget.com" class="footerLink">SearchAppSecurity.com</a><br>');      
				   box.push('<a href="http://searchWebServices.techtarget.com" class="footerLink">SearchWebServices.com</a><br>');  
				   box.push('<a href="http://searchVB.techtarget.com" class="footerLink">SearchVB.com</a><br>');       box.push('<p>');
			         
				 box.push('<p><span class="h2"><b>ENTERPRISE APPLICATIONS</b></span><br>');   box.push('<a href="http://searchCRM.techtarget.com" class="footerLink">SearchCRM.com</a><br>');         
				   box.push('<a href="http://searchDataManagement.techtarget.com" class="footerLink">SearchDataManagement.com</a><br>');      
				   box.push('<a href="http://searchOracle.techtarget.com" class="footerLink">SearchOracle.com</a><br>');  
				   box.push('<a href="http://searchSAP.techtarget.com" class="footerLink">SearchSAP.com</a><br>');    
				   box.push('<a href="http://www.2020software.com" class="footerLink">2020software.com</a><br>');      box.push('<p>');
			                                    box.push('<p>');
			                                    box.push('<p>');
			  box.push('</td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1" alt=""></td>',
	'</tr>',
	'</table>',
	'</td>',
	'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColorEF.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="1" alt=""></td>',
	'<td>',
	'<table border="0" cellspacing="0" cellpadding="0" width="100%">',
	'<tr>',
	'<td rowspan="99"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="10" height="1" alt=""></td>',
	'<td colspan="3" align="left">',
	'<img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="35" height="1" alt="">',
	'<img src="http://media.techtarget.com/digitalguide/images/Misc/footer_tt_logo_onColorEF.gif" width="77" height="74" alt="TechTarget - The Most Targeted IT Media">',
	'</td>',
	'<td rowspan="99"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
	'</tr>',
	'<tr>',
	'<td colspan="3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="15" alt=""></td>',
	'</tr>',
	'<tr>',
	'<td colspan="3"><span class="textDkRed6"><span class="h2">Explore these TechTarget sites:</span></span></td>',
	'</tr>',
	'<tr>',
	'<td valign="top"><span class="h3"><span class="textDkRed9">&gt;</span></span></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="1" alt=""></td>',
	'<td width="100%"><a href="http://expertanswercenter.techtarget.com" class="footerLink">TechTarget Expert Answer Center</a></td>',
	'</tr>',
	'<tr>',
	'<td valign="top"><span class="h3"><span class="textDkRed9">&gt;</span></span></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="1" alt=""></td>',
	'<td><a href="http://events.techtarget.com/" class="footerLink">TechTarget Events</a></td>',
	'</tr>',
	'<tr>',
	'<td valign="top"><span class="h3"><span class="textDkRed9">&gt;</span></span></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="1" alt=""></td>',
	'<td><a href="http://www.techtarget.com/" class="footerLink">TechTarget Corporate Web Site</a></td>',
	'</tr>',
	'<tr>',
	'<td valign="top"><span class="h3"><span class="textDkRed9">&gt;</span></span></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="1" alt=""></td>',
	'<td><a href="http://www.techtarget.com/mediakit/" class="footerLink">Media Kit</a></td>',
	'</tr>',
	'</table>',
	'</td>',
	'</tr>',
	'<tr class="colorFooter">',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="30" alt=""></td>',
	'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColorEF.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="30" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="30" alt=""></td>',
	'</tr>',
	'</table>',
	'<table border="0" cellpadding="0" cellspacing="0" width="100%">',
	'<tr class="color6">',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="19" alt=""></td>',
	'<td width="100%"><span class="h2"><span class="textF">Explore <a href="http://www.searchtechtarget.com" class="footerLink2"><span class="h2">SearchTechTarget.com</span></a>, the guide to the TechTarget network of industry-specific IT Web sites.</span></span></td>',
	'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColor6.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="19" alt=""></td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="174" height="19" alt=""></td>',
	'<td rowspan="99" class="color1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>	',
	'</tr>',
	'<tr class="color3">',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="4" height="19" alt=""></td>',
	'<td width="100%"><span class="h2"><span class="textF">All Rights Reserved, <a href="http://searchWebServices.techtarget.com/copyright/0,289135,sid19,00.html" class="footerLink2"><span class="h2">Copyright 2000 - 2005</span></a>, TechTarget</span></span></td>',
	'<td background="http://media.techtarget.com/searchWebServices/images/background_lineTrio_onColor3.gif"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="34" height="24" alt=""></td>',
	'<td align="right"><a href="http://www.techtarget.com/html/privacy_policy.html" target="_blank" class="footerLink2"><span class="h2">Read our Privacy Statement</span></a><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="1" alt=""></td>',
	'</tr>',
	'</table>',
	'<!-- END: TechTarget website network links -->');
	return box.join("");
}

	function MEDIA_LINKS_DISPLAY_CODE_1() {
		var hasImage = 0;
		if (hasImage) {
			var mediaCode = "WC",
			links = new Array('<map name="headermap">'),
			popupWinName = "mediaPopup",
			popupWinProp = "width=388,height=388,menubar=no,resizable=no,status=no,titlebar=no,scrollbars=yes";
			switch (mediaCode) {
				case "MCW": links.push(
					'<area shape="rect" coords="52,32 98,43"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab1,00.html" alt="Magazine"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">',
					'<area shape="rect" coords="106,32 136,43"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab2,00.html" alt="Conferences"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">',
					'<area shape="rect" coords="144,32 192,43"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab3,00.html" alt="Web Sites"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">');
					break;
				case "MW": links.push(
					'<area shape="rect" coords="124,36 185,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab1,00.html" alt="Magazine"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">',
					'<area shape="rect" coords="193,36 252,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab3,00.html" alt="Web Sites"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">');
					break;
				case "CW": links.push(
					'<area shape="rect" coords="115,36 194,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab2,00.html" alt="Conferences"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">',
					'<area shape="rect" coords="202,36 261,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab3,00.html" alt="Web Sites"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">');
					break;
				case "W": links.push(
					'<area shape="rect" coords="159,36 218,47"'+
					' href="http://searchWebServices.techtarget.com/mediaPopup/0,295511,sid26_tab1,00.html" alt="Web Sites"'+
					' target="'+popupWinName+'" onClick="window.open(\'about:blank\',\''+popupWinName+'\',\''+popupWinProp+'\')">');
					break;
			} links.push('<area shape="default" nohref alt="">',
			'</map>',
			'<img src="http://media.techtarget.com/searchWebServices/images/header_mediaSections_WC.gif" width="208" height="56" ismap usemap="#headermap" alt="TechTarget Application Development Media" border="0">');
			return links;
		} else return new Array('<img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="208" height="58" alt="" border="0">');
	}
 function OPEN_FIXED_WIDTH_TABLE_DISPLAY_CODE_3() {
	return '<table width="776" cellpadding="0" cellspacing="1" border="0" class="color6"><tr><td class="colorF" align="center">';
}
function OPEN_CENTER_PAGE() {
	return '<div align="center">';
}
function CLOSE_CENTER_PAGE() {
	return '</div>';
}
function HEADER_DISPLAY_CODE_3() {
	if((navigator.appName == "Netscape" && parseInt(navigator.appVersion) < 5) || WEBREPORTING == "off") {
	//do nothing
	} else document.write(WEB_REPORTING());
	if (memberUpdate == "on" && memUpd != -1 && memberUpdateOverride == -1) document.write(MEMBER_UPDATE());
	document.write(OPEN_CENTER_PAGE());
	if (PORTFOLIOBAND == "on" && JSdigitalGuideID != 63) document.write(PORTFOLIO_BAND());
	if (LEADERBOARD == "on") document.write(LEADER_BOARD());
	if (ISFIXEDWIDTH) document.write(OPEN_FIXED_WIDTH_TABLE());
	document.write(HEADER_CORE());
	if (HEADERNAV == "on") document.write(PAGE_NAVIGATION());
	if (HEADERSEARCH == "on" && JSdigitalGuideID != 9 && JSdigitalGuideID != 63) document.write(HEADER_SEARCH());
	else if (HEADERNAV == "on") document.write('<table border="0" cellspacing="0" cellpadding="0" width="100%">'+
	'<tr class="color0"><td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3" alt=""></td></tr>'+
	'</table>');
	if (!ISHOME && SPONSORBANNER == "on") document.write(SPONSOR_BANNER());
	document.write('<table border="0" cellpadding="0" cellspacing="0">'+
	'<tr>'+
	'<td width="100%"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="15" alt=""></td>'+
	'</tr>'+
	'</table>');
}

function PORTFOLIO_BAND_DISPLAY_CODE_3() {
	var pfoBand = new Array('<table border="0" cellpadding="1" cellspacing="0" width="776"><tr><td class="color9">',
	'<table border="0" cellpadding="0" cellspacing="0" class="crmColorPortfolioBand" width="100%">',
	'<tr class="crmColorPortfolioBand"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3"></td></tr>',
	'<tr class="crmColorPortfolioBand">',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="15"></td>',
	'<td width="100%"><span class="a2"><span class="crmTxOnColorPortfolioBand"><b>Explore the TechTarget Network at </b>'+
	'<a href="http://searchtechtarget.techtarget.com/" class="crmTxOnColorPortfolioBand"><span class="a2">SearchTechTarget.com</span></a>.</span>'+
	'</span></td>',
	'<td nowrap align="right" class="a2">'+((USERINFO == "on") ? '<span class="crmTxOnColorPortfolioBand">'+((loggedIn != -1) ? '<i>You\'re logged in as:</i> <b>'+DisplayName+'</b>&nbsp;'+
	'<a href="http://searchWebServices.techtarget.com/register/1,289568,sid26,00.html" class="crmTxOnColorPortfolioBand"><span class="a2">Edit your Profile</span></a>&nbsp;<span class="yellow">|</span>&nbsp;'+
	'<a href="'+((ALTLOGOUT != "no") ? ALTLOGOUT : 'http://searchWebServices.techtarget.com/logout/1,289500,sid26,00.html')+'" class="crmTxOnColorPortfolioBand"><span class="a2">Log-out</span></a>' :
	'<a href="http://searchWebServices.techtarget.com/register/1,289568,sid26,00.html" class="crmTxOnColorPortfolioBand"><span class="a2">Activate your FREE membership today</span></a>&nbsp;<span class="yellow">|</span>&nbsp;'+
	'<a href="'+((ALTLOGIN != "no") ? ALTLOGIN : 'http://searchWebServices.techtarget.com/login/1,289498,sid26,00.html')+'" class="crmTxOnColorPortfolioBand"><span class="a2">Log-in</span></a>')+'</span>' : '&nbsp;')+
	'</td>',
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>',
	'</tr>',
	'<tr class="crmColorPortfolioBand"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3"></td></tr>',
	'<tr class="color1"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td></tr>',
	'<tr class="crmColorPortfolioBand"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td></tr>',
	'</table></td></tr></table>');
	return pfoBand.join("");
}

function LEADER_BOARD_DISPLAY_CODE_3() {
		var board = new Array('<table border="0" cellpadding="0" cellspacing="0" width="776">',
		'<tr class="colorF">');
		if (!ISFIXEDWIDTH) board.push('<td width="50%" rowspan="99"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>');
		board.push('<td colspan="7"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="9" alt=""></td>',
		'<td width="100%" rowspan="99"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>',
		'</tr>','<tr class="colorF">',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="19" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="728" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="19" height="1" alt=""></td>',
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'</tr>','<tr>',
		'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td align="center" valign="top">'+
		'<img src="http://media.techtarget.com/searchWebServices/images/white_ad_sideHeader_728_90.gif" width="19" height="90" border="0" alt=""></td>',
		'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td>'+PAGE_AD(12)+'</td>',
		'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'<td align="center" valign="top">'+
		'<img name="toggle728x90" src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="19" height="90" border="0" alt=""></td>',
		'<td class="colorF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'</tr>','<tr class="colorF">',
		'<td colspan="7"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>',
		'</tr>','<tr class="colorF">',
		'<td colspan="7"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="9" alt=""></td>',
		'</tr>',
		'</table>');
		return board.join("");
}

function HEADER_CORE_DISPLAY_CODE_3() {
	var hc = new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%"><tr>'); 
    hc.push('    <td width="405" class="color1"><a href="http://searchWebServices.techtarget.com/home/0,289692,sid26,00.html"><img src="http://media.techtarget.com/searchWebServices/images/header_logo2.gif" width="405" height="68" border="0"></a></td>');
    hc.push('    <td width="491" background="http://media.techtarget.com/searchWebServices/images/header_right_fade.gif" align="right">'); 
    hc.push('      <table border="0" cellspacing="0" cellpadding="0">');
    hc.push('        <tr>'); 
    hc.push('          <td nowrap><img src="http://media.techtarget.com/searchWebServices/images/arrow_content_item.gif" width="5" height="5" align="absmiddle"><a href="http://searchWebServices.techtarget.com/news/0,289141,sid26,00.html" class="contentNavLink">NEWS</a></td>');
    hc.push('          <td rowspan="2" width="26"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="26" height="40" alt=""></td>');
    hc.push('          <td nowrap><img src="http://media.techtarget.com/searchWebServices/images/arrow_content_item.gif" width="5" height="5" align="absmiddle"><a href="http://searchWebServices.bitpipe.com/?asrc=SS_NAV_WP" class="contentNavLink">WHITE ');
    hc.push('            PAPERS</a></td>');
    hc.push('          <td rowspan="2" width="26"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="26" height="40" alt=""></td>');
    hc.push('          <td nowrap><img src="http://media.techtarget.com/searchWebServices/images/arrow_content_item.gif" width="5" height="5" align="absmiddle"><a href="http://searchWebServices.techtarget.com/webcasts/0,295024,sid26,00.html?asrc=SS_NAV_WC" class="contentNavLink">WEBCASTS</a></td>');
    hc.push('          <td rowspan="2" width="26"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="26" height="40" alt=""></td>');
	 hc.push('          <td nowrap><img src="http://media.techtarget.com/searchWebServices/images/arrow_content_item.gif" width="5" height="5" align="absmiddle"><a href="http://searchWebServices.techtarget.com/careers/0,289753,sid26,00.html" target="_blank" class="contentNavLink">CAREERS</a></td>');
	 hc.push('          <td rowspan="2" width="26"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="26" height="40" alt=""></td>');
    hc.push('        </tr>');
    hc.push('       <tr>'); 
    hc.push('          <td nowrap><img src="http://media.techtarget.com/searchWebServices/images/arrow_content_item.gif" width="5" height="5" align="absmiddle"><a href="http://searchWebServices.techtarget.com/glossary/0,294242,sid26,00.html" class="contentNavLink">GLOSSARY</a></td>');
  
  
   hc.push('        <td nowrap><img src="http://media.techtarget.com/searchWebServices/images/arrow_content_item.gif" width="5" height="5" align="absmiddle"><a href="http://searchWebServices.bitpipe.com/itdownloads?asrc=SS_NAV_DL" class="contentNavLink">DOWNLOADS</a></td>');
	
	
	
	hc.push('          <td nowrap><img src="http://media.techtarget.com/searchWebServices/images/arrow_content_item.gif" width="5" height="5" align="absmiddle"><a href="http://searchWebServices.techtarget.com/expert/Knowledgebase/0,289622,sid26,00.html" class="contentNavLink">EXPERTS</a></td>');
    hc.push('          <td nowrap><img src="http://media.techtarget.com/searchWebServices/images/arrow_content_item.gif" width="5" height="5" align="absmiddle"><a href="http://searchWebServices.techtarget.com/rssLanding/0,295701,sid26,00.html" class="contentNavLink">RSS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://searchWebServices.techtarget.com/tips/0,289484,sid26,00.html" class="contentNavLink">TIPS</a></td>');
    hc.push('        </tr>');
    hc.push('      </table>');
    hc.push('    </td>');
    hc.push('</tr></table>');
	return hc.join("");
}

function HEADER_SEARCH_DISPLAY_CODE_3() {
	return new Array('<table border="0" cellspacing="0" cellpadding="0" width="100%">',
	'<form name="search" action="http://searchWebServices.techtarget.com/search/1,293876,sid26,00.html" method="get">',
	'<tr>',
	'<td class="colorEF" width="8"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="26" alt=""></td>',
	'<td class="colorEF" width="1%"><input type="text" name="query" size="8" class="i3width125"></td>',
	'<td width="7" class="colorEF"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="7" height="1" alt=""></td>',
	'<td width="48" class="colorEF"><input type="image" src="http://media.techtarget.com/digitalguide/images/Misc/button_search_cccccc.gif"></td>',
	'<td nowrap class="colorEF">&nbsp;&nbsp;&nbsp;<a href="http://searchWebServices.techtarget.com/integratedSearchAdvanced/0,289518,sid26,00.html" class="searchLink">Advanced</a>&nbsp;'+
	'<span class="text9">|</span>&nbsp;<a href="http://searchWebServices.techtarget.com/siteMap/0,294352,sid26,00.html" class="searchLink">Site Map</a></td>',
    '<td class="colorEF" align="right"><span class="searchPowerTx">Search Powered by&nbsp;&nbsp;'+
	'<a href="http://www.google.com"><img src="http://media.techtarget.com/searchWebServices/images/google_logo.gif" width="56" height="26" align="absmiddle" border="0" alt="Search Powered by Google"></a></span></td>',
	'<td class="colorEF" width="9"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="8" height="26" alt=""></td>',
	'</tr>',
	'</form>',
	'</table>').join("");
}

function PAGE_FOOTER_BOTTOM_DISPLAY_CODE_3() {
	if (FOOTERMEDIABAR == "on" && typeof FOOTER_MEDIABAR == "function") document.write(FOOTER_MEDIABAR());
	document.write('<table border="0" cellspacing="0" cellpadding="0" width="100%">'+
	'<tr class="color0">'+
	'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="3" alt=""></td>'+
	'</tr>'+
	'</table>');
	if ((FOOTERLINKS == "on" || FOOTERSEARCH == "on") && JSdigitalGuideID != 63) {
		document.write('<table border="0" cellpadding="0" cellspacing="0" width="100%">'+
		'<tr class="color1">'+
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="5" height="1"></td>'+
		'<td width="100%"'+((FOOTERLINKS == "on") ? ' height="29" class="textOnColor1">'+FOOTER_LINKS() : '>&nbsp;')+'</td>'+
		'<td'+((FOOTERSEARCH == "on" && JSdigitalGuideID != 9) ? ' class="color1">'+FOOTER_SEARCH() : '>&nbsp;')+'</td>'+
		'</tr>'+
		'<tr class="color1">'+
		'<td colspan="3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="5"></td>'+
		'</tr>'+
		'</table>');
	} else {
		document.write('<table border="0" cellpadding="0" cellspacing="0" width="100%">'+
		'<tr class="color1">'+
		'<td><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="7"></td>'+
		'</tr>'+
		'</table>');
	}
	document.write('<table border="0" cellpadding="2" cellspacing="0" width="100%">');
	if (PORTFOLIOBOX == "on") {
		document.write('<tr class="color1">'+
		'<td width="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>'+
		'<td width="100%" colspan="2" class="color9">'+PORTFOLIO_BOX()+'</td>'+
		'<td width="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td>'+
		'</tr>');
	}
	document.write('<tr class="color1">'+
	'<td width="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td>'+
	'<td class="textOnColor1"><b>All Rights Reserved, <a href="http://searchWebServices.techtarget.com/copyright/0,289135,sid26,00.html" class="textOnColor1"><span class="bold">Copyright 2001 - 2006</span></a>, TechTarget</b></td>'+
	'<td align="right" nowrap><a href="http://www.techtarget.com/html/privacy_policy.html" target="_blank" class="textOnColor1">Privacy Statement</a></td>'+
	'<td width="1"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1"></td>'+
	'</tr>'+
	 '<tr class="color1"><td colspan="4"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="4"></td></tr>'+
	'</table>');
	document.write(LIFTSTUDY_QUEUE());
	if (ISFIXEDWIDTH) document.write(CLOSE_FIXED_WIDTH_TABLE_DISPLAY_CODE_3());
	document.write(CLOSE_CENTER_PAGE());
	if (typeof f360I_TRACKING == "function") document.write(f360I_TRACKING());
}

function CLOSE_FIXED_WIDTH_TABLE_DISPLAY_CODE_3() {
	return '</td></tr></table>';
}
 


	
	function buildOmedaURL(p)
{
	var omedaBaseURL = '';				
	var currentURL = window.location.search;
	if(currentURL.indexOf('Offer=') != -1)
		var offerValue = currentURL.substring(currentURL.indexOf('Offer=')+6,currentURL.length);
	else
		var offerValue = '';
	var omedaURL = omedaBaseURL + '?Offer=' + p + offerValue + '&p=' + p + offerValue + '&ttURL=http%3A%2F%2FsearchWebServices%2Etechtarget%2Ecom%2Fregistration%2Fomeda%2F1%2C%2Cmag3%2C00%2Ehtml&nextURL=http%3A%2F%2FsearchWebServices%2Etechtarget%2Ecom%2FmagConfirm%2F';
	window.location = omedaURL;			
}
 if (typeof Array.prototype.push != "function") Array.prototype.push = function () {
		var args = Array.prototype.push.arguments, len = args.length;
		for (var i = 0; i < len; i++) this[this.length] = args[i];
		return this.length;
	}
	

   /* Cookie Functions */

	var allcookies = document.cookie;

	function cookieExists(name) {return allcookies.indexOf(name + "=")}

	function getCookieValue(name) {
		var pos = allcookies.indexOf(name + "=");
		if (pos != -1) {
			var start = pos + name.length + 1;
			var end = allcookies.indexOf(";",start);
			if (end == -1) end = allcookies.length;
			var value = allcookies.substring(start, end);
			return value;
		} else {
			return "";
		}
	}

	function getChipValue(cookiename,chipname) {
		var cookievalue = getCookieValue(cookiename);
		if (cookievalue != "") {
			if (cookievalue.indexOf(chipname) != -1) {
				var start = unescape(cookievalue.substring(cookievalue.indexOf(chipname) + chipname.length));
				var end = start.substring(0,start.indexOf(";"));
				if (!end) end = start.substring(0, start.length);
				var regexp = /(\W)/g;;
				var value = end.replace(regexp," ");
				return value;
			} else {
				return "";
			}
		} else {
			return "";
		}
	}

	function setSessionCookie (name, value) {
		document.cookie = name + "=" + value + ";path=/" + ";domain=.techtarget.com";
	}

	function getDisplayName() {return getChipValue("Datav2", "DispName")}
	function getHandle() {return getChipValue("Datav2", "Handle")}

  /* Login and User Info Section */
	var allcookies = document.cookie;
	var indexLogin = allcookies.indexOf("Datav2");
	var indexProps = allcookies.indexOf("Datav2");
	var indexProps2 = allcookies.indexOf("uidLoggedIn");
	var SiteList = unescape(allcookies.substring(allcookies.indexOf("Site", indexProps)+4));
	var thisSite = SiteList.indexOf(",26,");
	var loggedIn = (indexProps != -1 && thisSite != -1) ? 1 : -1;
	var uidLoggedIn = (indexProps2 != -1 && thisSite != -1) ? 1 : -1;
	var indexIPC = getCookieValue("IPC");
	var ipcLoggedIn = (indexIPC != "") ? 1 : -1;	
	var beginName = unescape(allcookies.substring(allcookies.indexOf("DispName",indexProps)+8));
	var endName = beginName.substring(0,beginName.indexOf(";"));
	var regexp = /(\+)/g;;
	var DisplayName = endName.replace(regexp," ");
	var ttUser = (indexLogin != -1 && indexProps != -1) ? 1 : -1;

	/* magazine-based access */
	var accessMONYY = getChipValue("magAccess","sid26");
	var validAccessValues = '';
	if (accessMONYY == '') var userContentAccess = false;
	else if (validAccessValues.indexOf(accessMONYY) != -1)
		var userContentAccess = true;
		else var userContentAccess = false;
	
	
	/* Offer cookie */
	var locationOffer = document.location.search.indexOf("Offer=");
	if (locationOffer != -1) {
	    var Offer = document.location.search.substring(locationOffer+6,document.location.search.length);
		if (Offer.indexOf("&") != -1) {
			Offer = Offer.substring(0,Offer.indexOf("&"));
		}
	    var underscoreOffer = "-"+Offer;
	    setSessionCookie("Offer",Offer);
	} else {
	    var underscoreOffer = "";
	}

	/* Turn off interstitials if URL parameter int=off */
	var interstitialSwitchValue = "on";
	var interstitialSwitch = document.location.search.indexOf("int=");
	if (interstitialSwitch != -1) {
		interstitialSwitchValue = document.location.search.substring(interstitialSwitch+4,document.location.search.length);
		if (interstitialSwitchValue.indexOf("&") != -1) {
			interstitialSwitchValue = interstitialSwitchValue.substring(0,interstitialSwitchValue.indexOf("&"));
		}
	}

  /* Member Update Section */
	var memUpd = -1;
	var memberUpdate = "on";
	var memberUpdateOverride = (typeof JSmemberUpdateOverride == "undefined") ? -1 : JSmemberUpdateOverride;
	if (memberUpdate == "on" && loggedIn == 1) {
		var mu1 = getCookieValue("mu1");
		if (mu1 == "") memUpd = 1;
		if (mu1 != 1 && mu1 != "") {
			var oneDay = (24*(60*(60*1000)));
			var cDate = (new Date(mu1)).getTime();
			var tDate = cDate+oneDay;
			var nowDate = (new Date()).getTime();
			if (nowDate > tDate) memUpd = 1;
		}
	}

  /* Lift Study Section */
	var LSvalue = "";
	var LSuser = "";
	var lsbool = "";
	if (allcookies.indexOf("LS=") != -1 && JSadCategory != "") {
		LSvalue = getCookieValue("LS");
		LSuser = LSvalue.substr(LSvalue.indexOf(":")+1);
		LSvalue = LSvalue.substr(0,LSvalue.indexOf(":"));
		if (LSvalue.substring(LSvalue.length-1,LSvalue.length) == "A") {
			lsbool = "true";
		}
		if (allcookies.indexOf("LSA=") == -1 && lsbool == "true") {
			setSessionCookie("LSA",1);
		} else {
			if (getCookieValue("LSA") == 1 && lsbool == "true") {
				setSessionCookie("LSA",2);
			}
		}
	}

  /* Variables Section */
	var JSdigitalGuideID = "26";
	var siteDisplayCode = 3;
	var ISHOME = (typeof JSisHomePage == "undefined") ? false : eval(JSisHomePage);
	var ISEXTERNAL = (typeof JSexternal == "undefined") ? false : eval(JSexternal);
	var ISFIXEDWIDTH = (typeof JSfixedWidth == "undefined") ? true : eval(JSfixedWidth);
	var PORTFOLIOBAND = (typeof JSportfolioStrip == "undefined") ? "on" : JSportfolioStrip;
	var USERINFO = (typeof JSuserInfo == "undefined") ? "on" : JSuserInfo;
	var ALTLOGIN = (typeof JSlinkLogin == "undefined") ? "no" : JSlinkLogin;
	var ALTLOGOUT = (typeof	JSlinkLogout == "undefined") ? "no" : JSlinkLogout;
	var LOGO = (typeof JSlogo == "undefined") ? "on" : JSlogo;
	var BYLINE = (typeof JSbyline == "undefined") ? "on" : JSbyline;
	var MEDIALINKS = (typeof JSmediaLinks == "undefined") ? "on" : JSmediaLinks;
	var LEADERBOARD = (typeof JSleaderBoard == "undefined") ? "off" : JSleaderBoard;
	var HEADERNAV = (typeof JSnavHeader == "undefined") ? "on" : JSnavHeader;
	var nsSiteDgROM = "on";
	var ROLLOVERMENUS = (typeof JSrolloverMenus == "undefined") ? nsSiteDgROM : (nsSiteDgROM == "on") ? JSrolleverMenus : "off";
	var HEADERSEARCH = (typeof JSsearchHeader == "undefined") ? "on" : JSsearchHeader;
	var SPONSORBANNER = (typeof JSsponsorBanner == "undefined") ? "off" : JSsponsorBanner;
	var FOOTERMEDIABAR = (typeof JSfooterMediaBar == "undefined") ? "on" : JSfooterMediaBar;
	var FOOTERNAV = (typeof JSnavFooter == "undefined") ? "on" : JSnavFooter;
	var FOOTERLINKS = (typeof JSoptlinksFooter == "undefined") ? "on" : JSoptlinksFooter;
	var FOOTERSEARCH = (typeof JSsearchFooter == "undefined") ? "on" : JSsearchFooter;
	var PORTFOLIOBOX = (typeof JSportfolioFooter == "undefined") ? "on" : JSportfolioFooter;
	var PAGE_LOADED = false; //Cross-browser global indicator for page readyState
	if (typeof adDcopt == "undefined") var adDcopt = "ist";
	var INTERSTITIAL = (typeof JSadInterstitial == "undefined") ? "off" : JSadInterstitial;
	if (INTERSTITIAL == "on" && interstitialSwitchValue == "off") INTERSTITIAL = "off";
	if (INTERSTITIAL == "off") adDcopt = "";
	var ipcON = "on";
	var clickThruLive = 'off';


	var isNS = 0, isIE = 0, isOP = 0, isXX = 0, apV = 1;
var isMac = 0, isWin = 0, isX = 0;
var isDHTML = 0, isID = 0, isAll = 0, isLayers = 0;
if (navigator.userAgent.indexOf('Opera') != -1)
{isOP = 1;
var op = navigator.userAgent.indexOf('Opera') + 6;
apV = parseFloat(navigator.userAgent.substring(op));
if (isNaN(apV)) apV = parseFloat(navigator.appVersion);}
else if (navigator.appName == "Netscape")
{isNS = 1;
var ns = navigator.userAgent.lastIndexOf('/') + 1;
apV = parseFloat(navigator.userAgent.substring(ns));
if ((isNaN(apV)) || (apV > 10))
apV = parseFloat(navigator.appVersion);}
else if (navigator.appName == "Microsoft Internet Explorer")
{isIE = 1;
var ie = navigator.appVersion.indexOf('MSIE') + 5;
apV = parseFloat(navigator.appVersion.substring(ie));}
else
{isXX = 1;
apV = parseFloat(navigator.appVersion);}
if (navigator.appVersion.indexOf('Macintosh') != -1) isMac = 1;
else if (navigator.appVersion.indexOf('Windows') != -1) isWin = 1;
else isX = 1;
if ((isMac) && (document.all)) isAll = 1, isDHTML = 1;
else if (document.getElementById) isID = 1, isDHTML = 1;
else if (document.all) isAll = 1, isDHTML = 1;
else if (document.layers) isLayers = 1, isDHTML = 1;
function getObj(objID) {
if (typeof objID == "string") {
if (isID) return (document.getElementById(objID));
if (isAll) return (document.all[objID]);
if (isLayers) return (document.layers[objID]);
}}
function getStyle(obj,cssProp) {
var cssValue = obj.style[cssProp];
if (!cssValue)
if (document.defaultView)
cssValue = document.defaultView.
getComputedStyle(obj,null).getPropertyValue(cssProp);
else if (obj.currentStyle)
cssValue = obj.currentStyle[cssProp];
return (cssValue);
}
function findLeft(obj) {
if ((isAll) && (obj.clientLeft)) return (obj.clientLeft);
if ((isLayers) && (obj.pageX)) return (obj.pageX);
var pos;
if (getStyle(obj,'position') == "absolute") {
pos = parseFloat(getStyle(obj,'left'));
if (!isNaN(pos)) return (pos);
pos = parseFloat(getStyle(obj,'pixelLeft'));
if (!isNaN(pos)) return (pos);
}
pos = 0;
if (obj.offsetParent)
while (obj.offsetParent) {
pos += obj.offsetLeft;
obj = obj.offsetParent;
}
else if (obj.x) pos += obj.x;
return (pos)
}
function findTop(obj) {
if ((isAll) && (obj.clientTop)) return (obj.clientTop);
if ((isLayers) && (obj.pageY)) return (obj.pageY);
var pos;
if (getStyle(obj,'position') == "absolute") {
pos = parseFloat(getStyle(obj,'top'));
if (!isNaN(pos)) return (pos);
pos = parseFloat(getStyle(obj,'pixelTop'));
if (!isNaN(pos)) return (pos);
}
pos = 0;
if (obj.offsetParent)
while (obj.offsetParent) {
pos += obj.offsetTop;
obj = obj.offsetParent;
}
else if (obj.y) pos += obj.y;
return (pos);
}
function findHeight(obj) {
if ((isAll) && (obj.clientHeight)) return (obj.clientHeight);
if ((isLayers) && (obj.height)) return (obj.height);
var pos;
pos = parseFloat(getStyle(obj,'height'));
if (!isNaN(pos)) return (pos);
pos = parseFloat(getStyle(obj,'pixelHeight'));
if (!isNaN(pos)) return (pos);
if (obj.offsetHeight) return (obj.offsetHeight);
}
function findBottom(obj) {
return (findTop(obj) + findHeight(obj));
}
function moveObjectTo(obj,x,y) {
if (obj.moveTo)
obj.moveTo(x,y);
else {
obj.style.left = x + "px";
obj.style.top = y + "px";
}}
function moveObjectBy(obj,deltaX,deltaY) {
if (obj.moveBy)
obj.moveBy(deltaX,deltaY);
else {
obj.style.left = (findLeft(obj) + deltaX) + "px";
obj.style.top = (findTop(obj) + deltaY) + "px";
}}
function setVisibility(obj) {
var state = getStyle(obj,'visibility');
if ((state == "hidden") || (state == "hide"))
obj.style.visibility = "visible";
else if ((state == "visible") || (state == "show"))
obj.style.visibility = "hidden";
else obj.style.visibility = "visible";
}
function setClip(obj,clipTop,clipRight,clipBottom,clipLeft) {
if ((isLayers) && (obj.layers)) obj.clip.top = clipTop, obj.clip.right = clipRight,
obj.clip.bottom = clipBottom, obj.clip.left = clipLeft;
else obj.style.clip = "rect(" + clipTop + "px " + clipRight + "px " + clipBottom + "px " + clipLeft + "px)";
}
function setMargin(obj,marginTop,marginRight,marginBottom,marginLeft) {
obj.style.margin = marginTop + "px " + marginRight + "px " + marginBottom + "px " + marginLeft + "px";
}

  /* Write out CSS */
	if (isMac) {
		//IE 5 for Mac will not allow rules added to linked stylesheets.
		if (isIE && ISFIXEDWIDTH) document.write('<style type="text/css"></style>\n');
		document.write('<link rel="stylesheet" type="text/css" href="http://media.techtarget.com/digitalguide/stylesheets/dgmac.css">\n');
		document.write('<link rel="stylesheet" type="text/css" href="http://media.techtarget.com/digitalguide/stylesheets/searchWebServicesmac.css">\n');
	} else if (isWin) {
		document.write('<link rel="stylesheet" type="text/css" href="http://media.techtarget.com/digitalguide/stylesheets/dgwin.css">\n');
		document.write('<link rel="stylesheet" type="text/css" href="http://media.techtarget.com/digitalguide/stylesheets/searchWebServiceswin.css">\n');
	} else {
		document.write('<link rel="stylesheet" type="text/css" href="http://media.techtarget.com/digitalguide/stylesheets/dgother.css">\n');
		document.write('<link rel="stylesheet" type="text/css" href="http://media.techtarget.com/digitalguide/stylesheets/searchWebServicesother.css">\n');
	}
	document.write('<link rel="stylesheet" type="text/css" href="http://media.techtarget.com/digitalguide/stylesheets/DG.css">\n');
	document.write('<link rel="stylesheet" type="text/css" href="http://media.techtarget.com/digitalguide/stylesheets/searchWebServices.css">\n');
	
		
	  /*
	   Force login if content is members only.
	   Redirect to top in case document is loaded in a frame or iframe.
	*/
	var forMembersOnly = (typeof JSmembersOnly != "undefined" && JSmembersOnly == "on") ? true : false; 
	var offerPos = document.location.search.indexOf("Offer=");
	if (offerPos != -1) {
	    var offerValue = document.location.search.substring(offerPos+6,document.location.search.length);
		if (offerValue.indexOf("&") != -1) {
			offerValue = offerValue.substring(0,offerValue.indexOf("&"));
		}
	} else var offerValue = "";	

	/* 
		Auto-login for users coming from newsletters passing a valid UserID
	 */
	if ( (forMembersOnly) && uidLoggedIn != 1 &&  loggedIn != 1 && (window.location.href.indexOf("uid") != -1) ) {
		var uidString = getURLParam("uid");
		var uidArray = uidString.split("=");
		var uid = uidArray[1];
		//var errorString = 'inside first members only check\n\nindexLogin: [' + indexLogin + ']\nindexProps: [' + indexProps + ']\nindexProps2: [' + indexProps2 + ']\nthisSite: [' + thisSite + ']\nloggedIn: [' + loggedIn + ']\nuidLoggedIn: [' + uidLoggedIn + ']\nindexIPC: [' + indexIPC + ']\nipcLoggedIn: [' + ipcLoggedIn + ']\nbeginName: [' + beginName + ']\nendName: [' + endName + ']\nDisplayName: [' + DisplayName + ']\nttUser: [' + ttUser + ']\n';
		//alert(errorString);
		var NextURL = window.top.location.href;
		if (NextURL.indexOf("/ttCMAv2/Production_Center/Preview_Form_v2/1,2563,,00.html") == -1) {
			var redirectURL;
			if (typeof JSmembersLoginURL == "undefined" || JSmembersLoginURL == "") {
				redirectURL = (typeof JSlinkLogin != "undefined") ? JSlinkLogin : "http://searchWebServices.techtarget.com/loginMembersOnly/1,289498,sid26,00.html";
			} else {
				redirectURL = ((JSmembersLoginURL.indexOf("http://searchWebServices.techtarget.com") == 0) ? "" : "http://searchWebServices.techtarget.com") + JSmembersLoginURL;
			}
			redirectURL += '?'			
			if(offerValue != '') redirectURL += 'Offer=' + offerValue + '&'; 
            if(NextURL != '') redirectURL += 'NextURL=' + escape(NextURL);
			window.top.location.replace(redirectURL);			
		}
	}
	else if (forMembersOnly && loggedIn != 1 && uidLoggedIn != 1 && siteDisplayCode != 1) {
		var NextURL = window.top.location.href;
		if (NextURL.indexOf("/ttCMAv2/Production_Center/Preview_Form_v2/1,2563,,00.html") == -1) {
			var redirectURL;
			if (typeof JSmembersLoginURL == "undefined" || JSmembersLoginURL == "") {
				redirectURL = (typeof JSlinkLogin != "undefined") ? JSlinkLogin : "http://searchWebServices.techtarget.com/loginMembersOnly/1,289498,sid26,00.html";
			} else {
				redirectURL = ((JSmembersLoginURL.indexOf("http://searchWebServices.techtarget.com") == 0) ? "" : "http://searchWebServices.techtarget.com") + JSmembersLoginURL;
			}
			redirectURL += '?'
			if(offerValue != '') redirectURL += 'Offer=' + offerValue + '&'; 
            if(NextURL != '') redirectURL += 'NextURL=' + escape(NextURL);
			window.top.location.replace(redirectURL);
		}
	}
	else if (siteDisplayCode == 1 && forMembersOnly && !userContentAccess) {
		redirectURL = 'http://searchWebServices.techtarget.com/magLogin/1,291245,sid26,00.html';			
		if(offerValue != '') redirectURL += '?Offer=' + offerValue; 
		document.cookie = "strgArticleURL=" + window.top.location.href + ";path=/";
		window.top.location.replace(redirectURL);
	}

	/*
	   Force IPC login if content is members only.
	   Redirect to top in case document is loaded in a frame or iframe.
	*/
	var forIPCMembersOnly = (typeof JSIPCmembersOnly != "undefined" && JSIPCmembersOnly == "on") ? true : false;
	if (forIPCMembersOnly && ipcLoggedIn != 1) {
		var NextURL = window.top.location.href;
		if (NextURL.indexOf("/ttCMAv2/Production_Center/Preview_Form_v2/1,2563,,00.html") == -1) {
			var redirectURL;
			if (typeof JSIPCmembersLoginURL == "undefined" || JSIPCmembersLoginURL == "") {
				redirectURL = (typeof JSIPClinkLogin != "undefined") ? JSIPClinkLogin : "http://searchWebServices.techtarget.com/ITKnowledgeExchange/0,294907,sid26,00.html";
			} else {
				redirectURL = ((JSIPCmembersLoginURL.indexOf("http://searchWebServices.techtarget.com") == 0) ? "" : "http://searchWebServices.techtarget.com") + JSIPCmembersLoginURL;
			}
			window.top.location.replace(redirectURL);
		}
	}	

   /* custom Microsoft tracking iframes */
	if (typeof tt_hbxCL_id != "undefined") {
		if ( tt_hbxCL_id == 281) {
			// SQLServer
			document.write('<iframe src="http://view.atdmt.com/MRT/iview/tchtritp0030003457mrt/direct/01?click=" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" topmargin="0" leftmargin="0" allowtransparency="true" width="1" height="1">');
			document.write('<a href="http://clk.atdmt.com/MRT/go/tchtritp0030003457mrt/direct/01/" target="_blank"><img src="http://view.atdmt.com/MRT/view/tchtritp0030003457mrt/direct/01/"/></a></iframe>');
		} else if ( (tt_hbxCL_id == 323) || (tt_hbxCL_id == 201) || (tt_hbxCL_id == 161) ) {		
			// Security
			document.write('<iframe src="http://view.atdmt.com/MRT/iview/tchtritp0020004932mrt/direct/01?click=" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" topmargin="0" leftmargin="0" allowtransparency="true" width="1" height="1">');
			document.write('<a href="http://clk.atdmt.com/MRT/go/tchtritp0020004932mrt/direct/01/" target="_blank"><img src="http://view.atdmt.com/MRT/view/tchtritp0020004932mrt/direct/01/"/></a></iframe>');			
		}
	}

	
	 /* testing display */
	if (window.location.search.indexOf("wrData=on") != -1) document.cookie="wrData=on; path=/";
	if (window.location.search.indexOf("wrData=off") != -1) document.cookie="wrData=off; path=/";
	
  /* Web Reporting */

	function getRptSiteID(siteName) {
		// for backward compatibility
		return 'DM5211140NRV83EN3';
	}

	function getURLParam(param) {
		var paramValue = param + "=";
		var searchValue = window.location.search.toLowerCase();
		var searchValueParam = "";
		if (searchValue.indexOf(paramValue) != -1) {
			searchValueParam = window.location.search.substring(searchValue.indexOf(paramValue),searchValue.length);
			if (searchValueParam.indexOf("&") != -1) searchValueParam = searchValueParam.substring(0,searchValueParam.indexOf("&"));
		}
		return searchValueParam;
	}
	function getURLParamValue(param) {
		var paramValue = param + "=";
		var searchValue = window.location.search.toLowerCase();
		var searchValueParam = "";
		if (searchValue.indexOf(paramValue) != -1) {
			searchValueParam = window.location.search.substring(searchValue.indexOf(paramValue),searchValue.length);
			if (searchValueParam.indexOf("&") != -1) searchValueParam = searchValueParam.substring(0,searchValueParam.indexOf("&"));
		}
		searchValueParam = searchValueParam.substring((param.length)+1,searchValueParam.length);
		return searchValueParam;
	}
	function getSearchEngineReferrer() {
		//if user is referred from search engine, mark them
		//if user remains on our sites, keep them marked
		//else remove them
		var r = document.referrer;
		var s = "";
		var t = (document.cookie.indexOf('ref=') != -1) ? document.cookie.substring(document.cookie.indexOf('ref=') + 4, document.cookie.length) : 'null';
		if (t != 'null' && t.indexOf(';') != -1) t = t.substring(0,t.indexOf(';'));
		if (t != 'null' && r.indexOf('techtarget.com') != -1) s = t;
		if (r.indexOf('google') != -1) s = 'Google';
		if (r.indexOf('search.yahoo.com') != -1) s = 'Yahoo';
		if (r.indexOf('search.msn.com') != -1) s = 'MSN';
		if (r.indexOf('web.ask.com') != -1) s = 'AskJeeves';
		if (r.indexOf('altavista') != -1) s = 'AltaVista';
		if (r.indexOf('search.aol.com') != -1) s = 'AOL Netfind';
		if (s != "") {
			document.cookie="ref="+s+"; path=/; domain=techtarget.com";
			return s;
		} else {
			return '-1';
		}
	}

	function getVisitorSegment() {
		var uStatus = new String();
		var uStatusRollup = new String();
		if(thisSite != -1) uStatus += "7";
		if(indexLogin != -1){
			if(uStatus != "") uStatus += ","
			uStatus += "8";
		}
		if(ipcLoggedIn == '1'){
			if(uStatus != "") uStatus += ","
			uStatus += "9";
		}
		
		if(ttUser == '1'){
			uStatusRollup = "6";
		}
		if(uStatus == '') uStatus = '*';
		if(uStatusRollup == '') uStatusRollup = '*';

		uStatus += ";" + uStatusRollup; //combine value with Global Rollup
		if(tt_hbxExtraAcct) uStatus += ";*"
		return uStatus;
	}
	var wlh = window.location.hostname.toLowerCase(window.location.hostname);
	if (wlh.indexOf("whatis") != -1) {
		tt_rptSiteName = "whatis";
	} else if (wlh.indexOf("expertanswercenter") != -1) {
		tt_rptSiteName = "expertanswercenter";
	} else if (wlh.indexOf("knowledgestorm") != -1) {
		tt_rptSiteName = window.location.pathname.substring(1, window.location.pathname.indexOf("/", 1));
	} else {
		tt_rptSiteName = wlh.substring(wlh.indexOf("search"),wlh.indexOf("."));
	}
	
	var tt_rptGlobalID = "DM5212204PCA83EN3";
	var tt_rptSiteID = "DM5211140NRV83EN3";
	var tt_rptExtraID = "DM56031759VS83EN3";
	var tt_rptCampaignGoal = "";

	function WEB_REPORTING() {
		if(typeof tt_hbx404 == "undefined") var tt_hbx404 = false;
		if(tt_hbx404) return HBX_ERROR();
		else return HBX_PAGE();
	}
	
	
function HBX_PAGE() {
	var strWebRptg = new String('<!--WEBSIDESTORY CODE HBX1.0 (Universal)-->\n' +
	'<!--COPYRIGHT 1997-2004 WEBSIDESTORY,INC. ALL RIGHTS RESERVED. U.S.PATENT No. 6,393,479B1. MORE INFO:http://websidestory.com/privacy-->\n' +
	'<script language="javascript">\n' +
	'var _hbEC=0,_hbE=new Array;function _hbEvent(a,b){b=_hbE[_hbEC++]=new Object();b._N=a;b._C=0;return b;}\n' +
	'var hbx=_hbEvent("pv");hbx.vpc="HBX0100u";hbx.gn="ehg-techtarget.hitbox.com";\n' +
	'//BEGIN EDITABLE SECTION\n' +
	'//CONFIGURATION VARIABLES\n' +
	'if(typeof tt_hbxTemplateID == "undefined") var tt_hbxTemplateID = "";\n' +
	'if(typeof tt_hbxApplicationPath == "undefined") var tt_hbxApplicationPath = "";\n' +
	'if(typeof tt_hbxSitePath == "undefined") var tt_hbxSitePath = "/searchWebServices";\n' +
	'if(typeof tt_hbxExtraAcct == "undefined") var tt_hbxExtraAcct = false;\n' +
	'if(typeof tt_hbxMLC == "undefined") var tt_hbxMLC = "";\n' +
	'if(typeof tt_hbx404 == "undefined") var tt_hbx404 = false;\n' +
	'if(typeof JSv3ic == "undefined") var JSv3ic = false;\n' +
	'hbx.acct=tt_rptSiteID + ";" + tt_rptGlobalID;//ACCOUNT NUMBER(S)\n' +
	'if(tt_hbxExtraAcct) hbx.acct+= ";" + tt_rptExtraID;\n' +
	'hbx.pn = ""; //pagename \n' +
	'var wlp = window.location.pathname.replace(eval("/\\\\//g"),"-");\n' +
	'wlp = wlp.substring(1,wlp.length);\n' +
	'if (wlh.indexOf("knowledgestorm") != -1) wlp = "knowledgestorm-" + wlp;\n' +
	'var oidValue = ""; \n' +
	'//get path name and oid value\n' +
	'if (tt_hbxTemplateID == "195") {\n' +
	'	hbx.pn = "home";\n' +
	'} else if (tt_hbxTemplateID == "359") {\n' +
	'	hbx.pn = "whome";\n' +
	'} else if (tt_hbxTemplateID == "1128") {\n' +
	'	hbx.pn = "magHome";\n' +
	'} else if (wlp == "/") {\n' +
	'	hbx.pn = "home";\n' +
	'} else if (wlp.indexOf("-0,") != -1) {\n' +
	'	hbx.pn = wlp.substring(0, wlp.indexOf("-0,"));\n' +
	'	oidValue = wlp.substring(wlp.indexOf("-0,"),wlp.length);\n' +
	'	oidSplit = oidValue.split(",");\n' +
	'	oidValue = oidSplit[2];\n' +
	'	hbx.pn += "--" + oidValue;\n' +
	'} else if (wlp.indexOf("-1,") != -1) {\n' +
	'	hbx.pn = wlp.substring(0,wlp.indexOf("-1,"));\n' +
	'	oidValue = wlp.substring(wlp.indexOf("-1,"),wlp.length);\n' +
	'	oidSplit = oidValue.split(",");\n' +
	'	oidValue = oidSplit[2];\n' +
	'	hbx.pn += "--" + oidValue;\n' +
	'} else {\n' +
	'	hbx.pn = wlp;\n' +
	'}\n' +
	'//add URL parameters\n' +
	'var searchValueOffer = getURLParam("offer");\n' +
	'var searchValueTrack = getURLParam("track");\n' +
	'var searchValueS = getURLParam("s");\n' +
	'if (searchValueOffer != "") hbx.pn += "--" + searchValueOffer;\n' +
	'if (searchValueTrack != "") hbx.pn += "--" + searchValueTrack;\n' +
	'if (searchValueS != "") hbx.pn += "--" + searchValueS;\n' +
	'hbx.pn = hbx.pn.replace(eval("/\%/g"),".");\n' +
	'if(tt_hbxMLC == "") hbx.mlc = "*"; else hbx.mlc = "";\n' +
	'hbx.mlc+=tt_hbxMLC + ";" + tt_hbxSitePath + tt_hbxMLC;//MULTI-LEVEL CONTENT CATEGORY\n' +
	'if(tt_hbxExtraAcct) { if(JSv3ic == true) hbx.mlc+=";" + tt_hbxMLC + tt_hbxSitePath; else hbx.mlc+=";" + tt_hbxApplicationPath + tt_hbxSitePath; }\n' +
	'hbx.pndef="title";//DEFAULT PAGE NAME\n' +
	'hbx.ctdef="full";//DEFAULT CONTENT CATEGORY\n' +
	'//OPTIONAL PAGE VARIABLES\n' +
	'//ACTION SETTINGS\n' +
	'hbx.lt="auto";//LINK TRACKING\n' +
	'hbx.dlf="n";//DOWNLOAD FILTER\n' +
	'hbx.dft="n";//DOWNLOAD FILE NAMING\n' +
	'hbx.elf="n";//EXIT LINK FILTER\n' +
	'//SEGMENTS AND FUNNELS\n' +
	'hbx.seg=getVisitorSegment();//VISITOR SEGMENTATION\n' +
	'hbx.fnl=(typeof wrFunnelValue == "undefined") ? "" : wrFunnelValue;//FUNNELS\n' +
	'//CAMPAIGNS\n' +
	'hbx.cmp=(typeof cmpValue == "undefined") ? "" : cmpValue;//CAMPAIGN ID\n' +
	'hbx.gp=(typeof cmpGoalValue == "undefined") ? "" : cmpGoalValue;//CAMPAIGN GOAL\n' +
	'hbx.fv="n";//FORM VALIDATION MINIMUM ELEMENTS OR SUBMIT FUNCTION NAME\n' +
	'hbx.dcmp="";//DYNAMIC CAMPAIGN ID\n' +
	'hbx.hqsp="ATTR";//RESPONSE ATTRIBUTE IN QUERY\n' +
	'hbx.fv="";//FORM VALIDATION MINIMUM ELEMENTS OR SUBMIT FUNCTION NAME\n' +
	'hbx.cmpn="";//CAMPAIGN ID IN QUERY\n' +
	'hbx.dcmpn="";//DYNAMIC CAMPAIGN ID IN QUERY\n' +
	'hbx.dcmpe="";//DYNAMIC CAMPAIGN EXPIRATION\n' +
	'hbx.dcmpre="";//DYNAMIC CAMPAIGN RESPONSE EXPIRATION\n' +
	'hbx.hra="";//RESPONSE ATTRIBUTE\n' +
	'hbx.hqsr="";//RESPONSE ATTRIBUTE IN REFERRAL QUERY\n' +
	'hbx.hlt="";//LEAD TRACKING\n' +
	'hbx.hla="";//LEAD ATTRIBUTE\n' +
	'hbx.gpn="";//CAMPAIGN GOAL IN QUERY\n' +
	'hbx.hcn="";//CONVERSION ATTRIBUTE\n' +
	'hbx.hcv="";//CONVERSION VALUE\n' +
	'hbx.cp="null";//LEGACY CAMPAIGN\n' +
	'hbx.cpd="";//CAMPAIGN DOMAIN\n' +
	'//INTERNAL SEARCH\n' +
	'var ttSearchQuery=getURLParamValue("query");\n' +
	'if(ttSearchQuery!="") {\n' +
	'var ev1=_hbEvent("search");\n' +
	'ev1.keywords=ttSearchQuery.replace(" ","+");\n' + 
	'if(typeof searchTotal == "undefined") var searchTotal = "";\n' +
	'if(searchTotal == "") {\n' +
	'ev1.results="0";} else {\n' +
	'ev1.results=searchTotal;}\n' + 
	'}\n' +
	'//CUSTOM VARIABLES\n' +
	'var asrcParam = getURLParamValue("asrc");\n' +
	'var asrc_und_1_pos = asrcParam.indexOf("_");\n' +
	'var asrcLast2 = asrcParam.substring(asrc_und_1_pos+1,asrcParam.length);\n' +
	'var asrc_und_2_pos = asrcLast2.indexOf("_");\n' +
	'var asrc_src = asrcParam.substr(0,asrc_und_1_pos);\n' +
	'var asrc_vehicle = asrcLast2.substr(0,asrc_und_2_pos);\n' +
	'var asrc_vid = asrcLast2.substr(asrc_und_2_pos+1,asrcLast2.length);\n' +
	'var psrcParam = getURLParamValue("psrc");\n' +
	'if (psrcParam.indexOf("_") != -1) psrcParam = psrcParam.substring(0,psrcParam.indexOf("_")) + "|" + psrcParam.substring(psrcParam.indexOf("_")+1, psrcParam.length);' +
	'hbx.ci="";//CUSTOMER ID\n' +
	'if(asrc_src != "") hbx.hc1=asrc_src + "|searchWebServices-" + asrc_vehicle + "-" + asrc_vid + "-" + tt_hbxGCI;//CUSTOM 1\n' +
	'else hbx.hc1="";//CUSTOM 1 if no src\n' +
	'hbx.hc2=psrcParam;//CUSTOM 2\n' +
	'hbx.hc3=tt_hbxSitePath;//CUSTOM 3\n' +
	'if(JSv3ic == true) hbx.hc3 += tt_hbxMLC; else hbx.hc3 += tt_hbxApplicationPath;\n' +
	'hbx.hc3+="|" + tt_hbxGCI;\n' +
	'hbx.hc4="";//CUSTOM 4\n' +
	'hbx.hc5="";//CUSTOM 5\n' +
	'hbx.hrf="";//CUSTOM REFERRER\n' +
	'hbx.pec="";//ERROR CODES\n' +

	'if (document.cookie.indexOf("wrData=on") != -1) {\n' +
	'	window.alert("HITBOX DATA \\n accounts (hbx.acct) = " + hbx.acct + "\\n pagename (hbx.pn) = " + hbx.pn + "\\n hbx.mlc = " + hbx.mlc + "\\n visitor segment (hbx.seg) = " + hbx.seg + "\\n funnel id (hbx.fnl) = " + hbx.fnl + "\\n campaign page (hbx.cmp) = " + hbx.cmp + "\\n goal page (hbx.gp) = " + hbx.gp + "\\n custom metric 1 (hbx.hc1) =" + hbx.hc1 + "\\n custom metric 2 (hbx.hc2) = " + hbx.hc2 + "\\n custom metric 3 (hbx.hc3) = " + hbx.hc3 + "\\n custom metric 4 (hbx.hc4) = " + hbx.hc4 + "\\n custom metric 5 (hbx.hc5) = " + hbx.hc5);\n' +
	'}\n' +

	'//INSERT CUSTOM EVENTS\n' +
	'//END EDITABLE SECTION\n' +
	'//REQUIRED SECTION. CHANGE "YOURSERVER" TO VALID LOCATION ON YOUR WEB SERVER (HTTPS IF FROM SECURE SERVER)\n' +
	'</script><script language="javascript1.1" defer src="http://searchWebServices.techtarget.com/hbx.js"></script>\n' +
	'<!--END WEBSIDESTORY CODE-->\n');
	if (window.location.search.indexOf('wrTest=on') != -1) window.alert(strWebRptg);
	return strWebRptg;
	}
	
function HBX_ERROR()
{
		var strWebRptg = new String('<!--WEBSIDESTORY CODE HBX1.5 (Error)-->\n' +
	'<!--COPYRIGHT 1997-2005 WEBSIDESTORY,INC. ALL RIGHTS RESERVED. U.S.PATENT No.6,393,479B1 & 6,766,370. INFO:http://websidestory.com/privacy-->\n' +
	'<script language="javascript">\n' +
	'var hbx=new Object();hbx.vpc="HBX0150.02e";hbx.gn="ehg-techtarget.hitbox.com";\n' +
	'//BEGIN EDITABLE SECTION\n' +
	'//CONFIGURATION VARIABLES\n' +
	'hbx.acct="DM5211140NRV83EN3;DM5212204PCA83EN3";\n' +
	'hbx.mlc="ERROR"; //multi-level content category\n' +
	'//END EDITABLE SECTION\n' +
	'var _sv=10;\n' +
	'</script><script language="javascript1.1">_sv=11</script><script language="javascript">\n' +
	'function _A(v){return escape(v)}function _D(v){return(typeof eval("window._"+v)!=_hud)?eval("window._"+v):""}\n' +
	'function _II(a,b,c){return a.indexOf(b,c?c:0)}function _E(a){var b="",d=a.split(",");for(var c=0;c<d.length;c++)b+="&"+d[c]+"="+_A(_D(d[c]));return b}\n' +
	'var _hud="undefined",_ss="na",_sc="na",_cy="u",_hp="u",_vpc=hbx.vpc,_rf=document.location+"";var __r=".referrer";_er=eval("document"+__r)+"";\n' +
	'if((_er==_hud)||(_er==""))_er="bookmark";if(_II(document.cookie,"CP=")!=-1){_ce="y"}else{\n' +
	'document.cookie="CP=nul"+"l*; path=/; expires=Wed, 1 Jan 2020 00:00:00 GMT";_ce=(_II(document.cookie,"CP=")!=-1)?"y":"n"};\n' +
	'var _bnI=_II(navigator.appName,"Microsoft")>-1;var _hM=_II(navigator.userAgent,"Mac")>-1;var _I5=false;\n' +
	'if(_bnI){var _nua=navigator.userAgent,_is=_II(_nua,"MSIE"),_if=_II(_nua,".",_is);if(_if>_is)_I5=_nua.substring(_is+5,_if)>=5}\n' +
	'if(window.screen){_sv=12;_ss=screen.width+"*"+screen.height;_sc=_bnI?screen.colorDepth:screen.pixelDepth;\n' +
	'if(_sc==_hud)_sc="na"}var _ra=new Array();if(_ra.toSource||(_bnI&&_ra.shift))_sv=13;if(_I5&&!_hM){\n' +
	'if(_II(""+navigator.appMinorVersion,"Privacy")>-1)_ce="p";if(document.body&&document.body.addBehavior){document.body.addBehavior("#default#homePage");\n' +
	'_hp=document.body.isHomePage(location.href)?"y":"n";document.body.addBehavior("#default#clientCaps");_cy=document.body.connectionType}}\n' +
	'var _arg=(location.protocol=="https:"?"https://":"http://")+hbx.gn+"/HG?hc=&hb="+hbx.acct+"&cd=1&l=e"+"&ja="+(navigator.javaEnabled()?"y":"n")+\n' +
	'_E("rf,er,ce,vpc,sv,ss,sc,cy,hp");if(typeof eval("hbx.mlc")!=_hud&&_II(hbx.mlc,"CONTENT+CATEGORY")<0)_arg+="&vcon="+_A(hbx.mlc);\n' +
	'var _hbi=new Image();_hbi.src=_arg+"&hid="+Math.random();</script>\n' +
	'<script language="javascript">if(_sv<11){document.write("<img src="+_arg+" border=0 height=1 width=1>")}</script>\n' +
	'<!--END WEBSIDESTORY CODE-->\n');
	if (window.location.search.indexOf('wrTest=on') != -1) window.alert(strWebRptg);
	return strWebRptg;
}	

	

  if (typeof JSwebReporting == "undefined") {
  	var wr = getCookieValue("wrData");
	if (wr == "") {
		var WEBREPORTING = ("on" == "") ? "off" : "on";
	} else var WEBREPORTING = wr;
  } else var WEBREPORTING = JSwebReporting;

  /* Header Section */
	function PAGE_HEADER() {
		if(siteDisplayCode == 1) HEADER_DISPLAY_CODE_1();
		else if(siteDisplayCode == 3) HEADER_DISPLAY_CODE_3();
		else HEADER_DISPLAY_CODE_0();				
	}
	
	function MEMBER_UPDATE() {
		return '<iframe src="http://searchWebServices.techtarget.com/memberUpdateCheck/1,294121,sid26,00.html" name="memberUpdate" width="1" height="0" border="0" frameborder="0" marginheight="0" marginwidth="0" scrolling="no"></iframe>';
	}

	function OPEN_FIXED_WIDTH_TABLE() {
		if(siteDisplayCode == 3) return OPEN_FIXED_WIDTH_TABLE_DISPLAY_CODE_3();
		else return OPEN_FIXED_WIDTH_TABLE_DISPLAY_CODE_0();				
	}

	function PORTFOLIO_BAND() {
		if(siteDisplayCode == 3) return PORTFOLIO_BAND_DISPLAY_CODE_3();
		else if(siteDisplayCode == 1) return PORTFOLIO_BAND_DISPLAY_CODE_1();
		else return PORTFOLIO_BAND_DISPLAY_CODE_0();				
	}

	
	function HEADER_CORE() {
		return HEADER_CORE_DISPLAY_CODE_3(); 
	}
	
	 function MEDIA_LINKS() {
		if(siteDisplayCode == 1) return MEDIA_LINKS_DISPLAY_CODE_1();
		else return MEDIA_LINKS_DISPLAY_CODE_0()
	}

	function LEADER_BOARD() {
		if(siteDisplayCode == 1) return LEADER_BOARD_DISPLAY_CODE_1();
		else if(siteDisplayCode == 3) return LEADER_BOARD_DISPLAY_CODE_3();
		else return LEADER_BOARD_DISPLAY_CODE_0();	
	}
	
	function HEADER_SEARCH() {
		if(siteDisplayCode == 1) return HEADER_SEARCH_DISPLAY_CODE_1();
		else if(siteDisplayCode == 3) return HEADER_SEARCH_DISPLAY_CODE_3();
		else if(clickThruLive == 'on') return HEADER_SEARCH_CLICKTHRU_DISPLAY_CODE_0();
		else return HEADER_SEARCH_DISPLAY_CODE_0();			
	}

	function SPONSOR_BANNER() {
		if(siteDisplayCode == 1) return SPONSOR_BANNER_DISPLAY_CODE_1();
		else if(siteDisplayCode == 0) return SPONSOR_BANNER_DISPLAY_CODE_0();
		else return SPONSOR_BANNER_DISPLAY_CODE_0();			
	}

  /* Footer Section */
	function PAGE_NO_FOOTER() {
		document.write(LIFTSTUDY_QUEUE());
		if (ISFIXEDWIDTH) document.write(CLOSE_FIXED_WIDTH_TABLE());
		if (typeof f360I_TRACKING == "function") document.write(f360I_TRACKING());
	}

	function PAGE_FOOTER_TOP() {
		if(siteDisplayCode == 1) PAGE_FOOTER_TOP_DISPLAY_CODE_1();
		else PAGE_FOOTER_TOP_DISPLAY_CODE_0();				
	}

	function PAGE_FOOTER_BOTTOM() {
		if(siteDisplayCode == 1) PAGE_FOOTER_BOTTOM_DISPLAY_CODE_1();
		else if(siteDisplayCode == 3) PAGE_FOOTER_BOTTOM_DISPLAY_CODE_3(); 
		else PAGE_FOOTER_BOTTOM_DISPLAY_CODE_0();				
	}

	function FOOTER_LINKS() {
		if(siteDisplayCode == 1) return FOOTER_LINKS_DISPLAY_CODE_1();
		else return FOOTER_LINKS_DISPLAY_CODE_0();			
	}

	function FOOTER_SEARCH() {
		if(siteDisplayCode == 1) return FOOTER_SEARCH_DISPLAY_CODE_1();
		else return FOOTER_SEARCH_DISPLAY_CODE_0();			
	}

	function PORTFOLIO_BOX() {	
		if(siteDisplayCode == 1) return PORTFOLIO_BOX_DISPLAY_CODE_1();
		else return PORTFOLIO_BOX_DISPLAY_CODE_0();				
	}

	function LIFTSTUDY_QUEUE() {
		return '';
		//return '<iframe src="http://searchWebServices.techtarget.com/liftStudySurveyQueue/0,290887,sid26,00.html" name="Survey" width="1" height="0" border="0" frameborder="0" marginheight="0" marginwidth="0" scrolling="no"></iframe>';
	}

	 function CLOSE_FIXED_WIDTH_TABLE() {
		return '</td><td width="2" class="color3"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="2" height="1" alt=""></td></tr></table>';
	}

	function PAGE_ONLOAD() {
		if (ROLLOVERMENUS == "on" && typeof TTMS != "undefined" && TTMS.init) TTMS.init("menuBar");
		if (typeof bodyOnLoad == "function") bodyOnLoad();
		PAGE_LOADED = true;
	}

  /* Declare default events */
	window.onload = PAGE_ONLOAD;

 /* Ad Section */  


  		
	function PAGE_AD(x) {
		var showInfoLink = (typeof JSshowInfoLink == "undefined") ? false : eval(JSshowInfoLink);
		var type = (typeof eval('JSad'+x+'Type') == "undefined") ? "1" : eval('JSad'+x+'Type');
		if (type == "2") {
			return ((showInfoLink) ? eval('JSwriteADInfo(JSad'+x+'SiteValue, JSad'+x+'AreaValue, JSad'+x+'Width, JSad'+x+'Height, JSad'+x+'PositionValue, JSad'+x+'KW, JSadCategory, adDcopt, adPageID)') : '') +
			((x == 12) ? eval('JSwriteLeaderBoard2(JSad'+x+'SiteValue, JSad'+x+'AreaValue, JSad'+x+'Width, JSad'+x+'Height, JSad'+x+'PositionValue, JSad'+x+'KW, adDcopt, adPageID)') :
			eval('JSwriteAD2(JSad'+x+'SiteValue, JSad'+x+'AreaValue, JSad'+x+'Width, JSad'+x+'Height, JSad'+x+'PositionValue, JSad'+x+'KW, adDcopt, adPageID)')) + 
			eval('adDcopt = ""'); 
		} else {
			return eval('JSwriteAdBanner(JSad'+x+'Id, JSad'+x+'SiteName, JSad'+x+'PageName, JSad'+x+'SearchPageName, JSad'+x+'BannerSize, JSad'+x+'KeyWord)');
		} 
	}
	
	
	 /* Ad Functions Section */

	// Leftover variables from Cobranded.
	var dgADW, dgCTW, locationPathname;
	var coBrandPath = new Object();
	
	function getOIDValue(oidParam) {
		var oidValue = "";
		var wlp = window.location.pathname;
		if (wlp.indexOf("/0,") != -1) wlp = wlp.substring(wlp.indexOf("/0," + 3,wlp.length));
		if (wlp.indexOf("/1,") != -1) wlp = wlp.substring(wlp.indexOf("/1," + 3,wlp.length));
		if (wlp.indexOf(",00.html") != -1) wlp = wlp.substring(0,wlp.indexOf(",00.html"));
		if (wlp.indexOf(oidParam) != -1) {
			oidValue = wlp.substring(wlp.indexOf(oidParam) + oidParam.length,wlp.length);
			if (oidValue.indexOf("_") != -1) oidValue = oidValue.substring(0,oidValue.indexOf("_"));
			if (oidValue.indexOf(",") != -1) oidValue = oidValue.substring(0,oidValue.indexOf(","));
		}
		return oidValue;
	}

	function JSwriteAdBanner(id, sitename, pagename, searchpage, size, keyword) {
	    var tile = id.charAt(id.length - 1); //This obtains the tile based on the id
	    sitename = (sitename.length > 0) ? sitename : "searchWebServices.com"; //When sitename is empty default to guide.com
	    pagename = (pagename.length > 0) ? pagename : "mainpage"; //When pagename is empty default to homepage
	    searchpage = (searchpage.length > 0) ? "/" + searchpage : searchpage; //When searchpage isn't empty make it /searchpage
	    size = (size.length > 0) ? size : "468x60"; //When size is empty default to 468x60
	    var width = size.substring(0, size.indexOf("x"));
	    var height = size.substring(size.indexOf("x") + 1, size.length);
	    var bbanner = "";
	    if (!document.layers) {
	    bbanner += "<iframe src='http://ad.doubleclick.net/adi/" + sitename + "/" + pagename + searchpage + ";kw=" + keyword + ";sz=" + size + ";tile=" + tile + ";ord='" + Math.random() * 10000000 + "?' name='frame" + id + "' width='" + width + "' height='" + height + "' border='0' frameborder='0' marginheight='0' marginwidth='0' scrolling='no'>\n";
	    bbanner += "<a href='http://ad.doubleclick.net/jump/" + sitename + "/" + pagename + searchpage + ";kw=" + keyword + ";sz=" + size + ";tile=" + tile + ";ord='" + Math.random() * 10000000 + "?'>\n";
	    bbanner += "<img src='http://ad.doubleclick.net/ad/" + sitename + "/" + pagename + searchpage + ";kw=" + keyword + ";sz=" + size + ";tile=" + tile + ";ord='" + Math.random() * 10000000 + "?' width='" + width + "' height='" + height + "' border='0'></a>\n";
	    bbanner += "</iframe>\n";
	    }
	    if (document.layers) {
	    bbanner += "<ilayer id='layer" + id + "' visibility='hide' height='" + height + "' top='0' left='0'></ilayer>\n";
	    }
	    return bbanner;
	}
	function getURLParamValue(param) {
		var paramValue = param.toLowerCase() + "=";
		var searchValue = window.location.search.toLowerCase();
		var searchValueParam = "";
		if (searchValue.indexOf(paramValue) != -1) {
			searchValueParam = window.location.search.toLowerCase().substring(searchValue.indexOf(paramValue),searchValue.length);
			if (searchValueParam.indexOf("&") != -1) searchValueParam = searchValueParam.substring(0,searchValueParam.indexOf("&"));
		}
		searchValueParam = searchValueParam.substring((param.length)+1,searchValueParam.length);
		return searchValueParam;
	}


	
	function JSwriteAD2(adSiteValue, adZoneValue, width, height, adPosition, adKeyword, adDcopt, pageNum) {
	    var bbanner = "";
	    var lsKey = "off";
	    var allcookies = document.cookie;
    	var adNumber = adPosition.substring(adPosition.indexOf("_")+1, adPosition.length);
		var random = Math.round(Math.random() * 100000000);
		if (!pageNum) pageNum = Math.round(Math.random() * 100000000);
		var aamsz = width + "x" + height;
		var wlp = window.location.pathname;

		//zone
		var zone = getURLParamValue("parentZone");
		if(zone != "") adZoneValue = zone;

		//gci
		var gci = getURLParamValue("parentGci");
		if(gci == "") gci = getOIDValue("gci");

		//taxonomy
		if(typeof tt_dartTAX_id != "undefined") 
			var tax = tt_dartTAX_id;
		else
			var tax = getOIDValue("tax");
		// tax override ad group
		var adg = getURLParamValue("adg");
		if ( (typeof JSadTaxID != "undefined") && (adg == '') ) {
			adg = JSadTaxID;
		}
		//taxomomy cluster;
		if (typeof tt_hbxCL_id != "undefined")
			var clu = tt_hbxCL_id;
		else 
			var clu = getOIDValue("clu");
			
		//path name
		var pth = getURLParamValue("parentPth");
		if (pth == "") {
			var wlp = window.location.pathname.substring(1,window.location.pathname.length);
			var pth = wlp.replace(eval("/\\//g"),".");
			if (pth.indexOf(".0,") != -1) pth = pth.substring(0,pth.indexOf(".0,"));
			if (pth.indexOf(".1,") != -1) pth = pth.substring(0,pth.indexOf(".1,"));
		}
		
		//ptile
		var ptile = adPosition.substring(adPosition.indexOf('_') + 1, adPosition.length);


		//keyword
		kw = getURLParamValue("parentKw");
		if (kw != '') adKeyword = kw;

		//infocenter id
		var iid = getOIDValue("iid");
		if ( (iid == '') && (typeof JSinfoCenterID != "undefined")) {
			iid = JSinfoCenterID;
		}
		//infocenter name
		var iin = getURLParamValue("parentIin");
		if (iin == '') {
			if (typeof tt_rptInfoCenterMLC != "undefined") iin = tt_rptInfoCenterMLC;
			if ( (iin == '') && (typeof JSinfoCenterName != "undefined")) {
				iin = JSinfoCenterName;
			}
		}
		//resourcecenter id
		var rci = getURLParamValue("parentRci");
		//newsletter ad id
		var nlValue = "";
		if (window.location.search.indexOf("?ad=") != -1 || window.location.search.indexOf("&ad=") != -1) {
			var nlS = window.location.search;
			if (nlS.indexOf("?ad=") != -1) {
				nlValue = nlS.substring(nlS.indexOf("?ad=") + 4, nlS.length);
			} else {
				nlValue = nlS.substring(nlS.indexOf("&ad=") + 4, nlS.length);
			}
			if (nlValue.indexOf("&") != -1) nlValue = nlValue.substring(0, nlValue.indexOf("&"));
		}
		//track ad id
		var trackValue = "";
		if (window.location.search.indexOf("?track=") != -1 || window.location.search.indexOf("&track=") != -1) {
			var trackS = window.location.search;
			if (trackS.indexOf("?track=") != -1) {
				trackValue = trackS.substring(trackS.indexOf("?track=") + 7, trackS.length);
			} else {
				trackValue = trackS.substring(trackS.indexOf("&track=") + 7, trackS.length);
			}
			if (trackValue.indexOf("&") != -1) trackValue = trackValue.substring(0, trackValue.indexOf("&"));
		}
		//persistent ad id
		var sesValue = "";
		if (window.location.search.indexOf("?ses=") != -1 || window.location.search.indexOf("&ses=") != -1) {
			var sesS = window.location.search;
			if (sesS.indexOf("?ses=") != -1) {
				sesValue = sesS.substring(sesS.indexOf("?ses=") + 5, sesS.length);
			} else {
				sesValue = sesS.substring(sesS.indexOf("&ses=") + 5, sesS.length);
			}
			if (sesValue.indexOf("&") != -1) sesValue = sesValue.substring(0, sesValue.indexOf("&"));
		}
	    if (allcookies.indexOf("LS=") != -1 && allcookies.indexOf("LSA=") != -1) {
		var name = "LSA";
		var pos = allcookies.indexOf(name + "=");
		var start = pos + name.length + 1;
		var end = allcookies.indexOf(";",start);
		if (end == -1) end = allcookies.length;
		var LSAvalue = allcookies.substring(start, end);
		if (LSAvalue != 2) {
			name = "LS";
			pos = allcookies.indexOf(name + "=");
			start = pos + name.length + 1;
			end = allcookies.indexOf(";",start);
			if (end == -1) end = allcookies.length;
			var LSvalue = allcookies.substring(start, end);
			var LSuser = LSvalue.substr(LSvalue.indexOf(":")+1);
			LSvalue = LSvalue.substr(0,LSvalue.indexOf(":"));
			if (LSvalue.substring(LSvalue.length-1,LSvalue.length) == "A") lsKey = "on";
			LSvalue = LSvalue.substr(0,LSvalue.length-1);
			if (lsKey == "on") adKeyword = "ls" + LSvalue;
		}
	    }
		// check if we're accessing a piece of content that has "topic=XXXXX" in the URL
		var overwriteTax = false;
		if (window.location.href.indexOf("?topic=") != -1 || window.location.href.indexOf("&topic=") != -1) {
			// overwrite the tax and cluster values for DART based on the tax value in the query string
			overwriteTax = true;
			var overwriteTaxVal = "";
			var overwriteClusterVal = "";
			var topicString = window.location.href;
			if (topicString.indexOf("?topic=") != -1) {
				topicValue = topicString.substring(topicString.indexOf("?topic=") + 7, topicString.length);
			} else {
				topicValue = topicString.substring(topicString.indexOf("&topic=") + 7, topicString.length);
			}
			if (topicValue.indexOf("&") != -1) topicValue = topicValue.substring(0, topicValue.indexOf("&"));
			var evalString = eval("typeof cl_id_" + topicValue);
			if( evalString == "undefined" ) {
				var clu = 'NONE';
			} else {
				var clu = eval("cl_id_" + topicValue);
			}
			var tax = topicValue;
		}
		if (!document.layers) {
			bbanner += "<iframe src='http://ad.doubleclick.net/adi/" + adSiteValue + "/" + adZoneValue + ";pos=0;pth=" + pth  + ";kw=" + adKeyword + ";gci=" + gci + ";tax=" + tax + ";clu=" + clu + ";adg=" + adg + ";sz=" + aamsz + ";dcopt=" + adDcopt + ";ptile=" + ptile + ";iid=" + iid + ";iin=" + iin + ";rci=" + rci + ";nl=" + nlValue + ";ses=" + sesValue + ";track=" + trackValue + ";ord=" + pageNum + "?' width='" + width + "' height='" + height + "' border='0' frameborder='0' marginheight='0' marginwidth='0' scrolling='no'>\n";
			bbanner += "<a href='http://ad.doubleclick.net/jump/" + adSiteValue + "/" + adZoneValue + ";pos=0;pth=" + pth  + ";kw=" + adKeyword + ";gci=" + gci + ";tax=" + tax + ";clu=" + clu + ";adg=" + adg + ";sz=" + aamsz + ";dcopt=" + adDcopt + ";ptile=" + ptile + ";iid=" + iid + ";iin=" + iin + ";rci=" + rci + ";nl=" + nlValue + ";ses=" + sesValue + ";track=" + trackValue + ";ord=" + pageNum + "?'>\n";
			bbanner += "<img src='http://ad.doubleclick.net/ad/" + adSiteValue + "/" + adZoneValue + ";pos=0;pth=" + pth  + ";kw=" + adKeyword + ";gci=" + gci + ";tax=" + tax + ";clu=" + clu + ";adg=" + adg + ";sz=" + aamsz + ";dcopt=" + adDcopt + ";ptile=" + ptile + ";iid=" + iid + ";iin=" + iin + ";rci=" + rci + ";nl=" + nlValue + ";ses=" + sesValue + ";track=" + trackValue + ";ord=" + pageNum + "?' width='" + width + "' height='" + height + "' border='0'></a>\n";
			bbanner += "</iframe>\n";
		}
		if (document.layers) {
			bbanner += "<ilayer id='" + adPosition + "' height='" + height + "' visibility='hide' top='0' left='0'></ilayer>\n";
			ADlayer[adPosition] = "http://ad.doubleclick.net/adl/" + adSiteValue + "/" + adZoneValue + ";pos=0;pth=" + pth  + ";kw=" + adKeyword + ";gci=" + gci + ";tax=" + tax + ";adg=" + adg + ";sz=" + aamsz + ";dcopt=" + adDcopt + ";ptile=" + ptile + ";iid=" + iid + ";iin=" + iin + ";rci=" + rci + ";nl=" + nlValue + ";ses=" + sesValue + ";track=" + trackValue + ";ord=" + pageNum + "?'";
			//if (isNS) window.alert(adPosition + " - " + ADlayer[adPosition]);
		}
		if (window.location.search.indexOf("adIframe=on") != -1) window.alert("Ad: " + adPosition + "\n" + bbanner);
		if (window.location.search.indexOf("adString=on") != -1) window.alert("Ad: " + adPosition + "\n site=" + adSiteValue + " zone=" + adZoneValue + "\n ;pos=0;pth=" + pth + ";kw=" + adKeyword + ";gci=" + gci + ";tax=" + tax + ";clu=" + clu + ";adg=" + adg + ";sz=" + aamsz + ";dcopt=" + adDcopt + ";ptile=" + ptile + ";iid=" + iid + ";iin=" + iin + ";rci=" + rci + ";nl=" + nlValue + ";ses=" + sesValue + ";track=" + trackValue + ";ord=" + pageNum);
	    return bbanner;
	}
	
	
	function JSwriteLeaderBoard2(adSiteValue, adZoneValue, width, height, adPosition, adKeyword, adDcopt, pageNum) {
		var width = (!width) ? 728 : width;
		var height = (!height) ? 90 : height;
	    var size = width + "x" + height;
	    var lsKey = "off";
	    var allcookies = document.cookie;
		var position = "0";
	    var sLdrBoard = new String();
		var adNumber = adPosition.substring(adPosition.indexOf("_")+1,adPosition.length);
		var rNum = Math.random() * 10000000;
		if (!pageNum) pageNum = Math.round(Math.random() * 100000000);
		//gci
		var gci = getOIDValue("gci");
		
		//taxonomy
		if(typeof tt_dartTAX_id != "undefined") 
			var tax = tt_dartTAX_id;
		else
			var tax = getOIDValue("tax");
		//taxomomy cluster;
		if (typeof tt_hbxCL_id != "undefined")
			var clu = tt_hbxCL_id;
		else 
			var clu = '';
		// tax override ad group
		var adg = getURLParamValue("adg");
		if ( (typeof JSadTaxID != "undefined") && (adg == '') ) {
			adg = JSadTaxID;
		}
		//path name
		var wlp = window.location.pathname.substring(1,window.location.pathname.length);
		var pth = wlp.replace(eval("/\\//g"),".");
		if (pth.indexOf(".0,") != -1) pth = pth.substring(0,pth.indexOf(".0,"));
		if (pth.indexOf(".1,") != -1) pth = pth.substring(0,pth.indexOf(".1,"));

		var ptile = adPosition.substring(adPosition.indexOf('_') + 1, adPosition.length);

		//infocenter id
		var iid = getOIDValue("iid");
		//infocenter name
		var iin = "";
		if (typeof tt_rptInfoCenterMLC != "undefined") iin = tt_rptInfoCenterMLC;
		//resourcecenter id
		var rci = "";
		//newsletter ad id
		var nlValue = "";
		if (window.location.search.indexOf("?ad=") != -1 || window.location.search.indexOf("&ad=") != -1) {
			var nlS = window.location.search;
			if (nlS.indexOf("?ad=") != -1) {
				nlValue = nlS.substring(nlS.indexOf("?ad=") + 4, nlS.length);
			} else {
				nlValue = nlS.substring(nlS.indexOf("&ad=") + 4, nlS.length);
			}
			if (nlValue.indexOf("&") != -1) nlValue = nlValue.substring(0, nlValue.indexOf("&"));
		}
		//track ad id
		var trackValue = "";
		if (window.location.search.indexOf("?track=") != -1 || window.location.search.indexOf("&track=") != -1) {
			var trackS = window.location.search;
			if (trackS.indexOf("?track=") != -1) {
				trackValue = trackS.substring(trackS.indexOf("?track=") + 7, trackS.length);
			} else {
				trackValue = trackS.substring(trackS.indexOf("&track=") + 7, trackS.length);
			}
			if (trackValue.indexOf("&") != -1) trackValue = trackValue.substring(0, trackValue.indexOf("&"));
		}
		//persistent ad id
		var sesValue = "";
		if (window.location.search.indexOf("?ses=") != -1 || window.location.search.indexOf("&ses=") != -1) {
			var sesS = window.location.search;
			if (sesS.indexOf("?ses=") != -1) {
				sesValue = sesS.substring(sesS.indexOf("?ses=") + 5, sesS.length);
			} else {
				sesValue = sesS.substring(sesS.indexOf("&ses=") + 5, sesS.length);
			}
			if (sesValue.indexOf("&") != -1) sesValue = sesValue.substring(0, sesValue.indexOf("&"));
		}
	    if (allcookies.indexOf("LS=") != -1 && allcookies.indexOf("LSA=") != -1) {
			var name = "LSA";
			var pos = allcookies.indexOf(name + "=");
			var start = pos + name.length + 1;
			var end = allcookies.indexOf(";",start);
			if (end == -1) end = allcookies.length;
			var LSAvalue = allcookies.substring(start, end);
			if (LSAvalue != 2) {
				name = "LS";
				pos = allcookies.indexOf(name + "=");
				start = pos + name.length + 1;
				end = allcookies.indexOf(";",start);
				if (end == -1) end = allcookies.length;
				var LSvalue = allcookies.substring(start, end);
				var LSuser = LSvalue.substr(LSvalue.indexOf(":")+1);
				LSvalue = LSvalue.substr(0,LSvalue.indexOf(":"));
				if (LSvalue.substring(LSvalue.length-1,LSvalue.length) == "A") lsKey = "on";
				LSvalue = LSvalue.substr(0,LSvalue.length-1);
				if (lsKey == "on") adKeyword = "ls" + LSvalue;
			}
	    }
		// check if we're accessing a piece of content that has "topic=XXXXX" in the URL
		var overwriteTax = false;
		if (window.location.href.indexOf("?topic=") != -1 || window.location.href.indexOf("&topic=") != -1) {
			// overwrite the tax and cluster values for DART based on the tax value in the query string
			overwriteTax = true;
			var overwriteTaxVal = "";
			var overwriteClusterVal = "";
			var topicString = window.location.href;
			if (topicString.indexOf("?topic=") != -1) {
				topicValue = topicString.substring(topicString.indexOf("?topic=") + 7, topicString.length);
			} else {
				topicValue = topicString.substring(topicString.indexOf("&topic=") + 7, topicString.length);
			}
			if (topicValue.indexOf("&") != -1) topicValue = topicValue.substring(0, topicValue.indexOf("&"));
			var evalString = eval("typeof cl_id_" + topicValue);
			if( evalString == "undefined" ) {
				var clu = 'NONE';
			} else {
				var clu = eval("cl_id_" + topicValue);
			}
			var tax = topicValue;
		}
		if (isLayers) {
			sLdrBoard += '<ilayer id="'+adPosition+'" height="'+height+'" visibility="hide" top="0" left="0"></ilayer>';
			ADlayer[adPosition] = "http://ad.doubleclick.net/adl/"+adSiteValue+"/"+adZoneValue+";pos=0;pth="+pth+";kw="+adKeyword+";gci="+gci+";tax="+tax+";clu="+clu+";adg="+adg+";iid="+iid+";iin="+iin+";rci="+rci+";nl="+nlValue+";ses="+sesValue+";track="+trackValue+";sz="+size+";dcopt="+adDcopt+";ptile="+adNumber+";ord="+pageNum+"?"
		} else {
			var sURL = new String();
			if (((isNS) && (apV < 6.2)) || (isOP) || (isXX) || (typeof JSleaderboardNF == "boolean" && JSleaderboardNF == true)) {
				sURL = "http://ad.doubleclick.net/adi/"+adSiteValue+"/"+adZoneValue+";pos=0;pth="+pth+";kw="+adKeyword+";gci="+gci+";tax="+tax+";clu="+clu+";adg="+adg+";iid="+iid+";iin="+iin+";rci="+rci+";nl="+nlValue+";ses="+sesValue+";track="+trackValue+";sz="+size+";dcopt="+adDcopt+";ptile="+adNumber+";ord="+pageNum+"?";
			} else {
				sURL = "/techtarget/leaderboard.html?" + escape("http://ad.doubleclick.net/adj/"+adSiteValue+"/"+adZoneValue+";pos=0;pth="+pth+";kw="+adKeyword+";gci="+gci+";tax="+tax+";clu="+clu+";adg="+adg+";iid="+iid+";iin="+iin+";rci="+rci+";nl="+nlValue+";ses="+sesValue+";track="+trackValue+";sz="+size+";dcopt="+adDcopt+";ptile="+adNumber+";ord="+pageNum+"?");
			}
			sLdrBoard += '<iframe src="'+sURL+'" name="frame_'+adPosition+'" id="fra728x90" width="'+width+'" height="'+height+'" border="0" frameborder="0" marginheight="0" marginwidth="0" scrolling="no">';
			sLdrBoard += '<a href="http://ad.doubleclick.net/jump/'+adSiteValue+'/'+adZoneValue+';pos=0;pth='+pth+';kw='+adKeyword+';gci='+gci+';tax='+tax+';clu='+clu+';adg='+adg+';iid='+iid+';iin='+iin+';rci='+rci+';nl='+nlValue+';ses='+sesValue+';track='+trackValue+';sz='+size+';dcopt='+adDcopt+';ptile='+adNumber+';ord='+pageNum+'?">';
			sLdrBoard += '<img src="http://ad.doubleclick.net/ad/'+adSiteValue+'/'+adZoneValue+';pos=0;pth='+pth+';kw='+adKeyword+';gci='+gci+';tax='+tax+';clu='+clu+';adg='+adg+';iid='+iid+';iin='+iin+';rci='+rci+';nl='+nlValue+';ses='+sesValue+';track='+trackValue+';sz='+size+';dcopt='+adDcopt+';ptile='+adNumber+';ord='+pageNum+'?" width="'+width+'" height="'+height+'" border="0"></a>';
			sLdrBoard += '</iframe>';
		}
		if (window.location.search.indexOf("adIframe=on") != -1) window.alert("Ad: " + adPosition + "\n" + unescape(sLdrBoard));
		if (window.location.search.indexOf("adString=on") != -1) window.alert("Ad: " + adPosition + "\n" + "site="+adSiteValue+" zone="+ adZoneValue + "\n ;pos=0;pth="+pth+";kw="+adKeyword+";gci="+gci+";tax="+tax+";clu="+clu+";adg="+adg+";iid="+iid+";iin="+iin+";rci="+rci+";nl="+nlValue+";ses="+sesValue+";track="+trackValue+";sz="+size+";dcopt="+adDcopt+";ptile="+adNumber+";ord="+pageNum);
	    return (sLdrBoard);
	}

	function JSwriteADInfo(sitevalue, areavalue, width, height, position, kw, category, vibe, pageNum) {
		var adNum = position.substring(position.indexOf("_")+1, position.length);
		var bbbanner = "";
		bbbanner += "<table cellspacing=0 cellpadding=0 border=0 width=100% bgcolor=#DFDFDF><tr><td>\n";
		bbbanner += "<a class=small href=\"/ADinfo?sitevalue=" + sitevalue + "&areavalue=" + areavalue + "&width=" + width + "&height=" + height + "&position=" + position + "&kw=" + kw + "&cat=" + JSadCategory + "&vibe=" + vibe + "&adpageid=" + pageNum + "\" target=\"ADwindow\">\n";
		bbbanner +="<img src=\"/digitalguide/images/Misc/arrow_sort_down_666666.gif\" border=0> Information for AD" + adNum + "</a>\n";
		bbbanner += "</td></tr></table>\n";
		return bbbanner;
	}

	function JSwriteAdLayer(id, sitename, pagename, searchpage, size, keyword) {
	    var tile = id.charAt(id.length - 1); //This obtains the tile based on the id
	    sitename = (sitename.length > 0) ? sitename : "searchWebServices.com"; //When sitename is empty default to guide.com
	    pagename = (pagename.length > 0) ? pagename : "homepage"; //When pagename is empty default to homepage
	    searchpage = (searchpage.length > 0) ? "/" + searchpage : searchpage; //When searchpage isn't empty make it /searchpage
	    size = (size.length > 0) ? size : "468x60"; //When size is empty default to 468x60
	    var llayer = "";
	    llayer += "<layer src=\"http://ad.doubleclick.net/adl/" + sitename + "/" + pagename + searchpage + ";kw=" + keyword + ";sz=" + size + ";tile=" + tile + ";ord=" + Math.random() * 10000000 + "?\" visibility=\"hide\" onload=\"moveToAbsolute(layer" + id + ".pageX, layer" + id + ".pageY); visibility='show'\"></layer>\n";
	    return llayer;
	}

	var LSValue = "";
	var lsbool = false;

	function JSwriteLSAdBanner(id, sitename, pagename, searchpage, size, keyword, adname) {
	
		var adname = (!adname) ? "ad" : adname;
		//var lsbool = false;
		if (allcookies.indexOf("LS=") != -1 && allcookies.indexOf("LSAD=") == -1) {
			
			var name = "LS";
			var pos = allcookies.indexOf(name + "=");
			var start = pos + name.length + 1;
			var end = allcookies.indexOf(";",start);
			if (end == -1) end = allcookies.length;
			//var LSvalue = allcookies.substring(start, end);
			LSvalue = allcookies.substring(start, end);
			
			var LSuser = LSvalue.substr(LSvalue.indexOf(":")+1);
			LSvalue = LSvalue.substr(0,LSvalue.indexOf(":"));
			if (LSvalue.substring(LSvalue.length-1,LSvalue.length) == "A") {
				lsbool = true;
			}
			LSvalue = LSvalue.substr(0,LSvalue.length-1);
		}
		size = (size.length > 0) ? size : "468x60"; //When size is empty default to 468x60
		var width = size.substring(0, size.indexOf("x"));
		var height = size.substring(size.indexOf("x") + 1, size.length);
		var bbanner = "";
		if (lsbool == true) {
			if (!document.layers) {
				bbanner += "<iframe src=\"http://searchWebServices.techtarget.com/liftStudy/" + LSvalue + "/" + adname + "\" name=\"frame" + id + "\" width=\"" + width + "\" height=\"" + height + "\" border=\"0\" frameborder=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\">\n";
				bbanner += "<a href=\"http://searchWebServices.techtarget.com/liftStudy/" + LSvalue + "/" + adname + "\">\n";
				bbanner += "<img src=\"http://searchWebServices.techtarget.com/liftStudy/" + LSvalue + "/" + adname + "\" width=\"" + width + "\" height=\"" + height + "\" border=\"0\"></a>\n";
				bbanner += "</iframe>\n";
			}
	
			if (document.layers) {
				bbanner += "<ilayer id='layer" + id + "' visibility='hide' height='" + height + "' top='0' left='0'></ilayer>\n";
			}
		} else {
			bbanner += JSwriteAdBanner(id, sitename, pagename, searchpage, size, keyword);
		}
	
		return bbanner;
	}

	function JSwriteLSAdLayer(id, sitename, pagename, searchpage, size, keyword, adname) {
		var adname = (!adname) ? "ad" : adname;
		var llayer = "";
		if (lsbool == true) {
			llayer += "<layer src=\"http://searchWebServices.techtarget.com/liftStudy/" + LSvalue + "/" + adname + "\" visibility=\"hide\" onload=\"moveToAbsolute(layer" + id + ".pageX, layer" + id + ".pageY); visibility='show'\"></layer>\n";
		
		} else {
			llayer += JSwriteAdLayer(id, sitename, pagename, searchpage, size, keyword);
	
		}
	
		return llayer;
	}

  /* Legacy Ad Variables Section - used on WebX and WhatIs SkyScraper */

	var adTag = Math.random() * 10000000;
	var adTag1 = Math.random() * 10000000;
	var adTag2 = Math.random() * 10000000;
	var adTag3 = Math.random() * 10000000;
	var dgSponsor = Math.random() * 10000000;
	var dgGiveAway = Math.random() * 10000000;
	var dgPromo = Math.random() * 10000000;
	var dgSkyScraper = Math.random() * 10000000;

	function getAdNumber(item) {
		return item;
	}


  /* Leaderboard Ad Section */

	var bMoveBack728x90, imgCollapse728x90, imgExpand728x90, oFrame728x90, oToggle728x90;

	function setLeaderBoard(oCCmd) {
	
	
		collapsePath = "http://media.techtarget.com/digitalguide/images/Misc/ad_sideHeader_collapse_wh_728_90.gif";
		expandPath = "http://media.techtarget.com/digitalguide/images/Misc/ad_sideHeader_expand_wh_728_90.gif";
		swapWidth = 19;
	 if (!PAGE_LOADED) {
	s728x90 = setTimeout('setLeaderBoard("'+oCCmd+'")',100);
	return;
	}
	if (typeof s728x90 != "undefined")
	clearTimeout(s728x90);
	oFrame728x90 = getObj('fra728x90');
	if (oFrame728x90) {
	var oDoc;
	if (oFrame728x90.contentWindow)
	oDoc = oFrame728x90.contentWindow.document;
	else if (window.frames)
	oDoc = window.frames[oFrame728x90.name].document;
	else return;
	oToggle728x90 = document.toggle728x90;
	var h = findHeight(oDoc.body.firstChild);
	if ((oToggle728x90) && (h > 91)) {
	imgCollapse728x90 = new Image(swapWidth,90);
	imgCollapse728x90.src = ((!oCCmd) ? '' : oCCmd) + collapsePath;
	imgExpand728x90 = new Image(swapWidth,90);
	imgExpand728x90.src = expandPath;
	if (cookieExists('adv') == -1) {
	setSessionCookie('adv',1);
	bMoveBack728x90 = true;
	t728x90 = setTimeout('expandLeaderBoard()',100);}
	else t728x90 = setTimeout('collapseLeaderBoard()',100);
	}
	}
	}

	function collapseLeaderBoard() {
	if (typeof b728x90 != "undefined") {
	bMoveBack728x90 = false;
	clearTimeout(b728x90);
	}
	if (typeof t728x90 != "undefined")
	clearTimeout(t728x90);
	if (oToggle728x90.src != imgExpand728x90.src) {
	oToggle728x90.src = imgExpand728x90.src;
	oToggle728x90.onclick = expandLeaderBoard;
	}
	var h = findHeight(oFrame728x90);
	if (h > 90) {
	oFrame728x90.style.height = (h-30) + "px";
	t728x90 = setTimeout('collapseLeaderBoard()',100);
	} else {
	t728x90 = setTimeout('null',1);
	}
	}

	function expandLeaderBoard() {
	if (typeof t728x90 != "undefined")
	clearTimeout(t728x90);
	if (oToggle728x90.src != imgCollapse728x90.src) {
	oToggle728x90.src = imgCollapse728x90.src;
	oToggle728x90.onclick = collapseLeaderBoard;
	}
	var h = findHeight(oFrame728x90);
	if (h < 300) {
	oFrame728x90.style.height = (h+30) + "px";
	t728x90 = setTimeout('expandLeaderBoard()',100);
	} else {
	if (bMoveBack728x90) b728x90 = setTimeout('collapseLeaderBoard()',4000);
	t728x90 = setTimeout('null',1);
	}
	}


   /* Sponsor Move Function */

	function sponsorMove() {
		var moveX = 3;
		var moveY = 5;
		var oSponsor;
		var oHolder;
		if ((isNS) && (isLayers)) {
			oSponsor = getObj('layerMove');
			oHolder = getObj('layerHolder');
			if ((oSponsor) && (oHolder)) {
				oSponsor.moveToAbsolute(oHolder.pageX+moveX,oHolder.pageY+moveY);
				oSponsor.visibility = "show";
			}
		} else {
			oSponsor = getObj('divMove');
			oHolder = getObj('divHolder');
			if ((oSponsor) && (oHolder)) {
				moveObjectTo(oSponsor,findLeft(oHolder)+moveX,findTop(oHolder)+moveY);
				oSponsor.style.visibility = "visible";
			}
		}
	}

	function sponsorMove_old() {
		var moveX=3;
		var moveY=5;
		NN4=(document.layers) ? 1 : 0;
		NN6=(document.getElementById && !document.all) ? 1 : 0;
		IE=(document.all) ? 1 : 0;

		if (IE) {
			var agt=navigator.userAgent.toLowerCase();
			var is_mac=(agt.indexOf("mac")!=-1);
			var is_major=parseInt(navigator.appVersion);
			var msie_vers_start=agt.indexOf("msie")+5;
			var msie_real_vers=parseFloat(agt.substring(msie_vers_start, msie_vers_start+3));
			var mac45=(is_mac && (msie_real_vers < 5)) ? 1 : 0;

			if (mac45) {
				temp=document.all.divMove.innerHTML;
				//alert(temp);
				document.all.divMove.innerHTML="";
				document.all.divHolder.innerHTML=temp;
			} else {
				divHolder.getRealLeft = getRealLeft;
				divHolder.getRealTop = getRealTop;

				function getRealLeft() {
					xPos = this.offsetLeft;
					tempEl = this.offsetParent;
					while (tempEl != null) {
						xPos += tempEl.offsetLeft;
						tempEl = tempEl.offsetParent;
					}
					return xPos;
				}

				function getRealTop() {
					yPos = this.offsetTop;
					tempEl = this.offsetParent;
					while (tempEl != null) {
						yPos += tempEl.offsetTop;
						tempEl = tempEl.offsetParent;
					}
					return yPos;
				}

				Left=divHolder.getRealLeft();
				Top=divHolder.getRealTop();

				divMove.style.left=Left+moveX;
				divMove.style.top=Top+moveY;

				divMove.style.visibility="visible";
			}
		} else if (NN4) {
			document.layerMove.moveToAbsolute(document.layerHolder.pageX+moveX, document.layerHolder.pageY+moveY);
			document.layerMove.visibility='show';
		} else if (NN6) {
			tempDiv=document.getElementById("Holder");
			Top=document.defaultView.getComputedStyle(tempDiv, "").getPropertyValue("top");
			Left=document.defaultView.getComputedStyle(tempDiv, "").getPropertyValue("left");

			if (Top.indexOf("px")) {
				Top=Top.slice(0,-2);
				Top=Top*1;
			}

			if (Left.indexOf("px")) {
				Left=Left.slice(0,-2);
				Left=Left*1;
			}

			document.getElementById("divMove").style.top=Top+moveY;
			document.getElementById("divMove").style.left=Left+moveX;
			document.getElementById("divMove").style.visibility="visible";
		}
	}

  /* Check Email Function */

	function checkEmail (emailStr) 
	{
		var num_error=0;
		var NewemailStr="";
		var emailPat=/^(.+)@(.+)$/
		var specialChars="\\(\\)\\{\\}\/%?\\$\\*\\^\\|\\.=&`~#!<>@,;:\\\\\\\"\\.\\[\\]"
		var invalidchars="\\(\\)\\{\\}\/%?\\$\\s\\^~#!&`\\*\\|=@<>,;:\\\\\\\"\\[\\]'"
		var validChars="\[^\\s" + specialChars + "\]"
		var validChars1="\[^\\s" + invalidchars + "\]"
		var quotedUser=/(\"[^\"]*\"\')/
		var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/
		var atom=validChars + '+'
		var atom1=validChars1 + '+'
		var word="(" + atom + "|" + quotedUser + ")"
		var word1="(" + atom1 + "|" + quotedUser + ")"
		var userPat=new RegExp("^" + word + "(\\." + word + ")*$")
		var domainPat=new RegExp("^" +  word1 + "(" + word1 + ")*$")

		if (emailStr == "") {
			// change to false
			return "An email address is required";
		} else {
			var NewemailStr=emailStr;
			// need to trim space beginning and the end each email, then pass back to the form. 
		}

		var matchArray=NewemailStr.match(emailPat);

		if (matchArray==null) {
			return "E-mail address is not a valid format (check @ and .'s)";
		}
		var user=matchArray[1];
		var domain=matchArray[2];

		if (user.match(userPat)==null) {
		    return "The username in the email address doesn't seem to be valid.";
		}

// 05/27/03 BobH: Commented out below lines (see IT # 3424)
//		if(user.length>0)
//		{
//			if((user.charAt(0)=="-")||(user.charAt(0)=="_"))	
//			{
//				return "The username in the email address doesn't seem to be valid.";
//			} else if ((user.charAt(user.length-1)=="_")||(user.charAt(user.length-1)=="-")) {
//				return "The username in the email address doesn't seem to be valid.";
//			}				 
//		}

		var IPArray=domain.match(ipDomainPat);
		if (IPArray!=null) 
		{
			for (var i=1;i<=4;i++)
			{
				if (IPArray[i]>255)
			 	{
					return "Destination IP address in the email address is invalid!";
				}
			}
			return true;
		}

		var domainArray=domain.match(domainPat);	
		if (domainArray==null) {
			return "The domain name in the email address doesn't seem to be valid.";
		}

		if(domain.length>0)
		{
			if(domain.charAt(0)==".")	
			{
				return "The domain name in the email address doesn't seem to be valid.";
			} else if(domain.charAt(domain.length-1)==".")
			         {
				return "The domain name in the email address doesn't seem to be valid.";
			         } else {
				var errors=0;
				for(var k=1; k<domain.length; k++)
				{
					if(domain.charAt(k)==".")
						errors++;
					if((domain.charAt(k)==".") && (domain.charAt(k+1)=="."))
				              {
					     errors=errors + 5;
					     k=domain.length;
					}
				}
				if(errors>4)
				{
					return "The domain name in the email address doesn't seem to be valid.";
				}
			}				 
		}

		var atomPat=new RegExp(atom,"g");
		var domArr=domain.match(atomPat);

		var len=domArr.length;
		if (domArr[domArr.length-1].length < 2) 
		{
		   return "The email address must end in a valid domain.";
		}

		if (len<2)
	              {
		   return "This email address is missing a hostname!";
		}

		return "good";
	}

  /* Validate Email Function */

	function validateEmail (emailAddr) 
	{
		var emailAlert = checkEmail(emailAddr)

		if (emailAlert == 'good')
			return true;
		else 
		{
			alert(emailAlert);
			return false;
		}
	}

  /* Build URL Function */

	function buildURL(form, site) {

		// search400 uses "AS/400" for it's short name, so regexp out the "/"
		var regexp = /(\/)/g;;
		var name = site.replace(regexp,"");
		var regexp = / /g;;
		var name = name.replace(regexp,"");	// Get rid of spaces, for "Systems Management"

		var URL = form.URL.value;
		URL += "&email=" + form.email.value;

		if (validateEmail(form.email.value)) {
			window.open( URL, name, 'height=400,width=285,scrollbars=yes');
		}
	}

  /* Add Redirect Function */

	function addRedirectString(aCollection) {
		//redirectString is built in JSvariables, this function is called from the Footer template
		var i = 0;
		for(i = 0; i < aCollection.length; i++) {
			if (aCollection[i].href.indexOf("mailto:") == -1 && aCollection[i].href.indexOf("javascript:") == -1 && pathCoBrand[aCollection[i].pathname.substring(0, aCollection[i].pathname.indexOf("/"))] == "on") {
				aCollection[i].href = redirectString + aCollection[i].href;
			}
		}	
	}

	function getURLParamValue(param) {
		var paramValue = param + "=";
		var searchValue = window.location.search.toLowerCase();
		var searchValueParam = "";
		if (searchValue.indexOf(paramValue) != -1) {
			searchValueParam = window.location.search.substring(searchValue.indexOf(paramValue),searchValue.length);
			if (searchValueParam.indexOf("&") != -1) searchValueParam = searchValueParam.substring(0,searchValueParam.indexOf("&"));
		}
		searchValueParam = searchValueParam.substring((param.length)+1,searchValueParam.length);
		return searchValueParam;
	}

	
	function validateHandle(handleStr) {
		// performs checks on illegal characters and minimun length 
		var ttalert = '';

		// Search for valid chars: A-Z, a-z, and 0-9
		var handlePat=/[^a-zA-Z0-9]/
		var handleResult=handleStr.search(handlePat)

		// Check to make sure the handle has valid characters in it
		if (handleResult != -1) {
			ttalert += "The handle name must contain ONLY alphanumeric characters. Spaces are NOT allowed. \n";
		}
		
		//Check the length of the username
		if (handleStr.length < 6) {
			ttalert += "The handle must be 6 characters or greater in length. \n";
		}
		return ttalert;
	}

	function popUp(url , name, params) {
		if (!name) {
			var winName = "popUp";
		} else {			
			var winName = name;
		}
		if (!params) {
			var winParams = "width=400,height=350,toolbar=no,menubar=no,location=no,scrollbars=yes,resize=no";
		} else {
			var winParams = params
		}			
		var OpenWindow = window.open(url, winName , winParams);
	}
	
	function reservedHandle(handleStr) {
		//Check reserved keywords
		var ttalert = '';
		var reservedList = 'ipc itpeer peerconnect techtarget itconnect itpeerconnect';
		reservedList += ' itknowledgeexchange itknowledgexchange itknowledge itexchange';
		reservedList += ' itxchange knowledgeexchange knowledgexchange itke ike';
		reservedList += ' itkexchange itknowledgex itkxchange kexchange kxchange';
		var checkHandle = handleStr.toLowerCase();
		if ( reservedList.indexOf(checkHandle) != -1 ) {
			ttalert += 'Handle: ' + handleStr + ' is already in use \n';
		}	
		return ttalert;		
	}
	
	function replaceSID0() {
		//replace sid0 with OID sid value
		var fCollection = document.forms;
		for(var fi = 0; fi < fCollection.length; fi++) {
			if (fCollection[fi].action.indexOf("sid0") != -1) {
				fCollection[fi].action = fCollection[fi].action.replace("sid0","sid26");
			}
		}	
	}
	
	function replaceSID0onEvent() {
		//replace sid0 with OID sid value, for non-Netscape browsers
		var tempText = "";
		var eHref = (window.event.srcElement.tagName == "A") ? window.event.srcElement : window.event.srcElement.parentElement;
		if (eHref.parentElement && eHref.tagName != "A") eHref = eHref.parentElement;
		if (eHref.href) {
			if (eHref.href.indexOf("sid0") != -1) {
				tempText = eHref.innerText;
				eHref.href = eHref.href.replace("sid0", "sid26");
				if (tempText) eHref.innerText = tempText;
				//return true;
			}
		}
	}
	function replaceSID0onEventN(e) {
		//replace sid0 with OID sid value, for Netscape browsers
		var tempText = "";
		var eHref = (e.target.tagName == "A") ? e.target : e.target.parentNode;
		if (eHref.parentNode && eHref.tagName != "A") eHref = eHref.parentNode;
		if (eHref.href) {
			if (eHref.href.indexOf("sid0") != -1) {
				tempText = eHref.innerText;
				eHref.href = eHref.href.replace("sid0", "sid26");
				if (tempText) eHref.innerText = tempText;
				return true;
			}
		}
	}
	
	/* ClickThru Redirect Function */
	function clickThruValidate(form) {
		var clickPat=/[^a-zA-Z0-9]/;
		
		var clickResult=form.clickThruID.value.search(clickPat);

		if (clickResult != -1) {
			form.action = '/clickThruError';
		} else {
			form.action = '/clickThru/0,,'+'clk'+form.clickThruID.value+',00.html';
			form.submit();
		}
	}


//- TechTarget Javascript Menu System -
function TT_MENU_SYSTEM() {
/*
 TT_MENU_SYSTEM is an object constructor:
 Variables and functions are encapsulated in this constructor
 so they won't interfere with existing variables and functions
 IE for Windows implements the popup method for menus, because
 html elements pop under select boxes regardless of z-index
 Extra code is needed to map click events and styles for popups
*/
//- Browser Test
var isIE = 0; //Internet Explorer
var isNN = 0; //Netscape Navigator
var isFF = 0; //Firefox
var isOP = 0; //Opera
var isXX = 0; //Other
var isWin = 0; //Windows Platform
var isMac = 0; //Mac Platform
var isX = 0; //Other Platform
var apV = 1.0; //Browser Version
var isDOM = 0; //HTML DOM level 1
var isPopup = 0; //use createPopup
var isIframe = 0; //use iframe
function testBrowser() {
//Test DOM level 1 - DOM level 1 is required!
if (!(document
&& document.implementation
&& document.implementation.hasFeature
&& document.implementation.hasFeature("HTML","1.0"))) {
//no dom implementation? then exit
return;
}
isDOM = 1;
var av = navigator.appVersion;
if (av.indexOf("Windows") != -1) isWin = 1;
else if (av.indexOf("Macintosh") != -1) isMac = 1;
else isX = 1;
var ua = navigator.userAgent, i;
//Opera first because it can mask as IE or NN
if ((i = ua.indexOf("Opera ")) != -1)
isOP = 1, apV = parseFloat(ua.substring(i+6,ua.indexOf(" ",i+6)));
else if ((i = ua.indexOf("Firefox/")) != -1)
isFF = 1, apV = parseFloat(ua.substring(i+8,ua.indexOf(" ",i+8)));
else if ((i = ua.indexOf("Netscape/")) != -1)
isNN = 1, apV = parseFloat(ua.substring(i+9,ua.indexOf(" ",i+9)));
else if ((i = ua.indexOf("MSIE ")) != -1)
isIE = 1, apV = parseFloat(ua.substring(i+5,ua.indexOf(";",i+5)));
else isXX = 1, apV = parseFloat(av);
if (isIE && window.createPopup) isPopup = 1;
else if (!(isFF || (isNN && apV >= 7))) isIframe = 1;
}
testBrowser();
testBrowser = null;
//- Browser Test

//- MenuSystem Properties
this.length = 0;
var nextID = 1;
var menuBarTop = 0;
var menuBarLeft = 0;
var menuBarWidth = 0;
var menuTop = 0;
var menuContainer = null;
var menuCss = "http://media.techtarget.com/digitalguide/stylesheets/searchWebServices_menu.css";
var activeMenu = null;
var killZones = new Array();
//- MenuSystem Properties

//- MenuSystem Methods
this.add = function (key,offsetX,offsetY) {
key = cleanKey(key);
return this[this.length++] = this[key] = new Menu(offsetX,offsetY);
}
this.init = function (menuBar) {
if (!isDOM) return;
if (this.length == 0) return;
if (typeof menuBar == "string"
&& !(menuBar = getObj(menuBar))) return;
var lnks = getTags("A",menuBar), len = lnks.length;
if (len == 0) return;
menuBarTop = getTop(menuBar);
menuBarLeft = getLeft(menuBar);
menuBarWidth = getWidth(menuBar);
menuTop = getBottom(menuBar);
appendStyleSheet();
createMenuContainer();
activeMenu = null;
var lnk, mnu;
for (var i = 0; i < len; i++) {
lnk = lnks[i],
mnu = this[cleanKey(lnk.href)];
if (mnu != null && appendMenu(mnu,lnk))
captureEvent(lnk,"onmouseover",mnu.moHandler());
}
createKillZones();
captureEvent(window,"onunload",hideAll);
captureEvent(window,"onblur",hideAll);
captureEvent(window,"onresize",hideAll);
captureEvent(window,"onscroll",hideAll);
}
//- MenuSystem Methods

//- MenuSystem Functions
function appendMenu(mnu,lnk) {
var its = mnu.items;
if (its.length == 0) return false;
var div = createMenuDiv(its);
mnu.object = div;
var dt = menuTop+mnu.offsetY;
var dw = getWidth(div);
if (dw < 50) {
dw = 50;
div.style.width = "50px";
}
var ll = getLeft(lnk);
var lr = ll+getWidth(lnk);
var mbl = menuBarLeft;
var mbw = menuBarWidth;
var mbr = mbl+mbw;
if (ll+dw+mnu.offsetX > mbr && lr-dw-mnu.offsetX < mbl) {
div.style.wordWrap = "break-word";
dw = mbr-ll-mnu.offsetX;
div.style.width = (dw-2)+"px";
div.style.clip = "rect(auto "+dw+" auto auto)";
}
var dl = (ll+dw+mnu.offsetX > mbr && lr-dw-mnu.offsetX >= mbl)
? lr-dw-mnu.offsetX : ll+mnu.offsetX;
div.style.top = dt+"px", div.style.left = dl+"px";
return true;
}
function appendStyleSheet() {
if (isOP) {
var lnk = document.createElement("LINK");
lnk.rel = "stylesheet";
lnk.type = "text/css";
lnk.href = menuCss;
var head = getTags("HEAD",document), len = head.length;
if (len > 0) head[0].appendChild(lnk);
else document.body.insertBefore(lnk,document.body.firstChild);
}
}
function cleanKey(key) {
key = new String(key).toLowerCase();
var len = key.length;
if (key.charAt(len-1) == "/") key = key.substring(0,len-1);
key = encodeURIComponent(key);
return key;
}
function createKillZones() {
killZones = new Array();
var bw = Math.min(
isNaN(document.body.scrollWidth) ? 0 : document.body.scrollWidth,
isNaN(document.body.clientWidth) ? 0 : document.body.clientWidth,
getWidth(document.body)
);
var bh = Math.max(
isNaN(document.body.scrollHeight) ? 0 : document.body.scrollHeight,
isNaN(document.body.clientHeight) ? 0 : document.body.clientHeight,
getWidth(document.body)
);
var mbt = menuBarTop;
var mbl = menuBarLeft;
if (mbl > 0) {
killZones[killZones.length] =
createKillZone("0px","0px",mbl+"px",bh+"px");
}
var mbw = menuBarWidth;
var mbr = mbl+mbw;
if (mbr < bw) {
killZones[killZones.length] =
createKillZone(mbr+"px","0px",(bw-mbr)+"px",bh+"px");
}
killZones[killZones.length] =
createKillZone(mbl+"px","0px",mbw+"px",mbt+"px");
var mt = menuTop;
killZones[killZones.length] =
createKillZone(mbl+"px",mt+"px",mbw+"px",(bh-mt)+"px");
}
function createKillZone(x,y,w,h) {
var div = document.createElement("DIV");
div.style.position = "absolute";
div.style.visibility = "hidden";
div.style.top = y;
div.style.left = x;
div.style.width = w;
div.style.height = h;
div.style.zIndex = 5;
div.className = "menuKillZone";
div = document.body.appendChild(div);
captureEvent(div,"onmouseover",hideAll);
return div;
}
function createMenuContainer() {
if (isPopup) {
var pu = window.createPopup();
var div = pu.document.createElement("DIV");
div.id = "m";
div.className = "menuPanel";
div = pu.document.body.appendChild(div);
pu.document.createStyleSheet(menuCss);
captureEvent(pu.document,"onclick",
function () {
var se = pu.document.parentWindow.event.srcElement;
if (se.tagName == "A"
&& (se = getObj(se.id)) != null) se.click(), pu.hide();
});
captureEvent(pu.document,"onmouseover",
function () {
var se = pu.document.parentWindow.event.srcElement;
if (se.tagName == "A") top.status = se.href;
});
menuContainer = pu;
} else if (isIframe) {
var fra = document.createElement("IFRAME");
fra.frameBorder = 0;
fra.border = 0;
fra.marginWidth = 0;
fra.marginHeight = 0;
fra.scrolling = "no";
fra.noResize = "true";
fra.style.position = "absolute";
fra.style.visibility = "hidden";
fra.style.top = "0px";
fra.style.zIndex = 7;
fra = document.body.appendChild(fra);
function initFrame(f) {
f.contentDocument.write('<html><head>'+
'<link rel="stylesheet" type="text/css" href="'+menuCss+'">'+
'</head><body><div id="m" class="menuPanel"></div></body></html>');
captureEvent(f.contentDocument,"onclick",
function () {
var se = f.contentDocument.parentWindow.event.srcElement;
if (se.tagName == "A" && (se = getObj(se.id)) != null) se.click();
});
captureEvent(f.contentDocument,"onmouseover",
function () {
var se = f.contentDocument.parentWindow.event.srcElement;
if (se.tagName == "A") top.status = se.href;
});
}
if (fra.contentDocument != null) initFrame(fra);
else captureEvent(fra,"onload",function () {initFrame(fra)});
menuContainer = fra;
}
}
function createMenuDiv(lnks) {
var div = document.createElement("DIV");
div.style.position = "absolute";
div.style.top = "0px";
div.style.visibility = "hidden";
div.style.zIndex = 6;
div.className = "menuPanel";
var len = lnks.length, lnk;
if (len == 1) {
lnk = div.appendChild(lnks[0]);
lnk.className = "menuItemTop menuItemBottom";
} else {
for (var i = 0; i < len; i++) {
lnk = div.appendChild(lnks[i]);
if (i == 0) lnk.className = "menuItemTop";
}
lnk.className = "menuItemBottom";
}
div = document.body.appendChild(div);
return div;
}
function createMenuItem(id,href,text,target) {
var a = document.createElement("A");
a.style.display = "block";
a.hideFocus = "true";
a.className = "menuItem";
a.id = id;
a.href = href;
a.appendChild(document.createTextNode(text));
a.target = (!target) ? "_top" : target;
return a;
}
function getNextID() {return "tt_mi_"+(nextID++)}
function hideAll() {
if (activeMenu != null) activeMenu.hide();
activeMenu = null, toggleKillZones(0);
}
function toggleKillZones(state) {
var len = killZones.length;
for (var i = 0; i < len; i++)
killZones[i].style.visibility = (state) ? "visible" : "hidden";
}
function toggleFrames(state) {
var fra = getTags("IFRAME",document), len = fra.length;
for (var i = 0; i < len; i++)
if (fra[i] != menuContainer && getTop(fra[i]) > menuTop)
fra[i].style.visibility = (state) ? "visible" : "hidden";
}
//- MenuSystem Functions

//- Menu Constructor
function Menu(offsetX,offsetY) {
offsetX = parseInt(offsetX);
offsetY = parseInt(offsetY);
this.items = new Array();
this.object = null;
this.offsetX = (isNaN(offsetX)) ? 0: offsetX;
this.offsetY = (isNaN(offsetY)) ? 0: offsetY;
this.add = function (href,text,target) {
var id = getNextID();
return this.items[this.items.length] =
this.items[id] = createMenuItem(id,href,text,target);
}
this.hide = function () {
if (isPopup) {
if (menuContainer.isOpen) menuContainer.hide();
} else if (isIframe) {
toggleFrames(1);
menuContainer.style.visibility = "hidden";
} else this.object.style.visibility = "hidden";
}
this.moHandler = function () {
var mnu = this; return function () {mnu.show()}
}
this.show = function () {
if (activeMenu != null) activeMenu.hide();
activeMenu = this, toggleKillZones(1);
if (isPopup) {
var mc = menuContainer;
getObj("m",mc.document).innerHTML = this.object.innerHTML;
mc.show(0,0,getWidth(this.object),getHeight(this.object),this.object);
} else if (isIframe) {
toggleFrames(0);
var mc = menuContainer;
getObj("m",mc.document).innerHTML = this.object.innerHTML;
mc.style.top = this.object.style.top;
mc.style.left = this.object.style.left;
mc.style.width = getWidth(this.object)+"px";
mc.style.height = getHeight(this.object)+"px";
mc.style.visibility = "visible";
} else this.object.style.visibility = "visible";
}
}
//- Menu Constructor

//- DOM Functions
function getObj(id,doc) {
if (!doc) doc = document; return doc.getElementById(id);
}
function getTags(tagName,obj) {
return obj.getElementsByTagName(tagName);
}
function getStyle(obj,cssProp) {
var p = obj.style[cssProp];
if (!p) {
if (document.defaultView) {
p = document.defaultView.getComputedStyle(obj,null).getPropertyValue(cssProp);
} else if (obj.currentStyle) p = obj.currentStyle[cssProp];
}
return p;
}
function getTop(obj) {
var y;
if (getStyle(obj,"position") == "absolute") {
if (!isNaN(y = parseFloat(getStyle(obj,"top")))) return y;
if (!isNaN(y = parseFloat(getStyle(obj,"pixelTop")))) return y;
}
y = 0;
while (obj.offsetParent) {y += obj.offsetTop; obj = obj.offsetParent}
return y;
}
function getBottom(obj,y,h) {
if (!y) y = getTop(obj);
if (!h) h = getHeight(obj);
return y+h;
}
function getLeft(obj) {
var x;
if (getStyle(obj,"position") == "absolute") {
if (!isNaN(x = parseFloat(getStyle(obj,"left")))) return x;
if (!isNaN(x = parseFloat(getStyle(obj,"pixelLeft")))) return x;
}
x = 0;
while (obj.offsetParent) {x += obj.offsetLeft; obj = obj.offsetParent}
return x;
}
function getWidth(obj) {
if (obj.offsetWidth) return obj.offsetWidth;
var w;
if (!isNaN(w = parseFloat(getStyle(obj,"width")))) return w;
if (!isNaN(w = parseFloat(getStyle(obj,"pixelWidth")))) return w;
return 0;
}
function getHeight(obj) {
if (obj.offsetHeight) return obj.offsetHeight;
var h;
if (!isNaN(h = parseFloat(getStyle(obj,"height")))) return h;
if (!isNaN(h = parseFloat(getStyle(obj,"pixelHeight")))) return h;
return 0;
}
function captureEvent(obj,evt,handler) {
if (obj.attachEvent) obj.attachEvent(evt,handler);
else if (obj.addEventListener)
obj.addEventListener(evt.substring(2),handler,false);
else obj[evt] = handler;
}
//- DOM Functions
}
var TTMS = new TT_MENU_SYSTEM();
//- eof -


	    
		  var menu = TTMS.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299037,00.html",-1,0);
	 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301752,00.html","Registry/Repository");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299048,00.html","What is SOA?");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299050,00.html","SOA implementations");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299051,00.html","SOA development");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299052,00.html","SOA case studies");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299053,00.html","SOA best practices");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300609,00.html","Workflow");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300610,00.html","Business process management");
		 
	    
		  var menu = TTMS.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298931,00.html",-1,0);
	 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301915,00.html","Ajax");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298932,00.html","Introduction to Web services");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301569,00.html","Representational State Transfer (REST)");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301757,00.html","Web services management");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298933,00.html","Java");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298938,00.html","Visual Basic");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300607,00.html","MDA");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298939,00.html","ASP and ASP.NET");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298940,00.html","Application programming interfaces (API)");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298947,00.html","Best practices");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300608,00.html","Monitoring/testing");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300611,00.html","Security");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300620,00.html","Tools");
		 
	    
		  var menu = TTMS.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298809,00.html",-1,0);
	 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301930,00.html","Description standards and specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301935,00.html","Event processing and notification specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301937,00.html","Management standards and specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301927,00.html","Orchestration/choreography standards and specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301933,00.html","Protocol specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301929,00.html","Registry standards");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301934,00.html","Reliable message exchange standards and specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298877,00.html","SOAP specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301932,00.html","Security standards and specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax301928,00.html","Transaction specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298886,00.html","Description and directory specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298902,00.html","XML specifications");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298917,00.html","Security standards");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298923,00.html","Business process/transaction standards");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298929,00.html","Policy specifications");
		 
	    
		  var menu = TTMS.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298965,00.html",-1,0);
	 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298966,00.html","CORBA");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298968,00.html","Enterprise Application Integration (EAI)");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298969,00.html","Enterprise Services Bus (ESB)");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298970,00.html","Business process integration (BPI)");
		 
	    
		  var menu = TTMS.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298949,00.html",-1,0);
	 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298955,00.html","Application servers");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298950,00.html","Microsoft .NET");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298951,00.html","J2EE");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298952,00.html","Linux");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300606,00.html","Longhorn");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298953,00.html","Sun One");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298954,00.html","NetWeaver");
		 
	    
		  var menu = TTMS.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300618,00.html",-1,0);
	 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300619,00.html","Utility/Grid computing");
		 
	    
		  var menu = TTMS.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299625,00.html",-1,0);
	 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299626,00.html","Buying advice");
		 
		    
			menu.add("http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299630,00.html","Professional issues");
		 function PAGE_NAVIGATION() {
	var nav = new Array('<table border="0" cellpadding="0" cellspacing="0" width="100%"><tr><td colspan="2"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="1" alt=""></td></tr></table><table id="menuBar" border="0" cellpadding="0" cellspacing="0" width="100%"><tr>');
	var links = new Array();
	 
	
		links.push('<td class="navCell" nowrap bgcolor="#000000"><a href="http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299037,00.html" class="navLink">SOA</a></td>');
	  
	
		links.push('<td class="navCell" nowrap bgcolor="#000000"><a href="http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298931,00.html" class="navLink">WEB SERVICES</a></td>');
	  
	
		links.push('<td class="navCell" nowrap bgcolor="#000000"><a href="http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298809,00.html" class="navLink">WS STANDARDS</a></td>');
	  
	
		links.push('<td class="navCell" nowrap bgcolor="#000000"><a href="http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298965,00.html" class="navLink">INTEGRATION</a></td>');
	  
	
		links.push('<td class="navCell" nowrap bgcolor="#000000"><a href="http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax298949,00.html" class="navLink">PLATFORMS AND SERVERS</a></td>');
	  
	
		links.push('<td class="navCell" nowrap bgcolor="#000000"><a href="http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax300618,00.html" class="navLink">DATA CENTER</a></td>');
	  
	
		links.push('<td class="navCell" nowrap bgcolor="#000000"><a href="http://searchwebservices.techtarget.com/topics/0,295493,sid26_tax299625,00.html" class="navLink">STRATEGY AND PLANNING</a></td>');
	  
	  
	  
	  
	  
	  
	  
	   nav.push(links.join('<td class="spacerCell"><img src="http://media.techtarget.com/searchWebServices/images/spacer.gif" width="1" height="25" alt=""></td>'));
	nav.push('</tr></table>');
	return nav.join("");
}

//- eof -