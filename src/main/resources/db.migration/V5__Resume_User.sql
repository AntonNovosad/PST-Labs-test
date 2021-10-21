CREATE TABLE IF NOT EXISTS resume_user (
    user_id INT NOT NULL ,
    resume_id INT NOT NULL ,
    FOREIGN KEY (resume_id) REFERENCES resume(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE(user_id, resume_id));