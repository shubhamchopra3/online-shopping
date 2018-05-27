CREATE TABLE category (

 id IDENTITY,
 name varchar(50),
 description varchar(255),
 image_url varchar(255),
 is_active boolean,
 
 CONSTRAINT pk_category_id PRIMARY KEY(id)
 
);
