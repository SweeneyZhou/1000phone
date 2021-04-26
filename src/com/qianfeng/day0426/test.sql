CREATE TABLE country
(
    country_id   char(2)     default null,
    country_name varchar(20) default null
);
CREATE TABLE department
(
    department_id   int(4),
    department_name varchar(25),
    manager_id      int(4),
    location_id     int(4)
);
CREATE TABLE employee
(
    employee_id    int(4),
    first_name     varchar(20),
    last_name      varchar(20),
    email          varchar(20),
    phone_name     varchar(200),
    hire_date      date,
    job_id         varchar(20),
    salary         double,
    commission_pct double,
    manager_id     int(4),
    department_id  int(4)
);