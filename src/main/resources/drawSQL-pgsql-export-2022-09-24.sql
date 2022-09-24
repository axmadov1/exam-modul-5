CREATE TABLE "student"(
    "id" serial NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "surname" VARCHAR(255) NOT NULL,
    "course" INTEGER NOT NULL,
    "facultyId" INTEGER NOT NULL,
    "universityId" INTEGER NOT NULL
);
ALTER TABLE
    "student" ADD PRIMARY KEY("id");
CREATE TABLE "faculty"(
    "id" serial NOT NULL,
    "name" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "faculty" ADD PRIMARY KEY("id");
ALTER TABLE
    "faculty" ADD CONSTRAINT "faculty_name_unique" UNIQUE("name");
CREATE TABLE "university"(
    "id" serial NOT NULL,
    "name" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "university" ADD PRIMARY KEY("id");
ALTER TABLE
    "university" ADD CONSTRAINT "university_name_unique" UNIQUE("name");
ALTER TABLE
    "student" ADD CONSTRAINT "student_facultyid_foreign" FOREIGN KEY("facultyId") REFERENCES "faculty"("id");
ALTER TABLE
    "student" ADD CONSTRAINT "student_universityid_foreign" FOREIGN KEY("universityId") REFERENCES "university"("id");