package org.bankonus

import grails.gorm.transactions.Transactional
import grails.rest.RestfulController
@Transactional
class MobileController extends RestfulController<Mobile> {
    static responseFormats = ['json', 'xml']
    MobileController() {
        super(Mobile,false)
    }

    def customerMobile(Long q ) {
        if (q) {
            def mobileList = Mobile.executeQuery('select mo from Mobile mo '+ "where mo.customer.id = :id",
                    [id:q])

            respond(mobileList)
        }
        else {
            respond([])
        }
    }

}