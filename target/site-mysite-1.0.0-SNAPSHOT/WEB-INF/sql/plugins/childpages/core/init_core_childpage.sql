--
-- Dumping data for table `core_style`
--
INSERT INTO core_style (id_style, description_style, id_portlet_type, id_portal_component) VALUES (300,'Défaut','CHILDPAGES_PORTLET',0);
INSERT INTO core_style (id_style, description_style, id_portlet_type, id_portal_component) VALUES (301,'Image + lien','CHILDPAGES_PORTLET',0);

--
-- Dumping data for table `core_style_mode_stylesheet`
--
INSERT INTO core_style_mode_stylesheet (id_style, id_mode, id_stylesheet) VALUES (300,0,30);
INSERT INTO core_style_mode_stylesheet (id_style, id_mode, id_stylesheet) VALUES (301,0,9006);

--
-- Dumping data for table `core_stylesheet`
--
INSERT INTO core_stylesheet (id_stylesheet, description, file_name, source) VALUES (30,'Rubrique Pages filles - Défaut','portlet_childpages_simple.xsl',0x3C3F786D6C2076657273696F6E3D22312E30223F3E0D0A3C78736C3A7374796C6573686565742076657273696F6E3D22312E302220786D6C6E733A78736C3D22687474703A2F2F7777772E77332E6F72672F313939392F58534C2F5472616E73666F726D223E0D0A0D0A3C78736C3A706172616D206E616D653D22736974652D70617468222073656C6563743D22736974652D7061746822202F3E0D0A0D0A3C78736C3A74656D706C617465206D617463683D22706F72746C6574223E0D0A0D0A093C78736C3A7661726961626C65206E616D653D226465766963655F636C617373223E0D0A093C78736C3A63686F6F73653E0D0A09093C78736C3A7768656E20746573743D22737472696E6728646973706C61792D6F6E2D736D616C6C2D646576696365293D273027223E68696464656E2D70686F6E653C2F78736C3A7768656E3E0D0A09093C78736C3A7768656E20746573743D22737472696E6728646973706C61792D6F6E2D6E6F726D616C2D646576696365293D273027223E68696464656E2D7461626C65743C2F78736C3A7768656E3E0D0A09093C78736C3A7768656E20746573743D22737472696E6728646973706C61792D6F6E2D6C617267652D646576696365293D273027223E68696464656E2D6465736B746F703C2F78736C3A7768656E3E0D0A09093C78736C3A6F74686572776973653E3C2F78736C3A6F74686572776973653E0D0A093C2F78736C3A63686F6F73653E0D0A093C2F78736C3A7661726961626C653E0D0A090D0A093C64697620636C6173733D22706F72746C6574207B246465766963655F636C6173737D223E0D0A20202020202020203C78736C3A696620746573743D226E6F7428737472696E6728646973706C61792D706F72746C65742D7469746C65293D27312729223E0D0A0909093C64697620636C6173733D22706F72746C65742D686561646572202D746F70223E0D0A090909093C78736C3A76616C75652D6F662064697361626C652D6F75747075742D6573636170696E673D22796573222073656C6563743D22706F72746C65742D6E616D6522202F3E0D0A0909093C2F6469763E0D0A20202020202020203C2F78736C3A69663E0D0A09093C78736C3A696620746573743D226E6F7428737472696E6728646973706C61792D706F72746C65742D7469746C65293D27312729223E0D0A0909093C6469763E0D0A090909093C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D70616765732D706F72746C657422202F3E0D0A0909093C2F6469763E0D0A20202020202020203C2F78736C3A69663E0D0A09093C78736C3A696620746573743D22737472696E6728646973706C61792D706F72746C65742D7469746C65293D273127223E0D0A0909093C64697620636C6173733D22706F72746C65742D636F6E74656E74223E0D0A090909093C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D70616765732D706F72746C657422202F3E0D0A0909093C2F6469763E0D0A20202020202020203C2F78736C3A69663E0D0A093C2F6469763E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D226368696C642D70616765732D706F72746C6574223E0D0A093C756C3E0D0A09202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D7061676522202F3E0D0A093C2F756C3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D226368696C642D70616765223E0D0A093C6C693E0D0A09093C6120687265663D227B24736974652D706174687D3F706167655F69643D7B6368696C642D706167652D69647D22207461726765743D225F746F70223E0D0A0909093C623E3C78736C3A76616C75652D6F662073656C6563743D226368696C642D706167652D6E616D6522202F3E3C2F623E0D0A09093C2F613E3C62722F3E0D0A09093C78736C3A76616C75652D6F662073656C6563743D226368696C642D706167652D6465736372697074696F6E22202F3E3C62722F3E0D0A093C2F6C693E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C2F78736C3A7374796C6573686565743E);
INSERT INTO core_stylesheet (id_stylesheet, description, file_name, source) VALUES (9006,'Rubrique Liste de pages filles - Image','portlet_childpages_image.xsl',0x3C3F786D6C2076657273696F6E3D22312E30223F3E0D0A3C78736C3A7374796C6573686565742076657273696F6E3D22312E302220786D6C6E733A78736C3D22687474703A2F2F7777772E77332E6F72672F313939392F58534C2F5472616E73666F726D223E0D0A0D0A3C78736C3A706172616D206E616D653D22736974652D70617468222073656C6563743D22736974652D7061746822202F3E0D0A0D0A3C78736C3A74656D706C617465206D617463683D22706F72746C6574223E0D0A0D0A093C78736C3A7661726961626C65206E616D653D226465766963655F636C617373223E0D0A093C78736C3A63686F6F73653E0D0A09093C78736C3A7768656E20746573743D22737472696E6728646973706C61792D6F6E2D736D616C6C2D646576696365293D273027223E68696464656E2D70686F6E653C2F78736C3A7768656E3E0D0A09093C78736C3A7768656E20746573743D22737472696E6728646973706C61792D6F6E2D6E6F726D616C2D646576696365293D273027223E68696464656E2D7461626C65743C2F78736C3A7768656E3E0D0A09093C78736C3A7768656E20746573743D22737472696E6728646973706C61792D6F6E2D6C617267652D646576696365293D273027223E68696464656E2D6465736B746F703C2F78736C3A7768656E3E0D0A09093C78736C3A6F74686572776973653E3C2F78736C3A6F74686572776973653E0D0A093C2F78736C3A63686F6F73653E0D0A093C2F78736C3A7661726961626C653E0D0A0D0A093C64697620636C6173733D22706F72746C6574207B246465766963655F636C6173737D223E0D0A09093C78736C3A696620746573743D226E6F7428737472696E6728646973706C61792D706F72746C65742D7469746C65293D27312729223E0D0A0909093C68333E0D0A090909093C78736C3A76616C75652D6F662064697361626C652D6F75747075742D6573636170696E673D22796573222073656C6563743D22706F72746C65742D6E616D6522202F3E0D0A0909093C2F68333E0D0A09093C2F78736C3A69663E0D0A09093C78736C3A696620746573743D226E6F7428737472696E6728646973706C61792D706F72746C65742D7469746C65293D27312729223E0D0A0909093C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D70616765732D706F72746C657422202F3E0D0A0909093C78736C3A746578742064697361626C652D6F75747075742D6573636170696E673D22796573223E0D0A09090909093C215B43444154415B3C64697620636C6173733D22636C656172666978223E26233136303B3C2F6469763E5D5D3E0D0A090909093C2F78736C3A746578743E0D0A09093C2F78736C3A69663E0D0A09093C78736C3A696620746573743D22737472696E6728646973706C61792D706F72746C65742D7469746C65293D273127223E0D0A090909093C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D70616765732D706F72746C657422202F3E0D0A090909093C78736C3A746578742064697361626C652D6F75747075742D6573636170696E673D22796573223E0D0A09090909093C215B43444154415B3C64697620636C6173733D22636C656172666978223E26233136303B3C2F6469763E5D5D3E0D0A090909093C2F78736C3A746578743E0D0A09093C2F78736C3A69663E0D0A093C2F6469763E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D226368696C642D70616765732D706F72746C6574223E0D0A093C756C20636C6173733D22756E7374796C6564223E0D0A09093C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D7061676522202F3E0D0A093C2F756C3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C78736C3A74656D706C617465206D617463683D226368696C642D70616765223E0D0A093C6C693E0D0A2009093C6120687265663D227B24736974652D706174687D3F706167655F69643D7B6368696C642D706167652D69647D22207461726765743D225F746F70223E0D0A09093C78736C3A6170706C792D74656D706C617465732073656C6563743D226368696C642D706167652D696D61676522202F3E0D0A0909093C7374726F6E673E3C78736C3A76616C75652D6F662073656C6563743D226368696C642D706167652D6E616D6522202F3E3C2F7374726F6E673E0D0A09093C2F613E0D0A09093C6272202F3E0D0A09093C78736C3A76616C75652D6F662073656C6563743D226368696C642D706167652D6465736372697074696F6E22202F3E0D0A093C2F6C693E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C212D2D20466F726D617420696D61676520706F6C61726F6964202D2D3E0D0A3C78736C3A74656D706C617465206D617463683D226368696C642D706167652D696D616765223E0D0A202020203C64697620636C6173733D22696D672D706F6C61726F6964207370616E33223E0D0A202020202020203C696D67207372633D227B2E7D2220616C743D227B2E2E2F6368696C642D706167652D6E616D657D22202F3E0D0A202020203C2F6469763E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A0D0A3C2F78736C3A7374796C6573686565743E);

--
-- Dumping data for table core_portlet_type
--
INSERT INTO core_portlet_type (id_portlet_type,name,url_creation,url_update,home_class,plugin_name,url_docreate,create_script,create_specific,create_specific_form,url_domodify,modify_script,modify_specific,modify_specific_form) VALUES 
 ('CHILDPAGES_PORTLET','childpages.portlet.name','plugins/childpages/CreatePortletChildPages.jsp','plugins/childpages/ModifyPortletChildPages.jsp','fr.paris.lutece.plugins.childpages.business.portlet.ChildPagesPortletHome','childpages','plugins/childpages/DoCreatePortletChildPages.jsp','/admin/portlet/script_create_portlet.html','/admin/plugins/childpages/value_id_parent.html','','plugins/childpages/DoModifyPortletChildPages.jsp','/admin/portlet/script_modify_portlet.html','/admin/plugins/childpages/value_id_parent.html','');


