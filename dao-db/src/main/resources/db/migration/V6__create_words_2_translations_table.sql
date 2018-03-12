CREATE TABLE "words_2_translations" (
	"word_id" bigint NOT NULL,
	"translation_id" bigint NOT NULL
) WITH (
  OIDS=FALSE
);

ALTER TABLE "words_2_translations" ADD CONSTRAINT "words_2_translations_fk0" FOREIGN KEY ("word_id") REFERENCES "words"("id");
ALTER TABLE "words_2_translations" ADD CONSTRAINT "words_2_translations_fk1" FOREIGN KEY ("translation_id") REFERENCES "translations"("id");
