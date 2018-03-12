CREATE TABLE "words" (
	"id" serial NOT NULL,
	"user_id" bigint NOT NULL,
	"value" varchar NOT NULL,
	"repeat_count" bigint NOT NULL DEFAULT '0'
) WITH (
  OIDS=FALSE
);

ALTER TABLE "words" ADD CONSTRAINT "words_pk" PRIMARY KEY ("id");

ALTER TABLE "words" ADD CONSTRAINT "words_fk0" FOREIGN KEY ("user_id") REFERENCES "users"("id");
