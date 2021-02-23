package languages.microservice

import grails.core.GrailsApplication
import grails.plugins.*
import org.apache.commons.lang.StringUtils

class ApiController implements PluginManagerAware{

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager
    IsoService isoService


    def index(){
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }


    def listIso639two(){
        response.setContentType("application/json")
        render isoService.getIso639Table()
    }


    def language(){
        String shortcode = params.shortcode
        String targetLanguage = params.targetLanguage
        if (StringUtils.isEmpty(shortcode)){
            response.status = 422
            render "Missing param shortcode"
            return
        }
        if (StringUtils.isEmpty(targetLanguage)){
            response.status = 422
            render "Missing param targetLanguage"
            return
        }
        def entry = isoService.getIso639Table().get(shortcode)
        if (entry == null){
            response.status = 404
            render "No language for shortcode ${shortcode}"
            return
        }
        String target = entry.get(targetLanguage)
        if (target == null){
            response.status = 404
            render "No target word for shortcode ${shortcode} and targetLanguage ${targetLanguage}"
            return
        }
        render target
    }
}
