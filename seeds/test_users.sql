DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE IF EXISTS users_id_seq;

-- Then, we recreate them
CREATE SEQUENCE IF NOT EXISTS users_id_seq;
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    hashed_password VARCHAR(255)
);


-- password for "username" is "Passymcword!1"

INSERT INTO users (username, hashed_password) VALUES ('username', 'scrypt:32768:8:1$XsRhdI77WT7dCncm$094eca39b6c5168b6874f53c24463926c9c267f2bac34e9d3a37246b4f52a439ebdf94897cf515b4426006760d681aa69e4ac417ac0033a6f1fb096501b98d75');
-- password for "TooLong"
INSERT INTO users (username, hashed_password) VALUES ('TooLong', 'scrypt:32768:8:1$2ZcoGqadWm30S0ry$70811ecc40037d783a5e6544534f980480fda812ec02149ab4e2c73ef16a8494ae09d5612d02a32bfe3693828bec5841213fc1c201020090a59175f85ad0aa6a');

INSERT INTO users (username, hashed_password) VALUES ('admin', 'scrypt:32768:8:1$GyJxMBmMStc53kgU$14c84080ba5cc61580ece80fb0df7859865f8b9e306d77d29f99f4b410fb845e27207bf2a466bb97c08d843b20be094cdfad1164e5b0a25136037627f63a87fd');