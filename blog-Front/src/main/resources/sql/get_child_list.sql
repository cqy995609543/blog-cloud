DELIMITER $$
drop function if exists get_child_list$$
create function get_child_list(in_id varchar(10)) returns varchar(1000)
begin
 declare ids varchar(1000) default '';
 declare tempids varchar(1000);
 set tempids = in_id;
 while tempids is not null do
  set ids = CONCAT_WS(',',ids,tempids);
select GROUP_CONCAT(menu_id) into tempids from blogs_menu where FIND_IN_SET(menu_fid,tempids)>0;
end while;
return ids;
end
$$
delimiter;

-- 查询当前菜单下属所有子菜单，包括2级，3级子菜单。
-- 参考博客https://database.51cto.com/art/202007/622644.htm