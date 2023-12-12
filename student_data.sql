INSERT INTO st_street (street_code, street_name) VALUES
(1, 'улица Садовая'),
(2, 'Невский проспект'),
(3, 'улица Стахановцев'),
(4, 'улица Гороховая'),
(5, 'проспект Ветеранов');

INSERT INTO jc_country_street (area_id, area_name) VALUES
('010000000000','Город'),
('010010000000','Городо район 1'),
('010020000000','Городо район 2'),
('010020000000','Городо район 3'),
('010040000000','Городо район 4'),

('010000000000','Край'),
('020010010000','Край Область 1'),
('020010010000','Край Область 1 район 1'),
('020010010001','Край Область 1 район 1 поселение 1'),
('020010020002','Край Область 1 район 1 поселение 2'),
('020010020000','Край Область 1 район 2'),
('020010020001','Край Область 1 район 2 поселение 1'),
('020010020002','Край Область 1 район 2 поселение 2'),
('020010020003','Край Область 1 район 2 поселение 3'),
('020020000000','Край Область 2'),
('020020010000','Край Область 2 район 1'),
('020020010001','Край Область 2 район 1 поселение 1'),
('020020010002','Край Область 2 район 1 поселение 2'),
('020020020003','Край Область 2 район 1 поселение 2'),
('020020020000','Край Область 2 район 2'),
('020020020001','Край Область 2 район 2 поселение 1'),
('020020020002','Край Область 2 район 2 поселение 2');

INSERT INTO jc_passport_office (p_office_id, p_office_area_id, p_office_name) VALUES
(1, '010010000000','Паспортный стол района 1 города'),
(1, '010020000000','Паспортный стол 1 район 2 города'),
(2, '010020000000','Паспортный стол 2 район 2 города'),
(3, '010010000000','Паспортный стол района 3 города'),
(4, '020010010001','Паспортный стол Область 1 поселение 1'),
(5, '020010020002','Паспортный стол Область 1 поселение 2'),
(6, '020020010000','Паспортный стол Область 2 район 1'),
(7, '020020020000','Паспортный стол Область 2 район 2');


INSERT INTO jc_register_office (r_office_id, r_office_area_id, r_office_name ) VALUES
(1, '010010000000','ЗАГС 1 район 1 города'),
(2, '010010000000','ЗАГС 2 район 1 города'),
(3, '010020000000','ЗАГС района 2 города'),
(4, '020010010001','ЗАГС Область 1 поселение 1'),
(5, '020010020002','ЗАГС Область 1 поселение 2'),
(6, '020020010000','ЗАГС Область 2 район 1'),
(7, '020020020000','ЗАГС Область 2 район 2');