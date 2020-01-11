INSERT INTO employee_experience (items_per_hour, title)
VALUES (2, 'Junior'), (3, 'Expert');

INSERT INTO item_type (title, material_price)
VALUES ('Seat', 150.00), ('Backrest', 25.00), ('Steering wheel', 60), ('Doorhandle', 19.00), ('Other', 50.00);

INSERT INTO color (name)
VALUES ('Black'), ('White'), ('Red'), ('Green'), ('Blue'), ('Yellow'), ('Purple'), ('Brown'), ('Pink');

INSERT INTO employee (name, salary, employee_experience)
VALUES ('Pesho', 13.94, 1), ('Alex', 10.43, 1), ('bai Kolio', 15.28, 2), ('bai Blagoi', 19.68, 2);

INSERT INTO item (name, price, type, color, employee_id)
VALUES  ('BMW seat', 1234.32, 1, 1, 1), ('Volvo steering wheel', 934.32, 2, 3, 3);