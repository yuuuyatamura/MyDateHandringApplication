CREATE TABLE IF NOT EXISTS dateformula(
          id          varchar  (4)               NOT NULL  PRIMARY KEY
         ,name        varchar  (10)
         ,year  int      (2)    Default 0  NOT NULL
         ,month int      (3)    Default 0  NOT NULL
         ,day   int      (4)    Default 0  NOT NULL
);

CREATE TABLE IF NOT EXISTS users(
   user_id INT(11) unsigned NOT NULL AUTO_INCREMENT
  , name VARCHAR(100) DEFAULT NULL
  , email VARCHAR(100) DEFAULT NULL
  , password VARCHAR(100) DEFAULT NULL
  , created_by VARCHAR(50) NOT NULL
  , created_at DATETIME NOT NULL
  , updated_by VARCHAR(50) DEFAULT NULL
  , updated_at DATETIME DEFAULT NULL
  , deleted_by VARCHAR(50) DEFAULT NULL
  , deleted_at DATETIME DEFAULT NULL
  , version INT(11) unsigned NOT NULL DEFAULT 1
  , PRIMARY KEY (user_id)
  , KEY idx_users (email, deleted_at)
) ;