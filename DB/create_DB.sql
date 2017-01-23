DROP TABLE MI_User;


CREATE TABLE MI_User (
	id_user NUMBER(11) NOT NULL,
	index_user NUMBER(11),
	guid varchar2(256),
	isActive NUMBER(11) DEFAULT 0 NOT NULL ,
	balance NUMBER(11,2),
	picture varchar2(256),
	age NUMBER(3),
	eyeColor varchar2(256),
	name_user varchar2(128),
	gender varchar2(5),
	company varchar2(256),
	email varchar2(128),
	phone varchar2(128),
	address varchar2(256),
	about varchar2(256),
	registered varchar2(256),
	latitude NUMBER(11,2),
	longitude NUMBER(11,2),
	greeting varchar2(128),
	favoriteFruit varchar2(256),
	constraint USER_PK PRIMARY KEY (id_user));
/
DROP TABLE User_Tag;

CREATE TABLE User_Tag (
	id_tag NUMBER(11) NOT NULL,
	Tag_name varchar2(128),
  id_user NUMBER(11) NOT NULL,
	constraint TAG_PK PRIMARY KEY (id_tag));
/
DROP TABLE Friends;

CREATE TABLE Friends (
	id_friend NUMBER(11) not null,
	name VARCHAR2(64),
  id_user NUMBER(11) NOT NULL,
	constraint FRIEND_PK PRIMARY KEY (id_friend)
);
/
DROP trigger BI_USER;

CREATE OR REPLACE trigger BI_USER
  before insert on MI_USER
  for each row
begin
  select USER_SEQ.nextval 
  into :NEW.id_user 
  from dual;
end;
/
CREATE sequence TAG_SEQ;
/
CREATE OR REPLACE trigger BI_TAG
  before insert on User_Tag
  for each row
begin
  select TAG_SEQ.nextval 
  into :NEW.id_tag 
  from dual;
end;
/
DROP TRIGGER BI_FRIENDS;

CREATE OR REPLACE trigger BI_FRIENDS
  before insert on Friends
  for each row
begin
  select FRIEND_SEQ.nextval 
  into :NEW.id_friend 
  from dual;
end;
/
ALTER TABLE USER_TAG
DROP CONSTRAINT user_tag_fk;

ALTER TABLE USER_TAG
ADD CONSTRAINT user_tag_fk
  FOREIGN KEY (id_user)
REFERENCES MI_USER(id_user);
/
ALTER TABLE MI_USER 
DROP CONSTRAINT friend_fk; 

ALTER TABLE FRIENDS 
ADD CONSTRAINT user_friend_fk 
  FOREIGN KEY (id_user) 
REFERENCES MI_USER(id_user);
/
DROP sequence MI_USER_SEQ;

CREATE sequence MI_USER_SEQ;
/
INSERT INTO MI_USER (BALANCE, AGE, NAME_USER, GENDER, COMPANY, EMAIL, ADDRESS)
    VALUES (0, 32, 'VADIM', 'MALE', 'EPAM', 'ttt@epam.com', 'chel street');

INSERT INTO Friends (NAME, ID_USER) VALUES ('Vadim', 2);

INSERT INTO Friends (NAME, ID_USER) VALUES ('Anna', 2);

INSERT INTO Friends (NAME, ID_USER) VALUES ('Marina', 2);

INSERT INTO USER_TAG (TAG_NAME, ID_USER) VALUES ('ORANGE', 2);

INSERT INTO USER_TAG (TAG_NAME, ID_USER) VALUES ('RED', 2);

INSERT INTO USER_TAG (TAG_NAME, ID_USER) VALUES ('BLUE', 2);

/
DROP SEQUENCE FRIEND_SEQ;
CREATE sequence FRIEND_SEQ;
/

SELECT ID_USER, 
  INDEX_USER, 
  GUID, 
  ISACTIVE, 
  BALANCE, 
  PICTURE, 
  AGE,
  EYECOLOR, 
  NAME_USER, 
  GENDER, 
  COMPANY,
  EMAIL, 
  PHONE,
  ADDRESS ,
  ABOUT,
  REGISTERED,
  LATITUDE, 
  LONGITUDE,
  GREETING,
  FAVORITEFRUIT
  FROM MI_USER;
  
  select *
  from MI_USER;
  
  delete
  from MI_USER;
  
  delete
  from MI_USER
  where id_user = 4;
  
  DELETE
  FROM USER_TAG;
  
  DELETE
  FROM FRIENDS;