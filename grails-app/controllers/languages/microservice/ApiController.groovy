package languages.microservice

import grails.converters.JSON
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


    /**
     * This endpoint delivers the full map of all ISO-639-2 language codes together with the names of the languages in
     * the languages that are stored. By now, these include English, French and German.
     * @return
     */
    def listIso639two(){
        response.setContentType("application/json")
        render isoService.getIso639Table() as JSON
    }


    /**
     * This endpoint delivers the name of an ISO-639-2 language code in the language requested.
     * @param shortcode The shortcode whose language name is requested, e. g. "eng" for English.
     * @param targetLanguage The shortcode of the language that the language code should be returned in, e. g. "fre" if
     * the language name shall be in French.
     * Requesting shortcode="eng"&targetLanguage="fre" will result in "anglais".
     * @return The full language word specified by the params.
     */
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
