DROP TABLE IF EXISTS Survey;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS question_option;
  
CREATE TABLE survey (
  survey_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  created_by VARCHAR(250) DEFAULT NULL
);

CREATE TABLE question(
 question_id INT AUTO_INCREMENT  PRIMARY KEY,
 description VARCHAR(250) NOT NULL,
 survey_id INT,
 CONSTRAINT question_survey FOREIGN KEY (survey_id) REFERENCES survey(survey_id)

);

CREATE TABLE question_option(
 option_id INT AUTO_INCREMENT  PRIMARY KEY,
 description VARCHAR(250) NOT NULL,
 selected_count INT NOT NULL,
 question_id INT,
 CONSTRAINT option_question FOREIGN KEY (question_id) REFERENCES question(question_id)

);