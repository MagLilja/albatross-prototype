-- mod / yrgoP4ssword
INSERT INTO public.users (id, email, password, username) VALUES (1, 'tesdt@test.com', '$2a$10$a0K59Ok96Il1ukKePfz9T.2WZpxm86UDYl9tCL0/NqtjyTeejGycW', 'mod');

INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 1);
