CREATE TABLE "translations" (
	"id" serial NOT NULL,
	"value" varchar NOT NULL
) WITH (
  OIDS=FALSE
);

ALTER TABLE "translations" ADD CONSTRAINT "translations_pk" PRIMARY KEY ("id");
