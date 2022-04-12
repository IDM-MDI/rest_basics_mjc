-- Fill values to "Tag" table
INSERT INTO tagDtos (name)
VALUES ('tag1'),
('tag2'),
('tag3'),
('tag4'),
('tag5');

-- Fill values to "Gift_Certificates" table
INSERT INTO gift_certificates (name, description, price, duration, create_date, last_update_date)
('giftCertificate1', 'description1', 10, 1, '2020-08-29T06:12:15.156', '2020-08-29T06:12:15.156'),
('giftCertificate2', 'description2', 20, 2, '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156'),
('giftCertificate3', 'description3', 30, 3, '2019-08-29T06:12:15.156', '2019-08-29T06:12:15.156');

-- Mapping Gift_Certificate with Tag
INSERT INTO gift_certificates_tags (gift_id, tag_id)
VALUES (1, 2),
VALUES (2, 2);