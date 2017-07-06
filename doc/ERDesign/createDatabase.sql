
/* Create Tables */

CREATE TABLE buied_item
(
	-- buied_item表的主键
	id serial NOT NULL,
	name bit varying,
	-- category表的主键
	category_id_fk int NOT NULL,
	-- user表的主键
	buied_user_id_fk int NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE category
(
	-- category表的主键
	id serial NOT NULL,
	name bit varying,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE pictures
(
	-- picture表的主键
	id serial NOT NULL,
	-- picture在本地的路径
	path bit varying,
	-- published_item表的主键
	published_item_id_fk int NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE published_item
(
	-- published_item表的主键
	id serial NOT NULL,
	name bit varying,
	-- 物品发布时间
	publish_time date,
	origin_price float,
	sell_price float,
	status bit varying,
	description bit varying,
	picture bit varying,
	-- 是否支持"讲价"
	bargin boolean,
	-- category表的主键
	category_id_fk int NOT NULL,
	-- user表的主键
	published_user_id_fk int NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE selled_item
(
	-- selled_item表的主键
	id serial NOT NULL,
	name bit varying,
	ogrigin_price float,
	sell_price float,
	status bit varying,
	-- category表的主键
	category_id_fk int NOT NULL,
	-- user表的主键
	selled_user_id_fk int NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE users
(
	-- user表的主键
	id serial NOT NULL,
	name bit varying,
	-- 用户昵称
	nickname bit varying,
	password bit varying,
	-- 用户简介
	introduction bit varying,
	PRIMARY KEY (id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE buied_item
	ADD FOREIGN KEY (category_id_fk)
	REFERENCES category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE published_item
	ADD FOREIGN KEY (category_id_fk)
	REFERENCES category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE selled_item
	ADD FOREIGN KEY (category_id_fk)
	REFERENCES category (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE pictures
	ADD FOREIGN KEY (published_item_id_fk)
	REFERENCES published_item (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE buied_item
	ADD FOREIGN KEY (buied_user_id_fk)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE published_item
	ADD FOREIGN KEY (published_user_id_fk)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE selled_item
	ADD FOREIGN KEY (selled_user_id_fk)
	REFERENCES users (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Comments */

COMMENT ON COLUMN buied_item.id IS 'buied_item表的主键';
COMMENT ON COLUMN buied_item.category_id_fk IS 'category表的主键';
COMMENT ON COLUMN buied_item.buied_user_id_fk IS 'user表的主键';
COMMENT ON COLUMN category.id IS 'category表的主键';
COMMENT ON COLUMN pictures.id IS 'picture表的主键';
COMMENT ON COLUMN pictures.path IS 'picture在本地的路径';
COMMENT ON COLUMN pictures.published_item_id_fk IS 'published_item表的主键';
COMMENT ON COLUMN published_item.id IS 'published_item表的主键';
COMMENT ON COLUMN published_item.publish_time IS '物品发布时间';
COMMENT ON COLUMN published_item.bargin IS '是否支持"讲价"';
COMMENT ON COLUMN published_item.category_id_fk IS 'category表的主键';
COMMENT ON COLUMN published_item.published_user_id_fk IS 'user表的主键';
COMMENT ON COLUMN selled_item.id IS 'selled_item表的主键';
COMMENT ON COLUMN selled_item.category_id_fk IS 'category表的主键';
COMMENT ON COLUMN selled_item.selled_user_id_fk IS 'user表的主键';
COMMENT ON COLUMN users.id IS 'user表的主键';
COMMENT ON COLUMN users.nickname IS '用户昵称';
COMMENT ON COLUMN users.introduction IS '用户简介';




