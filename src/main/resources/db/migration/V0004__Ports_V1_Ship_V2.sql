create table ports (id int primary key,
                    name varchar (255),
                    cargo text,
                    price_list text,
                    politic varchar (1024),
                    description text
                    );

alter table ship rename column movementSpeed to movementspeed;
alter table ship rename column cargoCapacity to cargocapacity;
alter table ship rename column maxFuel to maxfuel;
alter table ship rename column captainSkill to captainskill;
alter table ship modify column cargo_map text;


