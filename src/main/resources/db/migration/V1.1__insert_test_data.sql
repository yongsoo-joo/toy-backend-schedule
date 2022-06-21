INSERT INTO schedule_user (name, email, password)
VALUES ('admin', 'admin@test.com', '$2a$10$t9FI8QkEwJjsbcf5kJJJVOP7tvk5BonRbZPiUQ8rxHkwC.tTE.n4y');
INSERT INTO schedule_user (name, email, password)
VALUES ('user1', 'user1@test.com', '$2a$10$t6hIMFodsmQa1ab65x9OGeaNcIsqUupExuLeXD9gtIxsxPxByn5pm');
INSERT INTO schedule_user (name, email, password)
VALUES ('user2', 'user2@test.com', '$2a$10$4K20KUULwNqiHI2dJUOD5.ocNHXZtyD.r5CYbyxhE1pzr59bUH2ym');
INSERT INTO schedule_user (name, email, password)
VALUES ('ys.joo', 'dkjs112@test.com', '$2a$10$j/1AL.5JNGOgARp.cceEv.soFKSGaQyjdwxEzEja2wgjt4HpDIJBC');

INSERT INTO schedule_schedule (title, contents, location, start_date, end_date, owner)
VALUES ('test_sc1', 'test_cnts1', 'test_loc1', '2022-06-13 09:00:00', '2022-06-13 11:00:00', 1);
INSERT INTO schedule_schedule (title, contents, location, start_date, end_date, owner)
VALUES ('test_sc2', 'test_cnts2', 'test_loc2', '2022-06-13 13:00:00', '2022-06-13 15:00:00', 2);
INSERT INTO schedule_schedule (title, contents, location, start_date, end_date, owner)
VALUES ('test_sc3', 'test_cnts3', 'test_loc3', '2022-06-13 17:00:00', '2022-06-13 18:00:00', 3);

INSERT INTO schedule_attendees (schedule_id, attendees)
VALUES (1, 2);
INSERT INTO schedule_attendees (schedule_id, attendees)
VALUES (2, 1);
INSERT INTO schedule_attendees (schedule_id, attendees)
VALUES (2, 3);
INSERT INTO schedule_attendees (schedule_id, attendees)
VALUES (3, 2);