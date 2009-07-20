;             
CREATE USER IF NOT EXISTS ADMINISTRATEUR PASSWORD '' ADMIN;   
CREATE USER IF NOT EXISTS JDOFUSCALC PASSWORD '' ADMIN;       
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_D050CCC2_A5DB_4632_8432_91D81A48DAAA START WITH 13 BELONGS_TO_TABLE;   
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_E51BC259_C9DA_4B53_B056_6C16431223C4 START WITH 791 BELONGS_TO_TABLE;  
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_8F6F33BB_BD26_4F9C_8A54_DA09C2DC87EE START WITH 9 BELONGS_TO_TABLE;    
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_4FE88599_FBC6_4A7C_BBC4_57ABFB35E3F2 START WITH 1109 BELONGS_TO_TABLE; 
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_1EC08222_E75F_4A7E_A271_A0C181FCFC18 START WITH 115 BELONGS_TO_TABLE;  
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_03A41BDD_CCCB_4CAE_BC5C_3359280B22AF START WITH 129 BELONGS_TO_TABLE;  
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_11380FCE_F7C3_47E4_B77B_39402B9421F1 START WITH 2380 BELONGS_TO_TABLE; 
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_2E136A91_5184_494D_9CEC_3FA196AAA5D4 START WITH 73 BELONGS_TO_TABLE;   
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_352F96C4_1DFB_432E_A514_295F8C72519D START WITH 67 BELONGS_TO_TABLE;   
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_FDBE5C9F_2209_42D7_BAA3_116B40F88A1F START WITH 4397 BELONGS_TO_TABLE; 
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_120C89E6_A97A_4040_BBC7_33D7BA05F4E7 START WITH 685 BELONGS_TO_TABLE;  
CREATE CACHED TABLE PUBLIC.DEGATS(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_11380FCE_F7C3_47E4_B77B_39402B9421F1) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_11380FCE_F7C3_47E4_B77B_39402B9421F1 SELECTIVITY 100,
    TABLE VARCHAR(100) SELECTIVITY 1,
    CHAMP VARCHAR(100) SELECTIVITY 1,
    DEGATS_NEUTRE_MINI INT SELECTIVITY 2,
    DEGATS_NEUTRE_MAXI INT SELECTIVITY 3,
    DEGATS_TERRE_MINI INT SELECTIVITY 2,
    DEGATS_TERRE_MAXI INT SELECTIVITY 3,
    DEGATS_FEU_MINI INT SELECTIVITY 1,
    DEGATS_FEU_MAXI INT SELECTIVITY 2,
    DEGATS_EAU_MINI INT SELECTIVITY 1,
    DEGATS_EAU_MAXI INT SELECTIVITY 2,
    DEGATS_AIR_MINI INT SELECTIVITY 2,
    DEGATS_AIR_MAXI INT SELECTIVITY 2,
    VOLE_NEUTRE_MINI INT SELECTIVITY 1,
    VOLE_NEUTRE_MAXI INT SELECTIVITY 1,
    VOLE_TERRE_MINI INT SELECTIVITY 1,
    VOLE_TERRE_MAXI INT SELECTIVITY 1,
    VOLE_FEU_MINI INT SELECTIVITY 1,
    VOLE_FEU_MAXI INT SELECTIVITY 1,
    VOLE_EAU_MINI INT SELECTIVITY 1,
    VOLE_EAU_MAXI INT SELECTIVITY 1,
    VOLE_AIR_MINI INT SELECTIVITY 1,
    VOLE_AIR_MAXI INT SELECTIVITY 1,
    SOINS_MINI INT SELECTIVITY 1,
    SOINS_MAXI INT SELECTIVITY 1
);               
-- 2379 +/- SELECT COUNT(*) FROM PUBLIC.DEGATS;               
CREATE CACHED TABLE PUBLIC.PANOPLIES(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_03A41BDD_CCCB_4CAE_BC5C_3359280B22AF) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_03A41BDD_CCCB_4CAE_BC5C_3359280B22AF SELECTIVITY 100,
    ID_DOFUS INT NOT NULL SELECTIVITY 100,
    NOM VARCHAR(100) NOT NULL SELECTIVITY 100,
    NIVEAU INT NOT NULL SELECTIVITY 1,
    CONDITIONS VARCHAR(200) SELECTIVITY 1,
    NB_OBJETS INT NOT NULL SELECTIVITY 5,
    BONUS_1O INT,
    BONUS_2O INT SELECTIVITY 100,
    BONUS_3O INT SELECTIVITY 96,
    BONUS_4O INT SELECTIVITY 87,
    BONUS_5O INT SELECTIVITY 54,
    BONUS_6O INT SELECTIVITY 40,
    BONUS_7O INT SELECTIVITY 28,
    BONUS_8O INT SELECTIVITY 9
);         
-- 128 +/- SELECT COUNT(*) FROM PUBLIC.PANOPLIES;             
CREATE CACHED TABLE PUBLIC.DOFUS(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_8F6F33BB_BD26_4F9C_8A54_DA09C2DC87EE) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_8F6F33BB_BD26_4F9C_8A54_DA09C2DC87EE,
    NOM VARCHAR(100),
    DESCRIPTION CLOB,
    NIVEAU INT,
    EFFETS_MINI INT,
    EFFETS_MAXI INT
);      
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.DOFUS;   
CREATE CACHED TABLE PUBLIC.EFFETS(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_FDBE5C9F_2209_42D7_BAA3_116B40F88A1F) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_FDBE5C9F_2209_42D7_BAA3_116B40F88A1F SELECTIVITY 100,
    TABLE VARCHAR(100) SELECTIVITY 1,
    CHAMP VARCHAR(100) SELECTIVITY 1,
    VIE DOUBLE,
    PA DOUBLE,
    PM DOUBLE,
    PO DOUBLE,
    INITIATIVE DOUBLE,
    PP DOUBLE,
    VITALITE DOUBLE,
    SAGESSE DOUBLE,
    FORCE DOUBLE,
    INTELLIGENCE DOUBLE,
    CHANCE DOUBLE,
    AGILITE DOUBLE,
    DOMMAGES DOUBLE,
    POURCENTAGES_DOMMAGES DOUBLE,
    PIEGES DOUBLE,
    POURCENTAGES_PIEGES DOUBLE,
    CC DOUBLE,
    SOINS DOUBLE,
    CREATURES_INVOCABLES DOUBLE,
    PODS DOUBLE,
    RESISTANCE_MAGIQUE DOUBLE,
    RESISTANCE_PHYSIQUE DOUBLE,
    RESISTANCE_NEUTRE DOUBLE,
    RESISTANCE_TERRE DOUBLE,
    RESISTANCE_FEU DOUBLE,
    RESISTANCE_EAU DOUBLE,
    RESISTANCE_AIR DOUBLE,
    POURCENTAGES_RESISTANCE_NEUTRE DOUBLE,
    POURCENTAGES_RESISTANCE_TERRE DOUBLE,
    POURCENTAGES_RESISTANCE_FEU DOUBLE,
    POURCENTAGES_RESISTANCE_EAU DOUBLE,
    POURCENTAGES_RESISTANCE_AIR DOUBLE,
    RENVOIS DOUBLE,
    EC DOUBLE,
    RESISTANCE_NEUTRE_COMBATTANTS DOUBLE,
    RESISTANCE_TERRE_COMBATTANTS DOUBLE,
    RESISTANCE_FEU_COMBATTANTS DOUBLE,
    RESISTANCE_EAU_COMBATTANTS DOUBLE,
    RESISTANCE_AIR_COMBATTANTS DOUBLE,
    POURCENTAGES_RESISTANCE_NEUTRE_COMBATTANTS DOUBLE,
    POURCENTAGES_RESISTANCE_TERRE_COMBATTANTS DOUBLE,
    POURCENTAGES_RESISTANCE_FEU_COMBATTANTS DOUBLE,
    POURCENTAGES_RESISTANCE_EAU_COMBATTANTS DOUBLE,
    POURCENTAGES_RESISTANCE_AIR_COMBATTANTS DOUBLE
);        
-- 4396 +/- SELECT COUNT(*) FROM PUBLIC.EFFETS;               
CREATE CACHED TABLE PUBLIC.PALIERS(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_2E136A91_5184_494D_9CEC_3FA196AAA5D4) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_2E136A91_5184_494D_9CEC_3FA196AAA5D4,
    UN_POUR_DEUX INT,
    UN_POUR_UN INT,
    DEUX_POUR_UN INT,
    TROIS_POUR_UN INT,
    QUATRE_POUR_UN INT,
    CINQ_POUR_UN INT
);     
-- 72 +/- SELECT COUNT(*) FROM PUBLIC.PALIERS;
CREATE CACHED TABLE PUBLIC.CLASSES(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_D050CCC2_A5DB_4632_8432_91D81A48DAAA) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_D050CCC2_A5DB_4632_8432_91D81A48DAAA SELECTIVITY 100,
    NOM VARCHAR(50) SELECTIVITY 100,
    DESCRIPTION TEXT SELECTIVITY 100,
    IMAGE VARCHAR(100) SELECTIVITY 100,
    ARME1 INT SELECTIVITY 25,
    ARME2 INT SELECTIVITY 16,
    PALIERS_VITALITE INT,
    PALIERS_SAGESSE INT,
    PALIERS_FORCE INT,
    PALIERS_INTELLIGENCE INT,
    PALIERS_CHANCE INT,
    PALIERS_AGILITE INT,
    VIE INT SELECTIVITY 33,
    PA INT SELECTIVITY 8,
    PM INT SELECTIVITY 8,
    PO INT SELECTIVITY 8,
    INI INT SELECTIVITY 8,
    PP INT SELECTIVITY 16
);  
-- 12 +/- SELECT COUNT(*) FROM PUBLIC.CLASSES;
CREATE CACHED TABLE PUBLIC.ARMES(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_E51BC259_C9DA_4B53_B056_6C16431223C4) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_E51BC259_C9DA_4B53_B056_6C16431223C4 SELECTIVITY 100,
    TYPE INT SELECTIVITY 1,
    NOM VARCHAR(100) SELECTIVITY 94,
    DESCRIPTION CLOB SELECTIVITY 67,
    NIVEAU INT SELECTIVITY 19,
    CONDITIONS OTHER,
    PANOPLIE INT SELECTIVITY 6,
    PA INT SELECTIVITY 1,
    PO INT SELECTIVITY 1,
    CC INT SELECTIVITY 2,
    BONUS_CC INT SELECTIVITY 2,
    EC INT SELECTIVITY 2,
    DEGATS_1 INT SELECTIVITY 100,
    DEGATS_2 INT SELECTIVITY 23,
    DEGATS_3 INT SELECTIVITY 6,
    DEGATS_4 INT SELECTIVITY 3,
    DEGATS_5 INT SELECTIVITY 1,
    EFFETS_MINI INT SELECTIVITY 100,
    EFFETS_MAXI INT SELECTIVITY 100,
    EFFETS_AUTRE CLOB SELECTIVITY 1
);       
-- 790 +/- SELECT COUNT(*) FROM PUBLIC.ARMES; 
CREATE CACHED TABLE PUBLIC.EQUIPEMENTS(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_4FE88599_FBC6_4A7C_BBC4_57ABFB35E3F2) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_4FE88599_FBC6_4A7C_BBC4_57ABFB35E3F2 SELECTIVITY 100,
    TYPE INT SELECTIVITY 1,
    NOM VARCHAR(100) SELECTIVITY 100,
    DESCRIPTION CLOB SELECTIVITY 88,
    NIVEAU INT SELECTIVITY 16,
    CONDITIONS OTHER,
    PANOPLIE INT SELECTIVITY 11,
    EFFETS_MINI INT SELECTIVITY 100,
    EFFETS_MAXI INT SELECTIVITY 100,
    EFFETS_AUTRE CLOB SELECTIVITY 1
);          
-- 1108 +/- SELECT COUNT(*) FROM PUBLIC.EQUIPEMENTS;          
CREATE CACHED TABLE PUBLIC.MONTURES(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_352F96C4_1DFB_432E_A514_295F8C72519D) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_352F96C4_1DFB_432E_A514_295F8C72519D,
    NOM VARCHAR(100),
    NIVEAU INT,
    CONDITIONS OTHER,
    EFFETS INT
);             
-- 66 +/- SELECT COUNT(*) FROM PUBLIC.MONTURES;               
CREATE CACHED TABLE PUBLIC.NIVEAUX_SORTS(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_120C89E6_A97A_4040_BBC7_33D7BA05F4E7) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_120C89E6_A97A_4040_BBC7_33D7BA05F4E7,
    PA INT,
    CC INT,
    EC INT,
    DEGATS INT,
    DEGATS_CC INT,
    EFFETS VARCHAR(200),
    EFFETS_CC VARCHAR(200)
);        
-- 684 +/- SELECT COUNT(*) FROM PUBLIC.NIVEAUX_SORTS;         
CREATE CACHED TABLE PUBLIC.SORTS(
    ID INT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_1EC08222_E75F_4A7E_A271_A0C181FCFC18) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_1EC08222_E75F_4A7E_A271_A0C181FCFC18,
    NOM VARCHAR(100),
    NIVEAU INT,
    CLASSE INT,
    NATURE VARCHAR(50),
    NIVEAU_1 INT,
    NIVEAU_2 INT,
    NIVEAU_3 INT,
    NIVEAU_4 INT,
    NIVEAU_5 INT,
    NIVEAU_6 INT
);  
-- 114 +/- SELECT COUNT(*) FROM PUBLIC.SORTS; 
ALTER TABLE PUBLIC.EFFETS ADD CONSTRAINT PUBLIC.CONSTRAINT_79 PRIMARY KEY(ID);
ALTER TABLE PUBLIC.NIVEAUX_SORTS ADD CONSTRAINT PUBLIC.CONSTRAINT_B PRIMARY KEY(ID);          
ALTER TABLE PUBLIC.CLASSES ADD CONSTRAINT PUBLIC.CONSTRAINT_5D PRIMARY KEY(ID);               
ALTER TABLE PUBLIC.MONTURES ADD CONSTRAINT PUBLIC.CONSTRAINT_1 PRIMARY KEY(ID);               
ALTER TABLE PUBLIC.SORTS ADD CONSTRAINT PUBLIC.CONSTRAINT_9 PRIMARY KEY(ID);  
ALTER TABLE PUBLIC.PANOPLIES ADD CONSTRAINT PUBLIC.CONSTRAINT_5 PRIMARY KEY(ID);              
ALTER TABLE PUBLIC.ARMES ADD CONSTRAINT PUBLIC.CONSTRAINT_3B PRIMARY KEY(ID); 
ALTER TABLE PUBLIC.DOFUS ADD CONSTRAINT PUBLIC.CONSTRAINT_3 PRIMARY KEY(ID);  
ALTER TABLE PUBLIC.DEGATS ADD CONSTRAINT PUBLIC.CONSTRAINT_77 PRIMARY KEY(ID);
ALTER TABLE PUBLIC.EQUIPEMENTS ADD CONSTRAINT PUBLIC.CONSTRAINT_8 PRIMARY KEY(ID);            
ALTER TABLE PUBLIC.PALIERS ADD CONSTRAINT PUBLIC.CONSTRAINT_F PRIMARY KEY(ID);
ALTER TABLE PUBLIC.DOFUS ADD CONSTRAINT PUBLIC.CONSTRAINT_3E UNIQUE(NOM);     
ALTER TABLE PUBLIC.PANOPLIES ADD CONSTRAINT PUBLIC.CONSTRAINT_5F UNIQUE(ID_DOFUS);            
ALTER TABLE PUBLIC.PANOPLIES ADD CONSTRAINT PUBLIC.CONSTRAINT_5F0 UNIQUE(NOM);