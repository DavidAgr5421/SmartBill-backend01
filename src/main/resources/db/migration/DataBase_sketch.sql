CREATE TABLE rol_privileges (
    fk_rol INT PRIMARY KEY REFERENCES user_rol(id_rol),
    create_bill BOOLEAN DEFAULT FALSE,
    delete_bill BOOLEAN DEFAULT FALSE,
    view_history BOOLEAN DEFAULT FALSE,
    print_bill BOOLEAN DEFAULT FALSE,
    create_product BOOLEAN DEFAULT FALSE,
    delete_product BOOLEAN DEFAULT FALSE,
    create_user BOOLEAN DEFAULT FALSE,
    delete_user BOOLEAN DEFAULT FALSE,
    generate_reports BOOLEAN DEFAULT FALSE,
    edit_config BOOLEAN DEFAULT FALSE,
    view_config BOOLEAN DEFAULT FALSE,
    create_rol BOOLEAN DEFAULT FALSE,
    delete_rol BOOLEAN DEFAULT FALSE
);

create table user_rol(
    id_rol SERIAL PRIMARY KEY,
    rol_name varchar(100) NOT NULL
);

create table users(
    id SERIAL PRIMARY KEY,
    name varchar(100) not null,
    fk_rol int not null REFERENCES user_rol(id_rol),
    email varchar(100) not null,
    password varchar(100) not null,
    creation_date timestamp default CURRENT_TIMESTAMP not null
);

create table clients(
    id SERIAL PRIMARY KEY,
    name varchar(100) not null,
    address varchar(200) not null,
    contact varchar(100) not null,
    created_at TIMESTAMP default CURRENT_TIMESTAMP
);

create table report(a
    id SERIAL PRIMARY KEY,
    fk_iduser INTEGER NOT NULL REFERENCES users(id),
    total_sales NUMERIC(20,2) NOT NULL,
    month_sales NUMERIC(20,2) NOT NULL,
    products_onstock NUMERIC(12,2) NOT NUll,
    products_lowstock NUMERIC(12,2) NOT NUll
);

create table bill(
    id SERIAL PRIMARY KEY,
    id_user INTEGER REFERENCES users(id),
    id_client INTEGER REFERENCES clients(id),
    total NUMERIC(20,2) NOT NULL,
    created_at TIMESTAMP default CURRENT_TIMESTAMP,
    payment_method varchar(50) not null
);

create table product(
    id SERIAL PRIMARY KEY,
    name varchar(100) not null,
    reference varchar(100) not null,
    unit_price NUMERIC(12,2) not null,
    created_at TIMESTAMP default CURRENT_TIMESTAMP,
    updated_at TIMESTAMP default CURRENT_TIMESTAMP
);

create table bill_detail(
    id SERIAL PRIMARY KEY,
    id_bill INTEGER REFERENCES bill(id),
    id_product INTEGER REFERENCES product(id),
    amount NUMERIC(12,2) NOT NULL,
    unit_price NUMERIC(12,2) NOT NULL,
    unit_measurement varchar(100),
    sub_total NUMERIC(20,2) NOT NULL,
    observation varchar(255)
);

create table configuration(
    id SERIAL PRIMARY KEY,
    name varchar(255) not null,
    created_at TIMESTAMP default CURRENT_TIMESTAMP NOT NULL,
    contact varchar(100),
    nit varchar(255) NOT NULL,
    footer TEXT,
    paper_width INT default 80,
    font_size INT default 1,
    updated_at TIMESTAMP default CURRENT_TIMESTAMP,
    logo_type VARCHAR(50),
    qr_type VARCHAR(50)
    );

