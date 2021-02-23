package languages.microservice

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class IsoService{

    static iso639Table

    static{
        JsonSlurper jsonSlurper = new JsonSlurper()
        File resourceFile
        String iso639ConfigFile = "${File.separator}ISO-639-2_utf-8_EN_FR_DE.json"
        try{
            // works for deployments in application servers
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader()
            resourceFile = new File(classLoader.getResource(iso639ConfigFile).toURI())
        }
        catch (NullPointerException npe){
            // works for local project configuration
            resourceFile = new File(getClass().getResource(iso639ConfigFile).toURI())
        }
        iso639Table = jsonSlurper.parse(resourceFile)
    }

    def getIso639Table(){
        return iso639Table
    }
}
