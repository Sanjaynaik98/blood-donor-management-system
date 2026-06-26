CREATE TABLE donors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    blood_group VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    date_of_birth DATE NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    last_donation_date DATE,
    available BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_donor_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);