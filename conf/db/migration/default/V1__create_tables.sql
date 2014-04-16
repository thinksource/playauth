CREATE TABLE account (
    id         integer NOT NULL PRIMARY KEY,
    email      varchar(255) NOT NULL UNIQUE,
    password   varchar(255) NOT NULL,
    name       varchar(255) NOT NULL,
    permission varchar(255) NOT NULL
);
