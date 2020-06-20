CREATE TABLE IF NOT EXISTS dateformula(
          id          varchar  (4)               NOT NULL  PRIMARY KEY
         ,name        varchar  (10)
         ,year  int      (2)    Default 0  NOT NULL
         ,month int      (3)    Default 0  NOT NULL
         ,day   int      (4)    Default 0  NOT NULL
);