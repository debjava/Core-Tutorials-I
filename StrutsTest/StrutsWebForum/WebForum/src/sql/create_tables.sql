# Connection: Server1
# Host: localhost
# Saved: 2004-06-20 20:11:05
# 
# Host: localhost
# Database: webforum
# Table: 'posts'
# 
CREATE TABLE `posts` (
  `PostID` int(10) unsigned NOT NULL auto_increment,
  `Subject` text,
  `ReplyCount` int(10) unsigned NOT NULL default '0',
  `UserID` int(10) unsigned NOT NULL default '0',
  `CreationDate` datetime NOT NULL default '0000-00-00 00:00:00',
  `Message` text NOT NULL,
  `ParentID` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`PostID`)
) TYPE=MyISAM; 

# Host: localhost
# Database: webforum
# Table: 'users'
# 
CREATE TABLE `users` (
  `UserID` int(10) NOT NULL auto_increment,
  `Username` varchar(8) NOT NULL default '',
  `Password` varchar(16) NOT NULL default '',
  `Forenames` varchar(64) NOT NULL default '',
  `Surname` varchar(64) NOT NULL default '',
  `CreationDate` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`UserID`)
) TYPE=MyISAM; 

