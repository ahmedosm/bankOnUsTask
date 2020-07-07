package org.bankonus

import org.grails.datastore.gorm.GormEntity


import grails.rest.*
@Resource(uri = '/customer')
class Customer  {
    String name
   static hasMany = [mobile:Mobile]
}
