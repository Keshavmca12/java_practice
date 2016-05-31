

CREATE SEQUENCE university_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 612774
  CACHE 1;



CREATE SEQUENCE college_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 612774
  CACHE 1;

CREATE TABLE university
(
  UNIVERSITY_ID bigint NOT NULL DEFAULT nextval('university_sequence'::regclass),
  name character varying(100) NOT NULL,
  location character varying(100),
  constraint university_pkey PRIMARY KEY (UNIVERSITY_ID)
)
WITH (
  OIDS=FALSE
);





CREATE TABLE College
(
COLLEGE_ID bigint NOT NULL DEFAULT nextval('college_sequence'::regclass),
  name character varying(100),
  location character varying(100),
  university_id bigint not null,
  CONSTRAINT college_pkey PRIMARY KEY (COLLEGE_ID ),
   CONSTRAINT university_college FOREIGN KEY (university_id)
      REFERENCES university(UNIVERSITY_ID) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);