drop schema if exists pets;
create schema pets;
use pets;

create table dogs (
	id int unsigned not null auto_increment primary key,
    name varchar(63) not null,
    description varchar(511) not null,
    breed varchar(63) not null,
    age int(3) not null,
    size int(3) not null,
    origin varchar(80) not null,
    price int(9) not null,
    image_url varchar(300) not null
);

create table users (
	id int unsigned not null auto_increment primary key,
    first_name varchar(20) not null,
    last_name varchar(40) not null,
    email varchar(80) not null unique,
    phone varchar(13),
    address varchar(120),
    google_id varchar(255),
    password varchar(200)
);
create table orders (
	id int unsigned not null auto_increment primary key,
    pet_id int unsigned not null,
	user_id int unsigned not null,
    order_status varchar(15),
    created_at TIMESTAMP DEFAULT current_timestamp not null,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    rating int(2),
	constraint fk_person_order foreign key (user_id) references users(id),
    constraint fk_pet_order foreign key (pet_id) references dogs(id)
);

insert into dogs(name, description, breed, age, size, origin, price, image_url) values 
	('Bruno', 'Good boy', 'Golden Retriever', 8, 185, 'Gnjilane', 150, 'https://plus.unsplash.com/premium_photo-1723709016897-3cc15635e618?q=80&w=1780&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
    ('Dzoni', 'Goodest boy', 'Illyrian Shepherd', 1, 210, 'Svrljig', 95, 'https://upload.wikimedia.org/wikipedia/commons/a/a6/Sarplaninac_k%C3%B6ly%C3%B6k.JPG'),
    ('Roki', 'Strong boy', 'American Stafford', 5, 150, 'Cacak', 50, 'https://cdn.pixabay.com/photo/2015/03/14/04/24/american-staffordshire-terrier-672699_1280.jpg'),
    ('Dzeki', 'Cuddly boy', 'Mixed street dog', 3, 130, 'Novi Pazar', 10, 'https://breed-assets.wisdompanel.com/dog/street-dog-india/Indian_Street_Dog1.jpg'),
    ('Marek', 'Slovak boy', 'Poodle', 6, 120, 'Novi Sad', 20, 'https://floridafurbabies.com/azure/sunshinestatepups/pups/white%20Poodle%20dog.png?w=557&h=557&mode=crop&autorotate=1'),
	('Novak', 'Goody boy', 'Labrador Retriever', 6, 185, 'Kraljevo', 40, 'https://xdn.tf.rs/2024/11/05/shutterstock1397834915-830x553.jpg'),
    ('Nidza', 'Very good boy', 'German Shepherd', 2, 120, 'Vranje', 60, 'https://images.unsplash.com/photo-1633564522273-2b2a3f21d860?q=80&w=2128&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
    ('Kika', 'English girly', 'English Bulldog', 5, 80, 'Beograd', 30, 'https://upload.wikimedia.org/wikipedia/commons/b/bf/Bulldog_inglese.jpg'),
    ('Marsovac', 'Alien boy', 'Unknown', 90, 130, 'Prizren', 1, 'https://assets3.thrillist.com/v1/image/2523441/1000x750/scale;webp=auto;jpeg_quality=60.jpg'),
    ('Toza', 'Twirly girl', 'Dalmatian', 6, 120, 'Zadar', 20, 'https://assets.rightpaw.com.au/images/breeds/dalmatian.jpg'),
    ('Mima', 'Fancy girl', 'Maltese Dog', 6, 120, 'Banja Luka', 10, 'https://upload.wikimedia.org/wikipedia/commons/9/94/Maltese_600.jpg'),
    ('Niksa', 'Big shepherd boy', 'Caucasian Shepherd', 3, 220, 'Niksic', 80, 'https://upload.wikimedia.org/wikipedia/commons/0/0b/Owczarek_kaukaski_65556.jpg'),
    ('Micko', 'Proud lil guy', 'Black Schnauzer', 3, 80, 'Kladovo', 20, 'https://upload.wikimedia.org/wikipedia/commons/3/3b/BlkStdSchnauzer2.jpg'),
    ('Leo', 'Wannabe shepherd', 'Jack Russel', 4, 80, 'Skadar', 30, 'https://upload.wikimedia.org/wikipedia/commons/9/99/Brooks_Chase_Ranger_of_Jolly_Dogs_Jack_Russell.jpg');
    
insert into users (first_name, last_name, email, phone, address, password) values
	('Matej', 'Matejevic', 'matej@gmail.com','38165151151', 'Nis', '$2a$10$xphhF81dU1yCcINdh/Jy.eX4O1GBgw6KB6Oqgsa7sqEgjJeLdHVum'),
	('Marko', 'Markovic', 'marko@gmail.com','38163333666', 'Beograd','$2a$10$kg4AVsxDH6kisK9ZnpWWyeBldRYpUyXL1vujUdp5gJ7HqdQRyHVI2'),
	('Luka', 'Lukic', 'luka@gmail.com','3816060606', 'Pristina', '$2a$10$3wB61PSySqN4.xKFC5Q47e2GRB12Z.lRYoYAm0V9ZtjF0vMyLX6Dq'),
	('Jovan', 'Jovanovic', 'jovan@gmail.com','38160121212', 'Negotin', '$2a$10$.WCPIsFFi2sflgLL5LwP.OpK1ju.cZZRobaZgu0TSVQl5fGuPQwAa'),
	('Darko', 'Darkovic', 'darko@gmail.com','38160121212', 'Gnjilane', '$2a$10$.ZzLHvPCQP3UKnbGnrSci.SeoEXLTYGaCXtQYD8qj9wQfzG6whx0G'),
	('Aksentije', 'Aksentijevic', 'aksentije@gmail.com','38160121212', 'Raska', '$2a$10$Xn1E/Ohjq3U7AtVCnBv9/uJAqx3nQH.0LVqlvdjje8fkCryTDZgSe'),
	('Bogdan', 'Bogdanovic', 'bogdan@gmail.com','38160121212', 'Kraljevo', '$2a$10$7kgzRp2v3tK5uGEznK0Z8OXO5EiWpWn2zz9rcO4zNISEbwKl00H5u'),
	('Cvetolik', 'Cvetolikovic', 'cvetolik@gmail.com','38160121212', 'Backa Palanka', '$2a$10$mJdOhxG.PSvKdvr2zSrr9ejiPynHkcxlOalO9Uzj9vvAJtgOQwGt6'),
	('Dragoslav', 'Dragoslavljevic', 'dragoslav@gmail.com','38160121212', 'Jagodina', '$2a$10$Ea8hUItNl3dXk0.LHtV1hO7iH6CzLlemVcU7I0/msX40y1sWqQIbW'),
	('Radasin', 'Radasinovic', 'radasin@gmail.com','38160121212', 'Petrovac na Mlavi', '$2a$10$wENXgXWyl/Y4Avv1cPf7tOqHmLx8oaT2LOUKWmzr7uoMc/ykXx03u'),
	('Petar', 'Petrovic', 'petar@gmail.com','38160121212', 'Subotica', '$2a$10$R.DZc2Z6x0f4H0xrSFZ9eOopBZlxf5pfhvpqaSsDUsPMltgk4Dklm');

    