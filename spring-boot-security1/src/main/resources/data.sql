insert into sys_user (id,user_name, password) values (1,'admin', 'admin');
insert into sys_user (id,user_name, password) values (2,'dongjun', '123456');

insert into sys_role(id,name) values(1,'ROLE_ADMIN');
insert into sys_role(id,name) values(2,'ROLE_USER');

insert into sys_role_user(role_id,user_id) values(1,1);
insert into sys_role_user(role_id,user_id) values(2,2);