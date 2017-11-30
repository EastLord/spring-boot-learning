insert into sys_user (id,user_name, password) values (1,'admin', '27385e9698462c9d4aed53e23ebb109b');
insert into sys_user (id,user_name, password) values (2,'user', 'a2e48badb138b6bd03939642b733c3c8');

insert into sys_role(id,name) values(1,'ROLE_ADMIN');
insert into sys_role(id,name) values(2,'ROLE_USER');

insert into sys_role_user(role_id,user_id) values(1,1);
insert into sys_role_user(role_id,user_id) values(2,2);