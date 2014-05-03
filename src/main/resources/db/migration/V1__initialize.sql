-- Table: sequence

CREATE TABLE sequence
(
  seq_name character varying(50) NOT NULL,
  seq_count numeric(38,0),
  CONSTRAINT sequence_pkey PRIMARY KEY (seq_name)
);
ALTER TABLE sequence
  OWNER TO monster;


-- Table: news

CREATE TABLE news
(
  id bigint NOT NULL,
  text text,
  title character varying(255),
  CONSTRAINT news_pkey PRIMARY KEY (id)
);
ALTER TABLE news
OWNER TO monster;

