CREATE TABLE "users" (
	"id" serial NOT NULL,
	"email" varchar NOT NULL UNIQUE,
	"password" varchar NOT NULL,
	"first_name_id" bigint NOT NULL,
	"last_name_id" bigint NOT NULL,
	"token" varchar NOT NULL UNIQUE
) WITH (
  OIDS=FALSE
);

ALTER TABLE "users" ADD CONSTRAINT "users_pk" PRIMARY KEY ("id");

ALTER TABLE "users" ADD CONSTRAINT "users_fk1" FOREIGN KEY ("first_name_id") REFERENCES "first_names"("id");
ALTER TABLE "users" ADD CONSTRAINT "users_fk2" FOREIGN KEY ("last_name_id") REFERENCES "last_names"("id");

CREATE UNIQUE INDEX "index_users_on_email" ON "users"("email");
