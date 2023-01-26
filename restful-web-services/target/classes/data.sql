insert into user_details(id,birth_date,name) values (10001,current_date(),'Gowtami');
insert into user_details(id,birth_date,name) values (10002,current_date(),'Mohan');
insert into user_details(id,birth_date,name) values (10003,current_date(),'Sowmya');

insert into post(id,description,user_id) values (20001,'I want to Learn AWS', 10001);
insert into post(id,description,user_id) values (20002,'I want to Learn Spring', 10001);
insert into post(id,description,user_id) values (20003,'I want to Learn MicroServices', 10002);
insert into post(id,description,user_id) values (20004,'I want to Learn DevOps', 10002);