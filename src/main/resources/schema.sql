
-- users are the main attraction here. You must be logged in to do anything else with these notes
-- Everything in the user entity must be unique except for the password
CREATE TABLE USER(
  USER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  LAST_NAME VARCHAR(16) NOT NULL,
  FIRST_NAME VARCHAR(16) NOT NULL,
  USERNAME VARCHAR(16) NOT NULL UNIQUE,
  EMAIL VARCHAR(50) NOT NULL UNIQUE,
  HASHED_PASSWORD VARCHAR(255) NOT NULL
);

-- Subjects is a used to index the public and private notes.. Subjects are required to be unique
-- Subject's ID is the PK and also the subject itself
CREATE TABLE SUBJECT(
  SUBJECT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  SUBJECT_NAME VARCHAR(128) NOT NULL UNIQUE
);
--public notes will keep the user_id to know who created the note
-- It will be indexed by its subject_id associated
CREATE TABLE PUBLICNOTE(
  PUBLIC_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR (80) NOT NULL,
  USER_ID BIGINT NOT NULL,
  SUBJECT_ID BIGINT NOT NULL,
  CONTENT CLOB NOT NULL
);
--private notes will only be accessible through the USER_ID
-- The private notes will be indexed through subject_id
CREATE TABLE PRIVATENOTE(
    PRIVATE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR (80) NOT NULL,
    USER_ID BIGINT NOT NULL,
    SUBJECT_ID BIGINT,
    CONTENT CLOB NOT NULL
);
-- Add foreign keys between the tables
ALTER TABLE PUBLICNOTE ADD FOREIGN KEY (SUBJECT_ID) REFERENCES SUBJECT(SUBJECT_ID);
ALTER TABLE PUBLICNOTE ADD FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID);
ALTER TABLE PRIVATENOTE ADD FOREIGN KEY (SUBJECT_ID) REFERENCES SUBJECT(SUBJECT_ID);
ALTER TABLE PRIVATENOTE ADD FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID);
-- Indexes set for the tables automatically for foreign keys and primary keys by H2
-- Users should be indexed by their unique username to allow rapid look up
