INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users (id, username, password, email, is_subscribed)
VALUES
    (1, 'Ivo', 'ivo@example.com', '$2a$10$YelHxdnNur5Wc3MKWuYA6OQGGTARcX1ub9z7F0Ty/5Tlm/80loZhi', true);


INSERT INTO users_roles (user_entity_id, roles_id)
VALUES
    (1, 1),
    (1, 2);