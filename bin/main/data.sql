/* ユーザーのテーブルのデータ　*/
INSERT INTO user(employee_id, employee_name, age)VALUES(0026, 'tamura', 28);

/* ユーザーのマスタのデータ （アドミン権限）*/
INSERT INTO user_info (id, password, user_name, age, role) VALUES (0026, 'password01', 'tamura', 28, 'ROLE_ADMIN');

/* ユーザーのマスタのデータ（一般権限） */
INSERT INTO user_info (id, password, user_name, age, role) VALUES (0027, 'password02', 'fujiwara', 28, 'ROLE_GENERAL');