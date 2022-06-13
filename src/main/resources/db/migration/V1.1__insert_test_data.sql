insert into schedule_user (name, address, phone_number, role)
values ('test1', 'test1_address', '010-1111-1111', 'test1');
insert into schedule_user (name, address, phone_number, role)
values ('test2', 'test2_address', '010-2222-2222', 'test2');
insert into schedule_user (name, address, phone_number, role)
values ('test3', 'test3_address', '010-3333-3333', 'test3');

insert into schedule_schedule (title, contents, location, start_date, end_date, owner)
values ('test_sc1', 'test_cnts1', 'test_loc1', '2022-06-13 09:00:00', '2022-06-13 11:00:00', 1);
insert into schedule_schedule (title, contents, location, start_date, end_date, owner)
values ('test_sc2', 'test_cnts2', 'test_loc2', '2022-06-13 13:00:00', '2022-06-13 15:00:00', 2);
insert into schedule_schedule (title, contents, location, start_date, end_date, owner)
values ('test_sc3', 'test_cnts3', 'test_loc3', '2022-06-13 17:00:00', '2022-06-13 18:00:00', 3);

insert into schedule_attendees (schedule_id, attendees)
values (1, 2);
insert into schedule_attendees (schedule_id, attendees)
values (2, 1);
insert into schedule_attendees (schedule_id, attendees)
values (2, 3);
insert into schedule_attendees (schedule_id, attendees)
values (3, 2);