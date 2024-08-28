CREATE TABLE booking
(
    id                INT AUTO_INCREMENT NOT NULL,
    created_at        datetime NOT NULL,
    updated_at        datetime NOT NULL,
    booking_review_id INT NULL,
    start_time        datetime NULL,
    end_time          datetime NULL,
    total_distance    BIGINT NULL,
    booking_status    ENUM('CONFIRMED',
        'CANCELLED',
        'ON_RIDE',
        'COMPLETED') NULL,
    driver_id         INT NULL,
    passenger_id      INT NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE driver
(
    id             INT AUTO_INCREMENT NOT NULL,
    created_at     datetime     NOT NULL,
    updated_at     datetime     NOT NULL,
    name           VARCHAR(255) NULL,
    license_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE passenger
(
    id         INT AUTO_INCREMENT NOT NULL,
    created_at datetime NOT NULL,
    updated_at datetime NOT NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_passenger PRIMARY KEY (id)
);

CREATE TABLE passenger_review
(
    id               INT    NOT NULL,
    passenger_rating BIGINT NOT NULL,
    passenger_review VARCHAR(255) NULL,
    CONSTRAINT pk_passenger_review PRIMARY KEY (id)
);

CREATE TABLE review
(
    id         INT AUTO_INCREMENT NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime     NOT NULL,
    content    VARCHAR(255) NOT NULL,
    rating     BIGINT NULL,
    CONSTRAINT pk_review PRIMARY KEY (id)
);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_BOOKING_REVIEW FOREIGN KEY (booking_review_id) REFERENCES review (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGER_REVIEW_ON_ID FOREIGN KEY (id) REFERENCES review (id);