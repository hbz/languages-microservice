package languages.microservice

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'api', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
        "/api/listIso639two"(controller: 'api', action:'listIso639two')
        "/api/language"(controller: 'api', action:'language')
    }
}
