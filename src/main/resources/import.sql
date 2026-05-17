-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO user_credentials (
    id,
    full_name,
    email,
    password_hash
)
VALUES (
           gen_random_uuid(),
           'Administrador',
           'admin@jusconnect.com',
           '$2a$10$7QJ2sF0M5jK6QmW8P5s7eO6nV8qYQJQ0m2Rz4Jm7gF5sL1nT9cP2W'
       );