package languages.microservice

import grails.core.GrailsApplication
import grails.plugins.*
import groovy.json.JsonSlurper

class ApiController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

    def listIso639two() {
        response.setContentType("application/json")
        File isoFile = new File(getClass().getResource(
            "${File.separator}ISO-639-2_utf-8_EN_FR_DE.json").toURI())
        render new JsonSlurper().parse(isoFile)
    }
}
