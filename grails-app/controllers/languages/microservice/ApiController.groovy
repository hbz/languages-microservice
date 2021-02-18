package languages.microservice

import grails.core.GrailsApplication
import grails.plugins.*

class ApiController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }
}
