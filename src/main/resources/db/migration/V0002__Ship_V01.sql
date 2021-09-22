create table ship ( id INT PRIMARY KEY AUTO_INCREMENT,
                    name varchar(255),
                    owner varchar (30),
                    movementSpeed int,
                    cargoCapacity int,
                    fuel int,
                    maxFuel int,
                    hull int,
                    captainSkill int,
                    cargo_map varchar (1024)
                    );