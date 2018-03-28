ALTER TABLE core_style MODIFY COLUMN description_style VARCHAR(100) NOT NULL;

INSERT INTO core_admin_right VALUES ('CORE_LINK_SERVICE_MANAGEMENT','portal.insert.adminFeature.linkService_management.name',2,NULL,'portal.insert.adminFeature.linkService_management.description',0,NULL,NULL,NULL,NULL,1);

ALTER TABLE core_page ADD COLUMN meta_keywords varchar(255) default NULL;
ALTER TABLE core_page ADD COLUMN meta_description varchar(255) default NULL;

DROP TABLE IF EXISTS core_indexer_action;
CREATE TABLE  core_indexer_action (
  id_action int default 0 NOT NULL,
  id_document varchar(255) NOT NULL,
  id_task int default 0 NOT NULL,
  indexer_name varchar(255) NOT NULL,
  id_portlet int default 0 NOT NULL,
  PRIMARY KEY (id_action)
);

UPDATE core_stylesheet SET source = 0x3C3F786D6C2076657273696F6E3D22312E30223F3E0D0A3C78736C3A7374796C6573686565742076657273696F6E3D22312E302220786D6C6E733A78736C3D22687474703A2F2F7777772E77332E6F72672F313939392F58534C2F5472616E73666F726D223E0D0A202020200D0A202020203C78736C3A706172616D206E616D653D22736974652D70617468222073656C6563743D22736974652D7061746822202F3E0D0A202020203C78736C3A7661726961626C65206E616D653D2263757272656E742D706167652D6964223E0D0A20202020202020203C78736C3A76616C75652D6F662073656C6563743D2263757272656E742D706167652D696422202F3E0D0A202020203C2F78736C3A7661726961626C653E0D0A202020200D0A202020200D0A202020203C78736C3A74656D706C617465206D617463683D22706167655B706167652D6C6576656C3D305D223E202020200D0A20202020202020203C68333E3C696D67207372633D226A732F6A71756572792F706C7567696E732F74726565766965772F696D616765732F666F6C6465722E67696622207374796C653D226D617267696E2D626F74746F6D3A2D313070783B222F3E3C2F68333E0D0A20202020202020203C756C2069643D22747265652220636C6173733D227472656576696577223E0D0A2020202020202020202020203C6C693E0D0A202020202020202020202020202020203C7370616E3E0D0A2020202020202020202020202020202020203C6120687265663D227B24736974652D706174687D3F706167655F69643D7B706167652D69647D223E0D0A20202020202020202020202020202020202020203C78736C3A76616C75652D6F662073656C6563743D22706167652D6E616D6522202F3E0D0A2020202020202020202020202020202020203C2F613E0D0A202020202020202020202020202020203C2F7370616E3E0D0A202020202020202020202020202020203C78736C3A696620746573743D226E6F7428737472696E6728706167652D726F6C65293D276E6F6E652729223E3C6272202F3E0D0A20202020202020202020202020202020202020203C7374726F6E673E0D0A2020202020202020202020202020202020202020202020203C78736C3A746578742064697361626C652D6F75747075742D6573636170696E673D22796573223E0D0A20202020202020202020202020202020202020202020202020202020236931386E7B706F7274616C2E736974652E61646D696E5F706167652E74616241646D696E4D6170526F6C6552657365727665647D0D0A2020202020202020202020202020202020202020202020203C2F78736C3A746578743E0D0A20202020202020202020202020202020202020203C2F7374726F6E673E0D0A20202020202020202020202020202020202020203C78736C3A76616C75652D6F662073656C6563743D22706167652D726F6C6522202F3E0D0A202020202020202020202020202020203C2F78736C3A69663E0D0A202020202020202020202020202020200D0A202020202020202020202020202020203C78736C3A696620746573743D226E6F7428737472696E6728706167652D6465736372697074696F6E293D272729223E0D0A20202020202020202020202020202020202020203C6272202F3E0D0A20202020202020202020202020202020202020203C7374726F6E673E0D0A2020202020202020202020202020202020202020202020203C78736C3A746578742064697361626C652D6F75747075742D6573636170696E673D22796573223E0D0A20202020202020202020202020202020202020202020202020202020236931386E7B706F7274616C2E736974652E61646D696E5F706167652E74616241646D696E4D61704465736372697074696F6E7D0D0A2020202020202020202020202020202020202020202020203C2F78736C3A746578743E0D0A20202020202020202020202020202020202020203C2F7374726F6E673E0D0A20202020202020202020202020202020202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D22706167652D6465736372697074696F6E22202F3E0D0A202020202020202020202020202020203C2F78736C3A69663E0D0A202020202020202020202020202020203C756C3E0D0A202020202020202020202020202020202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D70616765732D6C69737422202F3E0D0A202020202020202020202020202020203C2F756C3E0D0A2020202020202020202020203C2F6C693E0D0A20202020202020203C2F756C3E0D0A0D0A202020203C2F78736C3A74656D706C6174653E0D0A202020200D0A202020203C78736C3A74656D706C617465206D617463683D22706167655B706167652D6C6576656C3E305D22203E0D0A20202020202020203C6C693E0D0A20202020202020203C7370616E3E0D0A2020202020202020202020203C6120687265663D227B24736974652D706174687D3F706167655F69643D7B706167652D69647D223E0D0A202020202020202020202020202020203C78736C3A76616C75652D6F662073656C6563743D22706167652D6E616D6522202F3E0D0A2020202020202020202020203C2F613E0D0A202020202020202020203C2F7370616E3E20200D0A2020202020202020202020203C78736C3A696620746573743D226E6F7428737472696E6728706167652D726F6C65293D276E6F6E652729223E3C6272202F3E0D0A202020202020202020202020202020203C7374726F6E673E0D0A20202020202020202020202020202020202020203C78736C3A746578742064697361626C652D6F75747075742D6573636170696E673D22796573223E0D0A202020202020202020202020202020202020202020202020236931386E7B706F7274616C2E736974652E61646D696E5F706167652E74616241646D696E4D6170526F6C6552657365727665647D0D0A20202020202020202020202020202020202020203C2F78736C3A746578743E0D0A202020202020202020202020202020203C2F7374726F6E673E200D0A202020202020202020202020202020203C78736C3A76616C75652D6F662073656C6563743D22706167652D726F6C6522202F3E0D0A2020202020202020202020203C2F78736C3A69663E0D0A2020202020202020202020200D0A2020202020202020202020203C78736C3A696620746573743D226E6F7428737472696E6728706167652D6465736372697074696F6E293D272729223E0D0A202020202020202020202020202020203C6272202F3E0D0A202020202020202020202020202020203C7374726F6E673E0D0A20202020202020202020202020202020202020203C78736C3A746578742064697361626C652D6F75747075742D6573636170696E673D22796573223E0D0A202020202020202020202020202020202020202020202020236931386E7B706F7274616C2E736974652E61646D696E5F706167652E74616241646D696E4D61704465736372697074696F6E7D0D0A20202020202020202020202020202020202020203C2F78736C3A746578743E0D0A202020202020202020202020202020203C2F7374726F6E673E0D0A202020202020202020202020202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D22706167652D6465736372697074696F6E22202F3E0D0A2020202020202020202020203C2F78736C3A69663E0D0A2020202020202020202020200D0A2020202020202020202020203C78736C3A63686F6F73653E0D0A202020202020202020202020202020203C78736C3A7768656E20746573743D22636F756E74286368696C642D70616765732D6C6973742F2A293E30223E0D0A20202020202020202020202020202020202020203C756C3E0D0A2020202020202020202020202020202020202020202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D70616765732D6C69737422202F3E0D0A20202020202020202020202020202020202020203C2F756C3E0D0A202020202020202020202020202020203C2F78736C3A7768656E3E0D0A202020202020202020202020202020203C78736C3A6F74686572776973653E0D0A20202020202020202020202020202020202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D70616765732D6C69737422202F3E0D0A202020202020202020202020202020203C2F78736C3A6F74686572776973653E0D0A2020202020202020202020203C2F78736C3A63686F6F73653E0D0A20202020202020203C2F6C693E0D0A202020203C2F78736C3A74656D706C6174653E0D0A202020200D0A202020203C78736C3A74656D706C617465206D617463683D22706167652D6465736372697074696F6E223E0D0A20202020202020203C78736C3A76616C75652D6F662073656C6563743D222E22202F3E0D0A202020203C2F78736C3A74656D706C6174653E0D0A202020200D0A202020203C78736C3A74656D706C617465206D617463683D226368696C642D70616765732D6C697374223E0D0A20202020202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D227061676522202F3E0D0A202020203C2F78736C3A74656D706C6174653E0D0A202020200D0A3C2F78736C3A7374796C6573686565743E0D0A WHERE id_stylesheet = 279;
--
-- Table structure for table core_theme
--
DROP TABLE IF EXISTS core_theme;
CREATE TABLE  core_theme (
  code_theme varchar(25) default '' NOT NULL,
  theme_description varchar(255),
  path_images varchar(255) NOT NULL,
  path_css varchar(255) NOT NULL,
  theme_author varchar(255),
  theme_author_url varchar(255),
  theme_version varchar(255) NOT NULL,
  theme_licence varchar(255) NOT NULL,
  PRIMARY KEY (code_theme)
);

INSERT INTO core_theme VALUES ('black','Thème Noir','themes/black/images/','themes/black/css/page_template_styles.css','Mairie de Paris','http://fr.lutece.paris.fr','1.0','Creative-Commons');
INSERT INTO core_theme VALUES ('blue','Thème Bleu','images/','css/page_template_styles.css','Mairie de Paris','http://fr.lutece.paris.fr','1.0','Creative-Commons');

--
-- Table structure for table core_theme_global
--
DROP TABLE IF EXISTS core_theme_global;
CREATE TABLE core_theme_global (
  global_theme_code varchar(50) default '' NOT NULL,
  PRIMARY KEY  (global_theme_code)
);

INSERT INTO core_theme_global VALUES ('blue');