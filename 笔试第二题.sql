/*创建员工信息表*/
create table person (
	per_id int(10) NOT NULL PRIMARY KEY COMMENT '员工编号',
	dept_id int(10) NOT NULL COMMENT '部门编号',
	per_name varchar(20) NOT NULL COMMENT '员工姓名',
	per_sex varchar(5) NOT NULL COMMENT '员工性别',
	per_age int(5) NOT NULL COMMENT '员工年龄',
	per_phone varchar(11) NOT NULL COMMENT '员工手机号',
	per_jobName varchar(30) NOT NULL COMMENT '员工岗位名称'
) CHARACTER SET GBK COMMENT '员工信息表'

/*创建触发器实现插入数据时手机号脱敏*/
create trigger tuoming before insert on person for each row
begin
	  set new.per_phone = concat(left(new.per_phone,3), '*****' ,right(new.per_phone,3));
end 

/*统计各部门员工人数*/
select dept_id,count(*) as per_num from person group by dept_id

/*查询每个部门年龄最大的员工信息*/
select * from person p,(select dept_id,max(per_age) as max_age from person group by dept_id) m 
where p.dept_id = m.dept_id and p.per_age = m.max_age

/*根据手机号查询*/
select * from person where per_phone = concat(left('15188908409',3), '*****' ,right('15188908409',3))

