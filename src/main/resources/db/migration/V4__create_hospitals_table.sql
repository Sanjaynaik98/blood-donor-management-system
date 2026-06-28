CREATE TABLE hospitals (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    user_id BIGINT NOT NULL UNIQUE,

    phone VARCHAR(20) NOT NULL,

    address VARCHAR(255) NOT NULL,

    city VARCHAR(100) NOT NULL,

    state VARCHAR(100) NOT NULL,

    license_number VARCHAR(25) NOT NULL UNIQUE,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_hospital_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);