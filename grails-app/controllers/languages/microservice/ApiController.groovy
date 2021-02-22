package languages.microservice

import grails.core.GrailsApplication
import grails.plugins.*

class ApiController implements PluginManagerAware{

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager
    Iso639Service iso639Service


    def index(){
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }


    def listIso639two(){
        response.setContentType("application/json")
        render iso639Service.getIso639Table()
    }
}
