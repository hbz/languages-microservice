package languages.microservice

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class IsoService{

    static iso639Table = new JsonSlurper().parse(new File(getClass().getResource(
        "${File.separator}ISO-639-2_utf-8_EN_FR_DE.json").toURI()))

    def getIso639Table(){
        return iso639Table
    }
}
