# languages-microservice

This service provides information about languages and their names according to the ISO-639-2 specification.
It can either return a full map of all ISO-639 languages alongside their names in the languages stored so far, or it can
deliver the name of an ISO-639 language code in the language requested.

## Get the whole ISO-639-2 list

Just request `/api/listIso639two`.

## Get a name of an ISO-639 language code

Request `api/languages?shortcode=SRC&targetLanguage=TLG` with

- `SRC` being the shortcode of the language that you request a name of, e. g. `eng` if you need a name of the English
language and
- `TLG` being the shortcode of the language that you want the language word to be returned in, e. g. `fre` if the
requested language shall be returned in French.

Example: `api/languages?shortcode=eng&targetLanguage=fre` will return "anglais".
