CREATE TABLE silvia.user_table
(
    id bigserial PRIMARY KEY,
    username text NOT NULL,
    password text NOT NULL,
    role character varying NOT NULL DEFAULT 'USER',
    CONSTRAINT users_username_key UNIQUE (username)
);